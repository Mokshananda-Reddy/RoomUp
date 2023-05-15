import "./dashboard.css";
import Sidebar from "../../components/sidebardash/Sidebardash";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebardash/Pagebardash";
import Dash from "../../components/dash/Dash";

export default function blockslist(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Dash/>
        </>        
    );
}