import React, { useState, useEffect } from 'react';
import config from "../config.json";
import { useSearchParams } from 'react-router-dom';

const View = () => {
    const [cheese, setCheese] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [kilos, setKilos] = useState("1");
    const [searchParams] = useSearchParams();
    var id = searchParams.get('id');
    
    function changeKilos(e) {
        setKilos(e.target.value);
    }

    function round(value) {
        return Math.round(value * 100) / 100;
    }

    useEffect(() => {
        document.title = `Cheese Zero`;

        setCheeseLoading(true);

        const getCheese = async () => {
            const response = await fetch(
                 config.ApiBaseUrl + '/catalog/details?id=' + id
            );
            const rs = await response.json();
            setCheese(rs);
            document.title = cheese.Id === ""
                ? `Wrong cheese`
                : cheese.Name;
            setCheeseLoading(false);
        };

        getCheese();
    }, []);

    return (
        <div className='p-3'>
            {cheeseLoading &&
                <>
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </>
            }
            {!cheeseLoading && (cheese.Id === "") &&
                <p>
                    Wrong cheese.
                </p>
            }
            {!cheeseLoading && (cheese.Id !== "") &&
                <>
                    <h3>
                        {cheese.Name}
                    </h3>
                    <hr />
                    <div className='row'>
                        <div className='col-md-6'>
                            <img className='cheese-big-image' src={cheese.ImagePath} alt={cheese.Name} />
                        </div>
                        <div className='col-md-6'>
                            <div style={{display: 'flow-root'}}>
                                <ul className="summary-points">
                                    <li className="summary_milk">
                                        <i className="fa fa-flask"></i>
                                        <p>Made from {cheese.Milk.join(", ")} milk</p>
                                    </li>
                                    
                                    <li className="summary_country">
                                        <i className="fa fa-flag"></i>
                                        <p>Country of origin: {cheese.Country}</p>
                                    </li>

                                    <li className="summary_moisture_and_type">
                                        <i className="fa fa-folder"></i>
                                        <p>Type: {cheese.Type}</p>
                                    </li>

                                    <li className="summary_texture">
                                        <i className="fa fa-pie-chart"></i>
                                        <p>Texture: {cheese.Texture.join(", ")}</p>
                                    </li>

                                    <li className="summary_tint">
                                        <i className="fa fa-tint"></i>
                                        <p>Colour: {cheese.Colour}</p>
                                    </li>

                                    <li className="summary_tint">
                                        <i className="fa-solid fa-dollar-sign"></i>
                                        <p>
                                            Price Per Kilo: {cheese.PricePerKilo}
                                            <br></br>

                                            <div className='mt-3'>
                                                Calculate how much:
                                            </div>
                                            
                                            <div className='d-flex mt-3'>
                                                <div className=''>
                                                    <input type="number" className='form-control' min={1} style={{width: '120px'}} placeholder="How many kilos" value={kilos} onChange={changeKilos} />
                                                </div>
                                                <div className='ms-3 mt-2'>
                                                    KG
                                                </div>
                                            </div>

                                            <div className='mt-2'>
                                                <strong>
                                                    Total cost: ${round(cheese.PricePerKilo * kilos)}
                                                </strong>
                                            </div>
                                        </p>
                                    </li>
                                </ul>
                            </div>
                            
                            <p className='mt-4'>
                                {cheese.Description}
                            </p>

                        </div>
                    </div>
                </>
            }
        </div>
    );
};

export default View;