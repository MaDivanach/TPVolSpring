package com.sopra.TPVolSpring.controller.rest;

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
import com.sopra.TPVolSpring.model.Passager;
import com.sopra.TPVolSpring.model.view.JsonViews;
import com.sopra.TPVolSpring.repositories.PassagerRepository;



@RestController
@RequestMapping("/rest/passager")
public class PassagerRestController {

	
	@Autowired
	private PassagerRepository passagerRepository;

	// @RequestMapping(value="/", method=RequestMethod.GET)
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Passager>> findAll() {
		return new ResponseEntity<>(passagerRepository.findAll(), HttpStatus.OK);
	}

	// request body corps de la requête
	// request body corps de la requête
	// uricomponentsbuilder permet de renvoyer l url qui correspond à l objet que l on a cree
	// on utilise le header de la reponse pour mettre l url qui correspond a l endroit ou je devrai trouver l objet
	@PostMapping(path = { "/passager"})
	public ResponseEntity<Void> createBlueray(@Valid @RequestBody Passager passager, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			passagerRepository.save(passager);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/passager/{id}").buildAndExpand(passager.getIdPassager()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	// request body corps de la requête
	// uricomponentsbuilder permet de renvoyer l url qui correspond à l objet que l on a cree
	// on utilise le header de la reponse pour mettre l url qui correspond a l endroit ou je devrai trouver l objet


	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Passager> update(@Valid @RequestBody Passager passager, BindingResult br) {
		if (br.hasErrors() || passager.getIdPassager() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Passager> opt = passagerRepository.findById(passager.getIdPassager());
		if (opt.isPresent()) {
			// update possible
			Passager PassagerEnBase = opt.get();
			PassagerEnBase.setNom(passager.getNom());
			PassagerEnBase.setPrenom(passager.getPrenom());
			PassagerEnBase.setAdresse(passager.getAdresse());
			PassagerEnBase.setReservations(passager.getReservations());
			passagerRepository.save(PassagerEnBase);
			return new ResponseEntity<Passager>(PassagerEnBase, HttpStatus.OK);
		} else {
			// pas d'Passager
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Passager> findById(@PathVariable(name = "id") Long id) {
		Optional<Passager> opt = passagerRepository.findById(id);
		ResponseEntity<Passager> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Passager> opt = passagerRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			passagerRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}



}
