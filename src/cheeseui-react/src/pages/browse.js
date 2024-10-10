import React, { useState, useEffect } from 'react';
import CheeseList from "../components/cheese-list";
import config from "../config.json";

const Browse = () => {
    const [cheeseList, setCheeseList] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [cheeseLoadError, setCheeseLoadError] = useState("");
    
    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);

        const getList = async () => {
            return await fetch(
                 config.ApiBaseUrl + '/catalog/query?q='
            );
        };

        getList()
            .then(async (response) => {
                const rs = await response.json();
                setCheeseList(rs.Items);
            })
            .catch(error => {
                setCheeseLoadError(error.message);
            })
            .finally(() => {
                setCheeseLoading(false);
            });
    }, []);

    return (
        <div className='p-3'>
            <h3>
                Browse All Cheeses
            </h3>

            <CheeseList showLoading={cheeseLoading} loadError={cheeseLoadError} cheeses={cheeseList} />
        </div>
    );
};

export default Browse;