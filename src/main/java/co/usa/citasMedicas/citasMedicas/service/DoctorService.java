package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }
    public Optional<Doctor> getDoctorById(int id){
        return doctorRepository.getDoctorById(id);
    }
    public Doctor saveDoctor(Doctor doctor){
        if(doctor.getId()==null){
            return doctorRepository.saveDoctor(doctor);
        }else {
            Optional<Doctor> checkDoctor = doctorRepository.getDoctorById(doctor.getId());
            if (checkDoctor.isEmpty()){
                return doctorRepository.saveDoctor(doctor);
            }else {
                return doctor;
            }
        }
    }
    public void deleteDoctor(Doctor doctor){
        doctorRepository.deleteDoctor(doctor);
    }
    public boolean deleteDoctor(int id) {
        Boolean aBoolean = getDoctorById(id).map(doctor -> {
            doctorRepository.deleteDoctor(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
