import "./studentdetails.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebarstudet/Pagebarstudet";
import Stuinfo from "../../components/stuinfo/Stuinfo";

export default function currentstudentdetails(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Stuinfo/>
        </>        
    );
}