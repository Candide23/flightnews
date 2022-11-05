package flightnews.flightnews.Models.Repository;

import flightnews.flightnews.Models.Reservation;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Integer> {
}
