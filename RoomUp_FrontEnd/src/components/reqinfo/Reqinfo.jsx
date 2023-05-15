import './reqinfo.css';
// import axios from 'axios';
import "../ngrok";
// import { useEffect } from "react";
import { Outlet, useNavigate } from 'react-router-dom';


export default function RequestInfo() {

    const reqdetails = JSON.parse(localStorage.getItem('currreqdet'));
    const ID = reqdetails.taskID;
    const service = reqdetails.service;
    const date = reqdetails.date;
    const feedback = reqdetails.feedback;
    const room = reqdetails.room;
    const description = reqdetails.description;
  
    const navigate = useNavigate();


    return(

        <div className='Reqinfomaincontainer'>

            <div className='ReqDetails'>

                <div className='RequestID'>
                    <span className='Requestid'>
                        ServiceID : 
                    </span>
                    <span className='requestid'>
                        {ID}
                    </span>
                </div>

                <div className='RequestName'>
                    <span className='Requestname'>
                        Service Type : 
                    </span>
                    <span className='requestname'>
                        {service}
                    </span>
                </div>

                <div className='RequestDefaultflag'>

                    <span className='Requestdefaultflag'>
                        Date : 
                    </span>
                    <span className='requestdefaultflag'>
                        {date}
                    </span>

                </div>

                <div className='RequestRoom'>

                    <span className='Requestroom'>
                        Room Number : 
                    </span>
                    <span className='requestroom'>
                        {room}
                    </span>

                </div>                 

                <div className='RequestAnswer'>

                    <span className='Requestanswer'>
                        Feedback : 
                    </span>
                    <span className='requestanswer'>
                        {feedback}
                    </span>
                
                </div>
                
                <div className='RequestDescription'>
                    <span className='Requestdescription'>
                        Special Requests : 
                    </span>
                    <span className='requestdescription'>
                        {description}
                    </span>
                </div>

                <div className="ReqBackButton">

                    <button className="reqbackbutton" onClick={() => navigate(-1)}>
                        Go Back
                    </button>

                </div>

            </div>
            
            <Outlet/>
        </div>
    );

}