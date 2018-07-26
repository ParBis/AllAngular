function loadData(){
    // document.getElementById('name').innerText = "Testing DOM using JS"
    // $('#name').html("Updated using JQuery")
    
    $.ajax({
        url: 'dummy.json'
    }).then((res) => {
        console.log(res)
        $('#name').html(res.name)
        $('#age').html(res.age)
    })

    // fetch('dummy.json')
    // .then((res)=> res.json())
    // .then((data) => {
    //     console.log(data)
    //     document.getElementById('name').innerText = data.name
    //     document.getElementById('age').innerText = data.age
    // })
}

console.log('This is where we write JS') 