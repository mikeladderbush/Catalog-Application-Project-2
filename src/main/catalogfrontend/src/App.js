import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import MiniatureDetail from './Components/MiniatureDetail';
import styles from './mystyle.module.css';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainRoute />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/api/v1/miniature-controller/:token" element={<MiniatureDetail />} />
      </Routes>
    </Router>
  );
}
function MainRoute() {
  return (
      <div className={styles.Appbody}>
        <h1>Welcome to the Miniature Catalog</h1>
        <p>
          <Link to="/login">If you already have an account click here</Link> or <Link to="/register">Register</Link>
        </p>
      </div>
  );
}

function Login() {
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
      navigate(`/api/v1/miniature-controller/${newToken}`);
    } catch (error) {
      console.error('Login failed:', error);
    }
  };

  return (
    <div className={styles.Appbody}>
      <form onSubmit={handleLogin}>
        <h1>Miniature Catalog Log in</h1>
        <h3>Welcome to my miniature catalog, please enter your
          email and password.
        </h3>
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

function Register() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleRegister = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/api/v1/auth/register', {
        username,
        email,
        password,
        role: 'USER',
      });

      navigate('/login');
    } catch (error) {
      console.error('Registration failed:', error);
    }
  };

  return (
    <div className={styles.Appbody}>
      <form onSubmit={handleRegister}>
        <h1>Register</h1>
        <div>
          <label>Username:</label>
          <input type="text" value={username} onChange={handleUsernameChange} />
        </div>
        <div>
          <label>Email:</label>
          <input type="text" value={email} onChange={handleEmailChange} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={handlePasswordChange} />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default App;
