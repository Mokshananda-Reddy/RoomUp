import "./requestdetails.css";
import Sidebar from "../../components/sidebarr/Sidebarr";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebartasdet/Pagebartasdet";
import Reqinfo from "../../components/reqinfo/Reqinfo";

export default function currenttaskdetails(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Reqinfo/>
        </>        
    );
}