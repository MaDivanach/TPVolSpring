package com.sopra.TPVolSpring.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPVolSpring.model.Client;
import com.sopra.TPVolSpring.model.ClientEl;
import com.sopra.TPVolSpring.model.ClientMoral;
import com.sopra.TPVolSpring.model.ClientPhysique;
import com.sopra.TPVolSpring.model.Passager;
import com.sopra.TPVolSpring.model.view.JsonViews;
import com.sopra.TPVolSpring.repositories.ClientRepository;

@RestController
@RequestMapping("/rest/client")
public class ClientRestController {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping("")
	public ModelAndView home() {

		return new ModelAndView("redirect:/client/");
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Client>> findAll() {
		return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
	}


	// request body corps de la requête
	@PostMapping(path = { "/physique", "" })
	public ResponseEntity<Void> createPhysique(@Valid @RequestBody ClientPhysique clientPhysique, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			clientRepository.save(clientPhysique);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/physique/{id}").buildAndExpand(clientPhysique.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	// request body corps de la requête
	@PostMapping(path = { "/el", "" })
	public ResponseEntity<Void> createEl(@Valid @RequestBody ClientEl clientEl, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			clientRepository.save(clientEl);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/el/{id}").buildAndExpand(clientEl.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	// request body corps de la requête
	@PostMapping(path = { "/moral", "" })
	public ResponseEntity<Void> createMoral(@Valid @RequestBody ClientMoral clientMoral, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			clientRepository.save(clientMoral);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/moral/{id}").buildAndExpand(clientMoral.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Client> update(@Valid @RequestBody Client client, BindingResult br) {
		if (br.hasErrors() || client.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Client> opt = clientRepository.findById(client.getId());
		if (opt.isPresent()) {
			// update possible
			Client clientEnBase = opt.get();
			clientEnBase.setNom(client.getNom());
			clientEnBase.setNumeroTel(client.getNumeroTel());
			clientEnBase.setNumeroFax(client.getNumeroFax());
			clientEnBase.setEmail(client.getEmail());
			clientEnBase.setAdresse(client.getAdresse());
//			clientEnBase.getAdresse().setNumero(client.getAdresse().getNumero());
//			clientEnBase.getAdresse().setRue(client.getAdresse().getRue());
//			clientEnBase.getAdresse().setVille(client.getAdresse().getVille());
//			clientEnBase.getAdresse().setCodePostal(client.getAdresse().getCodePostal());
			if (Client.class.getSimpleName() == "ClientMoral") {

				((ClientMoral) clientEnBase).setSiret(((ClientMoral) client).getSiret());
			} else if (Client.class.getSimpleName() == "ClientEl") {
				((ClientEl) clientEnBase).setPrenom(((ClientEl) client).getPrenom());
			} else {

				((ClientPhysique) clientEnBase).setPrenom(((ClientPhysique) client).getPrenom());
			}

			clientRepository.save(clientEnBase);
			return new ResponseEntity<Client>(clientEnBase, HttpStatus.OK);
		} else {
			// pas de client
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Client> findById(@PathVariable(name = "id") Long id) {
		Optional<Client> opt = clientRepository.findById(id);
		ResponseEntity<Client> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Client> opt = clientRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			clientRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping("/reservations")
//	@JsonView(JsonViews.ClientByIdWithReservations.class)
	public String reservations(@RequestParam(name = "id") Long id, Model model) {
		Optional<Client> opt= clientRepository.findCustomByIdWithReservation(id);
		if (opt.isPresent()) {
			model.addAttribute("reservations", opt.get().getReservations());
			return "reservation/list";
		}
		 return "redirect:/client/";
	}

}
