import {useParams} from 'react-router-dom'
import './styles.css';

function ConfirmReservation() {
  const{reservationId}=useParams()
  return (
    <div className="reservation">
      <b>Flight Reservation is complete.The confirmation code is {reservationId}</b>
    </div>
  );
}

export default ConfirmReservation;;