// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n){
    let num =0;
    let num1 = 1;
    let num2 = 0;
if(n==0){
    return 0;
}
else if(n==1){
    return 1;
}
else 
  for (let i = 2; i<=n; i++){
        num2 = num1+num;
        num = num1;
        num1 = num2;

    }
  return  num2;
};




// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
let numArray = [];
function bubbleSort(numArray){
    let length = numArray.length;
    for (let i= 0; i < length; i++ ){
        for (let j = 1; j < length-1; j++ ){
                if (numArray[j] > numArray[j+1]){
                    let temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
        }
    }
  return numArray;
};

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    return someStr.split("").reverse().join("");
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum == 0) 
        return 1;
    else {
        return (someNum * factorial(someNum - 1));
    }
  } ;

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset){

    let splitStr = someStr.split("");
    let arr = [];
    let sum = (length+offset);
    let j =0;
    for (let i = offset; i< sum; i++){
        arr[j] = someStr[i];
        j++;
    }
return arr.join("");
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(n) {
    var div = n/2;
    var c = Math.ceil(div);
    var mult = c * 2;
    
    if (mult ==n ){
        return ("true");
    }
    else if (mult != n) {
        return ("false");
    }
 }


// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
    let rs = someStr.split("").reverse().join("");
    if (rs === someStr){
        return true;
    }
    else {
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

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj){
    let value;
    for (let name in someObj){
        value = someObj[name];
        console.log(name + value )
    }
}


// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr [2];
console.log(someArr.length);    
}




// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr){
    console.log(someArr.length);
    let arr = someArr;
    arr.splice(2,1)
    console.log(someArr.length);
}



// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age){
this.name = 'john';
this.age = 30; 
}



// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age){
    return new Person(name, age);
}









// **************************************************************************************************


// Part 2: 
// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
  function getUSA(){
    let ele = document.querySelectorAll("USA");
    console.log(ele[0]);
  }
// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
getPeopleInSales(){
    let names = document.querySelectorAll("table") [0];
    for (let i = 0; i< names.length; i++){
        if (names[i].innerText === "Sales"){
console.log(names[i].innerText)
        }

   
    }

}
// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
  function getAnchorChildren()
  {
      let anchorElement = document.querySelectorAll('span');
      for (let i = 0; i<anchorElement.length; i++){
          console.log(anchorElement[i].innerText);
      }
  }
// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies(){
    let option = document.getElementsByName('skills')[0];
    for (let i = 0; i < hobbies.length; i++) {
        if (option[i].selected === true) {
            console.log(option[i].innerText);
          } 
    }
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomAttribute(){
    let val = document.querySelectorAll("data-customAttr");
    for (let i = 0; i < val.length; i++) {
        if (val[i].selected === true) {
            console.log(val[i].innerText);
            console.log(val[i].getCustomAttribute);

          } 
}




// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

function sumEvent(){
    let inputOne = document.getElementById("num1").value;
    let inputTwo = document.getElementById("two").value;
    let sum = document.getElementById("sum").innerTex;
    sum = inputOne + inputTwo; 
}


// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.
document.getElementById("employee").style.display = "employee name";
document.getElementById("employee").style.display = "none";
// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.
function currentTime{
    var d = new Date();
    document.getElementById().innerHTML = d.toLocaleTimeString;

}
// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
let pId = document.getElementById("helloWorld");
pId.addEventListener('click', () => 
{ setTimeout
    (() =>  {pId.style.color = '#' + Math.random()}, 3000);});
// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDOM(node, func){

    while (node.childNode){
        
        let node = node.sibling;
    }
}