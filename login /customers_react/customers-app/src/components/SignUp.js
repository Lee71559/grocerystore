import { TextField, Button, Grid, Paper, Avatar, Typography, Link } from "@material-ui/core";
import { borderColor } from "@mui/system";
import { useForm } from "react-hook-form";
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';



const SignUp= () => {
    const { register, handleSubmit } = useForm();

    const onSubmit = (data) => {
        console.log(data);
    };

    const paperStyle={padding :50, height:'80vh', width:280, margin:"30px auto"}
    const avatarStyle={backgroundColor: 'gold'}
    const btnStyle={margin:'10px 0'}
    return (<div>

    <Grid>

        <Paper elevation={10} style = {paperStyle}>
          <form className="SignupForm" onSubmit={handleSubmit(onSubmit)}>

            <Grid align='center'>
             <Avatar style = {avatarStyle}> <LockOutlinedIcon/> </Avatar>
              <h2>Sign up</h2>
              <TextField
                label ="First Name"
                type="text"
                placeholder="First Name"
                name="firstname"
                fullWidth required
                {...register("firstname")} 
              /><br/><br/>
              <TextField
                label="Last Name"
                type="text"  
                placeholder="Last Name"
                name="lastname"
                fullWidth required
                {...register("lastname")} 
              />
                <br/><br/>
              <TextField
                label="Address"
                type="text"  
                placeholder="Address"
                name="address"
                fullWidth required
                {...register("address")} 
              />          
                <br/><br/>
              <TextField
                label="Phone Number "
                type="text"  
                placeholder="Phone Number"
                name="phonenumber"
                fullWidth required
                {...register("phonenumber")} 
              />    
                <br/><br/>
              <TextField
                label="Credit Card Id"
                type="text"  
                placeholder="Credit Card Id"
                name="creditcardid"
                fullWidth required
                {...register("creditcardid")} 
              />    
                <br/><br/>
              <TextField
                label="Email"
                type="email"  
                placeholder="Email"
                name="email"
                fullWidth required
                {...register("email")} 
              />    
                <br/><br/>
              <TextField
                label="Password"
                type="password"  
                placeholder="Password"
                name="password"
                fullWidth required
                {...register("password")} 
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
    );
};
export default SignUp;