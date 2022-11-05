package flightnews.flightnews.Models.Repository;

import flightnews.flightnews.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
