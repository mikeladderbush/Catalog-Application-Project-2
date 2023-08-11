import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import { useParams } from "react-router-dom";
import AddImageComponent from './AddImageComponent';
import DisplayImageComponent from './DisplayImageComponent';

const MiniatureDetail = () => {

  const { id } = useParams();
  const { token } = useParams();

  const config = {
    headers: { Authorization: `Bearer ${token}` },
  };

  const [miniature, setMiniature] = useState();
  const [updatedData, setUpdatedData] = useState({});

  const loadData = async () => {
    axios
      .get(`http://localhost:8080/api/v1/miniature-controller/${token}`, {
        headers: config.headers,
      })
      .then((response) => {
        setMiniature(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error('Error fetching miniature:', error);
      });
  }

  useEffect(() => {
    if (!miniature) loadData()
  }, [miniature, loadData])

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setUpdatedData({ ...updatedData, [name]: value });
  };

  const handleUpdate = () => {
    const updatedMiniature = { ...miniature, ...updatedData };

    axios.put(`http://localhost:8080//api/v1/miniature-controller/${token}`, updatedMiniature)
      .then((response) => {
        console.log("Miniature updated:", response.data);
        setMiniature(response.data);
      })
      .catch((error) => {
        console.error('Error updating miniature:', error);
      })
  };

  if (!miniature) {
    return <div>Loading...</div>
  }

  return (
    <div>
      <h2>Miniature Detail</h2>
      <p>ID: {miniature.id}</p>
      <p>
        Name:
        <input
          type="text"
          name="name"
          value={updatedData.miniature_name || miniature.miniature_name}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Scale:
        <input
          type="text"
          name="scale"
          value={updatedData.scale || miniature.scale}
          onChange={handleInputChange}
        />
      </p>
      <p>
        Progress:
        <input
          type="text"
          name="progress"
          value={updatedData.progress || miniature.progress}
          onChange={handleInputChange}
        />
      </p>
      <button onClick={handleUpdate}>Update</button>
      <Link to={`/miniatures`}>
        <button>Go Back to Menu</button>
      </Link>
    </div>
  );
}

export default MiniatureDetail;
