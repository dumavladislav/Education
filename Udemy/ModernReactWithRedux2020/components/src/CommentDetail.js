

 const CommentDetails = (props) => {
     console.log(props);
     
    return (
        <div className="comment">
            <a href="/" className="avatar">
                <img alt="avatar" src={props.avatarUrl} />
            </a>
            <div className="" className="content">
                <a href="/" className="author">{props.author}</a>
                <div className="metadata">
                    <span className="date">{props.timeAgo}</span>
                </div>
                <div className="text">{props.text}</div>
            </div>
        </div>
    );
}

export default CommentDetails;