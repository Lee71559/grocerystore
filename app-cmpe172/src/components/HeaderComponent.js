import React, { Component } from "react";
import { Link } from "react-router-dom";
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import MenuIcon from "@material-ui/icons/Menu";
import "../components/HeaderComponent.css"
import {
  Toolbar,
  AppBar,
  IconButton,
  Menu,
  MenuItem,
  Divider,
} from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles";

import Button from '@mui/material/Button';

const Bstyle = {
    color: "white",
  };
  const useStyles = makeStyles((theme) => ({
    root: {
        primary: '#88CAFB'
    },
  }));

  function MouseOver(event) {
    event.target.style.color = "yellow";
  }
  
  function MouseMover(event) {
    event.target.style.color = "blue";
  }
  
  //MouseMover & MouseMout for the drop down menu
  function MouseOut(event) {
    event.target.style.color = "white";
  }
  
  function MouseMout(event) {
    event.target.style.color = "black";
  }
class HeaderComponent extends Component {

    constructor(props)
    {
        super(props)
        this.state={

        }
    }

    render(){
        return(
            <div>
                 <AppBar> 
         <Toolbar className="navbar">
         <h1>SJSU Grocery Store</h1>
         <Link to="/checkout">
              <Button
                style={Bstyle}
                onMouseOver={MouseOver}
                onMouseOut={MouseOut}
              >
              <ShoppingCartIcon/>

              </Button>
            </Link>
         </Toolbar>
       </AppBar>
            
            </div>
        )
    }
}
export default HeaderComponent