import { TextField, Button, Grid, Paper, Avatar, Typography, Link } from "@material-ui/core";
import { borderColor } from "@mui/system";
import { useForm } from "react-hook-form";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import CustomerService from '../services/CustomerService';
import { useHistory } from 'react-router-dom';

const SignIn= () => {
    const { register, handleSubmit } = useForm();
    const history = useHistory();

    const onSubmit = (data) => {
          let customer = {name : data.customername, password: data.customerpassword};
          CustomerService.authenticateCustomer(customer).then(res => {
          console.log(res.data);
          history.push({pathname: "/home",
        state:{data:customer.name}});
        });
    };

    const paperStyle={padding :50, height:'60vh', width:280, margin:"100px auto"}
    const avatarStyle={backgroundColor: 'gold'}
    const btnStyle={margin:'10px 0'}
    return (<div>

    <Grid>

        <Paper elevation={10} style = {paperStyle}>
          <form className="SignupForm" onSubmit={handleSubmit(onSubmit)}>

            <Grid align='center'>
             <Avatar style = {avatarStyle}> <LockOutlinedIcon/> </Avatar>
              <h2>Sign in</h2>
              <TextField
                label ="Customer Name"
                type="text"
                placeholder="Name"
                name="customername"
                fullWidth required
                {...register("customername")} 
              /><br/><br/>
              <TextField
                label="Password"
                type="password"  
                placeholder="Password"
                name="customerpassword"
                fullWidth required
                {...register("customerpassword")} 
              />
              <br/><br/>
              <Button type = 'submit' variant="contained" color = "primary" style = {btnStyle} fullWidth>Sign in</Button>
                <Typography> Do you have an account?
                  <Link href="/signup">
                    Sign up
                  </Link>
                </Typography> 
              </Grid>

          </form>
            </Paper>
        </Grid>
        </div>
    );
};
export default SignIn;