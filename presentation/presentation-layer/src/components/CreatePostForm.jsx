import { useState } from 'react'
import './CreatePostForm.css'

const CATEGORIES = [
  { id: 1, name: 'Heritage Site' },
  { id: 2, name: 'Shopping' }
]

function CreatePostForm({ onCreatePost, error }) {
  const [title, setTitle] = useState('')
  const [description, setDescription] = useState('')
  const [address, setAddress] = useState('')
  const [categoryId, setCategoryId] = useState(CATEGORIES[0].id)
  const [formError, setFormError] = useState(null)

  const handleSubmit = () => {
    if (!title.trim() || !description.trim() || !address.trim()) {
      setFormError('One or more sections is empty')
      return
    }
    setFormError(null)
    onCreatePost(title, description, address, categoryId)
  }

  return (
    <div className="create-post-form">
      <input
        className="create-post-input"
        type="text"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <textarea
        className="create-post-textarea"
        placeholder="Description (Max 255 Chars)"
        maxLength={255}
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />
      <textarea
        className="create-post-textarea"
        placeholder="Address (Max 255 Chars)"
        maxLength={255}
        value={address}
        onChange={(e) => setAddress(e.target.value)}
      />
      <select
        className="create-post-select"
        value={categoryId}
        onChange={(e) => setCategoryId(Number(e.target.value))}
      >
        {CATEGORIES.map(category => (
          <option key={category.id} value={category.id}>
            {category.name}
          </option>
        ))}
      </select>
      {(formError || error) && <p className="create-post-error">{formError || error}</p>}
      <button className="create-post-btn" onClick={handleSubmit}>Create Post</button>
    </div>
  )
}

export default CreatePostForm