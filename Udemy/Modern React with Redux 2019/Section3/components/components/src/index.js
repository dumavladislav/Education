import React from 'react'
import ReactDOM from 'react-dom'
import faker from 'faker'
import CommentDetail from './CommentDetail'
import ApprovalCard from './ApprovalCard'


const CommentsList = () => {
    return (
        <div className="ui container comments">
            <ApprovalCard>
                <CommentDetail 
                    author="Sam" 
                    timeAgo="Today at 4:45PM" 
                    commentText="Hey There!" 
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>
            <ApprovalCard>
                <CommentDetail 
                    author="Vlad"  
                    timeAgo="Today at 2:00AM" 
                    commentText="Hey Sam!" 
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>
            <ApprovalCard>
                <CommentDetail 
                    author="Yulya"  
                    timeAgo="Yesterday at 5:00PM" 
                    commentText="What's up!" 
                    avatar={faker.image.avatar()}
                />
            </ApprovalCard>
        </div>
    );
}

const App = () => {
    return <div><CommentsList /></div>;
}

ReactDOM.render(<App />, document.querySelector("#root"))