import React, { useState } from "react";
import { GoogleOAuthProvider, GoogleLogin } from "@react-oauth/google";
import axios from "axios";

const GoogleLoginButton = () => {
  const [user, setUser] = useState(null);

  const googleClientId = import.meta.env.VITE_GOOGLE_CLIENT_ID;  
  const baseUrl = import.meta.env.VITE_BASE_URL;

  const handleLoginSuccess = async (credentialResponse) => {
    console.log("Google Login Success:", credentialResponse);

    try {
      const res = await axios.post(
        `${baseUrl}/google`,
        { token: credentialResponse.credential },
        {
          withCredentials: true,
          headers: { "Content-Type": "application/json" },
        }
      );

      console.log("User Data from Backend:", res.data);
      setUser(res.data);
    } catch (error) {
      console.error("Error fetching user data:", error.response?.data || error.message);
    }
  };

  return (
    <GoogleOAuthProvider clientId={googleClientId}>
      <div>
        {user ? (
          <div>
            <h2>Welcome, {user.name}</h2>
            <img src={user.picture} alt="User profile" />
          </div>
        ) : (
          <GoogleLogin
            onSuccess={handleLoginSuccess}
            onError={() => console.log("Login Failed")}
          />
        )}
      </div>
    </GoogleOAuthProvider>
  );
};

export default GoogleLoginButton;
