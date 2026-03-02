import './ControlBar.css'

export default function ControlBar({ onFilterClick, onSortClick, onNewPostClick }) {
  return (
    <div className="control-bar">
      <button className="btn btn-control" onClick={onFilterClick}>
        Filter ▼
      </button>
      <button className="btn btn-control" onClick={onSortClick}>
        Sort ▼
      </button>
      <button className="btn btn-primary" onClick={onNewPostClick}>
        New Post
      </button>
    </div>
  )
}
