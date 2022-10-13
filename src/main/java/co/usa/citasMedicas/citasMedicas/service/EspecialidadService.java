package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.model.Especialidades;
import co.usa.citasMedicas.citasMedicas.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService {
    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidades> getAll(){
        return especialidadRepository.getAll();
    }
    public Optional<Especialidades> getEspecialidadById(int id){
        return especialidadRepository.getEspecialidadById(id);
    }
    public Especialidades saveEspecialidad(Especialidades especialidad){
        if(especialidad.getId()==null){
            return especialidadRepository.saveEspecialidad(especialidad);
        }else {
            Optional<Especialidades> checkDoctor = especialidadRepository.getEspecialidadById(especialidad.getId());
            if (checkDoctor.isEmpty()){
                return especialidadRepository.saveEspecialidad(especialidad);
            }else {
                return especialidad;
            }
        }
    }
    public Boolean deleteEspecialidad(int id){
        Boolean aboolean = getEspecialidadById(id).map(especialidad->{
        especialidadRepository.deleteespecialidad(especialidad);
        return true;
        }).orElse(false);
        return aboolean;
    }

}
