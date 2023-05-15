import './pagebarblockdet.css';
import React from 'react';
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate } from 'react-router-dom';


export default function Pagebarblockdetails() {
    
    const navigate = useNavigate()
    const docdetails = JSON.parse(localStorage.getItem('currdocdet'));
    const name = docdetails.name;
    
    return(

        <div className='Ddtbarmaincontainer'>
            
            <div className='DdtPresentUsage1' onClick={()=>navigate('/blockslist')}>
                <span className="DdtPre">
                    Block Managers
                </span>
            </div>  

            <div className='DdtPresentUsage2'>
                <span className="icon">
                    <i className="fas fa-arrow-right"></i>
                </span>
            </div>

            <div className='DdtPresentUsage3'>
                <span className="DdtPre1">
                    {name}
                </span>
            </div>


            <div className='Ddtdivider'>

            </div>

        </div>
    );

}