package flightnews.flightnews.Models;

import javax.persistence.*;

@Entity
public class Reservation extends AbstractEntity {



    private boolean checkIn;
    private int numberOfBags;
    //Each Reservation will have one reservation
    @OneToOne
    private Flight flight;
    //Each Reservation will have one passenger
    @OneToOne
    private  Passenger passenger;

    // So whenever we save a reservation automatically the flight
    // primary key should be saved in the reservation table and the
    // passenger information as that if the passenger does not exist
    // in the database the passenger will be created a row will be
    // created in the passenger table and that primary key will be saved
    // in the reservation table right here



    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
