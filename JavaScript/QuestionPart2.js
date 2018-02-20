//Question 1 Part 2
function GetUSA() {
let USA = document.getElementsByTagName('span');
 for ( let i = 0; i < USA.length; i++) {
 if(USA[i].textContent.includes('USA')) {
  console.log(USA[i].textContent);
 }
 }
}

//Question 2 Part 2
// create a variable that holds the document element 
// create a for loop that goes through every TagName that has 'tr'
// then creates an if statement that prints out any content that has 'sales' 
function GetPeopleInSales() {
let Sales = document.getElementsByTagName('tr');
for ( let i = 0; i < Sales.length; i++) {
    if(Sales[i].textContent.includes('Sales')) { 
        console.log(Sales[i].firstElementChild.textContent);
    }
}
}

//Question 3 Part 2
// create a for loop that searches through all anchor
// create an if that checks if the children is greater than 1
// if the element child == span then console log the inner text 
function getAnchorChild() {
    let anch = document.getElementsByTagName('a');
    for ( let i = 0; i < anch.length; i++) {
    if(anch[i].children.length > 0) {
     if (anch[i].firstElementChild.nodeName == 'SPAN') {
            console.log(anch[i].firstElementChild.innerText);
    }
    }
}
}

//Question 4 Part 2
// creates a loop that iterates through the document elementByName
// create a variable that holds a string  
// create an if statement with a condition that if the selected is not empty 
// and selected == selected then add to the variable to console log it's value
function getHobbies() {
    let hobbies = document.getElementsByName('hobbies');
    let selected = " ";
    for (let i = 0; i < hobbies[0].length; i++) {
    if (hobbies[0][i].getAttributeNode('selected') != null && hobbies[0][i].getAttributeNode('selected').value == 'selected') 
        {
            selected += hobbies[0][i].getAttributeNode('value').value + "\n";
        }
    }
    console.log(selected);
 }

 //Question 5 Part 2
// goes through a for loop and within the loop looks for the condition 
// if the attribute has '' then print out the value of the attribute
 function getCustomAttribute() {
    let attribute = document.getElementsByTagName("*");
    for (let i = 0; i < attribute.length; i++) {
        if (attribute[i].hasAttribute('data-customattr')) {
            let custom = attribute[i].getAttribute('data-customattr');
            console.log(attribute[i]);
            console.log('it has a custom attribute value of ' + custom);
        }
    }
 }


//Question 6 Part 2
// find the sum of the two numbers within the HTML document
 function change() {
    let numb1 = Number(document.getElementById('num1').value);
    let numb2 = Number(document.getElementById('num2').value);
 
    let sum = numb1 + numb2;
 
    document.getElementById('sum').innerText = sum;
 
 }

//Question 7 Part 2
// create a set of ifs statements for the Skills 
// and create an alert for each one alerting the user
function selectSkills() {
    if (document.getElementsByTagName('select')[2].value ==  'css') {
        alert("Are you sure CSS is one of your skills?");
    }

    if (document.getElementsByTagName('select')[2].value ==  'html') {
        alert("Are you sure HTML is one of your skills?");
    }

    if (document.getElementsByTagName('select')[2].value ==  'net') {
    alert("Are you sure .NET is one of your skills?");
    }

    if (document.getElementsByTagName('select')[2].value ==  'java') {
        alert("Are you sure JAVA is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value ==  'dom') {
        alert("Are you sure DOM is one of your skills?");
    }
    if (document.getElementsByTagName('select')[2].value ==  'javascript') {
        alert("Are you sure Javascript is one of your skills?");
    }
    
    }
 //Question 8 Part 2
 // create a null instance that holds the previous color
 // create a function with a queryselect that selects the current value of 
 // the document and then create an if statement that holds the previous color
 // then change the color to the color of the name inside the HTML Document
let previous = null;

function FColor() {

 let CurrentCol = document.querySelector('input[name = "favoriteColor"]:checked').value;
   
   if (previous) {
       alert("You like " + CurrentCol + " more than " + previous + "?")
   }
   document.getElementById('color').style.background = CurrentCol;
   previous = CurrentCol;
}

 //Question 9 Part 2
// create a onmouseover where it creates a condition 
// that hides the names of the people when the mouse hovers over it
// using the opacity hides the name without modifying the element itself
function Hidden(h) {
    if(h.style.opacity == 0) {
    h.style.opacity = 1; 
    } else {
        h.style.opacity = 0;
    }
}

//Question 10 Part 2
// have to write function inside the HTML document to allow it to continue running while being on the page
function CurrentTime() {
    let CurrentTime = new Date();
    let Time = CurrentTime.getHours() + ":" + CurrentTime.getMinutes() + ":" + CurrentTime.getSeconds();

    document.getElementById('currentTime').innerText = Time;
}

//Question 11 Part 2
// change the color of helloWorld using the Math randomizer to get any given color # during a set of time
function WorldColor() {
    document.getElementById('helloWorld').style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);
}

//Question 12 Part 2
// create a DOM Parsing that reads through the document and creates an object of itself 
// and allows a function of a user to go through it
function WalkTheDom(doc , func) {
     
    func(doc);
    for(let i = 0; i < doc.children.length; ++i) {
        WalkTheDom(doc.children[i], func);
    }
}