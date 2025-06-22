export const fetchWeatherData = async (city) => {
    const response = await fetch(`/climify/api/weather/${city}`);
    if (!response.ok) throw new Error("City not found");
    return response.json();
};
