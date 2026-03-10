import axiosInstanse from "../config/AxiosConfig";


export const getUser = async () => {
    try {
        // const response = await axiosInstanse.get("https://jsonplaceholder.typicode.com/users");
        const response = await axiosInstanse.get("http://localhost/api");
        return response.data;
    } catch (err) {
        console.log("통신 실패", err);
    }
}