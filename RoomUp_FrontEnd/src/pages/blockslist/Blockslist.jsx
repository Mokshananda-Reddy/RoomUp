import "./blockslist.css";
import Sidebar from "../../components/sidebarb/Sidebarb";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebarblock/Pagebarblock";
import Blist from "../../components/blist/Blist";

export default function blockslist(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Blist/>
        </>        
    );
}