import {FETCH_WEATHER} from '../actions/index'

export default function(state = [], action) {
    switch(action.type) {
        case FETCH_WEATHER:
            return [action.payload.data, ...state ]; //ES6 syntax. Means [city, city, city] NOT [city, [city, city]] Equal to return state.concat([action.payload.data]);
    }
    return state;
}