import React, { useEffect } from 'react';
import axios from 'axios';

const DemotestComponent = ({ token }) => {

    console.log(token);

    const config = {
        headers: {Authorization: `Bearer ${token}`}
    };

    const bodyParameters = {
        key: "value"
    };

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/demo-controller',
        bodyParameters,
        config
        )
            .then(response => {
                console.log(response);
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