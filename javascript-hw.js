
// 1. Fibonacci
function fib(n){

    let i = 0;
    let j = 1;
    let k;

    for(p = 0; p < n; p++){
        k = j;
        j = i + j;
        i = k
    }
    return j;
}

// 2. Bubble Sort
function bubbleSort(numArray){
    let a;
    for(i = 0; i < numArray.length - 1; i++){
        for(j = 0; j < numArray.length - i - 1; j++){
            if(numArray[j] > numArray[j+1]){
                a = numArray[j+1];
                numArray[j+1] = numArray[j];
                numArray[j] = a;
            }
        }
    }
    return numArray;
}

// 3. Reverse String
function reverseStr(someStr){

    let ss = someStr.split("");
    let ra = ss.reverse();
    let ja = ra.join("");
    return ja;
}

// 4. Factorial
function factorial(someNum){

    if(someNum === 0){
        return 1;
    }
    else if(someNum === 1){
        return 1;
    }
    else{
        return factorial(someNum - 1) * someNum;
    }
}


// 5. Substring
function substring(someStr, length, offset){

    if(typeof(someStr) ==='string' && Number.isInteger(length) && Number.isInteger(offset)
        && length+offset < someStr.length && offset >= 0 && length >= 0){

        return someStr.slice(offset, offset + length + 1);
    }
    else {alert('invalid input');}
}

// 6. Even Number
function isEven(someNum){

   while(someNum > 2){
       someNum -= 2;
   }
   if(someNum === 2){
       return true;
   }
   else{
       return false;
   }
}

// 7. Palindrome
function isPalindrome(someStr){

    let a = reverseStr(someStr);
    if( a === someStr){
        return true;
    }
    else{
        return false;
    }
}

// 8. Shapes
function printShape(shape, height, character){
    let b = "";
    let a;
    switch(shape){
        case "square":
            a = new Array(height);
            for (let index = 0; index < height; index++) {
                a[index] = character;                
            }
            for (let index = 0; index < height; index++) {
                b += a.join("") + '\n';                
            }
            console.log(b);
            break;

        case "triangle":
            for(let j = 0; j < height; j++){
                a = new Array(j);
                for (let index = 0; index <= j; index++) {
                    a[index] = character;                                                      
                }
                b += a.join("") + '\n';
            }
            console.log(b);
            break;

        case "diamond":
            for (let j = 0; j < height; j++){
                (j <= height/2 - 0.5)? x = j : x = height - 1 - j;
                a = new Array(height);
                for (let index = 0; index < height; index++) {
                    if(index >= height/2 - 0.5 - x && index <= height/2 - 0.5 + x){
                        a[index] = character;
                    }
                    else{
                        a[index] = ' ';
                    }
                }           
                b += a.join("") + '\n';                
            }
            console.log(b);
            break;
    }
    return;
}

let leon = {
    name: 'Leon',
    age: 100
    }
// 9. Object literal
function traverseObject(someObj){
    for (key in someObj) {
        console.log(key + ": " + someObj[key]);
    }
}

// 10. Delete Element
function deleteElement(someArr){

    console.log(someArr + " " + someArr.length);
    delete(someArr[3]);
    console.log(someArr + " " + someArr.length);
}

// 11. Splice Element
function spliceElement(someArr){

    console.log(someArr + " " + someArr.length);
    someArr.splice(3,1);
    console.log(someArr + " " + someArr.length);

}

// 12. Defining an object using a constructor
function Person(name, age){

    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
function getPerson(name, age){

    let person = {
        name: name,
        age: age
    };
    return person;
}




































