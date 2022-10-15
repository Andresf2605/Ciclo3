package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.model.custom.CountClients;
import co.usa.citasMedicas.citasMedicas.model.custom.StatusAmount;
import co.usa.citasMedicas.citasMedicas.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservacionService {
    @Autowired
    private ReservacionRepository reservacionRepository;

    public List<Reservacion> getAll(){
        return reservacionRepository.getAll();
    }
    public Optional<Reservacion> getReservacionById(int id){
        return reservacionRepository.getReservacionById(id);
    }
    public Reservacion save(Reservacion reservacion){
        if(reservacion.getIdReservation()==null){
            return reservacionRepository.save(reservacion);
        }else{
            Optional<Reservacion> e= reservacionRepository.getReservacionById(reservacion.getIdReservation());
            if(e.isEmpty()){
                return reservacionRepository.save(reservacion);
            }else{
                return reservacion;
            }
        }
    }
    public Reservacion update(Reservacion reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservacion> e= reservacionRepository.getReservacionById(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                reservacionRepository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    public Boolean delete(int id){
        Boolean aboolean = getReservacionById(id).map(reservacion -> {
        reservacionRepository.delete(reservacion);
        return true;
        }).orElse(false);
        return aboolean;
    }

    public List<CountClients> getTopClients(){
        return reservacionRepository.getTopClients();
    }

    public List<Reservacion> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservacionRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public StatusAmount getReservationsStatusReport(){
        List<Reservacion>completed=reservacionRepository.getReservationByStatus("completed");
        List<Reservacion>cancelled=reservacionRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }

}
