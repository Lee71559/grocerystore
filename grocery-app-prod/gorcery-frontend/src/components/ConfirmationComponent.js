import React, { PureComponent, useState } from 'react'
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { Typography } from "@material-ui/core";
import CheckoutService, {checkOut} from '../services/CheckoutService.js'
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';

let orderNumber = "";


class ConfirmationComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            apiReturn: true,
            payments: [],
            order_confirmation: ""

        }
    }
    componentDidMount(){
        CheckoutService.getPayments().then((res) => {

            this.setState({ payments: res.data});
            this.setState({ order_confirmation: res.data.orderNumber});
            orderNumber = res.data.orderNumber;
        });
    }

    render() {

        let {apiReturn} = this.state;
       const authorized =()=> {
            if(apiReturn)
            {
                return <div>   
                    <Box style={{maxWidth: '1000px', maxHeight: '30px', minWidth: '200px', minHeight: '60px', fontWeight: '600'}}
>  
                    <Typography variant="h2" align="center">
                        Thank you for your payment
                    </Typography>
                    <br/>
                    
                    </Box>
                </div>
            }
            else{
                return <div>    
                    <Typography variant="h2" align="center">
                        Authorization Declined.
                    </Typography>
                    <Typography variant="h2" align="center">
                         Please enter correct credit card information.
                    </Typography>
                    {orderNumber}
                </div>
            }
        }
        return (
            <div>
                          
                 <Grid>
                     <Box m={20} maxHeight ={20}>
                      {authorized()}
                      <br/>
                      <br/>
                     </Box>
                     <br/>
                      <br/> <br/>
                      <br/> <br/>
                      <br/> <br/>
                      <br/> <br/>
                      <br/>
                 </Grid>
            
            </div>
            
        )
    }
}

export default ConfirmationComponent