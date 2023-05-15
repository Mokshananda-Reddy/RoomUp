import './blockinfo.css';
import { Outlet, useNavigate } from 'react-router-dom';


export default function BlockInfo() {

    const docdetails = JSON.parse(localStorage.getItem('currdocdet'));
    const ID = docdetails.blockID;
    const name = docdetails.name;
    const dob = docdetails.dob;
    const gender = docdetails.gender;
    const username = docdetails.username;
    const registeredID = docdetails.registeredID;
    const email = docdetails.email;

    console.log(docdetails)
    
    const navigate = useNavigate();

    return(

        <div className='Blockinfomaincontainer'>

            <div className='DocDetails'>

                <div className='BlockID'>
                    <span className='Blockid'>
                        BlockID : 
                    </span>
                    <span className='blockid'>
                        {ID}
                    </span>
                </div>

                <div className='BlockName'>
                    <span className='Blockname'>
                        Name : 
                    </span>
                    <span className='blockname'>
                        {name}
                    </span>
                </div>

                <div className='BlockDob'>

                    <span className='Blockdob'>
                        DOB : 
                    </span>
                    <span className='blockdob'>
                        {dob}
                    </span>

                </div>

                <div className='BlockGender'>
                    
                    <span className='Blockgender'>
                        Gender : 
                    </span>
                    <span className='blockgender'>
                        {gender}
                    </span>
                    
                </div>

                <div className='BlockStatus'>

                    <span className='Blockstatus'>
                        Username : 
                    </span>
                    <span className='blockstatus'>
                        {username}
                    </span>
                
                </div>
                
                <div className='BlockRegisteredID'>
                    <span className='BlockregisteredID'>
                        RegisteredID : 
                    </span>
                    <span className='blockregisteredID'>
                        {registeredID}
                    </span>
                </div>
                
                <div className='BlockSpecialization'>
                    <span className='Blockspecialization'>
                        Email : 
                    </span>
                    <span className='blockspecialization'>
                        {email}
                    </span>
                </div>

                <div className="DocBackButton">

                    <button className="docbackbutton" onClick={() => navigate(-1)}>
                        Go Back
                    </button>

                </div>

            </div>
            
            <Outlet/>
        </div>
    );

}