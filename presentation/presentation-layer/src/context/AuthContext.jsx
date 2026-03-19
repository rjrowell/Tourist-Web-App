/**
 * A react context to persit authentication (user) data
 */
import { createContext, useContext, useState } from 'react'

const AuthContext = createContext(null)

export function AuthContextProvider({ children }) {
  const [loggedInUser, setLoggedInUser] = useState(null)
  const [isAdmin, setIsAdmin] = useState(false)

  const login = (username, adminStatus) => {
    setLoggedInUser(username)
    setIsAdmin(adminStatus)
  }

  const logout = () => {
    setLoggedInUser(null)
    setIsAdmin(false)
  }

  return (
    <AuthContext.Provider value={{ loggedInUser, isAdmin, login, logout }}>
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth() {
  return useContext(AuthContext)
}