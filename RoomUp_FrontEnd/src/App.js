import Login from "./pages/login/Login"
import Studentslist from "./pages/studentslist/Studentslist";
import Blockslist from "./pages/blockslist/Blockslist";
import Taskslist from "./pages/tasklist/Tasklist";
import Requestslist from "./pages/requestlist/Requestlist";
import Addstudent from "./pages/addstudent/Addstudent";
import Addblock from "./pages/addblock/Addblock";
import Addtask from "./pages/addtask/Addtask";
import Notfound from "./pages/notfound/Notfound"
import Blockdetails from "./pages/blockdetails/Blockdetails";
import Studentdetails from "./pages/studentdetails/Studentdetails";
import Taskdetails from "./pages/taskdetails/Taskdetails";
import Requestdetails from "./pages/requestdetails/Requestdetails";
import Dashboard from "./pages/dashboard/Dashboard";
import { Routes, Route } from 'react-router-dom';
import { AuthProvider } from "./components/auth";
import { RequrieAuth } from "./components/RequrieAuth";



function App()
{

  return (
	<AuthProvider>

	  <Login/> 
	
	  <Routes>

		  <Route path="/" element={<Login />} />

		  <Route path="/dashboard" element={<RequrieAuth><Dashboard /></RequrieAuth>} />

		  <Route path="studentslist" element={<RequrieAuth><Studentslist /></RequrieAuth>}>
			<Route path="studentdetails" element={<RequrieAuth><Studentdetails /></RequrieAuth>} />
		  </Route>

		  <Route path="blockslist" element={<RequrieAuth><Blockslist /></RequrieAuth>}>
			<Route path="blockdetails" element={<RequrieAuth><Blockdetails /></RequrieAuth>} />
		  </Route>

		  <Route path="taskslist" element={<RequrieAuth><Taskslist /></RequrieAuth>}>
			<Route path="taskdetails" element={<RequrieAuth><Taskdetails /></RequrieAuth>} />
		  </Route>

		  <Route path="/requestslist" element={<RequrieAuth><Requestslist /></RequrieAuth>}>
			<Route path="requestdetails" element={<RequrieAuth><Requestdetails /></RequrieAuth>} />
			
		  </Route>

		  <Route path="/addblock" element={<RequrieAuth><Addblock /></RequrieAuth>} />
		  <Route path="/addstudent" element={<RequrieAuth><Addstudent /></RequrieAuth>} />
		  <Route path="/addrequest" element={<RequrieAuth><Addtask /></RequrieAuth>} />
		  <Route path="*" element={<Notfound />} />    

	  </Routes>
	  
	</AuthProvider>
	
  );
}

export default App;