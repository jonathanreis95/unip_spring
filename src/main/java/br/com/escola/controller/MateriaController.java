	package br.com.escola.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.servlet.ModelAndView;
	
	import br.com.escola.model.Materia;
	import br.com.escola.repository.MateriaRepository;

	@Controller
	public class MateriaController {
		
		@Autowired
		private MateriaRepository materiaRepo;
		
		
		@GetMapping("/materias")
		public ModelAndView listaMaterias() {
			ModelAndView mv = new ModelAndView("lista_materias");
			/*
			 * TODO: LISTAR AS MATERIAS SOMENTE DO USUARIO LOGADO
			 * */
			List<Materia> materias = materiaRepo.findAll();
			mv.addObject("materias", materias);
			return mv;
		}
	}
