import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";

function MiniatureDetails() {

    const { token } = useParams();
    const { miniatureId } = useParams();
    const [miniature, setMiniature] = useState({});

    const config = {
        headers: {
          Authorization: `Bearer ${token}`,
        },
      };

    useEffect (() => {
        const fetchMiniatureDetails = async () => {
            try {
                const response = await axios.get(
                    `http://localhost:8080/api/v1/miniature-controller/${token}/${miniatureId}`, {
                        headers: config.headers,
                    }
                );
                setMiniature(response.data);
            } catch (error) {
                console.error("Error fetching details:", error);
            }
        };

        fetchMiniatureDetails();
    }, [miniatureId])

    return (
        <div>
          <div>
            <ul>
                <p>Name: {miniature.miniatureName}</p>
                <p>Scale: {miniature.miniatureScale}</p>
                <p>Brand: {miniature.miniatureBrand}</p>
            </ul>
          </div>
        </div>
      );
};



export default MiniatureDetails;