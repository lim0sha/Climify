import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import WeatherCard from '../components/WeatherCard';
import { fetchWeatherData } from '../api';
import Loader from '../components/Loader';
import '../styles/weather.css';
import '../styles/error.css'

const WeatherPage = () => {
    const { city } = useParams();
    const navigate = useNavigate();
    const [weather, setWeather] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    useEffect(() => {
        fetchWeatherData(city)
            .then((data) => {
                setWeather(data);
                setLoading(false);
            })
            .catch(() => {
                setError(true);
                setLoading(false);
            });
    }, [city]);

    if (loading) return <Loader />;
    if (error) {
        return (
            <div className="error-container">
                <button className="back-uiverse-button" onClick={() => navigate('/climify')}>
                    Back
                </button>
                <div className="error-title">Oops!</div>
                <div className="error-message">City not found.</div>
            </div>
        );
    }

    return (
        <div className="weather-page">
            <button className="back-uiverse-button" onClick={() => navigate('/climify')}>
                Back
            </button>
            <div className="weather-wrapper">
                <div className="weather-card-container">
                    <div className="weather-card-shadow"></div>
                    <WeatherCard data={weather} />
                </div>
            </div>
        </div>
    );
};

export default WeatherPage;