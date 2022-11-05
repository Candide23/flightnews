package flightnews.flightnews.Models.dto;

/*A data transfer object (or DTO) is an object that enables multiple
 other objects or values to be passed around an application, in a single container.
 For reasons that will make more sense shortly, we will want to utilize a DTO to hold
 Event and Tag instances that we want to relate to each other.*/

public class CreateReservation {

    private int flightId;
    private String passengerFirstName;
    private String passengerLastName;
    private String passengerMiddleName;
    private String passengerEmail;
    private String passengerPhone;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getPassengerMiddleName() {
        return passengerMiddleName;
    }

    public void setPassengerMiddleName(String passengerMiddleName) {
        this.passengerMiddleName = passengerMiddleName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
