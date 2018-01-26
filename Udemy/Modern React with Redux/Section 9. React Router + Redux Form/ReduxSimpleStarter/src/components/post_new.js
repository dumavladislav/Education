import React, {Component} from 'react'
import { Field, reduxForm } from 'redux-form'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {createPost} from '../actions'

//reduxForm - аналог connect. Позволяет связать компонент с reducer-ом reduxForm.

class PostNew extends Component {

    renderField(field) {

        const { meta: { touched, error} } = field;
        //const className = `form-group ${field.meta.touched && field.meta.error ? 'has-danger' : '' }`;
        const className = `form-group ${touched && error ? 'has-danger' : '' }`;

        return (
            <div className={className}>
                <label>{field.label}</label>
                <input
                    className="form-control"
                    type="text"
                    {...field.input} //field.input - contains all required on-handlers
                                     //This single string replaces onChnage={field.input.onChange} 
                                     //onFocus={field.input.onFocus} etc.
                />
                <div className="text-help">
                    {field.meta.touched ? field.meta.error : ''  /*meta.error is added automatically by validate function*/
                                                             /*touched means user has focused on the element and then lost focus*/
                                                             /*can be replaced with just touched ? error : '' if we have additional
                                                             declarations above*/ } 
                </div>
            </div>
        );
    }

    onSubmit(values) {
        this.props.createPost(values, () => {this.props.history.push('/');});
    }

    render() {

        const {handleSubmit} = this.props;

        return (
            <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
                <Field
                    label = "Title For Post" //Можно добавлять в Field произвольные параметры с любыми именами. Потом в component функции они будут доступны по field.название
                    name="title"
                    component = {this.renderField} //function that returnd JSX
                />
                <Field
                    label = "Categories"
                    name="categories"
                    component = {this.renderField}
                />
                <Field
                    label = "Post Content"
                    name = "content"
                    component = {this.renderField}
                />
                <button type="submit" className="btn btn-primary">Submit</button>
                <Link className="btn btn-danger" to="/">
                    Cancel
                </Link>
            </form>
        )
    }
}

function validate(values) {
    //values -> { title: 'sadfsdf', categories: 'sdf wer wer', content: 'sadff wrw er wr'}
    const errors = {};

    // Logic to validate the inputs from 'values'

    if(values.title){
        if(values.title.length<3) {
            errors.title = "Title must be at least 3 symbols!";  // property "title" connects this error message with Field with name=title
        }
    }

    if(!values.title || values.title.length<3) {
        errors.title = "Enter a title!";
    }

    if(!values.categories) {
        errors.categories = "Enter some categories!";
    }

    if(!values.content) {
        errors.content = "Enter some content!";
    }

    // If errors is empty - the form is fine to submit
    // If errors has any properties, redux form assumes form is invalid
    return errors;
}

export default reduxForm({
    validate,   //because the name of the property is the same as function name. Otherwise it should be validate: function_name
    form: 'PostsNewForm' //name of the form. Must be unique
})(
    connect(null, {createPost})(PostNew)
);