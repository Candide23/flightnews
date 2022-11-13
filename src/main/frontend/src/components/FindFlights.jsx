import React, { useState } from "react";
import { useNavigate } from "react-router-dom";



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
        <div>
            <h2>Find Your  Flight</h2>
            <form>
                From: <input type="text" name="from" onChange={e=>setFrom(e.target.value)} />
                To: <input type="text" name="to" onChange={e=>setTo(e.target.value)}/>
                Departure: <input type="text" name="departure" onChange={e=>setDepartureDate(e.target.value)}/>
                <button onClick={handleSubmit.bind(this)}>Search</button>
            </form>
        </div>
    )
}

export default FindFlights;