

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n) {
    let fibarray = [n];
    fibarray[0] = 0;
    fibarray[1] = 1;

    for (let i = 0; i < n - 2; i++) {
        fibarray[i + 2] = fibarray[i] + fibarray[i + 1];
    }
    return console.log(fibarray);
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(numArray) {
    let x = numArray.length;
    let y; //temporary variable 

    for (let i = 0; i < x - 1; i++) {   //outer for loop to restart process after each digit shift

        for (let j = 1; j < x - i; j++) { //inner for loop comparing an element to the one before it. 
            if (numArray[j] < numArray[j - 1]) {
                y = numArray[j - 1];            //temporary variable used to switch values around
                numArray[j - 1] = numArray[j];
                numArray[j] = y;
            }
        }
    }

    return console.log(numArray);

}


// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.


function reverseStr(someStr) {
    let x = someStr.length;
    let newString = "";

    for (let i = x - 1; i >= 0; i--) {

        newString = newString + someStr.charAt(i);
    }

    return console.log(newString);

}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(someNum) {
    let start = 1;
    for (let i = 1; i <= someNum; i++) {
        start = start * i;
    }
    console.log(start);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
    let result = "";

    if (typeof (someStr) != 'string') {
        return alert("first param was not a string");
    }
    if (typeof (length) != 'number') {
        return alert("second parameter was not a number.");
    }
    if (typeof (offset) != 'number') {
        return alert("third parameter was not a number.");
    }

    for (let i = offset; i < length + offset; i++) {
        result += someStr.charAt(i);
    }
    console.log(result);
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum) {
    let x = parseInt(someNum / 2);

    if (x * 2 == someNum) {
        return true;
    }
    else {
        return false;
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr) {
    let str = '';
    str = someStr.split('').reverse().join('');
    return str == someStr;
}


// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *


function printShape(shape, height, character) {
    let ourStr = ``;
    switch (shape) {
        case 'Square':
            for (let i = 0; i <= height; i++) {
                ourStr += `
                `
                    ;
                for (let j = 0; j <= i; j++)
                    ourStr += `${character}`;
            }
            console.log(ourStr);
            break;

        case 'Triangle':

            for (let i = 0; i < height; i++) {
                for (let j = 0; j <= i; j++) {
                    console.log(`${character}`);
                }
            }

            break;

        case 'Diamond':

            for (let i = 0; i < height; i++) {
                for (let j = 0; j <= i; j++) {
                    console.log(`${character}`);
                }
            }

            break;

        default:
            log('Incorrect shape. Insert Square, Triangle or Rectangle.');
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj) {
    let propval;
    for (property in someObj) {  //for every property in the object
        propval = someObj[property];  //temporary change our local variable's value this property
        console.log(property, propval);  //print them together
    }
}



// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.


function deleteElement(someArr) {
    console.log("array has length: " + someArr.length);
    delete someArr[2];
    console.log("element deleted, array has length: " + someArr.length);
    return someArr;
}


// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement(someArr) {
    console.log("length of some array: " + someArr.length);
    someArr.splice(2, 1);
    console.log("length of some other array: " + someArr.length)
    return someArr;
}


// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

function Person(name, age) {  //simple constructor
    this.name = name;
    this.age = age;

}


// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);

function getPerson(name, age) {
    let person = {
        "name": name,
        "age": age
    }
    return person;

}

// -----------------------------------------------------------------------------------
// PART II

// Part II will focus on Javascript's ability to manipulate the DOM.
// Use the provided index.html
// Put your Javascript in the provided <script> element at the bottom of the page.
// Please put the question itself as a comment above each answer.

// NOTE: Part II will be done twice: once with Javascript and once with jQuery.
// 	  They should be done separately.
// 	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
// -----------------------------------------------------------------------------------


// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    let ele = document.getElementsByTagName('span'); //gets all span elements
    let ele2;
    for (let i = 0; i < ele.length; i++) {
        if (ele[i].innerText == 'USA') {        //every element thats inner text is "USA"
            ele2 = ele[i];  //add it to our returning element
        }
        else {
            continue;
        }
    }
    console.log(ele2);
    console.log(ele2.innerText);

};


// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
    let ele = document.getElementsByTagName('tr');  //get all rows of all tables    
    for (let i = 0; i < ele.length; i++) {
        if (ele[i].textContent.includes('Sales')) {  // if the row includes 'sales'
            console.log(ele[i].firstElementChild.textContent);  
            //the first element child of the 'sales' would be the employee name
        }
    }

}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>

