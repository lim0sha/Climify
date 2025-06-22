import React from 'react';

const WeatherCard = ({ data }) => {
    const current = data.currentConditions;
    const today = new Date(data.days[0].datetime).toLocaleDateString('en-GB', {
        day: '2-digit',
        month: 'short',
        year: 'numeric',
    });
    if (!current) return (
        <div className="error-container">
            <button className="back-uiverse-button" onClick={() => navigate('/climify')}>
                Back
            </button>
            <div className="error-title">Oops!</div>
            <div className="error-message">No weather data available.</div>
        </div>
    );

    return (
        <div className="weather-card">
            <h2>{data.resolvedAddress}</h2>
            <p>{today}</p>
            <h1>{Math.round(((current.temp - 32) / 1.8) * 10) / 10}°C</h1>
            <p>Feels like: {Math.round(((current.feelslike - 32) / 1.8) * 10) / 10}°C</p>
            <h4>{data.description}</h4>
            <div className="details">
                <span>Humidity: {current.humidity}%</span>
                <span>Wind: {Math.round(current.windspeed / 2.2355 * 10) / 10} m/s</span>
                <span>Pressure: {Math.round(current.pressure * 0.75 * 10) / 10} mmHg</span>
            </div>
        </div>
    );
};

export default WeatherCard;
