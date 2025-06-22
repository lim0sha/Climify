import React from 'react';
import '../styles/loader.css';

const Loader = () => {
    return (
        <div className="loader-container">
            <p className="loader-text">Loading...</p>
            <div className="loader"></div>
        </div>
    );
};

export default Loader;
