import "./slist.css";
import '@fortawesome/fontawesome-free/css/all.css';
import { useNavigate, Outlet } from 'react-router-dom';
import axios from "axios"
import { useEffect, useState } from "react";

export default function Slist() {
    
    const navigate = useNavigate()
    const [user,setUsers] = useState([])

    useEffect(()=>{
        loadStudents();
    },[])

    const loadStudents=()=>{
        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                'Authorization': localStorage.getItem('jwt token')
            }
        }
        axios.get(global.ngroklink + "/students", heads).then((result) =>{
            //console.log(result.data);
            setUsers(result.data);
        })
    }

    function handleClickpatdetails(params) {
        navigate('studentdetails', { state: { data: Object.entries(params) } });
        // console.log(Object.entries(params));
        localStorage.setItem("currpatdet", JSON.stringify(params));

    }

    return (
        <div className="Slistmaincontainer">

            <div className="listofstudents">

                {
                    user.map((user)=>(

                        <button className={'student'} onClick={()=>handleClickpatdetails(user)}>
                            <span className="icon">
                                <i className="fas fa-book-open-reader"></i>
                            </span>
                            {user.username}
                            <div className="Lastseentext">
                                {/* Lastseen */}
                            </div>
                        </button>

                    ))
                }
            </div>  
              
            <button className="addstudent" onClick={()=>navigate('/addstudent')}>
                <span className="icon">
                    <i className="fas fa-user-plus"></i>
                </span>
                Add a new Student

            </button>
            
            <Outlet/>
        </div>
        
    );
}