import axios from 'axios';


const CUSTOEMR_BACKEND = 'http://localhost:8080';


class CheckoutService{
    
    
    getPayments(){
        return axios.get(CUSTOEMR_BACKEND +'/checkout/payments');
    }
    


    checkOut(command)
    {

        return axios.post(CUSTOEMR_BACKEND +'/checkout/payments', command);
    }
}


export default new CheckoutService()