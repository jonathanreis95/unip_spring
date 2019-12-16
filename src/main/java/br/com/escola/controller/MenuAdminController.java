package br.com.escola.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.servlet.ModelAndView;
	
	import br.com.escola.model.Materia;
    import br.com.escola.repository.MateriaRepository;
    import br.com.escola.model.Usuario;
	import br.com.escola.repository.UsuarioRepository;

	@Controller
	public class MenuAdminController {
		
		@Autowired
		private MateriaRepository materiaRepo;
		@Autowired
        private UsuarioRepository usuarioRepo;
		
		
		@GetMapping("/menu_admin")
		public ModelAndView listaMaterias() {
			ModelAndView mv = new ModelAndView("menu_admin");
			List<Materia> materias = materiaRepo.findAll();
            mv.addObject("materias", materias);
            mv.addObject(new Materia());
            List<Usuario> usuarios = usuarioRepo.findAll(Sort.by(Sort.Direction.ASC, "nome"));
            mv.addObject("usuarios", usuarios);
            mv.addObject(new Usuario());
			return mv;
        }
        /**@PostMapping("/menu_admin")
		public ModelAndView criarMateria() {
			
			List<Materia> materias = materiaRepo.findAll();
            mv.addObject("materias", materias);
            mv.addObject(new Materia());
			return mv;
		}*/
	}