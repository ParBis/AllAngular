var express = require('express');
var app = express();
var port = 8080;

app.use(express.static(__dirname + '/public'));

var clientId = 0;
var clients = {};  // <- Keep a map of attached clients

// Called once for each new client. Note, this response is left open!
app.get('/events/', function(req, res) {
	req.socket.setTimeout(10000);
    res.writeHead(200, {
    	'Content-Type': 'text/event-stream',  // <- Important headers
    	'Cache-Control': 'no-cache',
    	'Connection': 'keep-alive'
    });
    res.write('\n');
    (function(clientId) {
        clients[clientId] = res;  // <- Add this client to those we consider "attached"
        req.on("close", function(){delete clients[clientId]});  // <- Remove this client when he disconnects
    })(++clientId)
});

setInterval(function(){
	var msg = Math.random();
	console.log("Clients: " + Object.keys(clients) + " <- " + msg);
	for (clientId in clients) {
		clients[clientId].write("data: "+ msg + "\n\n"); // <- Push a message to a single attached client
	};
}, 2000);

app.listen(port, function(){
	console.log("Express server listening on port: ", port);
});
