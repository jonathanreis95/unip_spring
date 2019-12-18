	package br.com.escola.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.servlet.ModelAndView;
	
	import br.com.escola.model.MateriaAluno;
	import br.com.escola.repository.MateriaAlunoRepository;

	@Controller
	public class MateriaAlunoController {
		
		@Autowired
		private MateriaAlunoRepository materiaAlunoRepo;
		
		
		@GetMapping("/chamada")
		public ModelAndView listaMaterias() {
			ModelAndView mv = new ModelAndView("lista_chamadas");
			/* TODO
			 * 1. PASSAR E PEGAR O PARAMETRO DA MATERIA_ALUNO.
			 * 2. CRIAR UM METODO NO REPOSITORY QUE RETORNA A SEGUINTE QUERY:
			 * 
			 * QUERY : SELECT ma.id, m.nome, au.data_aula, au.presenca, ma.total_falta, ma.aluno_id, ma.materia_id, al.nome  FROM TB_AULA au
						JOIN tb_materia_aluno ma ON au.MATERIA_ALUNO_ID = ma.ID
						JOIN tb_aluno al ON al.id = ma.aluno_id
						JOIN tb_materia m ON m.id = ma.materia_id
						WHERE ma.id = ? ;
			*/
			List<MateriaAluno> alunos = materiaAlunoRepo.findAll();
			mv.addObject("alunos", alunos);
			return mv;
		}
	}