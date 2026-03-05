import './ControlBar.css'

export default function ControlBar({ onFilterClick, onSortClick, onNewPostClick, showFilterDropdown, categories, onCategorySelect }) {
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
      <button className="btn btn-control" onClick={onSortClick}>Sort ▼</button>
      <button className="btn btn-control" onClick={onNewPostClick}>New Post</button>
    </div>
  )
}