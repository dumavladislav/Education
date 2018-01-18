import React, {PropTypes} from 'react';
import GoogleMap from 'react-google-map'
import GoogleMapLoader from 'react-google-maps-loader'

const MY_API_KEY = "AIzaSyDwsdjfskhdbfjsdjbfksiTgnoriOAoUOgsUqOs10J0"

const Map = (props) => {

    return (
        <div>
            <GoogleMap 
                googleMaps={{
                    googleMaps: PropTypes.object.isRequired,
                  }}
                zoom={12}
                center={{lat:props.lat, lng:props.lon}}
            />
        </div>
        /*<GoogleMapLoader 
            containerElement={ <div style={{height:'100%'}} /> }
            googleMapElement = { 
                <GoogleMap defaultZoom={12} defaultCenter={{lat:this.props.lat, lng:this.props.lon}} />
            }
        />*/
    );
}

Map.propTypes = {
    googleMaps: PropTypes.object.isRequired,
  }

  export default GoogleMapLoader(Map, {
    libraries: ["places"],
    key: MY_API_KEY,
  })