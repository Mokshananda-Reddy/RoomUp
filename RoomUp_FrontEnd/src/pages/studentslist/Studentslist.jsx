import "./studentslist.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebar/Pagebar";
import Slist from "../../components/slist/Slist";

export default function studentslist(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Slist/>
        </>        
    );
}