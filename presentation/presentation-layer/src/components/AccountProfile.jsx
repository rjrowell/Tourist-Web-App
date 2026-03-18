import './AccountProfile.css'
import blankAvatar from '../assets/blankAvatar.jpg'

function AccountProfile({ username }) {
  return (
    <div className="account-profile">
      <div className="account-avatar">
        <img src={blankAvatar} alt="avatar" />
      </div>
      <p className="account-username">{username}</p>
    </div>
  )
}

export default AccountProfile