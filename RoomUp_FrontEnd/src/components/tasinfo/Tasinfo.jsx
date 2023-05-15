import './tasinfo.css';
import "../../components/ngrok";
import { Outlet, useNavigate } from 'react-router-dom';


export default function TaskInfo() {

    const tasdetails = JSON.parse(localStorage.getItem('currtasdet'));
    let ID = null;
    let service = null;
    let date = null;
    let feedback = null;
    let room = null;
    let description = null;

    if (tasdetails !== null) 
    {
        ID = tasdetails.taskID;
        service = tasdetails.service;
        date = tasdetails.date;
        feedback = tasdetails.feedback;
        room = tasdetails.room;
        description = tasdetails.description;
    }

  
    const navigate = useNavigate();


    return(

        <div className='Tasinfomaincontainer'>

            <div className='TasDetails'>

                <div className='TaskID'>
                    <span className='Taskid'>
                        ServiceID : 
                    </span>
                    <span className='taskid'>
                        {ID && ID}
                    </span>
                </div>

                <div className='TaskName'>
                    <span className='Taskname'>
                        Service Type : 
                    </span>
                    <span className='taskname'>
                        {service && service}
                    </span>
                </div>

                <div className='TaskDefaultflag'>

                    <span className='Taskdefaultflag'>
                        Date : 
                    </span>
                    <span className='taskdefaultflag'>
                        {date && date}
                    </span>

                </div>

                <div className='TaskRoom'>

                    <span className='Taskroom'>
                        Room Number : 
                    </span>
                    <span className='taskroom'>
                        {room && room}
                    </span>

                </div>                

                <div className='TaskAnswer'>

                    <span className='Taskanswer'>
                        Feedback : 
                    </span>
                    <span className='taskanswer'>
                        {feedback && feedback}
                    </span>
                
                </div>
                
                <div className='TaskDescription'>
                    <span className='Taskdescription'>
                        Special Requests : 
                    </span>
                    <span className='taskdescription'>
                        {description && description}
                    </span>
                </div>

                <div className="TasBackButton">

                    <button className="tasbackbutton" onClick={() => navigate(-1)}>
                        Go Back
                    </button>

                </div>

            </div>
            
            <Outlet/>
        </div>
    );

}