import React, { PureComponent } from 'react'
import CheckoutService from '../services/CheckoutService'
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@mui/material/Button';


function data(amount,name,price)
{
    return{amount,name, price};
}

const rows = [
data('1','Milk','$7.98')
];

class CheckoutComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            //id: this.props.match.params.id,
            firstname: '',
            lastname: ''

        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
    }

    componentDidMount(){
        if(this.state.id == '_add'){
            return
        }else{
        }
    }

    changeFirstNameHandler= (event) => {
        this.setState({firstname: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lastname: event.target.value});
    }

    render() {
        return (
            <div>
                <Box m ={10} alignContent="center" maxWidth={300}>
                    <h3>Cart</h3>
                    <TableContainer> 
                        <Table>
                            <TableHead>
                                <TableRow>
                                    <TableCell> Amount </TableCell>
                                    <TableCell align="center">Item Name</TableCell>
                                    <TableCell align="center">Price </TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                            {rows.map((row) => (
                            <TableRow
                            key={row.name}
                            sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                            >
                                <TableCell align="center">{row.amount}</TableCell>
                            <TableCell align="center">
                                {row.name}
                            </TableCell>
                            <TableCell align="center">{row.price}</TableCell>
                            </TableRow>

                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                    </Box>
                    <Box m={10} 
                    component="form"
                    sx={{
                        '& .MuiTextField-root': { m: 1, width: '25ch'},
                    }}
                    noValidate
                    autoComplete="off"
                    >
                    <h3>Billing Address</h3> 
                    <TextField
                    required
                    id="outlined-required"
                    label="First Name"
                    placeholder="First Name"
                    value={this.state.firstname}
                    onChange={this.changeFirstNameHandler}
                    />
                    <br/>
                    <TextField
                    required
                    id="outlined-required"
                    label="Last Name"
                    placeholder="Last Name"
                    value={this.state.lastname}
                    onChange={this.changeLastNameHandler}
                    />
                 </Box>
                    <Box m={10}>
                    <Button variant="contained" color="success" >Process Payment</Button>
                    </Box>
            </div>


        )
    }
}

export default CheckoutComponent