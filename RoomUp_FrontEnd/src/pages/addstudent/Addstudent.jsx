import "./addstudent.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebaraddstu/Pagebaraddstu";
import Sform from "../../components/sform/Sform";

export default function addnewstudent(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Sform/>
        </>        
    );
}