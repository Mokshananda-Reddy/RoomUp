import './rlist.css';
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate, Outlet } from 'react-router-dom';
import axios from "axios"
import { useEffect, useState } from "react";
import "../ngrok";
import { useCookies } from 'react-cookie';


export default function Rlist() {

    const navigate = useNavigate()
    const [user,setUsers] = useState([])
    const [cookies] = useCookies(['name']);

    useEffect(()=>{
        loadRequests();
    }, [])

    const loadRequests=()=>{
        

        const details = cookies.name

        let username = null;

        if (details !== null) 
        {
            username = details;
        }
        
        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                Authorization: localStorage.getItem('jwt token')
            },
            params: {
                username: username
            }
        };

        axios.get(global.ngroklink + "/getstudentid", heads)
        .then((response)=>{
            localStorage.setItem("currstudetails", JSON.stringify(response.data));

            const headts = {
                headers:{
                    'ngrok-skip-browser-warning':'google-chrome',
                    Authorization: localStorage.getItem('jwt token')
                },
                params: {studentID: response.data['studentID']}
            };

            axios.get(global.ngroklink + "/gettasksbystudentid", headts).then((result) =>{
                setUsers([...result.data]);
            })

        })


    }


    function handleClicktasdetails(params) {
        navigate('requestdetails', { state: { data: Object.entries(params) } });
        localStorage.setItem("currreqdet", JSON.stringify(params));

    }

    return (

        <div className='Rlistmaincontainer'>

            <div className='listofrequests'>

                {
                    user.map((user)=>(
                        <button className={'request'} onClick={()=>handleClicktasdetails(user)}>
                            <span className="icon">
                                <i className="fas fa-bars-progress"></i>
                            </span>
                            {user.service}

                        </button>

                    ))
                }
            </div>

                <button className="addrequest" onClick={()=>navigate('/addrequest')}>
                    <span className="icon">
                        <i className="fa-solid fa-clipboard"></i>
                    </span>
                    Add a new Request

                </button>

            <Outlet/>
        </div>
    );
}