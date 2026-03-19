import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import LoginHeader from '../components/LoginHeader'
import LoginContainer from '../components/LoginContainer'
import ApiController from '../services/ApiController'
import { hashPassword } from '../services/HashPassword'
import { useAuth } from '../context/AuthContext'

const apiController = new ApiController()

function LoginPage() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState(null)
  const navigate = useNavigate()
  const { login } = useAuth()

  const handleLogin = async () => {
    try {
      let hashed = await hashPassword(password)
      await apiController.authenticateUser(username, hashed)
      const adminStatus = await apiController.checkIsAdmin(username)
      login(username, adminStatus)
      console.log('logged in as:', username)
      navigate('/')
    } catch (err) {
      setError('Invalid username or password')
    }
  }

  return (
    <div className="login-page">
      <LoginHeader />
      <LoginContainer
        username={username}
        password={password}
        error={error}
        onUsernameChange={setUsername}
        onPasswordChange={setPassword}
        onLogin={handleLogin}
      />
    </div>
  )
}

export default LoginPage