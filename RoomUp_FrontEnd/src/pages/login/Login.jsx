import "./login.css";
import React, { useState } from 'react'
import limage from "../login/Mindwiselogo-1.png"
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useAuth } from "../../components/auth";

export default function Login() {

    const navigate = useNavigate()
    const [Username, setUsername] = useState('');
    const [Password, setPassword] = useState('');
    const [Role, setRole] = useState('');
    const auth = useAuth()
 

    const handleInputChangeUsername = (event) => {
        setUsername(event.target.value);
    }

    const handleInputChangePassword = (event) => {
        setPassword(event.target.value);
    }

    const handleInputChangeRole = (event) => {
        setRole(event.target.value);
    }

    const getStudentDetails = async () => {
        const heads = {
          headers: {
            'ngrok-skip-browser-warning': 'google-chrome',
            Authorization: localStorage.getItem('jwt token')
          },
          params: {
            username: Username
          }
        };
      
        console.log(Username);
      
        try {
          const userdetails = await axios.get(
            global.ngroklink + '/getstudentid',
            heads
          );
      
          console.log(userdetails);
          localStorage.setItem('userdetails', JSON.stringify(userdetails.data));
        } catch (error) {
          console.log(error);
        }
      };
      

    const handleLogin =() => {
        axios.post(global.ngroklink + "/validate", {"username":Username, "role":Role, "password" : Password } 
        ).then((response) => {
        console.log(response.data);

            if(response.data)
            {
                
                axios.post(global.ngroklink + "/signin", {"username":Username, "password": Password}
                ).then((response1) => {
                    localStorage.setItem("jwt token", response1.data["token"]);

                })

                auth.login(Username)

                if(Role === "admin")
                {
                    navigate('dashboard', { replace: true})
                }

                if(Role === "manager") //change it to manager later
                {
                    navigate('/taskslist', { replace: true})
                }

                if(Role === "student")
                {
                    getStudentDetails();
                    navigate('/requestslist', { replace: true})
                }
                
            }
            else
            {
                alert('Username/Password Incorrect');
            }
            }).catch((error) => {
            alert('Error', error.message);
            console.log(error.message)
            });
    }

    return (

        <div className="Loginmaincontainer">
            <div className="Square1">

            </div>

            <div className="Square2">

            </div>

            <div className="LoginMindwiseLogo">
                <img className="LImage" src={limage} alt="Mindwise"/>
            </div>

            <div className="LoginAppName">
                <span className="LLogo">
                    RoomUp
                </span>
            </div>

            <div className="Input1">

                <input 
                    type="text"
                    value={Username}
                    onChange={handleInputChangeUsername}
                    placeholder="Username"  
                    className="Rounded-input1"
                />

            </div>

            <div className="Input2">

                <input 
                    type="password"
                    value={Password}
                    onChange={handleInputChangePassword}
                    placeholder="Password"  
                    className="Rounded-input2"
                />

            </div>

            <div className="Input3">

                <input 
                    type="text"
                    value={Role}
                    onChange={handleInputChangeRole}
                    placeholder="Role [manager/student/admin] " 
                    className="Rounded-input3"
                />

            </div>
            
            <div className="LoginButton">

                <button className="loginbutton" onClick={handleLogin}>
                    Login
                </button>

            </div>
        </div>
    );
}