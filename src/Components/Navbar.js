import React, { Component } from 'react'
import LeftNavbar from './LeftNavbar'
import CenterNavbar from './CenterNavbar'
import RightNavbar from './RightNavbar'
 class Navbar extends Component {
  render() {
    return (
     <nav className='nav'>
        <LeftNavbar></LeftNavbar>
         <CenterNavbar/>
        
     </nav>
    )
  }
}
export default Navbar
