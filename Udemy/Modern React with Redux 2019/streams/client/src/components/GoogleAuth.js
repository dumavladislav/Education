import React from 'react'

class GoogleAuth extends React.Component {

    state = { isSignedIn: null }

    componentDidMount() {

        // Google API initialization
        
        window.gapi.load('client:auth2', () => {
            window.gapi.client.init({
                clientId: '272795847142-k3p961o4fk5aajkfi3vsoe9ro1jthati.apps.googleusercontent.com',
                scope: 'email'
            }).then(() => {
                this.auth = window.gapi.auth2.getAuthInstance();
                this.setState( {isSignedIn: this.auth.isSignedIn.get()} );
            });
        });
    }

    renderAuthButton() {
        if (this.state.isSignedIn === null) {
            return <div>I don't know if we are signed in</div>;
        } else if (this.state.isSignedIn === true) {
            return <div>I am signed in!</div>;
        } else {
            return <div>I am NOT signed in!</div>;
        }
    }

    render() {
        return this.renderAuthButton();
    }

}

export default GoogleAuth;