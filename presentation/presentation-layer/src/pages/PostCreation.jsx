import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'
import LoginHeader from '../components/LoginHeader'
import CreatePostForm from '../components/CreatePostForm'
import ApiController from '../services/ApiController'

const apiController = new ApiController()

function PostCreation() {
  const { loggedInUser } = useAuth()
  const navigate = useNavigate()
  const [error, setError] = useState(null)

  const handleCreatePost = async (title, description, address, categoryId) => {
    try {
      await apiController.createPost(loggedInUser, categoryId, title, description, address)
      navigate('/')
    } catch (err) {
      setError('Failed to create post, please try again')
    }
  }

  return (
    <div className="create-post-page">
      <LoginHeader title="Create Post" />
      <CreatePostForm onCreatePost={handleCreatePost} error={error} />
    </div>
  )
}

export default PostCreation