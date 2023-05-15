import "./addblock.css";
import Sidebar from "../../components/sidebarb/Sidebarb";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebaraddblock/Pagebaraddblock";
import Bform from "../../components/bform/Bform";

export default function addnewblock(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Bform/>
        </>        
    );
}