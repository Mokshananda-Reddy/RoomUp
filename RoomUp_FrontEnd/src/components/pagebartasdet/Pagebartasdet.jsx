import './pagebartasdet.css';
import React from 'react';
import '@fortawesome/fontawesome-free/css/all.css';
// import { useNavigate } from 'react-router-dom';


export default function Pagebartaskdetails() {
    
    // const navigate = useNavigate()
    const tasdetails = JSON.parse(localStorage.getItem('currtasdet'));
    let name = null;

    if (tasdetails !== null) 
    {
        name = tasdetails.service;
    }

    return(

        <div className='Tdtbarmaincontainer'>
            
            <div className='TdtPresentUsage1'>
                <span className="TdtPre">
                    Services
                </span>
            </div>  

            <div className='TdtPresentUsage2'>
                <span className="icon">
                    <i className="fas fa-arrow-right"></i>
                </span>
            </div>

            <div className='TdtPresentUsage3'>
                <span className="TdtPre1">
                    {name}
                </span>
            </div>


            <div className='Tdtdivider'>

            </div>

        </div>
    );

}