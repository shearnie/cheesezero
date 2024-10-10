import React, { useState, useEffect } from 'react';
import config from "../config.json";
import { useSearchParams } from 'react-router-dom';

const View = () => {
    const [cheese, setCheese] = useState({});
    const [cheeseLoading, setCheeseLoading] = useState({});
    const [cheeseLoadError, setCheeseLoadError] = useState("");
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
            return await fetch(
                config.ApiBaseUrl + '/catalog/details?id=' + id
            );
        };

        getCheese()
            .then(async (response) => {
                const rs = await response.json();
                setCheese(rs);
                document.title = rs.name;
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
            {(cheeseLoadError !== "") &&
                <p className="text-danger">
                    Error: {cheeseLoadError}
                </p>
            }
            {!cheeseLoading && (cheeseLoadError === "") && (cheese.Id !== "") &&
                <>
                    <h3>
                        {cheese.name}
                    </h3>
                    <hr />
                    <div className='row'>
                        <div className='col-md-6'>
                            <img className='cheese-big-image' src={cheese.imagePath} alt={cheese.name} />
                        </div>
                        <div className='col-md-6'>
                            <div style={{display: 'flow-root'}}>
                                <ul className="summary-points">
                                    <li className="summary_milk">
                                        <i className="fa fa-flask"></i>
                                        <p>Made from {(cheese.milk ?? []).join(", ")} milk</p>
                                    </li>
                                    
                                    <li className="summary_country">
                                        <i className="fa fa-flag"></i>
                                        <p>Country of origin: {cheese.country}</p>
                                    </li>

                                    <li className="summary_moisture_and_type">
                                        <i className="fa fa-folder"></i>
                                        <p>Type: {cheese.type}</p>
                                    </li>

                                    <li className="summary_texture">
                                        <i className="fa fa-pie-chart"></i>
                                        <p>Texture: {(cheese.texture ?? []).join(", ")}</p>
                                    </li>

                                    <li className="summary_tint">
                                        <i className="fa fa-tint"></i>
                                        <p>Colour: {cheese.colour}</p>
                                    </li>

                                    <li className="summary_tint">
                                        <i className="fa-solid fa-dollar-sign"></i>
                                        <p>
                                            Price Per Kilo: {cheese.pricePerKilo}
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
                                                    Total cost: ${round(cheese.pricePerKilo * kilos)}
                                                </strong>
                                            </div>
                                        </p>
                                    </li>
                                </ul>
                            </div>
                            
                            <p className='mt-4'>
                                {cheese.description}
                            </p>

                        </div>
                    </div>
                </>
            }
        </div>
    );
};

export default View;