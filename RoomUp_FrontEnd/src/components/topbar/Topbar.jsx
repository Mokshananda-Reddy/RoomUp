import { useAuth } from "../auth";
import "./topbar.css";
import '@fortawesome/fontawesome-free/css/all.css';


export default function Topbar() {
    
    const auth = useAuth()
    
    return (
        <div className="Tbarmaincontainer">

            <div className="AppName">
                <span className="Logo">
                    RoomUp
                </span>
            </div>

            <div className="UserIcon">
                <span className="icon">
                    <i className="fas fa-user-secret"></i>
                </span>
            </div>

            <div className="UserName">
                <p>
                    {auth && auth.user ? auth.user : 'Guest'}
                </p>
            </div>

            <div className="line">

            </div>
        </div>
    );
}