package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Cliente;
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
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@RequestBody Cliente cliente){
        clienteService.delete(cliente);
    }

}
