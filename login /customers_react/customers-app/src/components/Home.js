import { TextField, Button, Grid, Paper, Avatar, Typography, Link } from "@material-ui/core";
import { borderColor } from "@mui/system";
import { useForm } from "react-hook-form";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import CustomerService from '../services/CustomerService';
import { useHistory } from 'react-router-dom';

const Home = () => {
    const { register, handleSubmit } = useForm();
    const history = useHistory();

    const onSubmit = () => {
      let customer = {name : history.location.state.data};
      CustomerService.logoutCustomer(customer).then(res => {
      console.log(res.data);
      history.push("/signin");
    });


            console.log(history.location.state.data);
 
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
              <h2>Logout</h2>

              <br/><br/>
              <Button type = 'submit' variant="contained" color = "primary" style = {btnStyle} fullWidth>Logout</Button>
              </Grid>

          </form>
            </Paper>
        </Grid>
        </div>
    );
};
export default Home;