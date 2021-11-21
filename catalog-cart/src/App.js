import logo from './logo.svg';
import './App.css';
import React, { Component } from "react";

class App extends Component {
  state = {
    items: []
  };

  async componentDidMount() {
    const response = await fetch('/items');
    const body = await response.json();
    this.setState({items: body});
  }

  render() {
    const {items} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
              <h2>items</h2>
              {items.map(item =>
                  <div key={item.id}>
                    {item.name} ({item.price})
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;