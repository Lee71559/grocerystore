import React, { PureComponent, useState } from 'react'
import "../components/HeaderComponent.css"
import Container from '@mui/material/Container';
import { Typography } from "@material-ui/core";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import { makeStyles } from "@material-ui/core/styles";
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import { Link, useNavigate } from 'react-router-dom';
import CatalogService, {getItems} from '../services/CatalogService.js'
import CartService, {viewCart} from '../services/CartService.js'

var userId = 11;
var orderId = 13;


const Bstyle = {
    color: "black",
  };
  
const useStyles = makeStyles((theme) => ({
root: {
    primary: '#88CAFB'
},
}));


class CatalogComponent extends PureComponent {



    constructor(props) {
        super(props)

        this.state = {
            items: []
        }
        
    }

    componentDidMount(){
        CatalogService.getItems().then((res) => {
            this.setState({ items: res.data});
        });
    }

    addToCart(itemId){

        let command = {
            itemId: itemId,
            quantity: 1
        }


        CartService.addToCart(userId, command).then((res) => {
            window.alert(res.data);
        });
    }

    render(){
        return(
            
            <div>
                <Box m={20} maxHeight ={20}>
                    <div>
                        <Typography variant="h2" align="center">
                            Catalog
                        </Typography>
                        <br/>
                    </div>
                    
                    <div>
                        <Grid container spacing={4}>
                            {
                                this.state.items.map(
                                    item => 
                                    <Grid item xs={4}>
                                        <Card sx={{ flex: '1 0 auto' }} variant="outlined">
                                            {/*<CardMedia
                                                component="img"
                                                alt="green iguana"
                                                height="300"
                                                image="/images/image1.jpg"
                                            />*/}
                                            <CardContent>
                                                <Typography gutterBottom variant="h5" component="div">
                                                    {item.name}
                                                </Typography>
                                                <Typography variant="body2" color="text.secondary">
                                                    {item.description}
                                                </Typography>
                                            </CardContent>
                                            <CardActions>
                                                <IconButton color="primary" aria-label="add to shopping cart" onClick={this.addToCart.bind(this, item.id)}>
                                                    <ShoppingCartIcon/>
                                                </IconButton>
                                            </CardActions>
                                        </Card>
                                    </Grid>
                                )
                            }
                        </Grid>
                    </div>
                    <div><Typography aligned="center"><Button enabled component={Link} to="/checkout" variant="contained" color="success"  >Process Payment</Button></Typography></div>

                </Box>
            </div>
        )
    }
}
export default CatalogComponent