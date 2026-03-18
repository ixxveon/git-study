import axios from 'axios';

const API_BASE_URL = 'https://d3ijeqnqadejib.cloudfront.net';

const axiosInstance = axios.create({
    baseURL: API_BASE_URL,
    timeout: 10000,
    header: {
        'Content-Type': 'application/json'
    }
})

export default axiosInstance;