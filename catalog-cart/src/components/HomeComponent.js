import React, { Component } from "react";
import MenuIcon from "@material-ui/icons/Menu";
import "../components/HeaderComponent.css"
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { Typography } from "@material-ui/core";
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';

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
    color: "black",
  };
  const useStyles = makeStyles((theme) => ({
    root: {
        primary: '#88CAFB'
    },
  }));
class HomeComponent extends Component {

    constructor(props)
    {
        super(props)
        this.state={

        }
    }

    render(){
        return(
            <div>
                 <Grid>
                     <Box m={20} maxHeight ={20}>
                         <Typography variant="h2" align="center">
                             Welcome to SJSU Store!
                         </Typography>
                         <Card>
                            <CardMedia
                            component="img"
                            alt="SJSU"
                            image="/images/image1.jpg"
                            title="SJSU"
                            />
                         </Card>
                     </Box>
                 </Grid>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>
                 <br/>

            </div>
        )
    }
}
export default HomeComponent