import './LoginContainer.css'

function SignUpContainer({ username, password, error, onUsernameChange, onPasswordChange, onSignUp }) {
  return (
    <div className="login-container">
      <input
        className="login-input"
        type="text"
        placeholder="Username"
        value={username}
        onChange={(e) => onUsernameChange(e.target.value)}
      />
      <input
        className="login-input"
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => onPasswordChange(e.target.value)}
      />
      {error && <p className="login-error">{error}</p>}
      <button className="login-btn" onClick={onSignUp}>Sign Up</button>
    </div>
  )
}

export default SignUpContainer