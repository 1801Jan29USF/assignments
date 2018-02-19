//PART 1

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

//initial term is 0 (modern usage according to wikipedia)
function fib(n) {
    if (n == 1)
        return 0;
    if (n == 2)
        return 1;

    return fib(n - 1) + fib(n - 2);

}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    //populate array
    let temp = 0;
    //loop through entire array
    for (let i = 0; i < numArray.length; i++) {
        //begin second loop at successive element and push
        //greatest value to end of array each iteration (preserving order)
        for (let j = 1; j < (numArray.length - i); j++) {
            //check if successive element is greater
            if (numArray[j - 1] > numArray[j]) {
                // swap the elements using temp 
                temp = numArray[j - 1];
                numArray[j - 1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    let splitString = someStr.split("");
    let reverseArray = splitString.reverse();
    let joinArray = reverseArray.join("");
    return joinArray;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum == 0) {
        return 1
    } else {
        return someNum * factorial(someNum - 1);
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset) {
    if (offset < 0) {
        alert("your offset is less than 0");
        return;
    }
    if (typeof someStr !== 'string') {
        alert("you must pass this function a string dufus !");
        return;
    }
    if (offset >= someStr.length) {
        alert(" your offset is too large");
        return;
    }
    if (offset + length >= someStr.length) {
        alert(" the length you chose is too large");
        return;
    }
    let splitString = someStr.split("");
    let temp = [];
    let j = 0;
    for (let i = offset; i < (offset + length); i++) {
        temp[j] = someStr[i];
        j++;
    }
    return temp.join("");
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {

    if (!Number.isInteger(someNum)) {
        console.log("Please enter an integer weisenheimer!")
        return;
    }
    // Check least significant rightmost bit 
    return (someNum & 1) ? false : true;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {

    // /..../g is a global regex which operates on multiple matches in the string
    //  [...] creates a character set. It basically matches any single character within the list
    // \W_ match the inverse of word characters and underscores
    let re = /[\W_]/g;
    //get rid of non alpha-numeric terms
    let lowRegStr = someStr.toLowerCase().replace(re, '');
    //split string, reverse, and join back into string
    let reverseSomeStr = lowRegStr.split('').reverse().join('');
    return reverseSomeStr === lowRegStr;

}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    let propValue;

    for (let propName in someObj) {
        propValue = someObj[propName]

        console.log(propName + " " + propValue);
    }

}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
    if (someArr.length < 3) {
        console.log("Array size is too small!");
    }
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);

}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
    if (someArr.length < 3) {
        console.log("Array size is too small!");
    }
    console.log(someArr.length);
    someArr.splice(2, 1);
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
    return new Person(name, age);
}



//PART 2
// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
    usaDiv = document.getElementsByTagName("div")[2];
    usaSpan = usaDiv.childNodes[1].getElementsByTagName("span")[0];
    text = usaSpan.textContent;
    console.log(text);


}

// 
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {

    table = document.getElementsByTagName("table")[0]
    table_row = table.getElementsByTagName("tr")[1]
    table_data = table.getElementsByTagName("td")[0].textContent;

    console.log(table_data);
}

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
    let matches = document.body.querySelectorAll('span');
    for (let i = 0; i < matches.length; i++) {
        console.log(matches[i].innerText);
    }


}


// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getHobbies() {
    skills = document.getElementsByName("skills")[0];
    for (let i = 0; i < skills.length; i++) {
        if (skills.childNodes[i].selected === true) {
            console.log(skills.childNodes[i].textContent)

        }
    }

}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
//TODO

function getCustomAttribute() {
    let elements = document.querySelectorAll("data-customAttr");
    console.log(elements);
    // for (let i = 0; i < elements.length; i++) {
    //     console.log();
    // }
    //value
    // .getAttribute
    //.textContent
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
    let i = 0;
    let j = 0;
    let k = 0;

    if (shape === "Triangle") {
        for (i = 1; i <= height; i++) {
            let row = '';
            for (j = 1; j <= i; j++) {
                row += character;
            }
            console.log(row);
        }
        return;
    }
    if (shape === "Square") {

        for (k = 0; k < height * height; k++) {
            if (k !== 0 && k % height === 0) {
                console.log("");
            }
            console.log(character);
        }
        return;
    }

    //print diamond

    let m = 0
    let s = 0;
    for (m = 1; m <= height; ++m) {
        for (s = 1; s <= height - m; ++s) {
            console.log(" ");
        }
        for (s = 1; s <= m; ++s) {
            console.log(character + " ");
        }
        console.log("\n");
    }
    for (m = height - 1; m >= 1; --m) {
        for (s = 1; s <= height - m; ++s) {
            console.log(" ");
        }
        for (s = 1; s <= m; ++s) {
            console.log(character + " ");
        }
        console.log("\n");
    }


}


//S L I C K
function sum() {
    let hasNumber = /\d/;
    let one = document.getElementById("num1").value;
    let two = document.getElementById("num2").value;

    if (hasNumber.test(one) && hasNumber.test(two)) {
        document.getElementById("sum").innerText = "Sum: " + (parseInt(one) + parseInt(two));
        return;
    }
    else {
        document.getElementById("sum").innerText = "Values cannot be added because you have not entered two numbers";
    }
}




// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

function ahlert() {
    alert("Are you sure that is one of your skills?");
}

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

let current = "";
function changeFunc() {
    current = document.getElementsByName("colors")[0].value;
    if (current === "select-color") {
        return;
    }
}

function colorAlert() {

    let colorTag = document.getElementsByName("favoriteColor");
    for (let i = 0; i < colorTag.length; i++) {
        if (colorTag[i].checked) {
            if (current === "select-color" || current === "") {
                alert("You were supposed to select your favorite color from the drop down box above but entering it here is fine too i guess.......");
                return;
            }
            alert("So you like " + colorTag[i].value + " more than " + current + " now?");
        }
    }
    document.getElementById(current).style.backgroundcolor = current;

}




// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript ()
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

//CHECK id ATTRIBUTE ADDED TO EACH <tr> ATTRIBUTE. I LINKED EACH id TO hw.css for simple solution :)

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

function startTime() {
    var d = new Date();
    var n = d.toLocaleTimeString();
    document.getElementById('currentTime').innerHTML = n;
    t = setTimeout(function () {
        startTime()
    }, 100);
}

startTime();



// 11. Delay (setTimeout(callback, time))
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
let timeout = 0;
function randomize() {

    let elem = document.getElementById('helloWorld')


    clearTimeout(timeout);
    timeout = setTimeout(function () {
        elem.style.color = randomC()
    }, 3000);
}


function randomC() {
    return '#' + Math.floor(Math.random() * 16777215).toString(16);
}

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).

function walkTheDOM(node, func) {

    func(node);
    node = node.firstChild;
    while (node) {
        walkTheDOM(node, func);
        node = node.nextSibling;
    }

}


