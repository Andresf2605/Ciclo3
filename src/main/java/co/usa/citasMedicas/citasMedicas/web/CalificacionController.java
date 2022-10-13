package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Calificacion;
import co.usa.citasMedicas.citasMedicas.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public List<Calificacion> getAll(){
        return calificacionService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Calificacion> getCalificacionById(@PathVariable("id") int id){
        return calificacionService.getCalificacionById(id);
    }
    @PostMapping("/save")
    public Calificacion save(@RequestBody Calificacion calificacion){
        return calificacionService.save(calificacion);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable int id){
        return calificacionService.delete(id);
    }
}
