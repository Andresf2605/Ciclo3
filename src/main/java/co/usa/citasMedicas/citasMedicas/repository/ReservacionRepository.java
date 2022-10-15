package co.usa.citasMedicas.citasMedicas.repository;

import co.usa.citasMedicas.citasMedicas.model.Cliente;
import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import co.usa.citasMedicas.citasMedicas.model.custom.CountClients;
import co.usa.citasMedicas.citasMedicas.repository.crud.ReservacionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClients> getTopClients(){
        List<CountClients> res =new ArrayList<>();
        List<Object[]> report = reservacionCrudRepository.countTotalReservationByCliente();
        for (int i =0; i<report.size();i++){
            res.add(new CountClients((Long) report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservacion> getReservationPeriod(Date a, Date b){
        return reservacionCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservacion> getReservationByStatus(String status){
        return reservacionCrudRepository.findAllByStatus(status);
    }


}
