// 1. fibonnacci
function fib(n) {
    if (n == 0) {
        return 0;

    } else if (n == 1) {
        return 1;
    } else {

        return fib(n - 1) + fib(n - 2);

    }
}

// 2. bubblesort
function bubblesort(numArray) {

    for (let index = 0; index < numArray.length; index++) {

        for (let j = 0; j < (numArray.length - (index - 1)); j++) {
            if (numArray[j] > numArray[j + 1]) {
                let element = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = element;
            }
        }
    }
    return numArray;
}

// 3. reverse a string
function reverseStr(someStr) {
    return someStr.split('').reverse().join('');
}

// 4. factorial (recursion)
function factorial(n) {
    if (n == 0) {
        return 1;
    }
    else if (n == 1) {
        return 1;
    }
    else return n + factorial(n - 1);
}

// 5. substring
function substring(someStr, length, offset) {
    if ((!(Number.isInteger(length)) || !(Number.isInteger(offset))) || typeof someStr !== "string") {
        alert('Invalid input');
    }
    else if (length <= someStr.length) {
        let str = someStr.substring(offset, length);
        return str;
    }
    else {
        alert('length parameter is greater than the length of our string');
    }
}

// 6. Even numbers
function isEven(someNum) {
    let num = someNum / 2;
    if (num - Math.round(num) != 0) {
        return 'odd';
    }
    else return 'even';
}

// 7. Palindromes
function isPalindrome(someStr) {
    if (someStr === someStr.split('').reverse().join('')) {
        return true;
    }
    else {
        return false;
    }
}

// 8. Shapes
function printShape(shape, height, character) {
    switch (shape) {
        case 'Square':
            let str = character;
            let rep = height;
            let final = '';
            while (height != 0) {
                final += str.repeat(rep) + "\n";
                height--;
            }
            console.log(final);
            break;
        case 'Triangle':
            let str2 = character;
            let index = 1;
            while (index <= height) {
                console.log(str2.repeat(index));
                index++;
            }
            break;
        case 'Diamond':
            let space = " ";
            let i = 1;
            let fH = height;
            while (fH != 0) {
                if (i <= height) {
                    console.log(space.repeat(fH) + character.repeat(i));
                    i += 2;
                }
                fH--;
            }
            let j = height - 2;
            let sh = height - 1;
            while (j >= 1) {
                if (height == 5) {
                    console.log(space.repeat(sh) + character.repeat(j));
                    j -= 2;
                    sh++;
                }
                else if (height < 5) {
                    console.log(space.repeat(height) + character.repeat(j));
                    j--;
                    height++;
                }
                else {
                    console.log(space.repeat(height - (height / 2 - 1.5)) + character.repeat(j));
                    j -= 2;
                    height += 2;
                }

            }
            break;
        default:
            console.log('What kind of shape is that?');
    }
}

// 9. Traverse function
function traverseObject(someobj) {
    for (var prop in someobj) {
        console.log(someobj[prop]);
    }
}
traverseObject({ name: 'Rick', age: 26, occupatin: 'Intern' });
// VM385:3 Rick
// VM385:3 26
// VM385:3 Intern

// 10. Delete Element
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(somearray) {
    console.log(somearray.length);
    delete somearray[2];
    console.log(somearray);
    console.log(somearray.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(2, 1);
    console.log(someArr);
    console.log(someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age) {
    var person = {
        name: name,
        age: age,
    }
    return person;
}

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.

function getUSA() {
    return document.getElementsByTagName("span")[1].textContent;
}

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.

function getPeopleInSales() {
    let s = document.body.querySelectorAll('.empName');
    let a = document.getElementsByTagName('tr');
    for (let index = 0; index < a.length; index++) {
        if (a[index].hasChildNodes) {
            let emp = a[index].childNodes;
            if (emp.item(3).textContent === 'Sales') {
                console.log(emp.item(1).textContent);
            }
        }

    }
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let a = document.body.querySelectorAll('a > span');
    for (let index = 0; index < a.length; index++) {
        console.log(a[index].textContent);
    }
}
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
// NOT SURE IF IT MEANT TO CHECK FOR HOBBIES NOT SKILLS ANYWAYS IS JUST CHANGING A WORD IN THE METHOD
function getHobbies() {
    let h = document.body.querySelectorAll('select');
    for (let index = 0; index < h.length; index++) {
        // Change hobbies to skills and it will retrieve skills.
        // I just figured it made more sense to check for hobbies since the method is getHobbies
        if (h[index].getAttribute('name') === 'hobbies') {
            let child = h[index].getElementsByTagName('option');
            for (let i = 0; i < child.length; i++) {
                if (child[i].getAttribute('selected') == 'selected') {
                    console.log(child[i].getAttribute('value') + ' ' + child[i].textContent);
                }
            }
        }
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute() {
    $('[data-customAttr]').each(function (index) {
        console.log(index + ": " + $(this).prop('tagName') + ': ' + $(this).attr('data-customAttr'));
    });
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>
let num1 = document.getElementById('num1');
let num2 = document.getElementById('num2');
let sum = document.getElementById('sum');

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element
num1.onchange = function () {
    if (isNaN(num1.value) || isNaN(num2.value)) {
        sum.textContent = "Cannot add";
        alert('Check your input');
    }
    else {
        sum.textContent = Number(num1.value) + Number(num2.value);
        //alert('Success');
    }
}
num2.onchange = () => {
    if (isNaN(num1.value) || isNaN(num2.value)) {
        sum.textContent = "Cannot add";
        alert('Check your input');
    }
    else {
        sum.textContent = Number(num1.value) + Number(num2.value);
        //alert('Success');
    }
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.
let selects = document.getElementsByTagName('select');
let skills = selects[2];
skills.onchange = function () {
    let option = skills.options[skills.selectedIndex].text;
    alert('Are you sure ' + option + ' is one of your skills?');
}


// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
function favoriteColors() {
    
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// Hide the name if shown.
// Show the name if hidden.
function showHide() {

    $('.empName').mouseover(function () {
        if ($(this).css('opacity') == 0) {
            $(this).css('opacity', 1);
        }
        else if ($(this).css('opacity') == 1) {
            $(this).css('opacity', 0);
        }
    });
}
showHide();
// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
function getCurrentTime() {
    var date = new Date();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();

    // Choose between pm or am
    var ampm = hours >= 12 ? 'pm' : 'am';

    // Convert from 24 hr format to 12 pm/am
    hours = hours % 12;
    hours = hours ? hours : 12;

    // Add 0 to minutes under 10
    minutes = minutes < 10 ? '0' + minutes : minutes;

    // Prepare the string
    var strTime = hours + ':' + minutes + ':' + seconds + ' ' + ampm;
    var cTime = document.getElementById('currentTime');

    cTime.textContent = strTime;
}

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
let hello = document.getElementById('helloWorld');
hello.onclick=function(){setTimeout(ranColor, 3000)};

function ranColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return hello.style.color = color;
}
// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).

//Found it online but I understand what is going on
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}
walkTheDOM(document.body, (node) =>{console.log(node.tagName)});