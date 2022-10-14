package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Cliente;
import co.usa.citasMedicas.citasMedicas.model.Doctor;
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

    public Cliente updateCliente(Cliente cliente){
        if (cliente.getIdClient()!=null){
            Optional<Cliente> e = getClienteById(cliente.getIdClient());
            if (!e.isEmpty()){
                if (cliente.getAge()!=null){
                    e.get().setAge(cliente.getAge());
                }
                if (cliente.getEmail()!=null){
                    e.get().setEmail(cliente.getEmail());
                }
                if (cliente.getMessages()!=null){
                    e.get().setMessages(cliente.getMessages());
                }
                if (cliente.getName()!=null){
                    e.get().setName(cliente.getName());
                }
                if (cliente.getPassword()!=null){
                    e.get().setPassword(cliente.getPassword());
                }
                if (cliente.getReservations()!=null){
                    e.get().setReservations(cliente.getReservations());
                }
                clienteRepository.save(e.get());
                return e.get();
            }else {
                return cliente;
            }
        }else {
            return cliente;
        }
    }

    public boolean delete(int id){
        Boolean aboolean = getClienteById(id).map(cliente->{
        clienteRepository.delete(cliente);
        return true;
        }).orElse(false);
        return aboolean;
    }
}
