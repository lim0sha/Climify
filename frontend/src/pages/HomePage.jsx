import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import SearchBar from '../components/SearchBar';
import '../styles/homepage.css'

const HomePage = () => {
    const [city, setCity] = useState('');
    const navigate = useNavigate();

    const handleSubmit = () => {
        if (city.trim()) {
            navigate(`/climify/weather/${city.trim()}`);
        }
    };

    return (
        <div className="homepage">
            <h1 className="homepage__title">Climify</h1>
            <p className="homepage__subtitle">Instant weather forecasts.</p>
            <SearchBar
                value={city}
                onChange={setCity}
                onSubmit={handleSubmit}
                placeholder="Enter your city..."
            />
        </div>
    );
};

export default HomePage;
