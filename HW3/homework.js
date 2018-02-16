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
