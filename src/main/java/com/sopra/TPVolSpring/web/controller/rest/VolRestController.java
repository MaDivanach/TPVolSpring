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
import com.sopra.TPVolSpring.model.Vol;
import com.sopra.TPVolSpring.model.view.JsonViews;
import com.sopra.TPVolSpring.repositories.VolRepository;

@RestController
@RequestMapping("/rest/vol")
public class VolRestController {

	@Autowired
	private VolRepository volRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Vol>> findAll() {
		return new ResponseEntity<>(volRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.VolByIdWithReservations.class)
	@GetMapping(path = { "/volwithreservation" })
	public ResponseEntity<Optional<Vol>> findByIdWithReservation(Long id) {
		return new ResponseEntity<>(volRepository.findCustomByIdWithReservation(id), HttpStatus.OK);
	}
	@JsonView(JsonViews.VolByIdWithCompagnieAeriennes.class)
	@GetMapping(path = { "/volwithcompagnie" })
	public ResponseEntity<Optional<Vol>> findByIdWithCompagnieAerienne(Long id) {
		return new ResponseEntity<>(volRepository.findCustomByIdWithCompagnieAerienne(id), HttpStatus.OK);
	}
	@JsonView(JsonViews.VolByIdWithEscales.class)
	@GetMapping(path = { "/volwithescale" })
	public ResponseEntity<Optional<Vol>> findByIdWithEscale(Long id) {
		return new ResponseEntity<>(volRepository.findCustomByIdWithEscale(id), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createVol(@Valid @RequestBody Vol vol, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			volRepository.save(vol);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/vol/{id}").buildAndExpand(vol.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Vol> findById(@PathVariable(name = "id") Long id) {
		Optional<Vol> opt = volRepository.findById(id);
		ResponseEntity<Vol> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Vol> update(@Valid @RequestBody Vol vol, BindingResult br) {
		if (br.hasErrors() || vol.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Vol> opt = volRepository.findById(vol.getId());
		if (opt.isPresent()) {
			// update possible
			Vol volEnBase = opt.get();
			volEnBase.setDateDepart(vol.getDateDepart());
			volEnBase.setDateArrivee(vol.getDateArrivee());
			volEnBase.setHeureDepart(vol.getHeureDepart());
			volEnBase.setHeureArrivee(vol.getHeureArrivee());
			volEnBase.setArrivee(vol.getArrivee());
			volEnBase.setDepart(vol.getDepart());
			volEnBase.setReservations(vol.getReservations());
			volEnBase.setEscales(vol.getEscales());
			volEnBase.setCompagnieAeriennes(vol.getCompagnieAeriennes());
			return new ResponseEntity<Vol>(volEnBase, HttpStatus.OK);
		} else {
			// pas de vol
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Vol> opt = volRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			volRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
