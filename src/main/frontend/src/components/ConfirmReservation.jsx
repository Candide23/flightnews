import {useParams} from 'react-router-dom'

function ConfirmReservation() {
  const{reservationId}=useParams()
  return (
    <div>
      <b>Flight Reservation is complete.The confirmation code is {reservationId}</b>
    </div>
  );
}

export default ConfirmReservation;;