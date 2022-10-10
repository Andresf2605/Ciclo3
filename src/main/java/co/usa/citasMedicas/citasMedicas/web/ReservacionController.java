package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/Reservation")
public class ReservacionController {
    @Autowired
    private ReservacionService reservacionService;

    @GetMapping("/all")
    public List<Reservacion> getAll(){
        return reservacionService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservacion> getReservacionById(@PathVariable("id") int id){
        return reservacionService.getReservacionById(id);
    }
    @PostMapping("/save")
    public Reservacion save(@RequestBody Reservacion reservacion){
        return reservacionService.save(reservacion);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Reservacion reservacion){
        reservacionService.delete(reservacion);
    }
}
