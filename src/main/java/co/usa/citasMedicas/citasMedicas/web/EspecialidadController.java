package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Especialidades;
import co.usa.citasMedicas.citasMedicas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/all")
    public List<Especialidades> getAll(){
        return especialidadService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Especialidades> getEspecialidadById(@RequestParam("id") int id){
        return especialidadService.getEspecialidadById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidades save(@RequestBody Especialidades especialidades){
        return especialidadService.saveEspecialidad(especialidades);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEspecialidad(@RequestBody Especialidades especialidades){
        especialidadService.deleteEspecialidad(especialidades);
    }

}