function getAnchorChildren() {
    let ele = document.getElementsByTagName('a'); //get all anchor elements
    for (let i = 0; i < ele.length; i++) {
        if (ele[i].children.length > 0) {
            if (ele[i].firstElementChild.nodeName == 'SPAN') { //ifrin the childdren are span elements,
                console.log(ele[i].firstElementChild.innerText);    //print their contents
            }
        }

    }

}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
    let ele = document.getElementsByName('hobbies');
    let selected = "";
    for (let i = 0; i < ele[0].length; i++) { 
        if (ele[0][i].getAttributeNode('selected') != null && ele[0][i].getAttributeNode('selected').value == 'selected') {
            //first check if the attribute node has a 'selected' tag, otherwise was returning null pointer repeatedly
            selected += ele[0][i].getAttributeNode('value').value + "\n";
            //concat it to a string 'selected' 

        }
    }
    console.log(selected); //print the string
};

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute() {
    let ele = document.getElementsByTagName("*"); //gets ALL elements on the page
    for (let i = 0; i < ele.length; i++) {
        if (ele[i].hasAttribute('data-customattr')) { //if it has custom attribute
            let att = ele[i].getAttribute('data-customattr'); //we get the attribute of custom attribute
            console.log(ele[i]);
            console.log(' has custom attribute value of ' + att); //print the element, and the attribute value
            console.log('_________________');
        }
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



function change() {
    let number1 = Number(document.getElementById('num1').value); //variable storing number in num1 tag's value
    let number2 = Number(document.getElementById('num2').value); //variable storing number in num2 tag's value

    let numsum = number1 + number2; //add the numbers together

    document.getElementById('sum').innerText = numsum;  //put the sum in the text of the 'sum' element

}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.


//Used a bunch of if statements, could have used a switch case but there were only 6
function selectFunction() {
    if (document.getElementsByTagName('select')[2].value == 'css') {
        alert("Are you sure CSS is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value == 'javascript') {
        alert("Are you sure JavaScript is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value == 'net') {
        alert("Are you sure .NET is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value == 'java') {
        alert("Are you sure Java is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value == 'html') {
        alert("Are you sure HTML is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value == 'dom') {
        alert("Are you sure DOM is one of your skills?");
    }


}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

//global variable of the previous color used, the alert only displays if there was a previous color
let prevcolor = null; 

function favColor() {
    let ele = document.querySelector('input[name = "favoriteColor"]:checked').value;
    //gets the radio button that is selected, as only one is 'checked' at a time.

    //if there was a previous color, display the alert.
    if (prevcolor) {
        alert("So you like " + ele + " more than " + prevcolor + " now?")
    }

    //always changes the background to the new color, and changes 'previous color' from null or from the previous color from the previous call of this function
    document.getElementById('colorid').style.backgroundColor = ele;
    prevcolor = ele;

}


// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.




function toggleName(x) {
    //toggles the opacity of the table data to zero, visibility:hidden elements cannot be moused over
    if (x.style.opacity == 0) {
        x.style.opacity = 1; //set opacity style to 1 if zero
    } else {
        x.style.opacity = 0; //otherwise change it to zero (invisible)
    }
}


// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.



function getTime() {
    let currentTime = new Date(); //creates a date object
    let dateTime = currentTime.getHours() + ":" + currentTime.getMinutes() + ":" + currentTime.getSeconds();
    //creates a variable that gets hours, minutes and seconds from the date object
    document.getElementById('currentTime').innerHTML = dateTime;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

function randomColor() {
    //changes the element helloWorld's style to whatever "pickRandom()" returns
    document.getElementById('helloWorld').style.color = pickRandom();
}

function pickRandom() { //goes picks a random value between hex color code values, obtained from stackoverflow
    return '#' + Math.floor(Math.random() * 16777215).toString(16); 
}


// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node);

function walkTheDOM(node, func) {
    //friend helped me understand this function, 


    func(node); //performs the user function that is passed in, such as printing "hello" or printing the current element to the console
    for (var i = 0; i < node.children.length; ++i) { //for all of children of an element, 
        walkTheDOM(node.children[i], func); //recursively call WalkTheDOM on the node's child, passing in the same function the user specified originally 
    }
}
