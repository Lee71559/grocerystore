import axios from 'axios';

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/catalog";
const API_BASE_URL = "http://localhost:8080/catalog";


class CatalogService{
    
    
    getItems(){
        return axios.get(API_BASE_URL + '/items');
    }

    postItem(command)
    {
        return axios.post(EMPLOYEE_API_BASE_URL + '/items', command);
    }
}


export default new CatalogService()