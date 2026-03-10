/**
 * A react context to persit authentication (user) data
 */
import { createContext, useContext, useState } from 'react'

const AuthContext = createContext(null)

export function AuthContextProvider({ children }) {
  const [loggedInUser, setLoggedInUser] = useState(null)

  const login = (username) => setLoggedInUser(username)
  const logout = () => setLoggedInUser(null)

  return (
    <AuthContext.Provider value={{ loggedInUser, login, logout }}>
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth() {
  return useContext(AuthContext)
}