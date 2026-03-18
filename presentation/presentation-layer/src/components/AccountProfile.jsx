import './AccountProfile.css'

function AccountProfile({ username }) {
  return (
    <div className="account-profile">
      <div className="account-avatar">
        <img src="/blank-avatar.png" alt="avatar" />
      </div>
      <p className="account-username">{username}</p>
    </div>
  )
}

export default AccountProfile