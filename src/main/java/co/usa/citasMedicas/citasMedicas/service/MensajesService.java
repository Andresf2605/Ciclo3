package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Mensajes;
import co.usa.citasMedicas.citasMedicas.repository.MensajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajesService {
    @Autowired
    private MensajesRepository mensajesRepository;
    public List<Mensajes> getAll(){
        return (List<Mensajes>) mensajesRepository.getAll();
    }
    public Optional<Mensajes> getMensajeById(int id){
        return mensajesRepository.getMensajeById(id);
    }
    public Mensajes save(Mensajes mensajes){
        if (mensajes.getIdMessage() == null){
        return mensajesRepository.save(mensajes);
        }else {
            Optional<Mensajes> checkMensajes = mensajesRepository.getMensajeById(mensajes.getIdMessage());
            if (checkMensajes.isEmpty()){
                return mensajesRepository.save(mensajes);
            }else{
                return mensajes;
            }
        }
    }
    public void delete(Mensajes mensajes){
        mensajesRepository.delete(mensajes);
    }
}
