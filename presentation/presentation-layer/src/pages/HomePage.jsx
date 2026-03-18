import { useState, useEffect } from 'react'
import Header from '../components/Header'
import ControlBar from '../components/ControlBar'
import PostsList from '../components/PostsList'
import ApiController from '../services/ApiController'
import { useNavigate } from 'react-router-dom'
import { useAuth } from '../context/AuthContext'

const apiController = new ApiController()

function HomePage() {
  const [posts, setPosts] = useState([])
  const navigate = useNavigate()
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const [selectedCategory, setSelectedCategory] = useState(null)
  const [showFilterDropdown, setShowFilterDropdown] = useState(false)
  const { loggedInUser } = useAuth([])
  const [categories] = useState([
    { id: 1, name: 'Heritage Site' },
    { id: 2, name: 'Shopping' }
  ])

  useEffect(() => {
    loadPosts()
  }, [])

  const loadPosts = async (categoryId = null) => {
    try {
      setLoading(true)

      const postsFromApi = categoryId
        ? await apiController.fetchPostsByCategory(categoryId)
        : await apiController.fetchPosts()

      const postArray = await Promise.all(
        postsFromApi.map(async (post) => {
          const likesData = await apiController.getLikesForPost(post.id)
          return {
            id: post.id,
            categoryId: post.categoryId,
            title: post.title,
            description: post.description,
            location: post.address,
            likes: likesData
          }
        })
      )

      setPosts(postArray)
      
    } catch (err) {
      setError('Failed to load posts')
    } finally {
      setLoading(false)
    }
  }

  const handleFilter = () => {
    console.log('Filter clicked')
    setShowFilterDropdown(!showFilterDropdown)
  }

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId)
    setShowFilterDropdown(false)
    loadPosts(categoryId)
  }

  const handleSort = () => {
    console.log('Sort clicked')
    // TODO: Implement sort functionality
  }

  const handleNewPost = () => {
    console.log('New Post clicked')
    console.log(loggedInUser)
    if(loggedInUser != null){
      navigate('/postCreation')
    }
  }

  return (
    <div className="HomePage">
      <Header />
      <ControlBar 
        onFilterClick={handleFilter}
        onSortClick={handleSort}
        onNewPostClick={handleNewPost}
        showFilterDropdown={showFilterDropdown}
        categories={categories}
        onCategorySelect={handleCategorySelect}
      />
      <PostsList posts={posts} />
    </div>
  )
}

export default HomePage