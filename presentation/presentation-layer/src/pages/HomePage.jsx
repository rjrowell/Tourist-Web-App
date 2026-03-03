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

  useEffect(() => {
    loadPosts()
  }, [])

  const loadPosts = async () => {
    try {
      setLoading(true)

      const postFromApi = await apiController.fetchPosts()

      const postArray = await Promise.all(
        postFromApi.map(async (post) => {
          const likesData = await apiController.getLikesForPost(post.id)
          return {
            id: post.id,
            description: post.description,
            address: post.address,
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
    // TODO: Implement filter functionality
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
      />
      <PostsList posts={posts} />
    </div>
  )
}

export default HomePage