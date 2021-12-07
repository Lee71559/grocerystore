import axios from 'axios';

const CUSTOEMR_BACKEND = 'http://localhost:8080';


class CatalogService{
    
    
    getItems(){
        return axios.get(CUSTOEMR_BACKEND + '/catalog/items');
    }

}


export default new CatalogService()