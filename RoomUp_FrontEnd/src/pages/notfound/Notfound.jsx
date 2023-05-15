import "./notfound.css";
import React from 'react'
import nimage from "../notfound/404.png"

import { useNavigate } from 'react-router-dom';

export default function Notfound() {

    const navigate = useNavigate()

    return (

        <div className="Notfoundmaincontainer">
            <div className="Square1">

            </div>

            <div className="Square2">

            </div>

            <div className="404Logo">
                <img className="NImage" src={nimage} alt="Notfound"/>
            </div>

            <div className="404Name">
                <span className="TitleName">
                    Page Not Found
                </span>
            </div>
            
            <div className="BackButton">

                <button className="backbutton" onClick={() => navigate(-1)}>
                    Go Back
                </button>

            </div>
        </div>
    );
}