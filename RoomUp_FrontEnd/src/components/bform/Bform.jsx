import "./bform.css";

import React from 'react';
import { useState } from "react";
import TextField from '@mui/material/TextField';
import axios from "axios"
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { useNavigate } from 'react-router-dom';
import Email from 'emailjs-com';

import 'bootstrap/dist/css/bootstrap.min.css';


export default function Blockdetails() {

    const navigate = useNavigate()

    const [user,setUsers] = useState({
        name:"",
        dob:"",
        username:"",
        password:"",
        email:"",
        gender:"",
        registeredID:""

    });

    const onInputChange=(e)=>{
        setUsers({...user,[e.target.name]:e.target.value});
    };
    

    const sendEmail=async (e)=>{
        e.preventDefault();
        
        console.log("inside mailer");
        Email.sendForm('service_lmrp9uh', 'template_6g3n2sg', e.target, 'uDSocBPuV77OPgW5o')
          .then((result) => {
              console.log(result.text);
          }, (error) => {
              console.log(error.text);
          });

        await axios.post(global.ngroklink + "/block",user, { headers:{'Authorization': localStorage.getItem('jwt token')}}).then((response)=>{
        }).catch((error) => {
            alert('Error', error.message);
            console.log(error.message)
            });
        await axios.post(global.ngroklink + '/login', {"username":user.username, "role":"manager", "password" : user.password }, { headers:{'Authorization': localStorage.getItem('jwt token')}}); 
        e.target.reset()
        navigate("/blockslist");

      };

    return (
        <div className="Ddetailsmaincontainer">
            <div className="blockform">  
                <div className="PageHeading">
                    <span className="Dhead">
                        Block Manager Details
                    </span>
                </div>
                <div className="bformlayout"> 
                    <form onSubmit={sendEmail}>    
                        <Row>
                            <Col >
                                <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                    label="Name"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-name"
                                    size="normal"
                                    helperText="Please enter your fullname"
                                    name="name"
                                    value={user.name}
                                    onChange={(e)=>onInputChange(e)}

                                />
                            </Col>
                            <Col>
                                <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Date of Birth"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-dob"
                                    helperText="Please enter in yyyy-mm-dd format"
                                    name="dob"
                                    value={user.dob}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                        </Row>
                        <br />
                    
                        <Row>
                            <Col>
                            <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Username"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-username"
                                    helperText="Please enter your username"
                                    name="username"
                                    value={user.username}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                            <Col>
                                <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Password"
                                    required
                                    // type="password"
                                    variant="outlined"
                                    id="outlined-input-block-password"
                                    helperText="Please enter a strong password"
                                    name="password"
                                    value={user.password}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                        </Row>
                        <br />

                        <Row>
                            <Col>
                            <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Gender"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-gender"
                                    helperText="Please enter your gender"
                                    name="gender"
                                    value={user.gender}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                            <Col>
                                <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Registered-ID"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-registeredID"
                                    helperText="Please enter your registration Number"
                                    name="registeredID"
                                    value={user.registeredID}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                        </Row>
                        <br />

                        <Row>
                            <Col>
                                <TextField  InputLabelProps={{
                                        style: { color: "#FFFDD0" },
                                    }}
                                    label="Email-ID"
                                    required
                                    variant="outlined"
                                    id="outlined-input-block-emailID"
                                    helperText="Please enter your Email ID"
                                    name="email"
                                    value={user.email}
                                    onChange={(e)=>onInputChange(e)}
                                    inputProps={{
                                        style: {
                                            color: "white",
                                        }
                                    }}
                                />
                            </Col>
                        </Row>
                        <br />

                        <div className="BlockEmailButton">
                            <button type="submit" className="dsaveEmail">
                                Save
                            </button>

                        </div>

                    </form>
                </div>

            </div>
        </div>
    );
}
