import axios from 'axios';

const CUSTOEMR_BACKEND = 'http://localhost:8080';


class CartService{
    
    getOrder(id){
        return axios.get(CUSTOEMR_BACKEND +'/cart/orders/' + id);
    }
    
    addToCart(id, command){
        return axios.post(CUSTOEMR_BACKEND +'/cart/ordersItem/' + id, command);
    }
    
    updateCart(id, command){
        return axios.put(CUSTOEMR_BACKEND + '/cart/ordersItem/' + id, command);
    }

    viewCart(id)
    {
        return axios.get(CUSTOEMR_BACKEND +'/cart/ordersItem/' + id);
    }
}


export default new CartService()