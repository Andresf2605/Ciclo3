package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Cliente;
import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping("/all")
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Cliente> getClienteById(@PathVariable("id") int id){
        return clienteService.getClienteById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateCliente(@RequestBody Cliente cliente){
        return clienteService.updateCliente(cliente);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteCliente(@PathVariable("id") int id){
        return clienteService.delete(id);
    }

}
