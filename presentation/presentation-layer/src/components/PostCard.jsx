import { useState } from 'react'
import './PostCard.css'

export default function PostCard({ post }) {
  const [likeCount, setLikeCount] = useState(post.likes || 0)
  const [isLiked, setIsLiked] = useState(false)

  const handleLike = () => {
    if (isLiked) {
      setLikeCount(likeCount - 1)
    } else {
      setLikeCount(likeCount + 1)
    }
    setIsLiked(!isLiked)
  }

  const handleDislike = () => {
    // Add dislike logic here
  }

  return (
    <div className="post-card">
      <div className="post-content">
        <h3 className="post-title">{post.title}</h3>
        <p className="post-description">{post.description}</p>
        <p className="post-location">{post.location}</p>
      </div>
      <div className="post-footer">
        <div className="post-actions">
          <button 
            className={`btn btn-like ${isLiked ? 'active' : ''}`}
            onClick={handleLike}
          >
            👍 <span className="like-count">{likeCount}</span>
          </button>
          <button className="btn btn-dislike" onClick={handleDislike}>
            👎
          </button>
        </div>
      </div>
    </div>
  )
}
