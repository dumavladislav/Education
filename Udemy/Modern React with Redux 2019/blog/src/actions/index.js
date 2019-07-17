import _ from 'lodash'
import jsonPlaceholder from '../apis/jsonPlaceholder'

export const fetchPostsAndUsers = () => async (dispatch, getState) => {
    await dispatch(fetchPosts());
    
    // find unique userIds using lodash version of map and uniq function
    //const userIds = _.uniq(_.map(getState().posts, 'userId'));
    //userIds.forEach(id => dispatch(fetchUser(id)));


    // Same as above, but with chain lodash function
    _.chain(getState().posts)
    .map('userId')
    .uniq()
    .forEach(id => dispatch(fetchUser(id)))
    .value();

}

export const fetchPosts =  () => {

    // with redux-thunk we can return not only plain JS object from an action creator
    // But also we can return a function which is going to be executted by middleware
    // When the function will be called by the middleware it'll receive "dispatch" and "getState" functions as arguments 
    // so we could dispatch an action manually when the API response is received
    return async (dispatch /*, getState*/) => {
        const response = await jsonPlaceholder.get('/posts');
        
        dispatch( {
            type: 'FETCH_POSTS',
            payload: response.data
        });
    }
};


// this is a shortened form of what is written above (fetchPosts)
export const fetchUser = id => async dispatch => {
    const response = await jsonPlaceholder.get(`/users/${id}`);

    dispatch( {
        type: 'FETCH_USER',
        payload: response.data
    });
};


/// ----------------------------------------------------------- MEMOIZATION OPTION to solve duplicated requests -----------------------------------------

// export const fetchUser = id => dispatch => {
//     _fetchUser(id, dispatch);
// }

// const _fetchUser = _.memoize(async (id, dispatch) => {
//     const response = await jsonPlaceholder.get(`/users/${id}`);

//     dispatch( {
//         type: 'FETCH_USER',
//         payload: response.data
//     });
// });


// export const fetchUser = _.memoize(function(id) { 

//     return _.memoize(async function(dispatch) {
//         const response = await jsonPlaceholder.get(`/users/${id}`);

//         dispatch( {
//             type: 'FETCH_USER',
//             payload: response.data
//         });
//     });
// });