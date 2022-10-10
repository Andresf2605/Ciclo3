package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.repository.crud.ReservacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservacionRepository {
    @Autowired
    private ReservacionCrudRepository reservacionCrudRepository;

    public List<Reservacion> getAll(){
        return (List<Reservacion>) reservacionCrudRepository.findAll();
    }
    public Optional<Reservacion> getReservacionById(int id){
        return reservacionCrudRepository.findById(id);
    }
    public Reservacion save(Reservacion reservacion){
        return reservacionCrudRepository.save(reservacion);
    }
    public void delete(Reservacion reservacion){
        reservacionCrudRepository.delete(reservacion);
    }
}
