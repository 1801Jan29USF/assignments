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
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);

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
