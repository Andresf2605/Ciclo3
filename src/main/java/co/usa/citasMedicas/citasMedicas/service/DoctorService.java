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

    public Doctor updateDoctor(Doctor doctor){
        if (doctor.getId()!=null){
            Optional<Doctor> e = getDoctorById(doctor.getId());
            if (!e.isEmpty()){
                if (doctor.getDepartment()!=null){
                    e.get().setDepartment(doctor.getDepartment());
                }
                if (doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getMessages()!=null){
                    e.get().setMessages(doctor.getMessages());
                }
                if (doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if (doctor.getReservations()!=null){
                    e.get().setReservations(doctor.getReservations());
                }
                if (doctor.getSpecialty()!=null){
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                if (doctor.getYear()!=null){
                    e.get().setYear(doctor.getYear());
                }
                doctorRepository.saveDoctor(e.get());
                return e.get();
            }else {
                return doctor;
            }
        }else {
            return doctor;
        }
    }

    public boolean deleteDoctor(int id) {
        Boolean aBoolean = getDoctorById(id).map(doctor -> {
            doctorRepository.deleteDoctor(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
