import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import LoginHeader from '../components/LoginHeader'
import LoginContainer from '../components/LoginContainer'
import ApiController from '../services/ApiController'

const apiController = new ApiController()

function LoginPage() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState(null)
  const navigate = useNavigate()

  const handleLogin = async () => {
    try {
      await apiController.authenticateUser(username, password)
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