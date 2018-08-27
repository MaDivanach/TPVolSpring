package controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Passager;
import model.Reservation;
import repositories.PassagerRepository;

@Controller
@RequestMapping("/passager")
public class PassagerController {

	@Autowired
	private PassagerRepository passagerRepository;

	@RequestMapping(value = { "/" })
	public String list(Model model) {
		model.addAttribute("passagers", passagerRepository.findAll());
		return "passager/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id) {
		passagerRepository.deleteById(id);
		;
		return "redirect:/passager/";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam(name = "id") Long id, Model model) {
		Optional<Passager> opt = passagerRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get(), model);
		}
		return goEdit(new Passager(), model);
	}

	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute("passager") Passager passager, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(passager, model);
		} else {
			passagerRepository.save(passager);
			return "redirect:/passager/";
		}
	}

	@RequestMapping("/add")
	public String add(Model model) {
		return goEdit(new Passager(), model);
	}

	private String goEdit(Passager passager, Model model) {
		model.addAttribute("passager", passager);
		return "passager/edit";
	}

	@RequestMapping("/reservations")
	public String reservations(@RequestParam(name = "id") Long id, Model model) {
		Optional<Passager> opt= passagerRepository.findCustomByIdWithReservation(id);
		if (opt.isPresent()) {
			model.addAttribute("reservations", opt.get().getReservations());
			return "reservation/list";
		}
		 return "redirect:/passager/";
	}

}
