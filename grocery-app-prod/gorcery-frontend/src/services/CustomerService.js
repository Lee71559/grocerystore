import axios from 'axios' 

const CUSTOEMR_BACKEND = 'http://localhost:8080';

class CustomerService {
	
	getCustomers() {
		return axios.get(CUSTOEMR_BACKEND + '/customer');
	}

	addCustomer(customer) {
		return axios.post(CUSTOEMR_BACKEND+ '/customer', customer);
	}

	authenticateCustomer(customer) {
		return axios.post(CUSTOEMR_BACKEND + '/customer/authenticate', customer);
	}

	logoutCustomer(customer) {
		return axios.post(CUSTOEMR_BACKEND + '/customer/logout', customer);
	}

}

export default new CustomerService(); //export object of the class