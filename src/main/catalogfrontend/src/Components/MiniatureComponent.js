import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';

const MiniatureComponent = () => {
  const { token } = useParams();

  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [jsonData, setJsonData] = useState([]);

  const config = {
    headers: { Authorization: `Bearer ${token}` },
  };

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/v1/miniature-controller/miniatures', {
        headers: config.headers,
      })
      .then((response) => {
        setJsonData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [config.headers]);

  const handleSearch = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleFormSubmit = event => {
    event.preventDefault();
    const results = jsonData.filter(item => {
      if (item.page.includes("http://localhost:8080//api/v1/miniature-controller/miniature/1")) {
        return false;
      }
      return item.page && item.page.includes(searchQuery);
    });

    setSearchResults(results);
  };

  return (
    <div>
      <form onSubmit={handleFormSubmit}>
        <input
          type="text"
          value={searchQuery}
          onChange={handleSearch}
          placeholder="Search..."
        />
        <button type="submit">Search</button>
      </form>
      {searchResults.length > 0 && (
        <div>
          <h2>Search Results:</h2>
          <ul>
            {searchResults.map((result) => (
              <li key={result.id}>
                <Link to={`miniatures/${result.miniatureId}`}>{result.page}</Link>
              </li>
            ))}
          </ul>
        </div>
      )}
    </div>
  );
};

export default MiniatureComponent;
