import React from 'react';
import '../styles/searchbar.css';

const SearchBar = ({ value, onChange, onSubmit }) => {
    const handleKeyPress = (e) => {
        if (e.key === 'Enter') onSubmit();
    };

    return (
        <div className="input__container">
            <div className="shadow__input"></div>
            <button className="input__button__shadow" onClick={onSubmit}>
                <svg
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                    height="20px"
                    width="20px"
                >
                    <path
                        d="M4 9a5 5 0 1110 0A5 5 0 014 9zm5-7a7 7 0 104.2 12.6.999.999 0 00.093.107l3 3a1 1 0 001.414-1.414l-3-3a.999.999 0 00-.107-.093A7 7 0 009 2z"
                        fillRule="evenodd"
                        fill="#17202A"
                    />
                </svg>
            </button>
            <input
                type="text"
                className="input__search"
                placeholder="Enter your city..."
                value={value}
                onChange={e => onChange(e.target.value)}
                onKeyDown={handleKeyPress}
            />
        </div>
    );
};

export default SearchBar;
