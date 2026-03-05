import { useState, useEffect } from 'react'
import Header from '../components/Header'
import ControlBar from '../components/ControlBar'
import PostsList from '../components/PostsList'
import ApiController from '../services/ApiController'

const apiController = new ApiController()

function HomePage() {
  const [posts, setPosts] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const [selectedCategory, setSelectedCategory] = useState(null)
  const [showFilterDropdown, setShowFilterDropdown] = useState(false)
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
    // TODO: Implement new post modal/navigation
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