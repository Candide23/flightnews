package flightnews.flightnews.Controllers;

import flightnews.flightnews.Models.Flight;
import flightnews.flightnews.Models.Passenger;
import flightnews.flightnews.Models.Repository.FlightRepository;
import flightnews.flightnews.Models.Repository.PassengerRepository;
import flightnews.flightnews.Models.Repository.ReservationRepository;
import flightnews.flightnews.Models.Reservation;
import flightnews.flightnews.Models.dto.CreateReservation;
import flightnews.flightnews.Models.dto.UpdateReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {

    //this annotation tells spring that it should
    // create implementation of this repository dynamically
    // at runtime and inject it on autowire it into this field
    // so that we can use it wherever

    // it will fetch all the flight and convert them into a list
    // of flights and return it back

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    //So we have modified to find flights method from 2 and departure
    // city and on the repository we have a fine flights method that
    // filters out the flights based on those three parameters in the
    // next lecture

    @RequestMapping("/flights")
    public List<Flight> findFlights(@RequestParam(name = "from",required = false) String from,@RequestParam(name = "to", required = false) String to,
                                    @RequestParam(name = "departureDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date departureDate) {
        return flightRepository.findFlights(from, to, departureDate);
    }

    @RequestMapping("/flights/{id}")
    public Flight findFlight(@PathVariable("id")int id) {
        return flightRepository.findById(id).get();
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    @Transactional
    public Reservation saveReservation(@RequestBody CreateReservation request) {
        System.out.println("Save Reservation" + request.getFlightId());
        Flight flight= flightRepository.findById(request.getFlightId()).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setMiddleName(request.getPassengerMiddleName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerEmail());

         Passenger savePassenger = passengerRepository.save(passenger);

         Reservation reservation = new Reservation();
         reservation.setFlight(flight);
         reservation.setPassenger(savePassenger);
         reservation.setCheckIn(false);

        return reservationRepository.save(reservation);

    }

    @RequestMapping(value = "/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") int id) {
        return reservationRepository.findById(id).get();

    }

    @RequestMapping(value = "/reservations", method = RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody UpdateReservation request) {

        // if the reservation has an ID already then this method knows that
        // this not a new reservation it is a update that is happening
        // so it will execute a update sequel

        // We're fetchinh the current reservation from the DB using the ID
        // in the request then we are setting the numbers of bags that come in the
        // request and checking flag to whatever the clinet sends in for checkin
        // That will be true and we are saving that reservation which does the update
        // and you are returning that back

        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckIn(request.isCheckIn());
        return reservationRepository.save(reservation);

    }

}
