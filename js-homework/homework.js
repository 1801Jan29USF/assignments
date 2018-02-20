function fib(n) {
    arr = [];
    arr[0] = 0;
    arr[1] = 1;
        for (let i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            
        }
    
    return(arr[n]);
}
fib(25);



function bubbleSort(arr) {
    //arr = [10,23,55,67,9,6,3];
    let l = arr.length;
    let t = 0;
    for (let i = 0; i < l; i++) {
        for (let j = 1; j < l-i; j++) {
            if (arr[j-1]>arr[j]) {
                t = arr[j-1];
                arr[j-1]=arr[j];
                console.log(arr[j]=t);

                
            }
            
        }
        
    }

    
}

function reverseString(s) {
    return s.split("").reverse().join("");

    
}
reverseString("hello");

function factorial() {
    let f = 1;
    let num = 5;
    for (let i = 1; i <= num; i++) {
        f = f*i;
        
    }
    console.log(f);
    
}

function substring(params) {

    
}
function isEven() {
    let a = 11;
    let b = 2;
    let z = (a-b) * (a/b);
    console.log(z);
    if(z === 0){
        console.log("The numer " + a );
        
    }else{
        console.log("the number " + a + " is odd");
    }
    
}

function isPalindrome(pal) {

    let s = pal.split("").reverse().join("")
    if (pal === s) {
        console.log(pal + " is a palindrome");
        
    }
    else
{
    console.log(pal + " is not a palindrome");
}
    
}

function printShape(params) {

    
}

function traverseobject(someObj) {
    someObj ={
        name: 'javian',
        age: 23

    }
    let v;
    for (let p in someObj) {
        v= someObj[p];
        console.log(p,v);
        
    }
    
}

function deleteElement() {
    let someArr = [1,3,"some","food",4];
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);

    
}

function spliceElement (someArr) {
    let someArr = [4,5,6,20,45,200];
    console.log(someArr.length);
    someArr.splice(2,1);
    console.log(someArr.length);


    
}
function Person(name, age){
    this.name = name;
    this.age = age;
   
    


}
 function getPerson(name, age){
     var person = {name: name,

     }
 }

	

