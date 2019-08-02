import React from 'react'
import { OutgoingMessage } from 'http';

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
                this.auth.isSignedIn.listen(this.onAuthChange);
            });
        });
    }

    onAuthChange = () => {
        this.setState( {isSignedIn: this.auth.isSignedIn.get()} );
    }

    onSignIn = () => {
        this.auth.signIn();
    }

    onSignOut = () => {
        this.auth.signOut();
    }

    renderAuthButton() {
        if (this.state.isSignedIn === null) {
            return null;
        } else if (this.state.isSignedIn) {
            return (
                <button onClick={this.onSignOut} className="ui red google button">
                <i className="google icon" />
                Sign Out
                </button>
            );
        } else {
            return (
                <button onClick={this.onSignIn} className="ui red google button">
                    <i className="google icon" />
                    Sign In With Google
                </button>
            );
        }
    }

    render() {
        return this.renderAuthButton();
    }

}

export default GoogleAuth;