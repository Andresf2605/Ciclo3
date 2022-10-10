package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Calificacion;
import co.usa.citasMedicas.citasMedicas.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;
    public List<Calificacion> getAll(){
        return (List<Calificacion>) calificacionRepository.getAll();
    }
    public Optional<Calificacion> getCalificacionById(int id){
        return calificacionRepository.getCalificacionById(id);
    }
    public Calificacion save(Calificacion calificacion){
        if(calificacion.getId() == null) {
            return calificacionRepository.save(calificacion);
        }else{
            Optional<Calificacion> checkCalificacion = calificacionRepository.getCalificacionById(calificacion.getId());
            if(checkCalificacion.isEmpty()){
                return calificacionRepository.save(calificacion);
            }else {
                return calificacion;
            }
        }
    }
    public void delete(Calificacion calificacion){
        calificacionRepository.delete(calificacion);
    }
}
