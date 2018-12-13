const keys = require('./keys')
const redis = require('redis')

const redisClient = redis.createClient({
    host: keys.redisHost,
    port: keys.redisPort,
    retry_strategy: () => 1000  // try to reconnect every 1 sec
});

const sub = redisClient.duplicate();

function fib(index) {
    if(index<2) return 1;
    return fib(index-1) + fib(index-2);
}

// when we get new message in redis - perform the callback function
sub.on('message', (channel, message) => {
    console.log("YOOOOO!!!");
    // message actually holds index entered in the form
    // hset - hashSet with name 'values'
    redisClient.hset('values', message, fib(parseInt(message)));
});

sub.subscribe('insert');
console.log("!!! STARTED !!!");