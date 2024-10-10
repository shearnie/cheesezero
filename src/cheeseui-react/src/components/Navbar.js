import React, { useState } from 'react';
import { useSearchParams } from 'react-router-dom';

const Navbar = () => {
    const [searchParams] = useSearchParams();
    const [q, setQuery] = useState(searchParams.get('q'));

    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <a className="navbar-brand" href="/">
                        Cheese Zero
                    </a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <a className="nav-link" href="/browse">
                                    Browse Cheeses
                                </a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="/by-type">
                                    Cheeses by Type
                                </a>
                            </li>
                            {/* <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Cheeses by Category
                                </a>
                                <ul className="dropdown-menu">
                                    <li><a className="dropdown-item" href="/by-type">By Type</a></li>
                                    <li><a className="dropdown-item" href="/by-country">By Country</a></li>
                                    <li><a className="dropdown-item" href="/by-milk">By Milk</a></li>
                                    <li><a className="dropdown-item" href="/by-texture">By Texture</a></li>
                                    <li><a className="dropdown-item" href="/by-colour">By Colour</a></li>
                                </ul>
                            </li> */}
                        </ul>
                        <form className="d-flex" role="search" action='search'>
                            <input className="form-control me-2" type="search" name="q" placeholder="Search here for cheese!" aria-label="Search" value={q} />
                            <button className="btn btn-outline-warning" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </>
    );
};

export default Navbar;