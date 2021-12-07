import React, { PureComponent } from 'react'
import BottomNavigation from '@mui/material/BottomNavigation';
import BottomNavigationAction from '@mui/material/BottomNavigationAction';


class FooterComponent extends PureComponent {
    constructor(props) {
        super(props)

        this.state = {
            
        }
    }

    render() {
        return (
            <div>
                <BottomNavigation showLabels sx={{ maxHeight:'100%', maxWidth:'100%' }}>
                <BottomNavigationAction sx={{ maxHeight:'100%', maxWidth:'100%' }} label = "All Rights Reserved 2021 @CMPE172"/>
                </BottomNavigation>
                
            </div>
        )
    }
}

export default FooterComponent