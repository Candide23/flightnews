import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { Link } from "react-router-dom";



function DisplayFlights() {

    //These three will be fecthed from the URL and then they will be assigned to the variables 
    const {from, to, departureDate} = useParams();
    // will fetch data from the backend and then this flight will be filled in for us 
    const [flightData, setFlightData] = useState([])
    // when we fecth the data from the backend we want it be true
    const [isLoading, setLoading] = useState(true)

    // we need this when we make the backend call using axes 
    let count = 0;

    //* count: we want it to be invoked only once, so it will execute once
    // UseEffect should execute once that when we fetch the data from the back end
    //* setLoading will be set false onmy once the dat is loaded

    useEffect(()=>{
    axios.get('http://localhost:8081/flightnews/flights?from='+from+'&to='+to
    +'&departureDate='+departureDate).then(res=>{
      setFlightData(res.data);
      setLoading(false);
    })
  },[from,to,departureDate],count)

// if we try to render this flight"flightData", data will not be available and we'll end up into error
// So we want to render this onmy when flight data has already been feched from backend
    return(

        <div>

            <h2>Flights:</h2>
            <table>
                <thead>
                            <tr>

                    <th>Airlines</th>
                    <th>Departures City</th>
                    <th>Arrival City</th>
                    <th>Departure Date and Time</th>
                                </tr>

                </thead>
                <tbody>
          {!isLoading?flightData.map((flight, index)=><RowCreator key={index} item={flight}/>):null}
                </tbody>
            </table>

            
        </div>

    )
}

 function RowCreator(props) {
      var flight = props.item

       return <tr>
    <td>{flight.companyName}</td>
    <td>{flight.departureCity}</td>
    <td>{flight.arrivalCity}</td>
    <td>{flight.estimatedDepartureTime}</td>
    <td><Link to={'/passengerDetails/'+flight.id}>Select</Link></td>
  </tr>
  }

export default DisplayFlights;