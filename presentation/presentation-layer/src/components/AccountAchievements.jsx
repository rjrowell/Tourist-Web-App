import './AccountAchievements.css'
import greyTrophy from '../assets/greyTrophy.jpg'
import yellowTrophy from '../assets/yellowTrophy.jpg'

function AccountAchievements({ achievements }) {
  return (
    <div className="account-achievements">
      <h2 className="achievements-title">Achievements</h2>
      <div className="achievements-list">
        <div className="achievement">
          <img src={achievements?.FiveLikesAchievement ? yellowTrophy : greyTrophy} alt="trophy" className="trophy-img" />
          <p className="achievement-description">Like 5 Posts</p>
        </div>
        <div className="achievement">
          <img src={greyTrophy} alt="trophy" className="trophy-img" />
          <p className="achievement-description">Create 5 Posts</p>
        </div>
        <div className="achievement">
          <img src={greyTrophy} alt="trophy" className="trophy-img" />
          <p className="achievement-description">Like 10 Posts</p>
        </div>
        <div className="achievement">
          <img src={greyTrophy} alt="trophy" className="trophy-img" />
          <p className="achievement-description">Create 10 Posts</p>
        </div>
      </div>
    </div>
  )
}

export default AccountAchievements