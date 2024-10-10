import React from "react";

const CheeseList = ({ showLoading, loadError, cheeses }) => {
    return (
        <>
            {showLoading &&
                <div>
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div>
            }
            {!showLoading && (cheeses.length === 0) &&
                <p>
                   No cheeses found.
                </p>
            }
            {(loadError !== "") &&
                <p className="text-danger">
                    Error: {loadError}
                </p>
            }
            {!showLoading && (cheeses.length > 0) &&
                <div className="grid row">
                    {cheeses.map(cheese => (
                        <div key={cheese.name} className="col-sm-6 col-md-4 text-center">
                            <a className="cheese-link" href={'/view?id=' + cheese.id}>
                                <div className="p-3 mb-3">
                                    <p className="cheese-list-header text-center">
                                        <strong>
                                            {cheese.name}
                                        </strong>
                                    </p>
                                    <img className="cheese-image" src={cheese.imagePath} alt={cheese.name} />
                                </div>
                            </a>
                        </div>
                    ))}
                </div>
            }
        </>
    );
};

export default CheeseList;