console.log('Any message')

// Function types
// Numbers, Boolean, Strings

// Functions as objects

// Function as arguments

var sum = function(x, y) { 
    return x + y
}

function abc(fn, a, b){
    fn(a,b)
}
abc(sum, 1,2)
  


// Returning function from a function
function outer(){
	console.log('outer function')

	var inner = function(){
		console.log('inner function')
    }
	return inner;

}

// Function callbacks

console.log('Starting')
setTimeout( function(){
    console.log('foo')
}, 5000)

console.log('End')


// SYNC FLOW
function thirdPartyFunction(){
    console.log('Does some processing')
    return "SUCCESS"
}

console.log('Starting')
console.log(thirdPartyFunction())
console.log('End')


// ASYNC FLOW  - PROBLEM
function thirdPartyFunction(){
    
    setTimeout( function(){
        console.log('Does some processing');
        return "SUCCESS"
    }, 2000);
   
}

console.log('Starting')
console.log(thirdPartyFunction())
console.log('End')



// ASYNC FLOW  - PROBLEM
function thirdPartyFunction(callback){
    
    setTimeout( function(){
        console.log('Does some processing');
        callback("SUCCESS") 
    }, 2000);
   
}

console.log('Starting')
console.log(thirdPartyFunction(function(result){
    console.log(result)
}))
console.log('End')


// Promise as a solution to callback

function thirdPartyFunction(){
    return new Promise((resolve, reject) =>
    setTimeout( function(){
        console.log('Does some processing');
        resolve("SUCCESS") 
    }, 2000))
   
}

console.log('Starting')
thirdPartyFunction()
.then(function(result){
    console.log(result)
    return "1"
})
.then(function(x){
    console.log(x)
})
console.log('End')


$.get( "test.php" ).then(
    function() {
      alert( "$.get succeeded" );
    }, function() {
      alert( "$.get failed!" );
    }
  );
  