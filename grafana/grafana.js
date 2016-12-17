/*
* @author: Vishwanath H
  vishi83@gmail.com
  webhook for grafana alert notifications.
*/

var express = require('express');
var app = express();
var port = 4000;

var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({	extended: true }));

// POST
app.post('/notification', function(req, res) {
    console.log('***** POST from Grafana! ****** ');
    console.log(req.body);
});

// start the server
app.listen(port);
console.log('started the node server @ http://localhost:' + port);
