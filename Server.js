const http = require('http');
const server = http.createServer((req, res) => {
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/plain');
    res.end('This server is currently running');
});

server.listen(8080, '127.0.0.1', () => {
    console.log('Server running at http://127.0.0.1:8080/');
});
