import React from 'react';
import ReactDOM from 'react-dom';
import faker from 'faker'

import CommentDetail from './CommentDetail'
import ApprovalCard from './ApprovalCard'

const App = (props) => {

    console.log(props);

    return (
    <div className="ui container comments">
        <ApprovalCard>
            <div>
                <h4>Warning!</h4>
                Are you sure you want to do this?
            </div>
        </ApprovalCard>

        <ApprovalCard>
            <CommentDetail author="Sam" text="Nice fall on the market!" timeAgo="Today at 5:00PM" avatarUrl={faker.image.avatar()}/>
        </ApprovalCard>
        <ApprovalCard>
            <CommentDetail author="Any" text="Boeing is going down!" timeAgo="Today at 5:35PM" avatarUrl={faker.image.avatar()}/>
        </ApprovalCard>
        <ApprovalCard>
            <CommentDetail author="Steve" text="Landing....." timeAgo="Today at 6:43PM" avatarUrl={faker.image.avatar()}/>
        </ApprovalCard>
        
    </div>
    );
}

ReactDOM.render(
    <App />,
    document.querySelector("#root")
);