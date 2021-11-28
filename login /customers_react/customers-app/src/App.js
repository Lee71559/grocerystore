import Header from './components/Header'
import Home from './components/Home'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import SignIn from './components/SignIn'
import SignUp from './components/SignUp'

function App() {
  return (
    <Router>
      <div className='container'>
        <Switch>
          <Route path = "/header">
            <Header/>
          </Route>

          <Route path = "/signin">
            <SignIn/>
          </Route>

          <Route path = "/signup">
            <SignUp/>
          </Route>

        </Switch>
      </div>  
    </Router>
  )
  
}

export default App;
