package flightnews.flightnews.Models.Repository;

import flightnews.flightnews.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

   @Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
   List<Flight> findFlights(@Param("departureCity") String from,@Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);


}
