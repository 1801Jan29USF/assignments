// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
    let hTags = document.querySelectorAll('h1');
    console.log(hTags[0]);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    let x = document.querySelectorAll('table')[0];

    for(let i = 0; i < x.rows.length; i++) {
        if(x.rows[i].cells[1].innerHTML === 'Sales'){
            console.log(x.rows[i].cells[0].innerHTML);
        }
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let x = document.querySelectorAll('a');
    for(let i = 0; i < x.length; i++){
        let y = x[i].querySelectorAll('span');
        if(y.length > 0){
            console.log(y[0]);
        }
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

//The question is labelled hobbies so Im going to grab the options in the "hobbies" select element rather than the skills select element.
// I don't really know what it means by "checked options" though.
function getHobbies() {
    let x = document.getElementsByName('hobbies');
    let y = x[0].querySelectorAll('option');
    for(let i = 0; i < y.length; i++){
        console.log(y[i].value + ": " + y[i].innerHTML);
    }
}
// ... the value was basically the same as the contents for both of them...

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    let x = document.querySelectorAll('[data-customAttr]');
    for(let i = 0; i < x.length; i++){
        console.log(x[i].getAttribute('data-customAttr'));
    }
    for(let j = 0; j < x.length; j++) {
        console.log(x[j]);
    }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

document.getElementById('num1', 'num2').onchange = function() {
    let result = document.getElementById('num1').value + document.getElementById('num2').value;
    //if its undefined or nan or null it will have a value of 0 (aka falsy)
    if(result !== 0) {
        document.getElementById('sum').innerHTML = result;
    }
}


// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

// Why doesn't this command work? If I put hobbies, or colors, it works fine. But when I put skills I get a blank
// html collection that has a length of 1. It doesn't make sense
console.log(document.getElementsByName('skills'));


document.querySelectorAll('select')[2].onchange = function() {
    alert(`Are you sure ${document.querySelectorAll('select')[2].value} is one of your skills?`);
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

// Its doing it again for this, except this time its a length of 4. What the heck.
// document.getElementsByName('favoriteColor');

// Applying the .onchange to all of them at the same time didn't appear to work so I split them aprt which is rather annoying
// Tried a for loop like the other problems but it didn't work
let oldValue = undefined;
let favColor = document.querySelectorAll('[name="favoriteColor"]');
favColor[0].onchange = function() {
    let newValue = favColor[0].value;
    alert(`So you like ${newValue} more than ${oldValue} now?`);
    oldValue = newValue;
    for(let i = 0; i < favColor.length; i++) {
        favColor[i].classList.add('colored-blue');
    } 
}
favColor[1].onchange = function() {
    let newValue = favColor[1].value;
    alert(`So you like ${newValue} more than ${oldValue} now?`);
    oldValue = newValue;
    for(let i = 0; i < favColor.length; i++) {
        favColor[i].classList.add('colored-red');
    } 
}
favColor[2].onchange = function() {
    let newValue = favColor[2].value;
    alert(`So you like ${newValue} more than ${oldValue} now?`);
    oldValue = newValue;
    for(let i = 0; i < favColor.length; i++) {
        favColor[i].classList.add('colored-green');
    } 
}
favColor[3].onchange = function() {
    let newValue = favColor[3].value;
    alert(`So you like ${newValue} more than ${oldValue} now?`);
    oldValue = newValue;
    for(let i = 0; i < favColor.length; i++) {
        favColor[i].classList.add('colored-orange');
    } 
}
// Don't mind the fact that I just keep adding the colored class and never get rid of it


// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
let theTable = document.querySelectorAll('table')[0];
let show = true;
theTable.rows[1].onmouseover = function() {theTable.rows[1].cells[0].classList.toggle('hidden');}
for(let i = 1; i < theTable.rows.length; i++) {
    theTable.rows[i].onmouseover = function() {theTable.rows[i].cells[0].classList.toggle('hidden');}
}


// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
let curTime = document.getElementById('currentTime');
let pm;

function showTime() {
    let currentTime = new Date();
    let hours = currentTime.getHours();
    if(hours > 12) {
        hours = hours-12;
        pm = true;
    }
    let minutes = currentTime.getMinutes();
    let seconds = currentTime.getSeconds();
    if(minutes < 10){
        minutes = '0' + minutes;
    }
    if(seconds < 10){
        seconds = '0' + seconds;
    }

    if(pm === true){
        curTime.innerHTML = hours + ':' + minutes + ':' + seconds + ' PM';
    } else {
        curTime.innerHTML = hours + ':' + minutes + ':' + seconds + ' AM';
    }
    let t = setTimeout(showTime, 500);
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
let helloTag = document.getElementById('helloWorld');
// Yikes
helloTag.onclick = function() {
    setTimeout( () => {
        helloTag.style.color = getRandomColor();
    }, 3000)
}

// At what point do you think it will become plagarism to copy/paste people's code?
function getRandomColor() {
    let letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }


//   12. Walk the DOM
//   Define function walkTheDOM(node, func)
//   This function should traverse every node in the DOM. Use recursion.
//   On each node, call func(node).

function hi(node) {
    console.log('hi');
}
// The real question is: which came first, The answer or the question?
function walkTheDOM(node, func) {
    // Hope you have a function in mind when you call this
    func(node);

    // start with the first child. if .firstChild is actually a thing
    node = node.firstChild;
    // go depth first all the way down, then check all siblings on the way back up (going all the way down the sibling if it exists)
    // recursion ends when the nodes stop returing new nodes. Eventually the last one will return null
    while(node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}

// example test call
// walkTheDOM(document.querySelectorAll('body')[0], hi)
// results in 258 "hi"