import './tlist.css';
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate, Outlet } from 'react-router-dom';
import axios from "axios"
import { useEffect, useState} from "react";
import "../../components/ngrok";

export default function Tlist() {

    const navigate = useNavigate()
    const [user,setUsers] = useState([])

    useEffect(()=>{
        loadTasks();
    },[])

    const loadTasks=()=>{

        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                'Authorization': localStorage.getItem('jwt token')
            }
        }
        
        axios.get(global.ngroklink + "/tasks", heads).then((result) =>{
            console.log(result.data);
            setUsers(result.data);
        })
    }

    function handleClicktasdetails(params) {
        navigate('taskdetails', { state: { data: Object.entries(params) } });
        localStorage.setItem("currtasdet", JSON.stringify(params));

    }


    return (

        <div className='Tlistmaincontainer'>

            <div className='listoftasks'>

                {
                    user.map((user)=>(
                        
                        <button className={'task'} onClick={()=>handleClicktasdetails(user)}>
                            <span className="icon">
                                <i className="fas fa-bars-progress"></i>
                            </span>
                            {user.service}

                        </button>
                        
                    ))
                }

            </div>


            <Outlet/>
        </div>
    );
}