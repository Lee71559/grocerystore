import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/checkout";

class CheckoutService{
    postAction(command)
    {
        return axios.post(EMPLOYEE_API_BASE_URL, command);
    }
}

export default CheckoutService