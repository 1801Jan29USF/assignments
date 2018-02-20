
// 1
function fib(n) {
    let cnum = 1;
    let lnum = 0;
    let nNum;

    while(n >= 0) {
        n--;
        nNum = cnum;
        cnum+= lnum;
        lnum = nNum;
    }

    return lNum;
}

// 2
function bubbleSort(numArray) {
    for(let i = numArray.length-1; i >= 0; i--) {
        for(let j = numArray.length-1; j > 0; j--) {
            if(numArray[j] < numArray[j-1]) {
                let tmp = numArray[j];
                numArray[j] = numArray[j-1];
                numArray[j-1] = tmp;
            }
        }
    }
}

// 3
function reverseStr(someStr) {
    // Step 1. Use the split() method to return a new array
    let splitString = someStr.split("");
 
    // Step 2. Use the reverse() method to reverse the new created array
    var reverseArray = splitString.reverse();
 
    // Step 3. Use the join() method to join all elements of the array into a string
    var joinArray = reverseArray.join("");
    
    //Step 4. Return the reversed string
    return joinArray;
}

// 4
function factorial(someNum) {
    if(someNum === 0) {
        return 1;
    }

    return someNum * factorial(someNum - 1);
}

// 5
function substring(someStr, length, offset) {
    return someStr.substring(offset, length+1);
}

// 6
function isEven(someNum) {
    let a;
    a = someNum/2;

    if(a*2 === someNum) {
        return true;
    } else {
        return false;
    }
}

// 7
function isPalindrome(someStr) {
    return someStr == someStr.split('').reverse().join('');
}

// 8
function printShape(shape, height, character) {
    if(shape === 'Square') {
        for(let i = 0; i < height; i++) {
            for(let j = 0; j < height; j++) {
                console.log(character);
            }
            console.log();
        }
    } else if (shape === 'Triangle') {

    } else if (shape === 'Diamond') {

    }
}

// 9
function traverseObject(someObj) {
    return someObj;
}

// 10
function deleteElement(someArr) {
    let flength = someArr.length;

    delete someArr[2];
    let llength = someArr.length;

    return 'The first length is: ' + flength 
    + ' The second length is: ' + llength; 
}

// 11
function spliceElement(someArr) {
    let flength = someArr.length;

    someArr.splice(3,1);
    let llength = someArr.length;

    return 'The first length is: ' + flength 
    + ' The second length is: ' + llength; 
}

// 12
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13
function Person(name, age) {
    let Person = {Pname: name, pAge: age};
}



/*******************************************************************************************
 * 
 * Part 2
 */



 // 1
 function getUSA() {
     let ele = document.getElementsByTagName('*');
     let answer;
     for(let i = 0; i < ele.length; i++) {
        if(ele[i].innerText == 'USA') {
            answer = ele[i];
        } else {
            continue;
        }
     }
     console.log(answer);
     console.log(answer.innerText)
 }

 // 2
 function getPeopleInSales() {
    let employees = document.getElementsByTagName("tr");
    for(let i = 0; i < employees.length; i++) {
      if(employees[i].cells[1].innerText == 'Sales') {
        let g = employees[i].cells[0].innerHTML;
        console.log(g);
      }
    }
}

 // 3
 function getAnchorChildren() {
    let a = document.getElementsByTagName("a");
    for(let i = 0; i < a.length; i++) {
      let span = a[i].getElementsByTagName("span");
      for(let j = 0; j < span.length; j++) {
        console.log(span[j].innerHTML);
      }
    }
}

 // 5
 function getCustomAttribute() {
    let e = document.getElementsByTagName('*');
    for(let i = 0; i < e.length; i++) {
        if(e[i].hasAttribute('data-customattr')) {
            let a = e[i].getAttribute('data-customattr');
        }
        console.log(e[i]);
        console.log('Custom attribute = ' + a);
    }
 }

 // 6
 function sumEvent() {
    let number1 = Number(document.getElementById('num1').value); 
    let number2 = Number(document.getElementById('num2').value); 
 
    let numsum = number1 + number2; 
 
    document.getElementById('sum').innerText = numsum;
 }


 // 7
 function skillsEvent() {
     if(document.getElementsByTagName('select'[2].value) == 'css') {
         alert('Are you sure CSS is one of your skills?');
     } else if(document.getElementsByTagName('select'[2].value) == 'java') {
        alert('Are you sure Java is one of your skills?');
    } else if(document.getElementsByTagName('select'[2].value) == 'net') {
        alert('Are you sure .NET is one of your skills?');
    } else if(document.getElementsByTagName('select'[2].value) == 'dom') {
        alert('Are you sure DOM is one of your skills?');
    } else if(document.getElementsByTagName('select'[2].value) == 'html') {
        alert('Are you sure HTML is one of your skills?');
    } else if(document.getElementsByTagName('select'[2].value) == 'javascript') {
        alert('Are you sure JavaScript is one of your skills?');
    }
 }

 // 8
 function favoriteColor() {

 }

 // 9
 function showHide(e) {
     if(e.style.opacity == 0) {
         e.style.opacity = 1;
     } else {
         e.style.opacity = 0;
     }
 }

 // 10
 function currentTime() {
     let cTime = new Date();
     let aTime = cTime.getHours() + ':' + cTime.getMinutes() + ':' + cTime.getSeconds();

     document.getElementById('currentTime').innerHTML = dateTime;
 }

 // 11
 function delay() {
     document.getElementById('helloworld').style.color = (0 + Math.floor(Math.random() * 16777215)).toString(16);
 }

 // 12
 function walkTheDOM(node, func) {
     func(node);

        for(let i = 0; i < node.children.length; ++i) {
            walkTheDOM(node.children[i], func);
        }
 }