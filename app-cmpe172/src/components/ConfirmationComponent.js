import React, { PureComponent, useState } from 'react'
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { Typography } from "@material-ui/core";



class ConfirmationComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            apiReturn: true
        }
    }


    render() {

        let {apiReturn} = this.state;
       const authorized =()=> {
            if(apiReturn)
            {
                return <div>    
                    <Typography variant="h2" align="center">
                        Thank you for your payment
                    </Typography>
                    <Typography variant="h2" align="center">
                         Your Order Number is:
                    </Typography>
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