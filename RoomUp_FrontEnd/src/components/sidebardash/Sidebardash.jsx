import "./sidebardash.css";
import React from 'react';
import image from "../sidebar/Mindwiselogo-1.png";
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate } from 'react-router-dom';
import { useAuth } from "../auth";

export default function Sidebarbash() {

    const navigate = useNavigate()
    const auth = useAuth()

    const handleLogout = () => {
        auth.logout()
        navigate('/')
    }

    return (
        <div className="Dasbarmaincontainer">

            <div className="DasMindWiseLogo">
                <img className="Image" src={image} alt="Mindwise"/>
            </div>

            <div className="DasDividingLine">
                <div className="dasline1"></div>
            </div>

            <div className="DasRequiredButtons">

                <button className="dasb1" onClick={()=>navigate('/dashboard')}>
                    <span className="icon">
                        <i className="fa-solid fa-house-chimney"></i>
                    </span>
                    Dashboard
                </button>
                
                <button className="dasb2" onClick={()=>navigate('/blockslist')}>
                    <span className="icon">
                        <i className="fa-solid fa-building-user"></i>
                    </span>
                    Block Managers
                </button>

                <button className="dasb3" onClick={()=>navigate('/studentslist')}>
                    <span className="icon">
                        <i className="fa-solid fa-user-graduate"></i>
                    </span>
                    Students
                </button>

                <button className="dasb5" onClick={handleLogout}>
                    <span className="icon">
                        <i className="fa-solid fa-right-from-bracket"></i>
                    </span>
                    Logout 
                </button>
                

            </div>

            <div className="dasDividingLine2">
                <div className="dasline2"></div>
            </div>

            <div className="LogoutButton">

            </div>

            <div className="dasDividingLine3">
                <div className="dasline3"></div>
            </div>

        </div>
    );
}