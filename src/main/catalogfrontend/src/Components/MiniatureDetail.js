import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useParams } from 'react-router-dom';

const MiniatureDetail = () => {
  const { token } = useParams();

  const config = {
    headers: {
      Authorization: `Bearer ${token}`,
      'Content-Type': 'application/json', // Add this line for proper content type
    },
  };

  const [miniature, setMiniature] = useState({});
  const [updatedData, setUpdatedData] = useState({
    miniatureName: '',
    miniatureScale: '',
    miniatureBrand: '',
  });

  const loadData = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/api/v1/miniature-controller/${token}`,
        {
          headers: config.headers,
        }
      );
      setMiniature(response.data);
    } catch (error) {
      console.error('Error fetching miniature:', error);
    }
  };

  useEffect(() => {
    if (!miniature.miniatureId) {
      loadData();
    }
  }, [miniature.miniatureId]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUpdatedData({ ...updatedData, [name]: value });
  };

  const handleUpdate = () => {
    const dataToUpdate = {
      ...miniature,
      ...updatedData,
    };

    if (miniature.miniatureId) {
      axios
        .put(
          `http://localhost:8080/api/v1/miniature-controller/${token}/${miniature.miniatureId}/save`,
          dataToUpdate,
          {
            headers: config.headers, // Pass the headers here as well
          }
        )
        .then((response) => {
          console.log('Miniature updated:', response.data);
          setMiniature(response.data);
        })
        .catch((error) => {
          console.error('Error updating miniature:', error);
        });
    } else {
      axios
        .post(
          `http://localhost:8080/api/v1/miniature-controller/${token}/save`,
          dataToUpdate,
          {
            headers: config.headers, // Pass the headers here as well
          }
        )
        .then((response) => {
          console.log('New miniature created:', response.data);
          setMiniature(response.data);
        })
        .catch((error) => {
          console.error('Error creating miniature:', error);
        });
    }
  };

  return (
    <div>
      <h2>Miniature Detail</h2>
      <p>
        Name:
        <input
          type="text"
          name="miniatureName"
          value={updatedData.miniatureName}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Scale:
        <input
          type="text"
          name="miniatureScale"
          value={updatedData.miniatureScale}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Brand:
        <input
          type="text"
          name="miniatureBrand"
          value={updatedData.miniatureBrand}
          onChange={handleInputChange}
        />
      </p>
      <button onClick={handleUpdate}>Update</button>
      <Link to={`http://localhost:3000`}>
        <button>Go Back to Menu</button>
      </Link>
    </div>
  );
};

export default MiniatureDetail;
