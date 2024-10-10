import React, { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import CheeseList from "../components/cheese-list";
import config from "../config.json";

const ByType = () => {
    const [cheeseList, setCheeseList] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [cheeseLoadError, setCheeseLoadError] = useState("");
    const { cheesetype } = useParams();
    
    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);
        
        const url = (cheesetype == undefined)
            ? '/catalog/bytype' 
            : '/catalog/bytype/' + cheesetype;

        const getList = async () => {
            return await fetch(
                 config.ApiBaseUrl + url
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

    // TODO get types from API
    return (
        <div className='p-3'>
            <h3>
                Cheeses by type
            </h3>
            <div>
                <a href='/by-type/fresh-soft' className='btn btn-outline-warning me-3 mb-2'>
                    Fresh Soft
                </a>
                <a href='/by-type/fresh-firm' className='btn btn-outline-warning me-3 mb-2'>
                    Fresh Firm
                </a>
                <a href='/by-type/soft' className='btn btn-outline-warning me-3 mb-2'>
                    Soft
                </a>
                <a href='/by-type/semi-soft' className='btn btn-outline-warning me-3 mb-2'>
                    Semi Soft
                </a>
                <a href='/by-type/hard' className='btn btn-outline-warning me-3 mb-2'>
                    Hard
                </a>
                <a href='/by-type/semi-hard' className='btn btn-outline-warning me-3 mb-2'>
                    Semi Hard
                </a>
                <a href='/by-type/firm' className='btn btn-outline-warning me-3 mb-2'>
                    Firm
                </a>
                <a href='/by-type/semi-firm' className='btn btn-outline-warning me-3 mb-2'>
                    Semi Firm
                </a>
            </div>
            <CheeseList showLoading={cheeseLoading} loadError={cheeseLoadError} cheeses={cheeseList} />
        </div>
    );
}

export default ByType;