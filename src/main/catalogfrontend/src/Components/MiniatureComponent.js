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

  const handleFormSubmit = (event) => {
    event.preventDefault();
    const results = jsonData.filter((item) => {
      return (
        item.miniatureName.includes(searchQuery) ||
        item.miniatureBrand.includes(searchQuery) ||
        item.scale.toString().includes(searchQuery)
      );
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
              <li key={result.miniatureId}>
                <Link to={`miniatures/${result.miniatureId}`}>
                  {result.miniatureName} - {result.miniatureBrand} (Scale: {result.scale})
                </Link>
              </li>
            ))}
          </ul>
        </div>
      )}

    </div>
  );
};

export default MiniatureComponent;
