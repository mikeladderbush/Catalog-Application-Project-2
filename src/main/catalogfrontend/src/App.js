import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
/*import SearchComponent from './Components/SearchComponent';
import AddDataComponent from './Components/AddDataComponent';
import PrintToFile from './Components/PrintToFile';
import MiniatureDetail from './Components/MiniatureDetail';
*/
import LoginComponent from './Components/LoginComponent';
import DemoTestComponent from './Components/DemoTestComponent';

function App() {

  return (
    <Router>
      <Routes>
        <Route path="" element={<LoginComponent />} />
        <Route path="/api/v1/demo-controller" element={<DemoTestComponent />} />
      </Routes>
    </Router>
  );
}

function MainRoute() {

  return (
    <>
      <h1>My Miniature Catalog</h1>
      <p>this is my website to keep track of my miniatures</p>
    </>
  );
}

export default App;

