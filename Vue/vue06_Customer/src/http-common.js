import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:7788/api",
    headers: {
        "Content-type": "application/json",
    }
});