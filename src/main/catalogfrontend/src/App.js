import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import DemoTestComponent from './Components/DemoTestComponent';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainRoute />} />
        <Route path="/api/v1/demo-controller/:token" element={<DemoTestComponent />} />
      </Routes>
    </Router>
  );
}

function MainRoute() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState('');
  const navigate = useNavigate();

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLogin = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/v1/auth/authenticate', {
        email,
        password,
      });

      const newToken = response.data.access_token;
      setToken(newToken);
      navigate(`/api/v1/demo-controller/${newToken}`);
    } catch (error) {
      console.error('Login failed:', error);
    }
  };

  return (
    <div>
      <form onSubmit={handleLogin}>
        <div>
          <label>Email:</label>
          <input type="text" value={email} onChange={handleEmailChange} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={handlePasswordChange} />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
}

export default App;
