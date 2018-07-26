/**
 * Created by Puneet on 28-01-2014.
 */


var j = 0;
var worker;
function startWorker() {
    if (typeof Worker === undefined) {
        alert("This browser does not support WebWorker !!!!");
    }
    else {
        if (worker === undefined) {
            worker = new Worker("./js/T02_worker.js");
            var empCounter = document.getElementById("empCounter");
            var table = document.getElementById('empTable');
            worker.onmessage = function (event) {
                //console.log(event.data);
                var jsonObj = event.data.emp;
                addRow(table, jsonObj.name, jsonObj.position, jsonObj.office, jsonObj.age, jsonObj.salary);
                empCounter.innerHTML = "Total number of records found : " + (++j);
            }
        }
    }
}

function workerStopper() {
    worker.terminate();
    worker = undefined;
}


function addRow(table, name, posistion, office, age, salary) {
    var newRow = document.createElement('tr');

    var newNameCell = document.createElement('td');
    newNameCell.appendChild(document.createTextNode(name));
    newRow.appendChild(newNameCell);

    var newPositionCell = document.createElement('td');
    newPositionCell.appendChild(document.createTextNode(posistion))
    newRow.appendChild(newPositionCell);

    var newOfficeCell = document.createElement('td');
    newOfficeCell.appendChild(document.createTextNode(office));
    newRow.appendChild(newOfficeCell);

    var newAgeCell = document.createElement('td');
    newAgeCell.appendChild(document.createTextNode(age))
    newRow.appendChild(newAgeCell);

    var newSalaryCell = document.createElement('td');
    newSalaryCell.appendChild(document.createTextNode(salary))
    newRow.appendChild(newSalaryCell);

    table.appendChild(newRow);
}

function registeredEmp(event) {
    var name = document.getElementsByTagName('input')[0].value;
    var position = document.getElementsByTagName('input')[1].value;
    var office = document.getElementsByTagName('input')[2].value;
    var age = document.getElementsByTagName('input')[3].value;
    var salary = document.getElementsByTagName('input')[4].value;

    var newEmp = document.getElementById('newEmp');
    newEmp.innerHTML = name + " has successfully been registered.";
    var empList = "<ul><li>" + name + "</li><li>" + position + "</li><li>" + office + "</li><li>" + age + "</li><li>" + salary + "</li></ul>"
    newEmp.innerHTML += empList;

    // prevent form submission
    event.preventDefault();
}
