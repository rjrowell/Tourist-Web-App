import { useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'
import './Header.css'
import Logo from '../assets/HampshireRose.png'

export default function Header() {
  const navigate = useNavigate()
  const { loggedInUser } = useAuth()
  console.log('loggedInUser:', loggedInUser)
  return (
    <header className="header">
      <div className="header-left">
        <img src={Logo} alt="Visit Hampshire Logo" className="logo" />
        <h1>Visit Hampshire</h1>
      </div>
      <nav className="header-nav">
        {loggedInUser ? (
            <button className="btn-link" onClick={() => navigate('/account')}>Account</button>
        ) : (
          <>
            <button className="btn-link" onClick={() => navigate('/signup')}>Sign Up</button>
            <button className="btn-link" onClick={() => navigate('/login')}>Login</button>
          </>
        )}
      </nav>
    </header>
  )
}
