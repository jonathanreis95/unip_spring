package br.com.escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ListaAulasController {

	@GetMapping(value = {"/listaAulas"})
	public String listaAulas() {
		return "aulas";
	}
	
}
