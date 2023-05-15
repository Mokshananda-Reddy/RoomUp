import './tasklist.css';
import Sidebar from '../../components/sidebart/Sidebart';
import Topbar from '../../components/topbar/Topbar';
import Pagebar from '../../components/pagebartasks/Pagebartasks';
import Tlist from '../../components/tlist/Tlist';

export default function Tasklist() {
    return (
        <>
            <Topbar/>
            <Pagebar/>
            <Sidebar/>
            <Tlist/>
        </>
    );
}