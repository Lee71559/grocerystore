import React, { PureComponent, useState } from 'react'
import CheckoutService, {checkOut} from '../services/CheckoutService.js'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@mui/material/Button';
import InputLabel from '@mui/material/InputLabel';
import Divider from '@material-ui/core/Divider';
import Grid from '@material-ui/core/Grid';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import { Typography } from "@material-ui/core";




function data(amount,name,price)
{
    return{amount,name, price};
}

const rows = [
data('1','Milk','$7.00'),
data('1','Eggs','$4.00'),
data('2','Soda','$2.00')
];

var fnemptyError = false;
var lsemptyError = false;
var ademptyError = false;
var ctemptyError = false;
var stemptyError = false;
var ziemptyError = false;
var phemptyError = false;
var cnemptyError = false;
var cmemptyError = false;
var cyemptyError = false;
var cvemptyError = false;
var ememptyError = false;

var Error = false;



class CheckoutComponent extends PureComponent {
    constructor(props) {
        super(props)
        this.state = {
            firstname: '',
            lastname: '',
            address: '',
            city: '',
            state: '',
            zip:'',
            phone:'',

            cardnum:'',
            cardexpmon:'',
            cardexpyear:'',
            cardcvv:'',
            email:'',
            notes:''


        }

  
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeStateHandler = this.changeStateHandler.bind(this);
        this.changeZipHandler = this.changeZipHandler.bind(this);
        this.changePhoneNumberHandler = this.changePhoneNumberHandler.bind(this);
        this.changeCCNumberHandler = this.changeCCNumberHandler.bind(this);
        this.changeExpMonthHandler = this.changeExpMonthHandler.bind(this);
        this.changeExpYearHandler = this.changeExpYearHandler.bind(this);
        this.changeCVVHandler = this.changeCVVHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeNotesHandler = this.changeNotesHandler.bind(this);
        this.saveCC = this.saveCC.bind(this);
        

        
    }

    
    
    saveCC = (e) => {
        e.preventDefault();
        Error = false;
        let command = 
        {
           firstname: this.state.firstname, 
           lastname: this.state.lastname,
            address: this.state.address,
            city: this.state.city,
            state: this.state.state,
            zip: this.state.zip,
            phone: this.state.phone,
            cardnum: this.state.cardnum,
            cardexpmon: this.state.cardexpmon,
            cardexpyear: this.state.cardexpyear,
            cardcvv: this.state.cardcvv,
            email: this.state.email,
            notes: this.state.notes
        };
        
        CheckoutService.checkOut(command)
        .then(res => {
            //console.log(res);
            if(res.data.error == true)
            {
                Error = true;
            }
            console.log(res.data.error);
        

        });
    }

    
  
    changeFirstNameHandler= (event) => {
       fnemptyError = false;
        if(event.target.value =='')
        {
            fnemptyError = true;
            this.setState({firstname: event.target.value});
        }
        else{
            this.setState({firstname: event.target.value});
        }
    }

    changeLastNameHandler= (event) => {
        lsemptyError = false;
        if(event.target.value == '')
        {
            lsemptyError = true;
            this.setState({lastname: event.target.value});

        }
        else{
            this.setState({lastname: event.target.value});

        }
    }

    changeAddressHandler= (event) => {
        ademptyError = false;
        if(event.target.value == '')
        {
            ademptyError = true;
            this.setState({address: event.target.value});

        }
        else{
            this.setState({address: event.target.value});
        }
    }

    changeCityHandler= (event) => {
        ctemptyError = false;
        if(event.target.value == '')
        {
            ctemptyError = true;
            this.setState({city: event.target.value});

        }
        else{
            this.setState({city: event.target.value});
        }
    }

    changeStateHandler= (event) => {
        stemptyError = false;
        if(event.target.value == '')
        {
            stemptyError = true;
            this.setState({state: event.target.value});

        }
        else{
            this.setState({state: event.target.value});

        }
    }

