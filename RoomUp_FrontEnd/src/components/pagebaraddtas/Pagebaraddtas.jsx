import './pagebaraddtas.css';
import React from 'react';
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate } from 'react-router-dom';


export default function Pagebaraddstudent() {
    
    const navigate = useNavigate()

    return(

        <div className='Atbarmaincontainer'>
            
            <div className='AtPresentUsage1' onClick={()=>navigate('/requestslist')}>
                <span className="AtPre">
                    Requesting Service
                </span>
            </div>  

            <div className='Atdivider'>

            </div>

        </div>
    );

}