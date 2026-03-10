import axiosInstanse from "../config/AxiosConfig";


export const getUser = async () => {
    try {
        const response = await axiosInstanse.get("https://jsonplaceholder.typicode.com/users");
        return response.data;
    } catch {
        console.log("통신 실패", err);
    }
}