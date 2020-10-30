import React from 'react'
import ReactDOM from 'react-dom'

import SeasonDisplay from './SeasonDisplay'
import Spinner from './Spinner'


class App extends React.Component {

    // constructor(props) {
    //     super(props);

    //     // first way to initialize the state
    //     this.state = { lat: null, errMessage: '' }
    // }

    // second way to initialize the state. In this case Babel will do exactly the same - define a constructor for us with this.state = {.....}
    state = { lat: null, errMessage: '' };

    // Great place to do the initialization including network requests. Recommended to do it here, not in the constructor
    componentDidMount() {
        console.log('Component was just rendered on the screen');
        window.navigator.geolocation.getCurrentPosition(
            position => this.setState( {lat: position.coords.latitude} ),   // callback function if get geolocation was successful
            err => this.setState( {errMessage: err.message} )               // will only update errMessage. lat will not change // failure callback
        );
    }

    componentDidUpdate() {
        console.log('Component has just been updated!');
    }

    // COnditional logic ideally should be in a helper function like this (not in render):
    renderContent() {
        if (this.state.errMessage && !this.state.lat) {
            return  <div>Error: {this.state.errMessage}</div>;
        }


        if (!this.state.errMessage && this.state.lat) {
            return <div><SeasonDisplay lat={this.state.lat} /></div>;
        }

        return <Spinner message="Please accept the location request..."/>;
    }

    render() {
    return <div className="border red">{this.renderContent()}</div>
    }
}

ReactDOM.render(
    <App />,
    document.querySelector("#root")
);