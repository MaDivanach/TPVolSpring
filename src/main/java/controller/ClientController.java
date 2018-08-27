package controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Client;
import model.ClientEl;
import model.ClientMoral;
import model.ClientPhysique;
import repositories.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@RequestMapping("")
	public ModelAndView home() {
		
		return new ModelAndView("redirect:/client/");
	}
	
	@RequestMapping("/")
	public ModelAndView list(Model model) {
		return new ModelAndView("client/list", "clients", clientRepository.findAll());
	}
	
	private ModelAndView goEdit(Client client) {
		ModelAndView modelAndView = new ModelAndView("client/edit", "client", client);
		modelAndView.addObject("clients", clientRepository.findAll());
		return modelAndView;
	}
	
	@RequestMapping("/addphysique")
	public ModelAndView addPhysique() {
		return goEdit(new ClientPhysique());
	}
	
	@RequestMapping("/addmoral")
	public ModelAndView addMoral() {
		return goEdit(new ClientMoral());
	}
	
	@RequestMapping("/addel")
	public ModelAndView addEl() {
		return goEdit(new ClientEl());
	}
	
	@RequestMapping("/savemoral")
	public ModelAndView saveMoral(@ModelAttribute("client") ClientMoral clientMoral, BindingResult br) {
		return save(clientMoral, br);

	}
	@RequestMapping("/saveel")
	public ModelAndView saveEl(@ModelAttribute("client") ClientEl clientEl, BindingResult br) {
		return save(clientEl, br);
		
	}
	@RequestMapping("/savephysique")
	public ModelAndView savePhysique(@ModelAttribute("client") ClientPhysique clientPhysique, BindingResult br) {
		return save(clientPhysique, br);
		
	}
	
	
	
	public ModelAndView save(Client client, BindingResult br) {
		
		if(br.hasErrors()) {
			return goEdit(client);
		}
		clientRepository.save(client);
		
		return new ModelAndView("redirect:/client/");
		
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long id) {
		clientRepository.deleteById(id);
		return "redirect:/client/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Long id) {
		Optional<Client> opt = clientRepository.findById(id);
		if (opt.isPresent()) {
			return goEdit(opt.get());
		}
		return new ModelAndView("redirect:/client/");

	}
	
//	@RequestMapping("/reserv")
//	public ModelAndView findReserv(@RequestParam(name = "id") Long id, Reservation reservation) {
//		ModelAndView modelAndView = new ModelAndView("client/reserv", "reservation", reservation);
//		modelAndView.addObject("reservations", clientRepository.findCustomByIdWithReservation(id));
//		return modelAndView;
//	}
	
//	@RequestMapping("/reserv")
//    public String reserv(@RequestParam(name = "id") Long id, Model model) {
//        Optional<Client> opt= clientRepository.findById(id);
//        if (opt.isPresent()) {
//            model.addAttribute("reservations", opt.get().getReservations());
//            return "client/reserv";
//        }
//         return "redirect:/client/";
//    }
	
	@RequestMapping("/reserv")
    public String reservations(@RequestParam(name = "id") Long id, Model model) {
        Optional<Client> opt= clientRepository.findCustomByIdWithReservation(id);
        if (opt.isPresent()) {
            model.addAttribute("reservations", opt.get().getReservations());
            return "reserv";
        }
         return "redirect:/client/";
    }
	

}
