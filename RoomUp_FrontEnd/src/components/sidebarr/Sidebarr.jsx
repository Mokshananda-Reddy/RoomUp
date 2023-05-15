import "./sidebarr.css";
import React from 'react';
import timage from "../sidebar/Mindwiselogo-1.png";
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate } from 'react-router-dom';
import { useAuth } from "../auth";

export default function Sidebart() {

    const navigate = useNavigate()
    const auth = useAuth()

    const handleLogout = () => {
        auth.logout()
        navigate('/')
    }

    return (
        <div className="rbarmaincontainer">

            <div className="RMindWiseLogo">
                <img className="RImage" src={timage} alt="Mindwise"/>
            </div>

            <div className="RDividingLine">
                <div className="rline1"></div>
            </div>

            <div className="RRequiredButtons">

                <buttons className="rb4" onClick={()=>navigate('/requestslist')}>
                    <span className="icon">
                        <i className="fa-solid fa-list-check"></i>
                    </span>
                    Services
                </buttons>

                <button className="rb5" onClick={handleLogout}>
                    <span className="icon">
                        <i className="fa-solid fa-right-from-bracket"></i>
                    </span>
                    Logout  
                </button>
                

            </div>

            <div className="RDividingLine2">
                <div className="rline2"></div>
            </div>

            <div className="LogoutButton">

            </div>

            <div className="RDividingLine3">
                <div className="rline3"></div>
            </div>

        </div>

    );
}