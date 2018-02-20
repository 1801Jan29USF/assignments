// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    let previous = 0; 
    let current = 1; 
    let next = 0;

	for (let i = 1; i <= n; i++) {
		next = previous + current;
		previous = current;
		current = next;
    }
    return previous;
} 
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    let temp;
		for(let i = 0; i < numArray.length; i++) {
			for(let j = 1; j < (numArray.length - i); j++) {
				if(numArray[j-1] > numArray[j]) {
					temp = numArray[j-1];
					numArray[j-1] = numArray[j];
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
    let length = someStr.length;
    var newString = '';
    for(let i = 0; i < length; i++) {
        newString = newString.concat(someStr.charAt(length - (i + 1)));
    }
    return newString;
}
// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum < 0) {  
        return -1;  
    }  
    // If the number is 0, its factorial is 1.  
    else if (someNum == 0) {  
        return 1;  
    }  
    // Otherwise, call this recursive procedure again.  
    else {  
        return (someNum * factorial(someNum - 1));  
    }  
}
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
    let newString = '';
    try {
        newString = someStr.substr(offset, length);
    } catch (error) {
       alert(error); 
    }
    return newString
}
// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    let half = someNum/2;
    let temp = Math.ceil(half);
	if((temp * 2) == someNum) {
		return true;
	} else {
		return false;
	}
}
// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
    let str = someStr.toLowerCase();
    let strArray = str.split("");
    let reverse = strArray.reverse().join("");
    if(str.includes(reverse)) {
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

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    console.log(someObj);
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
//     var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}
// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
//     var john = getPerson("John", 30);
function getPerson(name, age) {
    let person = {name:name, age:age};
    return person;
}