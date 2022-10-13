package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Mensajes;
import co.usa.citasMedicas.citasMedicas.service.MensajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/Message")
public class MensajesController {
    @Autowired
    private MensajesService mensajesService;

    @GetMapping("/all")
    public List<Mensajes> getAll(){
        return mensajesService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Mensajes> getMensajeById(@PathVariable("id") int id){
        return mensajesService.getMensajeById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes save(@RequestBody Mensajes mensajes){
        return mensajesService.save(mensajes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){
        return mensajesService.delete(id);
    }

}
