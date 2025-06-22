import React from 'react';
import {toCelsium} from './WeatherCardConverter'
import {mphToMs} from './WeatherCardConverter'
import {mPaToMmHg} from './WeatherCardConverter'

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
            <h4>{today}</h4>
            <h1>{toCelsium(current.temp)}°C</h1>
            <p>Feels like {toCelsium(current.feelslike)}°C</p>
            <h4>{data.description}</h4>
            <div className="details">
                <span>Humidity: {current.humidity}%</span>
                <span>Wind: {mphToMs(current.windspeed)} m/s</span>
                <span>Pressure: {mPaToMmHg(current.pressure)} mmHg</span>
            </div>
        </div>
    );
};

export default WeatherCard;