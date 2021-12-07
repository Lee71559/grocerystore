import React, { PureComponent } from 'react'
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Box from '@mui/material/Box';
import CheckoutService, {checkOut} from '../services/CheckoutService.js'


class ListPaymentsComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            payments: []
        }
        
    }

    componentDidMount(){
        CheckoutService.getPayments().then((res) => {
            this.setState({ payments: res.data});
        });
    }

    render() {
        return (
            <div>
                <Box m={10}>
                <TableContainer>
                <TableHead><h3>List Payments</h3></TableHead>

                <Table>
                    <TableRow>

                        <TableCell>ID</TableCell>
                        <TableCell>First Name</TableCell>
                        <TableCell>Last Name</TableCell>
                        <TableCell>Address</TableCell>
                        <TableCell>City</TableCell>
                        <TableCell>State</TableCell>
                        <TableCell>Zip</TableCell>
                        <TableCell>Phone Number</TableCell>
                        <TableCell>Email</TableCell>
                        <TableCell>Notes</TableCell>
                        <TableCell>Order Number</TableCell>
                        <TableCell>Transaction Ammount</TableCell>
                        <TableCell>Transaction Currency</TableCell>
                        <TableCell>Auth ID</TableCell>
                        <TableCell>Auth Status</TableCell>
                        <TableCell>Capture Id</TableCell>
                        <TableCell>Capture States</TableCell>


                    </TableRow>
                    <TableBody align="center"> 
                        {
                            this.state.payments.map(
                                payments => 
                                <TableRow
                                key={payments.firstname}
                                
                                >
                                <TableCell>{payments.id}</TableCell>
                                <TableCell>{payments.firstname} </TableCell>
                                <TableCell>{payments.lastname} </TableCell>
                                <TableCell>{payments.address}</TableCell>
                                <TableCell> {payments.city}</TableCell>
                                <TableCell>{payments.state} </TableCell>
                                <TableCell>{payments.zip} </TableCell>
                                <TableCell>{payments.phone} </TableCell>
                                <TableCell> {payments.email}</TableCell>
                                <TableCell> {payments.notes}</TableCell>
                                <TableCell>{payments.orderNumber} </TableCell>
                                <TableCell>{payments.transactionAmount} </TableCell>
                                <TableCell>{payments.transactionCurrency} </TableCell>
                                <TableCell>{payments.authId} </TableCell>
                                <TableCell>{payments.authStatus} </TableCell>
                                <TableCell>{payments.captureId} </TableCell>
                                <TableCell>{payments.captureStatus} </TableCell>



                                </TableRow>
                            )
                        }
                    </TableBody>
                </Table>
                </TableContainer>
                </Box>
            </div>
        )
    }
}

export default ListPaymentsComponent