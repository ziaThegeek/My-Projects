import React, { Component } from 'react'
import LinkedInLogo from '../Components/LinkedInLogo.png'
import HomeIcon from '../Components/homeicon.png'
import JobsIcon from '../Components/jobicon.png'
import { FaHeaAiFillMessagert,FaHome,FaPeopleCarry } from "react-icons/fa";
import { BsFillBriefcaseFill,BsBellFill,BsChatLeftDotsFill } from "react-icons/bs";
  import { IoPeople} from "react-icons/io5";
import '../Components/CenterNav.css'
 class CenterNavbar extends Component {
  //hello
  render() {
    return (
      <nav className='nav'>
      <div className='navitem'>
        <a href='#Home' title='Home'>
        <FaHome style={{color: 'grey', fontSize: '20px'}}/></a>
        <h5>home</h5>
        
      </div>
      <div className='navitem'>
        <a href='#Home' title='Home'>
        <IoPeople style={{color: 'grey', fontSize: '20px'}}/></a>
        <h5>My Network</h5>
      </div>
      <div className='navitem'>
        <a href='#Home' title='Home'>
        <BsFillBriefcaseFill style={{color: 'grey', fontSize: '20px'}}/></a>
        <h5>Jobs</h5>
      </div>
      <div className='navitem'>
        <a href='#Home' title='Home'>
        <BsChatLeftDotsFill style={{color: 'grey', fontSize: '20px'}}/></a>
        <h5>Messeging</h5>
      </div>
      <div className='navitem'>
        <a href='#Home' title='Home'>
        <BsBellFill style={{color: 'grey', fontSize: '20px'}}/></a>
        <h5>Notifications</h5>
      </div>
      
      </nav>
    )
  }
}

export default CenterNavbar