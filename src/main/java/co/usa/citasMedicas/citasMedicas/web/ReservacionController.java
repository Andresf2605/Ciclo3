package co.usa.citasMedicas.citasMedicas.web;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.model.custom.CountClients;
import co.usa.citasMedicas.citasMedicas.model.custom.StatusAmount;
import co.usa.citasMedicas.citasMedicas.service.ReservacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservacion update(@RequestBody Reservacion reservation) {
        return reservacionService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){
        return reservacionService.delete(id);
    }

    @GetMapping("/report-clients")
    public List<CountClients> getReservationsReportClient(){
        return reservacionService.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservacion> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservacionService.getReservationsPeriod(dateOne,dateTwo);
    }
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservacionService.getReservationsPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return reservacionService.getReservationsStatusReport();
    }
}
