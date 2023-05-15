import "./sidebar.css";
import React from 'react';
import image from "../sidebar/Mindwiselogo-1.png";
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate } from 'react-router-dom';
import { useAuth } from "../auth";

export default function Sidebar() {

    const navigate = useNavigate()
    const auth = useAuth()

    const handleLogout = () => {
        auth.logout()
        navigate('/')
    }

    return (
        <div className="Sbarmaincontainer">

            <div className="MindWiseLogo">
                <img className="Image" src={image} alt="Mindwise"/>
            </div>

            <div className="DividingLine">
                <div className="line1"></div>
            </div>

            <div className="RequiredButtons">

                <button className="b1" onClick={()=>navigate('/dashboard')}>
                    <span className="icon">
                        <i className="fa-solid fa-house-chimney"></i>
                    </span>
                    Dashboard
                </button>

                <button className="b2" onClick={()=>navigate('/blockslist')}>
                    <span className="icon">
                        {/* <i className="fa-solid fa-user-tie"></i> */}
                        <i className="fa-solid fa-building-user"></i>
                    </span>
                    Block Managers
                </button>

                <button className="b3" onClick={()=>navigate('/studentslist')}>
                    <span className="icon">
                        {/* <i className="fa-solid fa-book-open-reader"></i> */}
                        <i className="fa-solid fa-user-graduate"></i>
                    </span>
                    Students
                </button>

                <button className="b5" onClick={handleLogout}>
                    <span className="icon">
                        <i className="fa-solid fa-right-from-bracket"></i>
                    </span>
                    Logout 
                </button>
                

            </div>

            <div className="DividingLine2">
                <div className="line2"></div>
            </div>

            <div className="LogoutButton">

            </div>

            <div className="DividingLine3">
                <div className="line3"></div>
            </div>

        </div>
    );
}