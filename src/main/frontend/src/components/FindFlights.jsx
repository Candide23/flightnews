import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import './styles.css';
import flight from './image/flight.jpeg'





function FindFlights() {
    const[from, setFrom] = useState('')
    const[to, setTo] = useState('');
    const[departureDate, setDepartureDate] = useState('');
    const navigate = useNavigate();

    const handleSubmit=(event)=>{
        event.preventDefault();
        navigate('/displayFlights/' + from+'/'+to+'/'+departureDate)
    }
    return(
         <div className="new-flight-container">
                    <div className="content">
                        <section>
                            <img src={flight} alt="FGAirlines" />

                            <h1>Find Your  Flight</h1>
                            <p>Cadastre um novo voo e coloque-o para venda agora mesmo!</p>


                        </section>

            <form>
                <input type="text" name="from"  placeholder="From" onChange={e=>setFrom(e.target.value)} />
                 <input type="text" name="to"  placeholder="To" onChange={e=>setTo(e.target.value)}/>
               <input type="text" name="departure"  placeholder="Departure" onChange={e=>setDepartureDate(e.target.value)}/>
                <button onClick={handleSubmit.bind(this)}>Search</button>
            </form>
               </div>
        </div>
    )
}

export default FindFlights;