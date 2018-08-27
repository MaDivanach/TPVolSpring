package com.sopra.TPVolSpring.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPVolSpring.model.Reservation;
import com.sopra.TPVolSpring.repositories.ClientRepository;
import com.sopra.TPVolSpring.repositories.PassagerRepository;
import com.sopra.TPVolSpring.repositories.ReservationRepository;
import com.sopra.TPVolSpring.repositories.VolRepository;

@RestController
@RequestMapping("/rest/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", ""})
	public ResponseEntity<List<Reservation>> findAll() {
		ResponseEntity<List<Reservation>> response = null;
		response = new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.ReservationWithDetails.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable(name = "id") Long id) {
		ResponseEntity<Reservation> response = null;
		Optional<Reservation> opt = reservationRepository.findById(id);
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createReservation(@Valid @RequestBody Reservation reservation, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			reservationRepository.save(reservation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/reservation/{id}").buildAndExpand(reservation.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PutMapping(path = { "/", "" })
	@JsonView(JsonViews.ReservationWithDetails.class)
	public ResponseEntity<Reservation> update(@Valid @RequestBody Reservation reservation, BindingResult br) {
		ResponseEntity<Reservation> response = null;
		if (br.hasErrors() || reservation.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Reservation> opt = reservationRepository.findById(reservation.getId());
		if (opt.isPresent()) {
			Reservation reservationEnBase = opt.get();
			reservationEnBase.setNumero(reservation.getNumero());
			reservationEnBase.setDate(reservation.getDate());
			reservationEnBase.setVol(reservation.getVol());
			reservationEnBase.setClient(reservation.getClient());
			reservationEnBase.setPassager(reservation.getPassager());
			reservationRepository.save(reservationEnBase);
			return new ResponseEntity<Reservation>(reservationEnBase, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Reservation> opt = reservationRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			reservationRepository.delete(opt.get());
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
