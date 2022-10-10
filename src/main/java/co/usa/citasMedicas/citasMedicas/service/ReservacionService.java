package co.usa.citasMedicas.citasMedicas.service;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
        if(reservacion.getIdReservation() ==null){
            reservacion.setStatus(HttpStatus.CREATED);
            return reservacionRepository.save(reservacion);
        }else {
            Optional<Reservacion> checkReservacion = reservacionRepository.getReservacionById(reservacion.getIdReservation());
            if(checkReservacion.isEmpty()){
                reservacion.setStatus(HttpStatus.CREATED);
                return reservacionRepository.save(reservacion);
            }else {
                return reservacion;
            }
        }
    }
    public void delete(Reservacion reservacion){
        reservacionRepository.delete(reservacion);
    }
}
