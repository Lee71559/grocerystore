import axios from 'axios' 

const CUSTOMERS_REST_API_URL = 'http://localhost:8080/customers';
const CUSTOMERS_REST_API_URL2 = 'http://localhost:8080/customer/authenticate';
const CUSTOMERS_REST_API_URL3 = 'http://localhost:8080/customer/logout';
class CustomerService {
	
	getCustomers() {
		return axios.get(CUSTOMERS_REST_API_URL);
	}

	addCustomer(customer) {
		return axios.post(CUSTOMERS_REST_API_URL, customer);
	}

	authenticateCustomer(customer) {
		return axios.post(CUSTOMERS_REST_API_URL2, customer);
	}

	logoutCustomer(customer) {
		return axios.post(CUSTOMERS_REST_API_URL3, customer);
	}

}

export default new CustomerService(); //export object of the class