import React, { useState, useEffect } from 'react';
import CheeseList from "../components/cheese-list";
import config from "../config.json";
import { useSearchParams } from 'react-router-dom';

const Search = () => {
    const [cheeseList, setCheeseList] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [searchParams] = useSearchParams();
    var q = searchParams.get('q');
    
    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);

        const getList = async () => {
            const response = await fetch(
                 config.ApiBaseUrl + '/catalog/query?q=' + q
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
                Search Cheeses
            </h3>

            <CheeseList showLoading={cheeseLoading} cheeses={cheeseList} />
        </div>
    );
};

export default Search;