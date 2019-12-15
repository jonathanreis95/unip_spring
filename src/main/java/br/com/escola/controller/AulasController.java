	package br.com.escola.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.servlet.ModelAndView;
	
	import br.com.escola.model.Aula;
	import br.com.escola.repository.AulaRepository;

	@Controller
	public class AulasController {
		
		@Autowired
		private AulaRepository aulaRepo;
		
		
		@GetMapping("/aulas")
		public ModelAndView listaMaterias() {
			ModelAndView mv = new ModelAndView("lista_aulas");
			/* TODO
			 * 1 - PASSAR E PEGAR O ID DA MATERIA POR PARAMETRO
			 * 2 - LISTAR SOMENTE AS AULAS QUE POSSUEM A MATERIA PASSADA POR PARAMETRO
			 * */
			List<Aula> aulas = aulaRepo.findAll();
			mv.addObject("aulas", aulas);
			return mv;
		}
		
		
		/* TODO:
		 * CRIAR UM API QUE RECEBA MATERIA_ALUNO_ID OU ID DA AULA E DÊ UM UPDATE NO CAMPO PRESENÇA
		 * */
	}