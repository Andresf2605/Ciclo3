package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Calificacion;
import co.usa.citasMedicas.citasMedicas.repository.crud.CalificacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public class CalificacionRepository implements Serializable {
    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;

    public List<Calificacion> getAll(){
        return (List<Calificacion>) calificacionCrudRepository.findAll();
    }
    public Optional<Calificacion> getCalificacionById(int id){
        return calificacionCrudRepository.findById(id);
    }
    public Calificacion save(Calificacion calificacion){
        return calificacionCrudRepository.save(calificacion);
    }
    public void delete(Calificacion calificacion){
        calificacionCrudRepository.delete(calificacion);
    }
}
