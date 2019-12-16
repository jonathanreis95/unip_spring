package br.com.escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListaMateriasController {

	@GetMapping(value = {"/listaMaterias"})
	public String listaMaterias() {
		return "materias";
	}
	
}

