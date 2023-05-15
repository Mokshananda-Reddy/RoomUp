import "./dash.css";
import '@fortawesome/fontawesome-free/css/all.css';
import React from 'react';
import axios from "axios"
import { useEffect, useState } from "react";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Doughnut } from 'react-chartjs-2';

ChartJS.register(ArcElement, Tooltip, Legend);


export default function Dashboardpanel() {
    
    const [allStudents,setAllStudents] = useState([])
    const [allBlocks,setAllBlocks] = useState([])

    useEffect(()=>{
        loadBlocks();
        loadStudents();
    },[])

    const loadBlocks=()=>{
        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                'Authorization': localStorage.getItem('jwt token')
            }
        }

        axios.get(global.ngroklink + "/blocks", heads).then((result) =>{
            setAllBlocks(result.data.length);
        })

    };

    const loadStudents=()=>{
        const heads = {
            headers:{
                'ngrok-skip-browser-warning':'google-chrome',
                'Authorization': localStorage.getItem('jwt token')
            }
        }

        axios.get(global.ngroklink + "/students", heads).then((result) =>{
            console.log(result.data)
            setAllStudents(result.data.length);
        })

    };

    return (
        <div className="Dashmaincontainer">

            <div className="chart1">
                
                <Doughnut data={{
                    labels:['Block Managers','Students'],
                    datasets:[
                        {
                            label: "Users Split", 
                            data:[allBlocks, allStudents],
                            backgroundColor: [
                                "#2EEE9D",
                                "#FFFDD0"
                            
                            ],
                            borderColor: [
                                "#2EEE9D",
                                "#FFFDD0"
                            ],
                            borderWidth: 1,
                        },
                    ]
                }} /> 

            </div>
        </div>
        
    );
}