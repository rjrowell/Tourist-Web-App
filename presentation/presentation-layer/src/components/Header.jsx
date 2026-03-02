import './Header.css'
import Logo from '../assets/HampshireRose.png'

export default function Header() {
  return (
    <header className="header">
      <div className="header-left">
        <img src={Logo} alt="Visit Hampshire Logo" className="logo" />
        <h1>Visit Hampshire</h1>
      </div>
      <nav className="header-nav">
        <button className="btn btn-link">Sign Up</button>
        <button className="btn btn-link">Login</button>
      </nav>
    </header>
  )
}
