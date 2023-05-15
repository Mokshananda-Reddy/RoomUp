import './requestlist.css';
import Sidebar from '../../components/sidebarr/Sidebarr';
import Topbar from '../../components/topbar/Topbar';
import Pagebar from '../../components/pagebartasks/Pagebartasks';
import Rlist from '../../components/rlist/Rlist';

export default function Requestlist() {
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Rlist/>
        </>
    );
}