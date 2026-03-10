import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import LoginHeader from '../components/LoginHeader'
import SignUpContainer from '../components/SignUpContainer'
import ApiController from '../services/ApiController'
import { hashPassword } from '../services/HashPassword'
import { useAuth } from '../context/AuthContext'

const apiController = new ApiController()

function SignUpPage() {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState(null)
  const navigate = useNavigate()
  const { login } = useAuth()

  const handleSignUp = async () => {
    if(password.length === 0){
      setError('Password cannot be empty')
    }else{
      try {
        let hashed = await hashPassword(password)
        await apiController.createUser(username, hashed)
        login(username)
        navigate('/')
      } catch (err) {
        if (err.status === 409) {
          setError('Username already exists')
        } else {
          setError('Failed to create account, please try again')
        }
      }
    }
    
  }

  return (
    <div className="signup-page">
      <LoginHeader />
      <SignUpContainer
        username={username}
        password={password}
        error={error}
        onUsernameChange={setUsername}
        onPasswordChange={setPassword}
        onSignUp={handleSignUp}
      />
    </div>
  )
}

export default SignUpPage