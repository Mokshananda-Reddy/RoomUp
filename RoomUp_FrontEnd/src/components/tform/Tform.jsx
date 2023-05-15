import "./tform.css";

import React from 'react';
import { useState } from "react";
import TextField from '@mui/material/TextField';
import axios from "axios"
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Box from '@mui/material/Box';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';


export default function Taskdetails() {

    const navigate = useNavigate()
    const studetails = JSON.parse(localStorage.getItem('currstudetails'));
    const [user,setUsers] = useState({
        service : "",
        date : "",
        feedback : "",
        room : "",
        description : "",
        studentID: studetails.studentID
        
    });

    //console.log(studetails.studentID);
    const onInputChange=(e)=>{
        
        setUsers({...user,[e.target.name]:e.target.value});
    };
    const onSubmit=async (e)=>{
        e.preventDefault();
        await axios.post(global.ngroklink + "/task", user, { headers:{'Authorization': localStorage.getItem('jwt token')}}).then((response)=>{
        }).catch((error) => {
            alert('Error', error.message);
            console.log(error.message)
            });
        console.log(user);
        navigate("/requestslist");
    };

    return (
        <div className="Tdetailsmaincontainer">
            <div className="taskform">  
                <div className="PageHeading">
                    <span className="Thead">
                        Service Request Details
                    </span>
                </div>
                <div className="tformlayout"> 
                    <Row>
                    <Col >
                        <TextField  InputLabelProps={{
                                    style: { color: "#FFFDD0" },
                                }}
                                label="Service Type"
                                required
                                variant="outlined"
                                id="outlined-input-service-type"
                                size="normal"
                                helperText="Please enter 'Standard' for Normal service and 'Urgent' for Fast service"
                                name="service"
                                value={user.service}
                                onChange={(e)=>onInputChange(e)}
                                inputProps={{
                                    style: {
                                        color: "white",
                                    }
                                }}
                            />
                        
                        </Col>
                        <Col >
                        <TextField  InputLabelProps={{
                                    style: { color: "#FFFDD0" },
                                }}
                                label="Date"
                                required
                                variant="outlined"
                                id="outlined-input-task-date"
                                size="normal"
                                helperText="Please enter the date in yyyy-mm-dd format for the service to be done"
                                name="date"
                                value={user.date}
                                onChange={(e)=>onInputChange(e)}
                                inputProps={{
                                    style: {
                                        color: "white",
                                    }
                                }}
                            />
                        
                        </Col>
                        <Col >
                        <TextField  InputLabelProps={{
                                    style: { color: "#FFFDD0" },
                                }}
                                label="Room Number"
                                required
                                variant="outlined"
                                id="outlined-input-room"
                                size="normal"
                                helperText="Please enter your Room Number"
                                name="room"
                                value={user.room}
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
                    <br />
                    <Row>
                    <Col>
                        <Box
                            sx={{
                                '& > :not(style)': { borderWidth: 2, borderLeftWidth: 6 , width: '60ch' },
                            }}
                        >
                            <TextField  InputLabelProps={{
                                    style: { color: "#FFFDD0" },
                                }}
                                label="Special Instructions"
                                required
                                variant="outlined"
                                id="outlined-input-description"
                                multiline
                                helperText="Please describe any special request that you want to have here"
                                name="description"
                                value={user.description}
                                onChange={(e)=>onInputChange(e)}
                                inputProps={{
                                    style: {
                                        color: "white",
                                    }
                                }}
                            />
                        </Box>
                    </Col>
                    <Col>
                        <Box
                            sx={{
                                '& > :not(style)': { borderWidth: 2, borderLeftWidth: 6 , width: '60ch' },
                            }}
                        >
                            <TextField  InputLabelProps={{
                                    style: { color: "#FFFDD0" },
                                }}
                                label="Feedback"
                                required
                                variant="outlined"
                                id="outlined-input-feedback"
                                multiline
                                helperText="Please give your feedback for the service"
                                name="feedback"
                                value={user.feedback}
                                onChange={(e)=>onInputChange(e)}
                                inputProps={{
                                    style: {
                                        color: "white",
                                    }
                                }}
                            />
                        </Box>
                    </Col>
                    </Row>
                    <br />

                </div>

                <div className="SaveButton">
                    <button className="tsave" onClick={(e)=>onSubmit(e)}>
                        Save
                    </button>

                </div>
            </div>
        </div>
    );
}

