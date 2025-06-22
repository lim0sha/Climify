import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import WeatherPage from './pages/WeatherPage';

const App = () => (
    <Router>
        <Routes>
            <Route path="/climify" element={<HomePage />} />
            <Route path="/climify/weather/:city" element={<WeatherPage />} />
        </Routes>
    </Router>
);

export default App;
