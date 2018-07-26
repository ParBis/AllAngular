const express = require('express')
const app = express()
const cors = require('cors')
const bodyParser = require('body-parser')

app.use(cors());
// parse application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({ extended: false }))
 
// parse application/json
app.use(bodyParser.json())

app.get('/', (req, res) => res.send('Hello World!'))


var todos =  [{text: 'todo item from server', isDone: true}, {text: 'todo item 2', isDone: false}]; 
app.get('/todos', (req, res) => {
    res.json(todos)
})

app.post('/todos', (req, res) => {
    var todo= req.body;
    console.log(todo);
    todos.push(todo);
    res.json(todos)
})

app.put('/todos', (req, res) => {
    todos = req.body;
    res.status(200).json({message: "Successfully updated !!"})
})

app.listen(3000, () => console.log('Example app listening on port 3000!'))