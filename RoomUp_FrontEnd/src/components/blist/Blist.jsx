import "./blist.css";
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate, Outlet } from 'react-router-dom';
import axios from "axios"
import { useEffect, useState } from "react";

export default function Blist() {
    
    const navigate = useNavigate()
    const [user,setUsers] = useState([]);

    useEffect(()=>{
        loadBlocks();
    },[])

    const loadBlocks=()=>{
        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                'Authorization': localStorage.getItem('jwt token')
            }
        }

        axios.get(global.ngroklink + "/blocks", heads).then((result) =>{
            //console.log(result.data);
            setUsers(result.data);
        })

    };

    function handleClickdocdetails(params) {
        navigate('blockdetails', { state: { data: Object.entries(params) } });
        localStorage.setItem("currdocdet", JSON.stringify(params));

    }

    return (
        <div className="Blistmaincontainer">

            <div className="listofblocks">
                {
                    user.map((user)=>(
                        <button className='block' alt="Manager Buttons" onClick={()=>handleClickdocdetails(user)}>
                            <span className="icon">
                                <i className="fas fa-user-tie"></i>
                            </span>
                            {user.username}
                            <div className="Lastseentext">
                                {/* Lastseen */}
                            </div>
                        </button>

                    ))
                }

            </div>

            <button className="addblock" onClick={()=>navigate('/addblock')}>
                    <span className="icon">
                        <i className="fas fa-user-plus"></i>
                    </span>
                    Add a new Block Manager

            </button>
            
            <Outlet/>
        </div>
        
    );
}