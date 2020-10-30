// Import React and ReactDOM libraries
import React from 'react';
import ReactDOM from 'react-dom';


// Create a react Component
const App = function () {
    return <div>Hi There!</div>;
}


// Show react component on the screen
ReactDOM.render(
    <App />,
    document.querySelector('#root')
);