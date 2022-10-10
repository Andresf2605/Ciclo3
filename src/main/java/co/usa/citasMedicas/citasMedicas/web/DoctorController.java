package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Doctor;
import co.usa.citasMedicas.citasMedicas.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll(){

        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctorById(@PathVariable("id") int id){
        return doctorService.getDoctorById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.saveDoctor(doctor);
    }
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@RequestBody Doctor doctor){
        doctorService.deleteDoctor(doctor);
    }
}
