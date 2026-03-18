import { useState, useEffect } from 'react'
import { useAuth } from '../context/AuthContext'
import ApiController from '../services/ApiController'
import './PostCard.css'

const apiController = new ApiController()

export default function PostCard({ post }) {
  const [likeCount, setLikeCount] = useState(post.likes || 0)
  const [isLiked, setIsLiked] = useState(false)
  const [isDisliked, setIsDisliked] = useState(false)
  const { loggedInUser } = useAuth([])

  useEffect(() => {
    if (loggedInUser != null) {
      loadLikeStatus()
    }
  }, [])

  const loadLikeStatus = async () => {
    try {
      const response = await apiController.getLike(loggedInUser, post.id)
      if (response != null) {
        if (response.likeStatus === true) {
          setIsLiked(true)
        } else {
          setIsDisliked(true)
        }
      }
    } catch (err) {
      // 404 means no like exists yet, so we can ignore it
    }
  }

  const handleLike = () => {
    if(loggedInUser != null){
      if (isLiked) {
          setLikeCount(likeCount - 1)
        } else if (isDisliked) {
          setLikeCount(likeCount + 2)
        } else {
        setLikeCount(likeCount + 1)
      }
      setIsLiked(!isLiked)
      setIsDisliked(false) // Reset dislike if liking the post

      apiController.addLike(loggedInUser, post.id, true)
    }
  }

  const handleDislike = () => {
    if(loggedInUser != null){
      if (isDisliked) {
        setLikeCount(likeCount + 1)
      } else if (isLiked) {
        setLikeCount(likeCount - 2)
      } else {
        setLikeCount(likeCount - 1)
      }
      setIsDisliked(!isDisliked)
      setIsLiked(false) // Reset like if disliking the post

      apiController.addLike(loggedInUser, post.id, false)
    }
  }

  return (
    <div>
      <div className="post-divider"></div>
      <div className="post-card">
        <div className="post-content">
          <h3 className="post-title">{post.title}</h3>
          <p className="post-description">{post.description}</p>
          <p className="post-location">{post.location}</p>
        </div>
        <div className="post-right">
          <div className="btn-wrapper">
            <button 
              className={`btn btn-like ${isLiked ? 'active' : ''}`}
              onClick={handleLike}
            >
              👍 
            </button>
            <div className="like-count">{likeCount}</div>
            <button className={`btn btn-dislike ${isDisliked ? 'active' : ''}`} 
                    onClick={handleDislike}>
              👎
            </button>
          </div>
        </div>
      </div>
    </div>
  )
}
