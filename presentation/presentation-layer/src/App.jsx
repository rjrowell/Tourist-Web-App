import { useState } from 'react'
import Header from './components/Header'
import ControlBar from './components/ControlBar'
import PostsList from './components/PostsList'
import './App.css'

function App() {
  // Sample posts data - replace this with data from your backend
  const [posts] = useState([
    {
      id: 1,
      title: 'Portchester Castle',
      description: 'A medieval fortress built within a Roman fort in Portchester. It was a royal residence, a hunting lodge, a prison and a port of embarkation for several campaigns to France',
      location: 'Church Road, Portchester, PO16 9QW, Hampshire',
      likes: 125
    },
    {
      id: 2,
      title: 'Portchester Castle',
      description: 'A medieval fortress built within a Roman fort in Portchester. It was a royal residence, a hunting lodge, a prison and a port of embarkation for several campaigns to France',
      location: 'Church Road, Portchester, PO16 9QW, Hampshire',
      likes: 125
    },
    {
      id: 3,
      title: 'Portchester Castle',
      description: 'A medieval fortress built within a Roman fort in Portchester. It was a royal residence, a hunting lodge, a prison and a port of embarkation for several campaigns to France',
      location: 'Church Road, Portchester, PO16 9QW, Hampshire',
      likes: 125
    }
  ])

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
    <div className="app">
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

export default App
