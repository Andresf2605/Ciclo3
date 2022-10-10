package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.repository.crud.DoctorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {
    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<Doctor> getAll(){
        return (List<Doctor>) doctorCrudRepository.findAll();
    }
    public Optional<Doctor> getDoctorById(int id){
        return doctorCrudRepository.findById(id);
    }
    public Doctor saveDoctor(Doctor doctor){
        return doctorCrudRepository.save(doctor);
    }
    public void deleteDoctor(Doctor doctor){
        doctorCrudRepository.delete(doctor);
    }

}
