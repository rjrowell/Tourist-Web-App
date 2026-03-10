import './LoginHeader.css'
import Logo from '../assets/HampshireRose.png'

function LoginHeader() {
  return (
    <div className="login-header">
      <img src={Logo} alt="Hampshire Rose" className="login-logo" />
      <h1>Visit Hampshire</h1>
    </div>
  )
}

export default LoginHeader