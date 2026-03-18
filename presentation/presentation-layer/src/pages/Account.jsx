import { useState, useEffect } from 'react'
import { useAuth } from '../context/AuthContext'
import Header from '../components/Header'
import AccountProfile from '../components/AccountProfile'
import AccountAchievements from '../components/AccountAchievements'
import ApiController from '../services/ApiController'

const apiController = new ApiController()

function Account() {
  const { loggedInUser } = useAuth()
  const [achievements, setAchievements] = useState(null)

  useEffect(() => {
    loadAchievements()
  }, [])

  const loadAchievements = async () => {
    try {
      const response = await apiController.calculateAchievements(loggedInUser)
      setAchievements(response)
    } catch (err) {
      console.error('Failed to load achievements:', err)
    }
  }

  return (
    <div className="account-page">
      <Header />
      <div className="account-content">
        <AccountProfile username={loggedInUser} />
        <AccountAchievements achievements={achievements} />
      </div>
    </div>
  )
}

export default Account