import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function DemotestComponent() {

    const [jsonData, setJsonData] = useState([]);
    const {token} = useParams();
  
    const config = {
      headers: {Authorization: `${token}`}
    };

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/demo-controller',
            config)
            .then(response => {
                setJsonData(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

    return (
        <div>
        </div>
      );
}

export default DemotestComponent;