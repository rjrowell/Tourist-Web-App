import HomePage from './pages/HomePage'
import LoginPage from './pages/LoginPage'
import { Routes, Route } from 'react-router-dom'
import './App.css'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
      </Routes>
    </div>
  )
}

export default App
