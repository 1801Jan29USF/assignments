// Question 1
// Fibonacci to get the 5th number
function fibonacci(n){
    let a = 1, b = 0, temp;
  
    while (n >= 2){
      temp = a;
      a = a + b;
      b = temp;
      n--;
    }
  
    return b;
}  
console.log(fibonacci(5));


//Question 2
// BubbleSort in an ArrayList 
function BubbleSort() {
let ArrList = [5,8,1,10,5,6,7,15,9,2]
let temp;
  for (let i = 0; i < ArrList.length; i++) {
    for (let j = 1; j < ( ArrList.length - i); j++) {
      if (ArrList[j-1] > ArrList[j]) {
         temp = ArrList[j-1];
         ArrList[j-1] = ArrList[j];
         ArrList[j] = temp;
 
      }
    }
  }      
  console.log(ArrList);
}

//Question 3
//Reverse String using the split function to split the array then reversing it
// afterwards using the join to rejoin it again.
function ReverseString() {
    Str = "PowerRanger";
    return Str.split("").reverse().join("");
}


//Question 4
//Factorial 
// use recursion if N does not equal 1, then N * N - 1 otherwise default 1
function Factor(n) {
  return (n != 1) ? n * Factor(n - 1) : 1;
}
console.log(Factor(5));


//Question 5
//SubString

function SubString() {

}


//Question 6
// uses the bitwise operator to determine if the number ends in 
// 1 in binary code which makes it odd. Ending in 0 means even. 
function isEven(T) {
  return ( T & 1 ) ? "odd" : "even";
}


//Question 7
// create a variable that split the string, then reverse it, then join it and compare it 
// to the first string whether it is the same or not
function Palindromes(Str) {
Str = "racecar";
console.log("is racecar a Palindrome?");
let SplitString = Str.split("");
let reverseString = SplitString.reverse();
let TruStr = reverseString.join("");

  if (Str === TruStr ) {
    return true; 
  } else {  
   return false;
  }
}

//Question 8
function PrintShape(shape, height, character) {

}

//Question 9
const NJ = {
   FullName: "New Jersey",
   Mayor: "Christie",
   Population: 500000,
   County: 27 
};
function info(NJ) {
  return NJ;
}

//Question 10
// Deleted March and replaced it with Deleted
function DeleteEle() {
  let months = ['Jan','Feb', 'March', 'April','May'];
  console.log(months);
  console.log(months.length); 
  let removed = months.splice(2,1, "Deleted");
  console.log(months);
  console.log(months.length);
}

//Question 11
//Deleted March and print 4
function SpliceEle() {
  let months = ['Jan','Feb', 'March', 'April','May'];
  console.log(months); 
  let removed = months.splice(2,1);
  console.log(months);
}

//Question 12
// use a constructor to set John name and age as a person and 
// use john as a variable to identify him
function Person(name, age) {
this.name = name;
this.age = age;
}
let john = new Person("John", 30);
console.log(john);

//Question 13
// use a literal object and function to return John 
 const John = {
   name: "John",
   age: 30
 };

function getPerson(John) {
  return John;
} 

