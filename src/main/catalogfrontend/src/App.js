import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import axios from 'axios';
import DemoTestComponent from './Components/DemoTestComponent';

function App() {

  return (
    <Router>
      <Routes>
        <Route path="" element={<MainRoute />} />
        <Route path="/api/v1/demo-controller" element={<DemoTestComponent />} />
      </Routes>
    </Router>
  );
}

function MainRoute() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState({ token: '' })

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
      }).then(
        response => setToken(response.data.access_token)
      );
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
        <Link to={`/api/v1/demo-controller`}>
          <button type="submit">Login</button>
        </Link>
      </form>
    </div>
  );
}

export default App;

