import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';

function SearchComponent() {
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [jsonData, setJsonData] = useState([]);

  const { token } = useParams();

  const config = {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  };

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/v1/miniature-controller/${token}`, {
        headers: config.headers,
      })
      .then((response) => {
        console.log(response.data);
        setJsonData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const handleSearch = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();

    if (!jsonData || jsonData.length === 0) {
      return;
    }

    if (!searchQuery) {
      setSearchResults(jsonData);
      return;
    }

    const results = jsonData.filter((item) => {
      const { miniatureName, miniatureScale, miniatureBrand } = item;

      return (
        (miniatureName && miniatureName.includes(searchQuery)) ||
        (miniatureScale && miniatureScale.includes(searchQuery)) ||
        (miniatureBrand && miniatureBrand.includes(searchQuery))
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
      <div>
        <h2>Search Results:</h2>
        <ul>
          {searchResults.map((result) => (
            <li key={result.miniatureId}>
              {console.log(result)}
              {result.miniatureName && (
                <p>Name: {result.miniatureName}</p>
              )}
              {result.miniatureScale && (
                <p>Scale: {result.miniatureScale}</p>
              )}
              {result.miniatureBrand && (
                <p>Brand: {result.miniatureBrand}</p>
              )}
              <Link to={`/${token}/${result.miniatureId}`}>
                View Details
              </Link>
            </li>
          ))}

        </ul>
      </div>
    </div>
  );
}

export default SearchComponent;
