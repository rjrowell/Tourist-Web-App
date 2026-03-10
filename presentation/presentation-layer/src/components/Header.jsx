import { useNavigate } from 'react-router-dom'
import './Header.css'
import Logo from '../assets/HampshireRose.png'

export default function Header() {
  const navigate = useNavigate()
  return (
    <header className="header">
      <div className="header-left">
        <img src={Logo} alt="Visit Hampshire Logo" className="logo" />
        <h1>Visit Hampshire</h1>
      </div>
      <nav className="header-nav">
        <button className="btn-link" onClick={() => navigate('/signup')}>Sign Up</button>
        <button className="btn-link" onClick={() => navigate('/login')}>Login</button>
      </nav>
    </header>
  )
}
