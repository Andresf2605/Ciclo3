package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Cliente;
import co.usa.citasMedicas.citasMedicas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return (List<Cliente>) clienteRepository.getAll();
    }
    public Optional<Cliente> getClienteById(int id){
        return clienteRepository.getClienteById(id);
    }
    public Cliente save(Cliente cliente){
        if(cliente.getIdClient() == null){
        return clienteRepository.save(cliente);
        }else {
            Optional<Cliente> checkCliente = clienteRepository.getClienteById(cliente.getIdClient());
            if(checkCliente.isEmpty()){
                return clienteRepository.save(cliente);
            }else {
                return cliente;
            }
        }
    }

    public void delete(Cliente cliente){
        clienteRepository.delete(cliente);
    }
}
