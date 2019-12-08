package br.com.escola.model.resources;
import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.escola.model.Materia;
import br.com.escola.repository.MateriaRepository;


@RestController
@RequestMapping("/materias")
public class MateriaResources {
	@Autowired
	private MateriaRepository materiaRepo;

	@GetMapping("/{id}")
	public Materia buscarPeloId(@PathVariable Long id) {
		return materiaRepo.getOne(id);
	}

	@GetMapping("/adminLista")
	public List<Materia> todasMaterias() {
		return materiaRepo.findAll();
	}
	
	/* TODO: LISTAR APENAS AS MATERIAS QUE ESTÃO VINCULADOS COM O ID DO USUARIO LOGADO 
	 * */
	@GetMapping("/lista")
	public List<Materia> listaMaterias() {
		return materiaRepo.findAll();
	}

	@PostMapping ("/salvar")
	public ResponseEntity<Materia> salvar(@RequestBody Materia materia, HttpServletResponse response) {
		Materia l = materiaRepo.save(materia);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/materia/{id}"). 
				buildAndExpand(l.getId()).
				toUri();
		return ResponseEntity.created(uri).body(l);
	}
}