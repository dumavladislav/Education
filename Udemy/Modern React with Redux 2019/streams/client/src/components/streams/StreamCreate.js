import React from 'react'
import { Field, reduxForm } from 'redux-form'
import {connect} from 'react-redux';
import { createStream } from '../../actions'

class StreamCreate extends React.Component {

    renderInput = ({input, label, meta}) => {
        /*return <input 
            onChange={formProps.input.onChange} 
            value={formProps.input.value} 
            />;*/

        const className = `field ${meta.error && meta.touched ? 'error' : ''}`

        return (
            <div className={className}>
                <label>{label}</label>
                <input {...input} autoComplete="off"/>
                {this.renderError(meta)}
            </div> 
        );
    }

    renderError({error, touched}) {
       if(touched && error) {
           return (
           <div className="ui error message">
               <div className="header">{error}</div>
           </div>
           )
       } 
    }

    onSubmit = (formValues) => {
        this.props.createStream(formValues);
    }

    render() {
        return (
            <form onSubmit={this.props.handleSubmit(this.onSubmit)} className="ui form error">
                <Field name="title" label="Enter Title" component={this.renderInput} />
                <Field name="description" label="Enter Description" component={this.renderInput} />
                <button className="ui button primary">Submit</button>
            </form>
        );
    }
}

const validate = (formValues) => {
    const errors = {}
    if (!formValues.title) {
        errors.title = "You must enter title!";
    }

    if (!formValues.description) {
        errors.description = "You must enter description!";
    }

    return errors;
}

const formWrapped =  reduxForm({
    form: 'streamCreate',
    validate: validate
})(StreamCreate);

export default connect(null, {createStream})(formWrapped);