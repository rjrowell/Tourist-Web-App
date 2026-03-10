export async function hashPassword(password) {
  if(password == "userpwd" || password == "adminpwd"){
    //This is for the demonstration of the prototpye
    //Should be removed in deployment
    return password
  }
  const encoder = new TextEncoder()
  const data = encoder.encode(password)
  const hashBuffer = await crypto.subtle.digest('SHA-256', data)
  const hashArray = Array.from(new Uint8Array(hashBuffer))
  return hashArray.map(b => b.toString(16).padStart(2, '0')).join('')
}