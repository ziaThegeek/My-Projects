import React, { Component } from 'react'
import LinkedInLogo from '../Components/LinkedInLogo.png'
import '../Components/LeftNav.css'
class LeftNavbar extends Component {
  render() {
    return (
      <nav className='nav'>
        <a href='www.linkenin.com'><img src={LinkedInLogo}></img></a>
        <input type='text' placeholder='Search'></input>
      </nav>
    )
  }
}

export default LeftNavbar