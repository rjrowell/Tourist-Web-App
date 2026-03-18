import './ControlBar.css'

export default function ControlBar({ onFilterClick, onSortClick, onNewPostClick, showFilterDropdown, categories, onCategorySelect, showSortDropdown, onSortSelect }) {
  return (
    <div className="control-bar">
      <div className="filter-wrapper">
        <button className="btn btn-control" onClick={onFilterClick}>
          Filter ▼
        </button>
        {showFilterDropdown && (
          <div className="filter-dropdown">
            <div onClick={() => onCategorySelect(null)}>All</div>
            {categories.map(category => (
              <div key={category.id} onClick={() => onCategorySelect(category.id)}>
                {category.name}
              </div>
            ))}
          </div>
        )}
      </div>
      <div className="filter-wrapper">
        <button className="btn btn-control" onClick={onSortClick}>
          Sort ▼
        </button>
        {showSortDropdown && (
          <div className="filter-dropdown">
            <div onClick={() => onSortSelect('likes')}>Most Likes</div>
            <div onClick={() => onSortSelect('date')}>Date Added</div>
          </div>
        )}
      </div>
      <button className="btn btn-control" onClick={onNewPostClick}>New Post</button>
    </div>
  )
}