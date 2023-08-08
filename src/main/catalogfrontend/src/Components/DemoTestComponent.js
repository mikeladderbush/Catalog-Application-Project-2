import React, { useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const DemotestComponent = () => {
  const { token } = useParams();
  console.log(token);

  const config = {
    headers: { Authorization: `Bearer ${token}` },
  };

  const bodyParameters = {
    key: 'value',
  };

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/v1/demo-controller', {
        headers: config.headers,
        data: bodyParameters,
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [config.headers]);

  return <div></div>;
};

export default DemotestComponent;
