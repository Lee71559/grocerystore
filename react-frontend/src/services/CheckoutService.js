import axios from 'axios';
//Docker: http://localhost:54504/
///const EMPLOYEE_API_BASE_URL = "http://localhost:8080/checkout/";
///const API_BASE_URL = "http://localhost:8080/checkout/";

const EMPLOYEE_API_BASE_URL = "http://localhost:54504/checkout/";
const API_BASE_URL = "http://localhost:54504/checkout/";


class CheckoutService{
    
    
    getPayments(){
        return axios.get(EMPLOYEE_API_BASE_URL +'/payments');
    }
    


    checkOut(command)
    {

        return axios.post(API_BASE_URL +'/payments', command);
    }
}


export default new CheckoutService()