    changeZipHandler= (event) => {
        ziemptyError = false;
        if(event.target.value == '')
        {
            ziemptyError = true;
            this.setState({zip: event.target.value});

        }
        else{
            this.setState({zip: event.target.value});

        }
    }

    changePhoneNumberHandler= (event) =>{
        phemptyError = false;
        if(event.target.value == '')
        {
            phemptyError = true;
            this.setState({phone: event.target.value});

        }
        else{
            this.setState({phone: event.target.value});

        }
    }

    changeCCNumberHandler= (event) =>{
        cnemptyError = false;
        if(event.target.value == '')
        {
            cnemptyError = true;
            this.setState({cardnum: event.target.value});

        }
        else{
            this.setState({cardnum: event.target.value});

        }
    }

    changeExpMonthHandler= (event) => {
        cmemptyError = false;
        if(event.target.value == '')
        {
            cmemptyError = true;
            this.setState({cardexpmon: event.target.value});

        }
        else{
            this.setState({cardexpmon: event.target.value});
        }
    }

    changeExpYearHandler= (event) => {
        cyemptyError = false;
        if(event.target.value == '')
        {
            cyemptyError = true;
            this.setState({cardexpyear: event.target.value});

        }
        else{
            this.setState({cardexpyear: event.target.value});

        }
    }

    changeCVVHandler= (event) => {
        cvemptyError = false;
        if(event.target.value == '')
        {
            cvemptyError = true;
            this.setState({cardcvv: event.target.value});

        }
        else{
            this.setState({cardcvv: event.target.value});

        }
    }

    changeEmailHandler= (event) => {
        ememptyError = false;
        if(event.target.value == '')
        {
            ememptyError = true;
            this.setState({email: event.target.value});

        }
        else{
            this.setState({email: event.target.value});

        }
    }

    changeNotesHandler= (event) => {
        this.setState({notes: event.target.value});

    }


