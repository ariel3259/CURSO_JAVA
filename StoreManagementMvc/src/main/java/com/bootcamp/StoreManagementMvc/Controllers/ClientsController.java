package com.bootcamp.StoreManagementMvc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.StoreManagementMvc.Interfaces.IClientsService;
import com.bootcamp.StoreManagementMvc.Interfaces.IFileSystem;
import com.bootcamp.StoreManagementMvc.Model.Clients;

@Controller
@RequestMapping("/clients")
public class ClientsController {
	
	@Autowired
	private IClientsService clientsService;
	
	@Autowired
	private IFileSystem  fs;
	
	@GetMapping
	public String getAllClients(Model model) {
		List<Clients> clients = clientsService.getAll();
		model.addAttribute("clients", clients);
		return "index";
	}
	
	@PostMapping("/dni")
	public String getClientByDni(Model model, @RequestParam("dni") String dni) {
		if(dni.isEmpty()) {
			model.addAttribute("client", null);
			return "client_by_dni";
		}
		Clients client = clientsService.getOneByDni(Integer.parseInt(dni));
		model.addAttribute("client", client);
		return "client_by_dni";
	}
	
	@GetMapping("/create")
	public String showCreateClient(Model model) {
		Clients client = new Clients();
		model.addAttribute("client", client);
		return "create_client";
	}
	
	@PostMapping("/create")
	public String createClient(@ModelAttribute("client") Clients client, @RequestParam("imageFile") MultipartFile image,RedirectAttributes redirectAttributes) {
		String imageName = fs.saveFile(image);
		client.setImage(imageName);
		clientsService.save(client);	
		redirectAttributes.addFlashAttribute("message", "Created client");
		redirectAttributes.addFlashAttribute("class", "success");
		return "redirect:/clients";
	}
	
	@GetMapping("/update/{id}")
	public String showUpdateClient(Model model, @PathVariable("id") int id) {
		Clients client = clientsService.getOne(id);
		model.addAttribute("client", client);
		return "update_client";
	}
	
	@PostMapping("/update/{id}")
	public String updateClient(@ModelAttribute("client") Clients client, @PathVariable("id") int id, RedirectAttributes redirectAttributes ) {
		client.setId(id);
		clientsService.update(client);
		redirectAttributes.addFlashAttribute("message", "Updated client");
		redirectAttributes.addFlashAttribute("class", "info");
		return "redirect:/clients";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteClient(@PathVariable("id") int id) {
		clientsService.delete(id);
		return "redirect:/clients";
	}
	
	
}
