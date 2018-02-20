// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    let a = 1, b = 0, temp;

    while (n >= 0) {
        temp = a;
        a = a + b;
        b = temp;
        n--;
    }
    return b;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    let num;
    do {
        num = false;
        for (let i = 0; i < numArray.length - 1; i++) {
            if (numArray[i] > numArray[i + 1]) {
                let temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
                num = true;
            }
        }
    } while (num);
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseString(someStr) {
    return someStr.split('').reverse().join('');
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum == 0) {
        return 1;
    } else {
        return someNum * factorial(someNum - 1);
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
    let sub;

    if (typeof someStr == 'string', typeof length == 'number', typeof offset == 'number') {
        sub = someStr.substring(offset, length + offset);
    } else {
        alert('Incorrect input, please enter input like this: (String, Number, Number)')
    }
    return sub;
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    return !(someNum & 1);
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
    if (someStr == someStr.split('').reverse().join('')) {
        return true;
    } else {
        return false;
    }
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
    switch (shape) {
        case 'Square':
            for (let i = 0; i < height; i++) {
                console.log(character);
            }
            break;

        case 'Triangle':
            for (let i = 0; i < height; i++) {
                console.log(character);

            }
            break;

        case 'Diamond':
            for (let i = 0; i < height; i++) {
                console.log(character);

            }
            break;

        default:
            console.log('Invalid input.')
            break;
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    console.log(Object.keys(someObj));
    console.log(Object.values(someObj));
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr);
    console.log(someArr.length);
}

// 11. Splice Element - setTimeout
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
    console.log(someArr.length)
    someArr.splice(2, 0, 'Hello');
    console.log(someArr);
    console.log(someArr.length - 1)
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
//     var john = new Person("John", 30);
function Person(name, age) {
    this.getName = () => {
        return name;
    }
    this.setName = (newName) => {
        age = newAge;
    }
    this.getAge = () => {
        return age;
    }
    this.setAge = (newAge) => {
        age = newAge;
    }
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
//     var john = getPerson("John", 30);
function getPerson(name, age) {
    let obj = {
        "name": 'Charles',
        "age": 100
    };
    return obj;
}


// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
    let USA = document.querySelectorAll('span')[2].innerHTML;
    console.log(USA);
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
    let sales = document.getElementsByClassName('empName');
    for (i = 0; i < sales.length; i++) {
        console.log(sales[i].innerHTML);
    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let anchor = document.querySelectorAll('a span');
    for (i = 0; i < anchor.length; i++) {
        console.log(anchor[i].innerHTML);
    }
}

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
    let arrHob = document.getElementsByName('hobbies')[0];
    for(let i = 0; i < arrHob.length; i++) {
        if(arrHob[i].selected === true) {
            console.log(arrHob[i].innerText);
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    let atr = document.querySelectorAll('[data-customAttr]');
    for (i = 0; i < atr.length; i++) {
        console.log(document.querySelectorAll('[data-customAttr]')[i].innerHTML)
        console.log(document.querySelectorAll('[data-customAttr]')[i])
    }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
//     <input id="num1" class="nums" type="text"/>
//     <input id="num2" class="nums" type="text"/>
//     <h3>Sum: <span id="sum"></span></h3>
// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
function spanSum(num1, num2) {
    return num1 + num2;
}

function getNum1() {
    return document.getElementById('num1');
}

function getNum2() {
    return document.getElementById('num2');
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
//     "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
function alertSkills() {
    let arrSkills = document.getElementsByName('skills')[0];
    for(let i = 0; i < arrSkills.length; i++) {
        if(arrSkills[i].selected === true) {
            console.log(`Are you sure ${arrSkills.value} is one of your skills?`);
        }
    }
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
//     "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
function colorEvent() {
    let arrColor = document.getElementsByName('favoriteColor')[0];
    for(let i = 0; i < arrColor.length; i++) {
        if(arrColor[i].selected === true) {
            console.log(`So you like ${arrColor.value} more than ${arrColor.defaultValue} now?`);
        }
    }
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
//     Hide the name if shown.
//     Show the name if hidden.
function employeeEvent() {
    let employee = document.getElementsByClassName('empName');
    for(let i = 0; i < employee.length; i++) {
        if(employee[i].style.visibility !== 'visible') {
            employee[i].style.visibility = 'visible';
        } else {
            employee[i].style.visibility = 'hidden';
        }
    }
} 

// 10. Current Time
// Regarding this element:
//     <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
let clock = setInterval(timer, 1000);

function timer() {
    let date = new Date();
    document.getElementById("currentTime").innerHTML = date.toLocaleTimeString();
}

// 11. Delay
// Regarding this element:
//     <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

function colorChanger() {
    document.getElementById("helloWorld").style.color = '#' + Math.random().toString(16).slice(2, 8);
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func) {
    node = node.firstChild;
    while (node) {

        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}