import React, { useState, useEffect } from 'react';
import CheeseList from "../components/cheese-list";
import config from "../config.json";
import { useSearchParams } from 'react-router-dom';

const Search = () => {
    const [cheeseList, setCheeseList] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [cheeseLoadError, setCheeseLoadError] = useState("");
    const [searchParams] = useSearchParams();
    var q = searchParams.get('q');
    
    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);

        const getList = async () => {
            return await fetch(
                 config.ApiBaseUrl + '/catalog/query?q=' + q
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
                Search Cheeses
            </h3>

            <CheeseList showLoading={cheeseLoading} loadError={cheeseLoadError} cheeses={cheeseList} />
        </div>
    );
};

export default Search;