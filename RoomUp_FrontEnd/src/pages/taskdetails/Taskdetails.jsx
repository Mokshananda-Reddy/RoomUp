import "./taskdetails.css";
import Sidebar from "../../components/sidebart/Sidebart";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebartasdet/Pagebartasdet";
import Tasinfo from "../../components/tasinfo/Tasinfo";

export default function currenttaskdetails(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Tasinfo/>
        </>        
    );
}