import HomePage from './pages/HomePage'
import LoginPage from './pages/LoginPage'
import SignUpPage from './pages/SignUpPage'
import AccountPage from './pages/Account'
import PostCreationPage from './pages/PostCreation'
import { Routes, Route } from 'react-router-dom'
import './App.css'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignUpPage/>}/>
        <Route path="/postCreation" element={<PostCreationPage/>}/>
        <Route path="/account" element={<AccountPage/>}/>
      </Routes>
    </div>
  )
}

export default App
