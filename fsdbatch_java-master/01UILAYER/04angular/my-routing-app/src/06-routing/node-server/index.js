const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const app = express();

app.use(bodyParser.json({ limit: '20mb' }));
app.use('*', cors({
    'allowedHeaders': ['Origin', 'X-Requested-With', 'Content-Type', 'Accept', 'Authorization'],
    'origin': '*',
    'methods': 'GET,HEAD,PUT,PATCH,POST,DELETE, OPTIONS',
    'preflightContinue': false
  }));

  const registeredUsers = ['Ravi', 'Arun', 'Amit', 'TestUser']

  app.get("/userexists/:username", (req, res)=>{
    let username = req.params.username
    console.log(username);
    let index = registeredUsers.indexOf(username)
    if(index<0){
        res.json({exists: false})
    }
    else{
        res.json({exists: true})
    }
    
})

  const users = [
    {name: 'Kunal Kapoor', age: 28, contact: '6352417896', email: "kunal@gmail.com"},
    {name: 'Ajeet Kumar', age: 31, contact: '9845796585', email: "ajeet.23@gmail.com"}
]

app.get("/users", (req, res)=>{
    res.json({success: true, data: users});
})
app.get("/user/:index", (req, res)=>{
    res.json({success: true, data: users[req.params.index]});
})
app.post("/users", (req, res)=>{
    users.push(req.body.newUser);
    res.json({success: true});
})
app.delete("/users/:index", (req, res)=>{
    let numberOfElementsToRemove = 1;
    users.splice(req.params.index, numberOfElementsToRemove);
    res.json({success: true});
})
app.put("/users/:index", (req, res)=>{
    users[req.params.index] = req.body.user;
    res.json({success: true});
})

app.set('port', (process.env.PORT || 7000));
app.listen(app.get('port'), function () {
    console.log('Node app is running on port', app.get('port'));
});
  