import React, { useState, useEffect } from 'react';
import CheeseList from "../components/cheese-list";
import config from "../config.json";

const Browse = () => {
    const [cheeseList, setCheeseList] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    
    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);

        const getList = async () => {
            const response = await fetch(
                 config.ApiBaseUrl + '/catalog/query?q='
            );
            const rs = await response.json();
            setCheeseList(rs.Items);
            setCheeseLoading(false);
        };

        getList();
    }, []);

    return (
        <div className='p-3'>
            <h3>
                Browse All Cheeses
            </h3>

            <CheeseList showLoading={cheeseLoading} cheeses={cheeseList} />
        </div>
    );
};

export default Browse;