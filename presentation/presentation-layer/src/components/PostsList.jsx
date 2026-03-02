import PostCard from './PostCard'
import './PostsList.css'

export default function PostsList({ posts }) {
  return (
    <div className="posts-list">
      {posts.map((post) => (
        <PostCard key={post.id} post={post} />
      ))}
    </div>
  )
}
