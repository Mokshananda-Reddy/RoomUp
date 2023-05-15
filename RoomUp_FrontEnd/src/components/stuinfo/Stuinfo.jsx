import './stuinfo.css';
import { Outlet, useNavigate } from 'react-router-dom';


export default function StudentInfo() {

    const patdetails = JSON.parse(localStorage.getItem('currpatdet'));
    const ID = patdetails.studentID;
    const name = patdetails.name;
    const dob = patdetails.dob;
    const gender = patdetails.gender;
    const username = patdetails.username;
    const room = patdetails.room;
    const admissionID = patdetails.admissionID;
    const email = patdetails.email;

    console.log(patdetails)
    
    const navigate = useNavigate();

    return(

        <div className='Stuinfomaincontainer'>

            <div className='PatDetails'>

                <div className='StudentID'>
                    <span className='Studentid'>
                        StudentID : 
                    </span>
                    <span className='studentid'>
                        {ID}
                    </span>
                </div>

                <div className='StudentName'>
                    <span className='Studentname'>
                        Name : 
                    </span>
                    <span className='studentname'>
                        {name}
                    </span>
                </div>

                <div className='StudentDob'>

                    <span className='Studentdob'>
                        DOB : 
                    </span>
                    <span className='studentdob'>
                        {dob}
                    </span>

                </div>

                <div className='StudentGender'>
                    
                    <span className='Studentgender'>
                        Gender : 
                    </span>
                    <span className='studentgender'>
                        {gender}
                    </span>
                    
                </div>

                <div className='StudentUsername'>

                    <span className='Studentusername'>
                        Username : 
                    </span>
                    <span className='studentusername'>
                        {username}
                    </span>
                
                </div>

                <div className='StudentRoom'>

                    <span className='Studentroom'>
                        Room : 
                    </span>
                    <span className='studentroom'>
                        {room}
                    </span>
                
                </div>                
                
                <div className='StudentAdmissionID'>

                    <span className='StudentadmissionID'>
                        AdmissionID : 
                    </span>
                    <span className='studentadmissionID'>
                        {admissionID}
                    </span>
                
                </div>

                <div className='StudentEmail'>

                    <span className='Studentemail'>
                        Email : 
                    </span>
                    <span className='studentemail'>
                        {email}
                    </span>
                
                </div>

                <div className="PatBackButton">

                    <button className="patbackbutton" onClick={() => navigate(-1)}>
                        Go Back
                    </button>

                </div>

            </div>
            
            <Outlet/>
        </div>
    );

}