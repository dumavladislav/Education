const express = require('express');
const redis = require('redis');

// just to emualte the crash
const process = require('process');
// just to emualte the crash

const app = express();
const client = redis.createClient({
     // ususally host specifies the IP or hostname of redis server
    // in case of usage docker-compose, docker sees that there is a hostname named 'redis-server' in docker-compose file 
    // and it refers the request to the container 'redis-server' as it was actual host name
    host: 'redis-server',
    port: 6379 // default redis port
});
client.set('visits', 0);

app.get('/', (req, resp) => {
    // just to emualte the crash
    process.exit(0);
    // just to emualte the crash
    
    client.get('visits', (err, visits) => {
        resp.send('Number of visits: ' + visits);
        client.set('visits', parseInt(visits)+1);
    })
});

app.listen(8081, () => {
    console.log('Listening on port 8081');
})