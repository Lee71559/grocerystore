import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/cart";
const API_BASE_URL = "http://localhost:8080/cart";


class CartService{
    
    getOrder(id){
        return axios.get(API_BASE_URL +'/orders/' + id);
    }
    
    addToCart(id, command){
        return axios.post(API_BASE_URL +'/ordersItem/' + id, command);
    }
    
    updateCart(id, command){
        return axios.put(API_BASE_URL + '/ordersItem/' + id, command);
    }

    viewCart(id)
    {
        return axios.get(API_BASE_URL +'/ordersItem/' + id);
    }
}


export default new CartService()