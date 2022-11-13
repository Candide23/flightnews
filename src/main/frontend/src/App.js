import { Routes, Route } from "react-router-dom";
import FindFlights from "./components/FindFlights";
import DisplayFlights from "./components/DisplayFlights";
import PassengerDetails from "./components/PassengerDetails";
import ConfirmReservation from "./components/ConfirmReservation";
import "./App.css";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<FindFlights />} />
        <Route
          path="displayFlights/:from/:to/:departureDate"
          element={<DisplayFlights />}
        />
        <Route
          path="passengerDetails/:flightId"
          element={<PassengerDetails />}
        />
        <Route
          path="confirmReservation/:reservationId"
          element={<ConfirmReservation />}
        />
      </Routes>
    </div>
  );
}

export default App;
