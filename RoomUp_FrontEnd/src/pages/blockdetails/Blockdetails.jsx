import "./blockdetails.css";
import Sidebar from "../../components/sidebarb/Sidebarb";
import Topbar from "../../components/topbar/Topbar";
import Pagebar from "../../components/pagebarblockdet/Pagebarblockdet";
import Blockinfo from "../../components/blockinfo/Blockinfo";

export default function currentblockdetails(){
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Blockinfo/>
        </>        
    );
}