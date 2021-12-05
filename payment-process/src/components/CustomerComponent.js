import React from 'react';
import CustomerService from '../services/CustomerService';
import { TextField, Button, Grid, Paper, Avatar, Typography, Link } from "@material-ui/core";
import { useForm } from "react-hook-form";


const paperStyle={padding :50, height:'80vh', width:280, margin:"30px auto"}
const avatarStyle={backgroundColor: 'gold'}
const btnStyle={margin:'10px 0'}

// const { register, handleSubmit } = useForm()

// const onSubmit = (data) => {
//   console.log(data);
// }

class CustomerComponent extends React.Component {

	constructor(props) {
		super(props)
		this.state = {
			 customers:[]//defined an array
			// , message:""
			// , name:""
			// , password:""	
		}
		// this.changeNameHandler = this.changeNameHandler.bind(this);
		// this.changePasswordHandler = this.changePasswordHandler.bind(this);
		// this.save = this.save.bind(this);

	}

	// save = (e) => {
	// 	e.preventDefault();
	// 	let customer = {name : this.state.name, password: this.state.password};
	// 	CustomerService.addCustomer(customer).then(res => {
	// 		console.log(res);
	// 	})
	// }

	// changeNameHandler = (event) => {
	// 	this.setState({
	// 		name: event.target.value
	// 	});
	// }

	// changePasswordHandler = (event) => {
	// 	this.setState({
	// 		password: event.target.value
	// 	});
	// }


	//used to call the REST API
	componentDidMount() {
		CustomerService.getCustomers().then((response) => {
			this.setState({customers: response.data})
		});

		// CustomerService.addCustomer("ron", "123").then((response) => {
		// 	this.setState({message: response})
		// });
	}

  

  

	render (){
    // const { register, handleSubmit } = useForm();


		return ( 
			<div>
				<h1 className = "text-center"> Customer Table</h1>
				<table className = "table table-striped">
					<thead>
					<tr>

						<td>ID</td>
						<td>Name</td>
						<td>Password</td>
					</tr>

					</thead>
					<tbody> 
						{
							this.state.customers.map(
								customer => 
									<tr key={customer.id}>
										<td> {customer.id} </td>
										<td> {customer.name} </td>
										<td> {customer.password} </td>	
										<td> {customer.authenticated} </td>																				
									</tr>
							)
						}
					</tbody>
				</table>

<Grid>

        <Paper elevation={10} style = {paperStyle}>
          <form className="SignupForm" >

            <Grid align='center'>
              <h2>Sign up</h2>
              <TextField
                label ="Name"
                type="text"
                placeholder="First Name"
                name="name"
                value={this.state.name}
                onChange = {this.changeNameHandler}
                fullWidth required
                // {...register("firstname")} 
              />
              <br/><br/>

              <TextField
                label="Password"
                type="password"  
                placeholder="Password"
                name="password"
                value={this.state.password}
                onChange = {this.changePasswordHandler}
                fullWidth required
                // {...register("password")} 
              />    
               <br/><br/>
              <Button type='submit' variant="contained" color = "primary" style = {btnStyle} fullWidth>Sign up</Button>
              <br/><br/><Typography> Already have an account?
                  <Link href="/signin">
                    Sign in
                  </Link>
               
                </Typography> 
              </Grid>

          </form>
            </Paper>
        </Grid>                       

			</div>
		)
	}
}

export default CustomerComponent