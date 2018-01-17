import axios from 'axios'

const API_KEY = "07150806529e52d5c7ede0178e19dba5"; //https://openweathermap.org/
//const ROOT_URL = `http://samples.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;
const ROOT_URL = `http://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export const FETCH_WEATHER = "FETCH_WEATHER";

export function fetchWeather(city) {
    const url = `${ROOT_URL}&q=${city},ru`;
    const request = axios.get(url);

    return {
        type: FETCH_WEATHER,
        payload: request
    }
}