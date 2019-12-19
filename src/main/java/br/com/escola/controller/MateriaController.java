	package br.com.escola.controller;

	import java.util.List;
	import javax.servlet.http.HttpServletRequest;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.servlet.ModelAndView;
	import br.com.escola.model.Materia;
	import br.com.escola.model.Usuario;
	import br.com.escola.repository.MateriaRepository;
	
	@Controller
	public class MateriaController {
		
		@Autowired
		private MateriaRepository materiaRepo;	
		
		@GetMapping("/materias")
		public ModelAndView listaMaterias(HttpServletRequest request) {			
			ModelAndView mv = new ModelAndView("lista_materias");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
			List<Materia> materias = materiaRepo.findByUsuario(usuario);
			
			mv.addObject("materias", materias);
			mv.addObject("usuario", usuario);
			return mv;
		}
		
	}