    render() {
        const check =()=> {

            if(Error)
            {
                return <div>
                <Typography align="center" color="error"> Error </Typography>  
             <Typography aligned="center"><Button variant="contained" color="success" onClick={this.saveCC} >Process Payment</Button></Typography></div>

             
            }
        if(fnemptyError || lsemptyError || ademptyError || ctemptyError || stemptyError || ziemptyError || phemptyError || cnemptyError || cmemptyError || cyemptyError || cvemptyError || ememptyError)
        {
            return <div>
               <Typography align="center" color="error"> Please fill in required information. </Typography>  
               <br/>
               <Typography align="center"> <Button disabled variant="contained" color="success" onClick={this.saveCC} >Process Payment</Button>
                </Typography>

            </div>
        }
        else{
            return <div><Typography aligned="center"><Button href="/status" variant="contained" color="success" onClick={this.saveCC} >Process Payment</Button></Typography></div>
        }
    }
        return (
            <div>
                <Box m ={10} marginTop={11} alignContent="center" maxWidth={300} boxShadow="1" p={2}>
                <TableHead>
          <TableRow>
            <TableCell align="center" >
              <h3>Cart</h3>
            </TableCell>
            <TableCell/>
            <TableCell/>
            <TableCell/>

            <TableCell  colSpan={4}>
            <h3>  <ShoppingCartIcon/>4</h3></TableCell>
          </TableRow>
          </TableHead>
                    <TableContainer> 
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell align="center">Item Name</TableCell>
                                    <TableCell align="center">Price </TableCell>
                                    <TableCell> Quantity </TableCell>

                                </TableRow>
                            </TableHead>
                            <TableBody>
                            {rows.map((row) => (
                            <TableRow
                            key={row.name}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                            <TableCell align="center">
                                {row.name}
                            </TableCell>
                            <TableCell align="center">{row.price}</TableCell>
                            <TableCell align="center">{row.amount}</TableCell> 
                            </TableRow>

                                ))}
                            </TableBody>
                            <TableBody> 
                                
                                <TableCell colSpan={2} align='right'> Total: $13.00 </TableCell>
                            </TableBody>
                        </Table>
                    </TableContainer>
                    </Box>
                    <Grid container spacing={2} maxWidth={200}>
                    <Grid item xs={3} >
                    <Box marginLeft={10} 
                    component="form"
                    sx={{
                        '& .MuiTextField-root': { m: 1, width: '25ch'},
                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <h3 >Billing Address</h3> 
                    <div>
                    <TextField
                    required
                    id="fname"
                    type="text"
                    name="firstname"
                    label="First Name"
                    placeholder="John"
                    value={this.state.firstname}
                    error={fnemptyError}

                    onChange={this.changeFirstNameHandler}
                    />
                    <br/>
                    <TextField
                    required
                    id="outlined-required"
                    label="Last Name"
                    placeholder="Doe"
                    value={this.state.lastname}
                    onChange={this.changeLastNameHandler}
                    error={lsemptyError}

                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Address"
                    placeholder="123 W. 17th Street "
                    value={this.state.address}
                    onChange={this.changeAddressHandler}
                    error={ademptyError}

                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="City"
                    placeholder="San Jose"
                    value={this.state.city}
                    error={ctemptyError}

                    onChange={this.changeCityHandler}
                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="State"
                    placeholder="CA"
                    value={this.state.state}
                    onChange={this.changeStateHandler}
                    error={stemptyError}

                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Zip"
                    placeholder="91111"
                    value={this.state.zip}
                    onChange={this.changeZipHandler}
                    error={ziemptyError}

                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Phone Number"
                    placeholder="(408) 123-4567"
                    value={this.state.phone}
                    onChange={this.changePhoneNumberHandler}
                    error={phemptyError}

                    />
                    </div>
                   

                 </Box>
                 </Grid>

                 <Grid item xs={5}>
                     <Box 
                     marginLeft={20} 
                    
                     component="form"
                     sx={{
                         '& .MuiTextField-root': { m: 1, width: '25ch'},
                     }}
                     noValidate
                     autoComplete="off"
                     >
                     <div>
                    <h3> Credit Card </h3>
                    
                        <h6> Accepted Cards </h6>
                        <img src="https://img.icons8.com/color-glass/48/000000/visa.png"/>
                        <img alt="svgImg" src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHg9IjBweCIgeT0iMHB4Igp3aWR0aD0iNDgiIGhlaWdodD0iNDgiCnZpZXdCb3g9IjAgMCAxNzIgMTcyIgpzdHlsZT0iIGZpbGw6IzAwMDAwMDsiPjxkZWZzPjxsaW5lYXJHcmFkaWVudCB4MT0iNzMuMDEwNDIiIHkxPSIzOS42MzUyNSIgeDI9IjEwMy4wMTM2NyIgeTI9IjE0Ni43MjMxNyIgZ3JhZGllbnRVbml0cz0idXNlclNwYWNlT25Vc2UiIGlkPSJjb2xvci0xX1NvNmpLOGk2amRkWl9ncjEiPjxzdG9wIG9mZnNldD0iMCIgc3RvcC1jb2xvcj0iIzAwYjNlZSI+PC9zdG9wPjxzdG9wIG9mZnNldD0iMSIgc3RvcC1jb2xvcj0iIzAwODJkOCI+PC9zdG9wPjwvbGluZWFyR3JhZGllbnQ+PC9kZWZzPjxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0ibm9uemVybyIgc3Ryb2tlPSJub25lIiBzdHJva2Utd2lkdGg9IjEiIHN0cm9rZS1saW5lY2FwPSJidXR0IiBzdHJva2UtbGluZWpvaW49Im1pdGVyIiBzdHJva2UtbWl0ZXJsaW1pdD0iMTAiIHN0cm9rZS1kYXNoYXJyYXk9IiIgc3Ryb2tlLWRhc2hvZmZzZXQ9IjAiIGZvbnQtZmFtaWx5PSJub25lIiBmb250LXdlaWdodD0ibm9uZSIgZm9udC1zaXplPSJub25lIiB0ZXh0LWFuY2hvcj0ibm9uZSIgc3R5bGU9Im1peC1ibGVuZC1tb2RlOiBub3JtYWwiPjxwYXRoIGQ9Ik0wLDE3MnYtMTcyaDE3MnYxNzJ6IiBmaWxsPSJub25lIj48L3BhdGg+PGc+PHBhdGggZD0iTTE1NC41MzEyNSwzMi4yNWgtMTM3LjA2MjVjLTUuNjkwMzMsMCAtMTAuMzAyMDgsNC42MTE3NSAtMTAuMzAyMDgsMTAuMzAyMDh2ODYuODk1ODNjMCw1LjY5MDMzIDQuNjExNzUsMTAuMzAyMDggMTAuMzAyMDgsMTAuMzAyMDhoMTM3LjA2MjVjNS42OTAzMywwIDEwLjMwMjA4LC00LjYxMTc1IDEwLjMwMjA4LC0xMC4zMDIwOHYtODYuODk1ODNjMCwtNS42OTAzMyAtNC42MTE3NSwtMTAuMzAyMDggLTEwLjMwMjA4LC0xMC4zMDIwOHoiIGZpbGw9InVybCgjY29sb3ItMV9TbzZqSzhpNmpkZFpfZ3IxKSI+PC9wYXRoPjxwYXRoIGQ9Ik04NS4yMDQ1LDEwMC4yNjUyNWMtMi45NjM0MiwwIC01LjM3NSwtMi40MTE1OCAtNS4zNzUsLTUuMzc1di0wLjE0NjkybC0xLjEwNzI1LDIuMzk3MjVjLTAuODc0MzMsMS44OTU1OCAtMi43OTE0MiwzLjEyNDY3IC00Ljg4MDUsMy4xMjQ2N2gtMy4yODU5MmMtMi4xMjQ5MiwwIC00LjA1Mjc1LC0xLjI1NDE3IC00LjkxMjc1LC0zLjE5NjMzbC0wLjkxMDE3LC0yLjA0OTY3Yy0wLjA2ODA4LDIuOTA2MDggLTIuNDUxLDUuMjQ2IC01LjM3NSw1LjI0NmgtOS40NTI4M2MtMi4xMzU2NywwIC00LjA2NzA4LC0xLjI2NDkyIC00LjkyMzUsLTMuMjE3ODNsLTEuMDM1NTgsLTIuMzY1aC03LjU5NjY3bC0xLjAwMzMzLDIuMzMyNzVjLTAuODUyODMsMS45NzQ0MiAtMi43OTE0MiwzLjI1MDA4IC00LjkzNzgzLDMuMjUwMDhoLTMuOTUyNDJjLTIuNDY4OTIsMCAtNC40NzkxNywtMi4wMTAyNSAtNC40NzkxNywtNC40NzkxN3YtMC4xOTcwOGwwLjA0MywtMC40M2wwLjEyMTgzLC0wLjU1OWwxMC4xNzY2NywtMjMuMzAyNDJjMC44NjcxNywtMS45NTI5MiAyLjc5ODU4LC0zLjIxNDI1IDQuOTI3MDgsLTMuMjE0MjVoNS44MTU3NWMyLjExNDE3LDAgNC4wMzg0MiwxLjI0NyA0LjkwNTU4LDMuMTc4NDJsMy40MzI4Myw3LjY4OTgzdi01LjQ5MzI1YzAsLTIuOTYzNDIgMi40MTE1OCwtNS4zNzUgNS4zNzUsLTUuMzc1aDYuNzA4YzIuMTEwNTgsMCA0LjAzNDgzLDEuMjQzNDIgNC45MDIsMy4xNzEyNWwzLjgwMTkyLDguNDYzODNsMy44MjM0MiwtOC40Njc0MmMwLjg2MzU4LC0xLjkyNDI1IDIuNzg3ODMsLTMuMTY3NjcgNC44OTQ4MywtMy4xNjc2N2g2Ljg4NzE3YzIuOTYzNDIsMCA1LjM3NSwyLjQxMTU4IDUuMzc1LDUuMzc1djIxLjQzMTkyYzAsMi45NjM0MiAtMi40MTE1OCw1LjM3NSAtNS4zNzUsNS4zNzV6IiBmaWxsPSIjMDAwMDAwIiBvcGFjaXR5PSIwLjA1Ij48L3BhdGg+PHBhdGggZD0iTTg1LjIwNDUsOTguNDczNThjLTEuOTc0NDIsMCAtMy41ODMzMywtMS42MDg5MiAtMy41ODMzMywtMy41ODMzM3YtOC4zMDYxN2wtNC41MjU3NSw5LjgwNzU4Yy0wLjU4NDA4LDEuMjY0OTIgLTEuODU5NzUsMi4wODE5MiAtMy4yNTM2NywyLjA4MTkyaC0zLjI4NTkyYy0xLjQxNTQyLDAgLTIuNzAxODMsLTAuODM0OTIgLTMuMjc1MTcsLTIuMTMyMDhsLTQuMzM1ODMsLTkuNzc4OTJ2OC4zMjc2N2MwLDEuOTc0NDIgLTEuNjA4OTIsMy41ODMzMyAtMy41ODMzMywzLjU4MzMzaC05LjQ1MjgzYy0xLjQyMjU4LDAgLTIuNzEyNTgsLTAuODQyMDggLTMuMjgyMzMsLTIuMTQ2NDJsLTEuNTA1LC0zLjQzNjQyaC05Ljk1MDkybC0xLjQ2OTE3LDMuNDE4NWMtMC41Njk3NSwxLjMxNTA4IC0xLjg1OTc1LDIuMTY0MzMgLTMuMjkzMDgsMi4xNjQzM2gtMy45NTI0MmMtMS40ODM1LDAgLTIuNjg3NSwtMS4yMDQgLTIuNjg3NSwtMi42ODc1di0wLjI0MDA4bDAuMTI1NDIsLTAuNTU5bDEwLjA2OTE3LC0yMi45NzI3NWMwLjU3NjkyLC0xLjMwMDc1IDEuODYzMzMsLTIuMTQyODMgMy4yODIzMywtMi4xNDI4M2g1LjgxNTc1YzEuNDExODMsMCAyLjY5MTA4LDAuODMxMzMgMy4yNzE1OCwyLjExNzc1bDYuODYyMDgsMTUuMzY1MzN2LTEzLjg5NjE3YzAsLTEuOTc0NDIgMS42MDg5MiwtMy41ODMzMyAzLjU4MzMzLC0zLjU4MzMzaDYuNzA4YzEuNDA4MjUsMCAyLjY5MTA4LDAuODI3NzUgMy4yNjgsMi4xMTQxN2w1LjQzMjMzLDEyLjA5Mzc1bDUuNDU3NDIsLTEyLjA5NzMzYzAuNTgwNSwtMS4yODI4MyAxLjg2MzMzLC0yLjExMDU4IDMuMjY4LC0yLjExMDU4aDYuODhjMS45NzQ0MiwwIDMuNTgzMzMsMS42MDg5MiAzLjU4MzMzLDMuNTgzMzN2MjEuNDMxOTJjMCwxLjk3NDQyIC0xLjYwODkyLDMuNTgzMzMgLTMuNTgzMzMsMy41ODMzM3pNNDEuMDc1NzUsODMuOTAzNzVsLTEuMDQ5OTIsLTIuNDA0NDJsLTEuMDEwNSwyLjQwNDQyeiIgZmlsbD0iIzAwMDAwMCIgb3BhY2l0eT0iMC4wNyI+PC9wYXRoPjxwYXRoIGQ9Ik04Ny43OTE2Nyw3MS42NjY2N2gtNi44ODcxN2MtMC43MDU5MiwwIC0xLjM0Mzc1LDAuNDEyMDggLTEuNjM0LDEuMDUzNWwtNy4wOTUsMTUuNzI3MjVsLTcuMDU5MTcsLTE1LjcyMzY3Yy0wLjI5MDI1LC0wLjY0MTQyIC0wLjkzMTY3LC0xLjA1NzA4IC0xLjYzNzU4LC0xLjA1NzA4aC02LjcwNDQyYy0wLjk4OSwwIC0xLjc5MTY3LDAuODAyNjcgLTEuNzkxNjcsMS43OTE2N3YyMi4zMDk4M2wtMTAuMjg3NzUsLTIzLjA0MDgzYy0wLjI4NjY3LC0wLjY0NSAtMC45MjgwOCwtMS4wNjA2NyAtMS42MzQsLTEuMDYwNjdoLTUuODE1NzVjLTAuNzA5NSwwIC0xLjM1NDUsMC40MTkyNSAtMS42NDExNywxLjA3MTQybC05Ljk4MzE3LDIyLjcyMTkyYzAsMCAtMC4wNjA5MiwwLjIyNTc1IC0wLjA2MDkyLDAuMzI2MDhjMCwwLjQ5NDUgMC40MDEzMywwLjg5NTgzIDAuODk1ODMsMC44OTU4M3YwaDMuOTUyNDJjMC43MTY2NywwIDEuMzYxNjcsLTAuNDI2NDIgMS42NDQ3NSwtMS4wODIxN2wxLjkzODU4LC00LjUwMDY3aDEyLjI5OGwxLjk3NDQyLDQuNTA3ODNjMC4yODY2NywwLjY1MjE3IDAuOTI4MDgsMS4wNzE0MiAxLjY0MTE3LDEuMDcxNDJoOS40NTI4M2MwLjk4OSwwIDEuNzkxNjcsLTAuODAyNjcgMS43OTE2NywtMS43OTE2N3YtMTYuNzg3OTJsNy43NjUwOCwxNy41MTUzM2MwLjI4NjY3LDAuNjQ4NTggMC45MjgwOCwxLjA2NDI1IDEuNjM3NTgsMS4wNjQyNWgzLjI4OTVjMC42OTg3NSwwIDEuMzMzLC0wLjQwNDkyIDEuNjI2ODMsLTEuMDM5MTdsNy45NDQyNSwtMTcuMjE3OTJ2MTYuNDY1NDJjMCwwLjk4OSAwLjgwMjY3LDEuNzkxNjcgMS43OTE2NywxLjc5MTY3aDIuNTg3MTdjMC45ODksMCAxLjc5MTY3LC0wLjgwMjY3IDEuNzkxNjcsLTEuNzkxNjd2LTIxLjQyODMzYzAsLTAuOTg5IC0wLjgwMjY3LC0xLjc5MTY3IC0xLjc5MTY3LC0xLjc5MTY3ek0zNi4zMTcwOCw4NS42OTU0MmwzLjY3NjUsLTguNzQzMzNsMy44MTk4Myw4Ljc0MzMzeiIgZmlsbD0iI2ZmZmZmZiI+PC9wYXRoPjxwYXRoIGQ9Ik0xMzkuNzI4NSwxMDAuMzMzMzNjLTEuNTUxNTgsMCAtMy4wMjQzMywtMC42NzAwOCAtNC4wNDU1OCwtMS44MzQ2N2wtNC4xMjA4MywtNC43MDQ5MmwtNC4yNjA1OCw0LjcwNDkyYy0xLjAxNDA4LDEuMTIxNTggLTIuNDY1MzMsMS43NzAxNyAtMy45ODQ2NywxLjc3MDE3aC0yMS4xOTE4M2MtMi45NjM0MiwwIC01LjM3NSwtMi40MTE1OCAtNS4zNzUsLTUuMzc1di0yMS40MzU1YzAsLTIuOTYzNDIgMi40MTE1OCwtNS4zNzUgNS4zNzUsLTUuMzc1aDI0LjQwNjA4bDUuMzUzNSw2LjA1NTgzbDQuNjk0MTcsLTUuMDk1NWwwLjM1NDc1LC0wLjE1MDVjMC41MTk1OCwtMC40MjY0MiAxLjQ1MTI1LC0wLjc0MTc1IDIuNDMzMDgsLTAuNzQxNzVoNS41MjE5MmMyLjQ2ODkyLDAgNC40NzkxNywyLjAxMDI1IDQuNDc5MTcsNC40NzkxN2MwLDAuNzMxIC0wLjE4NjMzLDEuODIzOTIgLTEuMDgyMTcsMi44ODFsLTcuNzQsOC40NTY2N2w5LjE3NjkyLDEwLjY0MjVsLTAuMzY5MDgsMC44NmMwLjAxMDc1LDAuMTI5IDAuMDE3OTIsMC4yNTggMC4wMTc5MiwwLjM4MzQyYzAsMi40Njg5MiAtMi4wMTAyNSw0LjQ3OTE3IC00LjQ3OTE3LDQuNDc5MTd6IiBmaWxsPSIjMDAwMDAwIiBvcGFjaXR5PSIwLjA1Ij48L3BhdGg+PHBhdGggZD0iTTEzOS43Mjg1LDk4LjU0MTY3Yy0xLjAzNTU4LDAgLTIuMDE3NDIsLTAuNDQ3OTIgLTIuNjk0NjcsLTEuMjIxOTJsLTUuNDUwMjUsLTYuMjIwNjdsLTUuNjExNSw2LjE5OTE3Yy0wLjY3MzY3LDAuNzQ4OTIgLTEuNjQ0NzUsMS4xNzg5MiAtMi42NTUyNSwxLjE3ODkyaC0yMS4xOTE4M2MtMS45NzQ0MiwwIC0zLjU4MzMzLC0xLjYwODkyIC0zLjU4MzMzLC0zLjU4MzMzdi0yMS40MzU1YzAsLTEuOTc0NDIgMS42MDg5MiwtMy41ODMzMyAzLjU4MzMzLC0zLjU4MzMzaDIzLjU5NjI1bDYuMTMxMDgsNi45MzczM2w1Ljc3NjMzLC02LjI3MDgzbDAuMTE4MjUsLTAuMDUwMTdjMC40NjU4MywtMC4zNTQ3NSAxLjAyNDgzLC0wLjU0ODI1IDEuNjEyNSwtMC41NDgyNWg1LjUyMTkyYzEuNDgzNSwwIDIuNjg3NSwxLjIwNCAyLjY4NzUsMi42ODc1YzAsMC40MzM1OCAtMC4xMTQ2NywxLjA4MjE3IC0wLjY1OTMzLDEuNzIzNThsLTguNzY4NDIsOS41NzgyNWw5LjQ4NTA4LDEwLjk5NzI1bC0wLjEzMjU4LDAuMzA0NThjMC4wNTAxNywwLjIwMDY3IDAuMDc1MjUsMC40MDg1IDAuMDc1MjUsMC42MTYzM2MwLDEuNDgzNSAtMS4yMDQsMi42ODc1IC0yLjY4NzUsMi42ODc1aC01LjE1Mjgzek0xMjAuMDY2NzUsODkuNjQwNjdsMS4yNDM0MiwtMS4zNjUyNWgtMTMuMDM2MTd2MS4zNjUyNXpNMTIyLjAzMDQyLDg3LjQ4NzA4bDMuMjgyMzMsLTMuNjAxMjVsLTMuMjgyMzMsLTMuNjc2NXpNMTIxLjgwMTA4LDc5Ljk1MTMzbC0wLjk0OTU4LC0xLjA2MDY3bC0xMi41Nzc1LC0wLjAzNTgzdjEuMTAwMDhoMTMuNTI3MDh6IiBmaWxsPSIjMDAwMDAwIiBvcGFjaXR5PSIwLjA3Ij48L3BhdGg+PHBhdGggZD0iTTE0NS41MzcwOCw5NS4yNjY1bDAuMDAzNTgsLTAuMDEwNzVsLTkuNzk2ODMsLTExLjM1NTU4bDkuNzk2ODMsLTEwLjY5OTgzYzAuMTMyNTgsLTAuMTU3NjcgMC4yMzY1LC0wLjM0NzU4IDAuMjM2NSwtMC41Njk3NWMwLC0wLjQ5NDUgLTAuNDAxMzMsLTAuODk1ODMgLTAuODk1ODMsLTAuODk1ODNjLTAuMDI1MDgsMCAtNS41MTExNywwIC01LjUyMTkyLDBjLTAuMjU4LDAgLTAuNDgzNzUsMC4xMTgyNSAtMC42NDUsMC4yOTM4M2wtMC4wMjUwOCwwLjAxMDc1bC02Ljg2NTY3LDcuNDQ5NzVsLTYuOTA4NjcsLTcuODIyNDJoLTIyLjc5Yy0wLjk4OSwwIC0xLjc5MTY3LDAuODAyNjcgLTEuNzkxNjcsMS43OTE2N3YyMS40MzU1YzAsMC45ODkgMC44MDI2NywxLjc5MTY3IDEuNzkxNjcsMS43OTE2N2gyMS4xODgyNWMwLjUwNTI1LDAgMC45ODksLTAuMjE1IDEuMzI5NDIsLTAuNTg3NjdsNi45NjI0MiwtNy42OTM0Mmw2Ljc3NjA4LDcuNzMyODNjMC4zNDA0MiwwLjM5MDU4IDAuODMxMzMsMC42MTI3NSAxLjM0NzMzLDAuNjEyNzVoNS4xNmMwLjQ5NDUsMCAwLjg5NTgzLC0wLjQwMTMzIDAuODk1ODMsLTAuODk1ODNjLTAuMDAzNTgsLTAuMjI5MzMgLTAuMTAzOTIsLTAuNDMgLTAuMjQ3MjUsLTAuNTg3Njd6TTEyMC44NTg2Nyw5MS40MzIzM2gtMTQuMzcyNzV2LTQuOTQ4NThoMTMuNzUyODN2LTQuNzQwNzVoLTEzLjc1Mjgzdi00LjY4N2wxNS4xNzE4MywwLjA0M2w2LjA2NjU4LDYuNzk3NTh6IiBmaWxsPSIjZmZmZmZmIj48L3BhdGg+PC9nPjwvZz48L3N2Zz4="/>
                        <img src="https://img.icons8.com/fluency/48/000000/mastercard.png"/>                    
                        <img src="https://img.icons8.com/fluency/48/000000/discover.png"/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Credit Card Number"
                    placeholder="4111-1111-1111-1111"
                    value={this.state.cardnum}
                    onChange={this.changeCCNumberHandler}
                    error={cnemptyError}

                    />
                    <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Exp Month"
                    placeholder="September"
                    value={this.state.cardexpmon}
                    onChange={this.changeExpMonthHandler}
                    error={cmemptyError}

                    />
                     <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Exp Year"
                    placeholder="2027"
                    value={this.state.cardexpyear}
                    onChange={this.changeExpYearHandler}
                    error={cyemptyError}

                    />
                     <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="CVV"
                    placeholder="456"
                    value={this.state.cardcvv}
                    onChange={this.changeCVVHandler}
                    error={cvemptyError}

                    />
                     <br/>
                    <TextField 
                    required
                    id="outlined-required"
                    label="Email"
                    placeholder="September@gmail.com"
                    value={this.state.email}
                    onChange={this.changeEmailHandler}
                    error={ememptyError}

                    />
                     <br/>
                    <TextField 
                    id="outlined-required"
                    label="Notes"
                    placeholder="Special instructions"
                    value={this.state.notes}
                    onChange={this.changeNotesHandler}
                    />
                    </div>
                     </Box>
                     </Grid>
                </Grid>
                <Grid xs={8}> 
                     <Box m={10}>
                    <Typography align="center"> {check()} </Typography>
                    </Box>
                     </Grid>
                     <div><Typography aligned="center"><Button href="/status" variant="contained" color="success" >Process Payment</Button></Typography></div>

            </div>


        )
    }
}

export default CheckoutComponent