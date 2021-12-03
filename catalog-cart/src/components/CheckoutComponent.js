import React, { PureComponent, useState } from 'react'
import CartService, {viewCart} from '../services/CartService.js'
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
import { Link } from 'react-router-dom';

var userId = 11;
var orderId = 13;

class CheckoutComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            orderItems: [],
            orderTotal: Object
        }
        
    }

    componentDidMount(){
        CartService.viewCart(userId).then((res) => {
            this.setState({ orderItems: res.data});
        });

        CartService.getOrder(orderId).then((res) => {
            this.setState({ orderTotal: res.data});
        });
    }

    update(itemId, newQuantity){

        let command = {
            itemId: itemId,
            quantity: newQuantity
        }

        CartService.updateCart(userId, command).then((res) => {
            if(!alert(res.data)){window.location.reload();}
        });

    }

    render() {

        return (
            <div>
                <Box m ={10} marginTop={11} alignContent="center" maxWidth={500} boxShadow="1" p={2}>
                    <TableHead>
                        <TableRow>
                            <TableCell align="center" >
                            <h3>Cart</h3>
                            </TableCell>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>
                            <TableCell/>

                            <TableCell  colSpan={4} align='right'>
                            <h3>  <ShoppingCartIcon/>{this.state.orderItems.length}</h3></TableCell>
                        </TableRow>
                    </TableHead>
                    <TableContainer> 
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell align="center">Item Name</TableCell>
                                    <TableCell align="center">Quantity </TableCell>
                                    <TableCell align="center">Price </TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                            {
                                this.state.orderItems.map(
                                    orderItem => 
                                    <TableRow key={orderItem.itemId}>
                                    <TableCell align='center'>{orderItem.itemName}</TableCell>
                                    <TableCell align='center'> 
                                        <Button size='small' onClick={this.update.bind(this, orderItem.itemId, orderItem.quantity - 1)} >-</Button> 
                                        {orderItem.quantity} 
                                        <Button size='small' onClick={this.update.bind(this, orderItem.itemId, orderItem.quantity + 1)} >+</Button> 
                                    </TableCell>
                                    <TableCell align='right'>${orderItem.total} </TableCell>
                                    </TableRow>
                                )
                            }
                            </TableBody>
                            <TableBody> 
                                
                                <TableCell colSpan={3} align='right'> ${this.state.orderTotal.total} </TableCell>
                            </TableBody>
                        </Table>
                    </TableContainer>
                    </Box>
            </div>
        )
    }
}

export default CheckoutComponent

//Code Save:
//<div><Typography aligned="center"><Button href="/status" variant="contained" color="success" >Process Payment</Button></Typography></div>
