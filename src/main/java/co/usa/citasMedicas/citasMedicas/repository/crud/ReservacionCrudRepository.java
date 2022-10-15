package co.usa.citasMedicas.citasMedicas.repository.crud;

import co.usa.citasMedicas.citasMedicas.model.Reservacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservacionCrudRepository extends CrudRepository<Reservacion,Integer> {

//    @Query("SELECT d.doctor, COUNT(d.doctor) from Reservacion AS group by d.doctor order by COUNT(d.doctor) DESC")
//    public List<Object[]> countTotalReservationByDoctor();

    @Query("SELECT c.client, COUNT(c.client) from Reservacion AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByCliente();


    public List<Reservacion> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservacion>findAllByStatus(String status);
}
