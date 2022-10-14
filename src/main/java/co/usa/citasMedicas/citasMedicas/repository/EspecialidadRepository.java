package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.model.Especialidades;
import co.usa.citasMedicas.citasMedicas.repository.crud.EspecialidadCrudRepository;
import co.usa.citasMedicas.citasMedicas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EspecialidadRepository {
    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;
    public List<Especialidades> getAll(){
        return (List<Especialidades>) especialidadCrudRepository.findAll();
    }
    public Optional<Especialidades> getEspecialidadById(int id){
        return especialidadCrudRepository.findById(id);
    }
    public Especialidades saveEspecialidad(Especialidades especialidades){
        return especialidadCrudRepository.save(especialidades);
    }
    public void deleteespecialidad(Especialidades especialidades){
        especialidadCrudRepository.delete(especialidades);
    }
}
