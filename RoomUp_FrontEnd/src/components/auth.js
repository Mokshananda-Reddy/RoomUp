import { useState, useContext, createContext } from "react";

const AuthContext = createContext(null)

export const AuthProvider = ({children}) => {

    const [user, setUser] = useState(null)

    const login = (user) => {
        console.log("logged in")
        setUser(user)
    }

    const logout = () => {
        console.log("logged out")
        setUser(null)
    }

    return( 
        <AuthContext.Provider value={{ user, login, logout}}>
            {children}
        </AuthContext.Provider>
    )
}

export const useAuth = () => {
    return useContext(AuthContext) 
}