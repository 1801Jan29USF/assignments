// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

// Looks like recursion still works
function fib(n) {
    if(n === 0)
        return 0;
    if(n === 1)
        return 1;
    return fib(n-1) + fib(n-2)
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(arr) {
    console.log(arr);
    for(let i = 0; i < arr.length-1; i++) {
        for(let j = 0; j < arr.length-i-1; j++) {
            if(arr[j] > arr[j+1]){
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    console.log(arr);
}


// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    // I was looking into .map and .reduce when I found this.
    return someStr.split('').reverse().join('');
}

    // The old(ish) fashioned way
// function reverseStr(someStr) {
//     let oldLength = someStr.length;
//     for(let i = oldLength - 1; i >= 0 ; i--) {
//         someStr = someStr.concat(someStr[i]);
//     }
//     someStr = someStr.substring(oldLength, someStr.length);
//     console.log(someStr);

// }


// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if(someNum === 1)
        return 1;
    return someNum * factorial(someNum-1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function mySubstr (someStr, offset, length) {
    if(offset > someStr.length) {
        alert("Alert: offset greater than length of string.");
    }
    return someStr.substring(offset, length+1);
}
// It seems like even if I put a large number in for the length (i.e. mySubtr(0,100) it just returns the full string.
// If I start at a point greater than my string it returns ""
// If I input characters for the offset/length it reads the strings as 0?
// floats are truncated to integer
// My point is that there doesn't seem to be proper "invalid" inputs


// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    if((someNum & 1) === 0)
        return "Even";
    else
        return "Odd";
}


// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
    if (someStr.split('').reverse().join('') === someStr) {
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
    let str = '';
    let i;
    switch (shape) {

        case "square":
            for(i = 0; i < height; i++){
                str = str + character;
            }
            for(i = 0; i < height; i++) {
                console.log(str);
            }
            break;

        case "triangle":
            for(i = 0; i < height; i++) {
                str = str + character;
                console.log(str);
            }
            break;

        
        // Technically only works for odds
        // Also no spacing
        case "diamond":
            str = character;
            console.log(str);
            for(i = 3; i <= height; i+=2) {
                str = str + character + character;
                console.log(str);
            }
            for(i = height-2; i > 0; i-=2) {
                str = str.substring(0, i);
                console.log(str);
            }
            break;

    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
     let result = '';
     for(let i in someObj){
         if(someObj.hasOwnProperty(i)){
             result += i + ': ' + someObj[i] + '\n';
         }
     }
     return result;
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(arr) {
    console.log(arr.length);
    arr[3] = undefined;
    console.log(arr[3]);
    console.log(arr.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(arr) {
    console.log(arr.length);
    arr.splice(3, 1);
    console.log(arr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}
let john = new Person('John', 30);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson (inName, inAge) {
    return person = {name: inName, age: inAge};
}
let john2 = getPerson("John", 30);