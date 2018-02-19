//Fibonacci: returns the nth number in the Fibonacci sequence
function fib(n){
    if(n === 1 || n === 0){
        return n
    }
    else{
        return fib(n-1) + fib(n-2)
    }
}

//Bubble Sort: uses bubble sort to sort, then return an array
function bubbleSort(array){
        let counter = array.length-1; //keeps track of the index of the last unsorted entry
        let swapped; //if this is true, then we have more indexes to check
        do{
            swapped = false;
            for(let i=1; i<=counter; i++){ //iterate over the array
                if(array[i-1] > array[i]){ //if the left entry is larger than the right
                    array.splice(i-1, 1, array.splice(i, 1, array[i-1])[0]); //swap the two
                    swapped = true //because we have swapped entries, we will have to iterate again
                }
            }
        }while(swapped);
        return array;
}

//Reverse String: reverse and returns the string
function reverseStr(str){
    return str.split('').reverse().join('')
}

//Factorial: returns the factorial of a number
function factorial(n){
    if(n === 0 || n === 1){
        return 1
    }
    else{
        return n * factorial(n-1)
    }
}

//Substring: return substring contained between offset and offset+length inclusive
//Also alerts for incorrect input
function substring(str, len, off){
    if (off + len < str.length) {
        if (len > 0) {
            if (off > 0) return str.slice(off - 1, off + len - 1)
            else alert('Offset must be non-negative.')
        }else alert('Length of subset must be non-negative.')
    }else alert('Offset plus length of subset must not be larger than length of string.')
}

//Even number: checks for parity without modulo
function isEven(n){
    return (n & 1) === 0
}

//Palindrome: checks if a string is a palindrome
function isPalindrome(str){
    return str === str.split('').reverse().join('')
}

//Shapes: prints either a square, triangle or diamond based on input
function printShape(shape, height, char)    {
    let str = '';
    switch(shape){
        case 'Square':
            for(let i=0; i<height; i++){
                for(let j=0; j<height; j++){
                    str += char;
                }
                str += '\n'
            }
            console.log(str);
            break;
        case 'Triangle':
            for(let i=0; i<height; i++){
                for(let j=0; j<i; j++){
                    str += char;
                }
                str += '\n'
            }
            console.log(str);
            break;
        case 'Diamond':
            for(let i=0; i<height; i++){
                let whitespace = Math.abs(((height-1)/2) - i);
                let charspace = height - 2*whitespace;
                for(let j=0; j<whitespace; j++){
                    str += ' '
                }
                for(let j=0; j<charspace; j++){
                    str += char;
                }
                for(let j=0; j<whitespace; j++){
                    str += ' ';
                }
                str += '\n'
            }
            console.log(str);
            break;
    }
}

//Object literal: prints every property and every value of an object
function traverseObject(obj){
    for(let key in obj){
        if(obj.hasOwnProperty(key)){
            console.log(obj[key])
        }
    }
}

//Delete Element: removes the third element in an array and returns the length before/after
function deleteElement(arr){
    console.log(arr.length);
    delete arr[2];
    console.log(arr.length)
}

//Splice Element: splices the third element in an array and returns the length before/after
function spliceElement(arr){
    console.log(arr.length);
    arr.splice(2, 1);
    console.log(arr.length);
}

//Constructor: define an object with a constructor
function Person(name, age){

    this.name = name;
    this.age = age;
}

//Define an object using an object literal
function getPerson(name,age){
    return {'name':name, 'age':age}
}