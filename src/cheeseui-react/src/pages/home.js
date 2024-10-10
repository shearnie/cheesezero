import React, { useEffect } from 'react';

const Home = () => {

    useEffect(() => {
        document.title = `Cheese Zero`;
    }, []);

    return (
        <div className='p-3'>
            <h3>
                Welcome Cheese Enthusiast
            </h3>
            <p>
                Cheese is nutritious food made mostly from the milk of cows but also other mammals, including sheep, goats, buffalo, reindeer, camels and yaks. Around 4000 years ago people have started to breed animals and process their milk. That's when the cheese was born.
            </p>
            <p>
                Explore this site to find out about different kinds of cheese from all around the world.
            </p>
            <p>
                You can search the database of 2036 variaties of cheese by names, by country of origin, by kind of milk that is used to produce it, or by texture.
            </p>
            <p>
                The database includes information on most famous sorts of cheese such as Cheddar, Camembert, Stilton or Parmesan, as well as rarities like Crottin de Chavignol.
            </p>

            <a className="btn btn-warning" href="/browse">
                View Cheeses &gt;
            </a>
        </div>
    );
};

export default Home;