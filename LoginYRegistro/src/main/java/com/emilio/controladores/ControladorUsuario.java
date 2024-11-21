package com.emilio.controladores;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.emilio.modelos.Usuario;
import com.emilio.servicios.ServicioUsuario;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ControladorUsuario {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@GetMapping("/")
	public String index(@ModelAttribute("usuario") Usuario usuario) {
		return "index";
	}
	
	@PostMapping("/procesa/registro")
	public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		if (servicioUsuario.nombreUsuarioExistente(usuario.getNombreUsuario())) {
			result.rejectValue("nombreUsuario", "Unique", "El nombre de usuario ya existe");
		}
		if (!usuario.getPassword().equals(usuario.getConfirmacionPassword())) {
			result.rejectValue("confirmacionPassword", "Match", "Las contraseñas no coinciden");
		}
		if (result.hasErrors()) {
			return "index";
		}
		usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
		servicioUsuario.registrarUsuario(usuario);
		return "redirect:/inicio";
	}
	
	@PostMapping("/procesa/login")
	public String procesarLogin(@RequestParam("nombreUsuario") String nombreUsuario, @RequestParam("password") String password, Model model) {
		Optional<Usuario> usuarioOptional = servicioUsuario.buscarPorNombreUsuario(nombreUsuario);
		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			if (BCrypt.checkpw(password, usuario.getPassword())) {
				return "redirect:/inicio";
		}
		}
		model.addAttribute("loginError","Nombre de usuario o contraseña incorrectos");
		return "index";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}
	
}
