package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Mensajes;
import co.usa.citasMedicas.citasMedicas.repository.crud.MensajesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajesRepository {
    @Autowired
    private MensajesCrudRepository mensajesCrudRepository;

    public List<Mensajes> getAll(){
        return (List<Mensajes>) mensajesCrudRepository.findAll();
    }
    public Optional<Mensajes> getMensajeById(int id){
        return mensajesCrudRepository.findById(id);
    }
    public Mensajes save(Mensajes mensajes){
        return mensajesCrudRepository.save(mensajes);
    }
    public void delete(Mensajes mensajes){
        mensajesCrudRepository.delete(mensajes);
    }
}
