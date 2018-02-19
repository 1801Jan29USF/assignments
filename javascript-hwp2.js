// 1. USA
function getUSA() {
        let a = document.querySelectorAll('span');
        let b;
        a.forEach(element => {
            if (element.getAttribute('data-customAttr') === 'USA') {
                b = element.innerText;
            }        
        });
        return b;
}

// 2. Sales
function getPeopleInSales() {
    let people = document.querySelectorAll('td');
    for (let i = 0; i < people.length; i++) {
        if (people[i].innerText === 'Sales') {
            console.log(people[i - 1].innerText);
        }
    }
}

// 3. Click Here
function getAnchorChildren() {
    let anchors = document.querySelectorAll('a span');
    for (let i = 0; i < anchors.length; i++) {
        console.log(anchors[i].innerText);
    }
}

// 4. Hobbies
function getHobbies() {
    let hobbies = document.getElementsByName('hobbies')[0];
    for (let i = 0; i < hobbies.length; i++) {
        if (hobbies[i].selected) {
            console.log(hobbies[i].innerText);
        }

    }
}

// 5. Custom Attribute
function getCustomAttribute() {
    let a = document.getElementsByTagName("*");
    for (let i = 0; i < a.length; i++) {
        if (a[i].hasAttribute('data-customAttr')) {
            console.log(a[i].getAttribute('data-customAttr'));
            console.log(a[i]);
        }
    }
}

//6. Sum Event


//7. Skills Event needs work
document.querySelectorAll('select')[2].onchange = function() {
    alert(`Are you sure ${document.querySelectorAll('select')[2].value} is one of your skills?`);
}

// 8. Favorite Color Event


// 9. Show/Hide Event


// 10. Current Time
function startTime() {
    let a = new Date();
    let b = 'AM';
    if (a.getHours() < 12) { b = 'AM' } else { b = 'PM' }
    let h = a.getHours() % 12;
    if (h === 0) { h = 12 };
    let m = a.getMinutes();
    if (m < 10) { m = "0" + m };
    let s = a.getSeconds();
    if (s < 10) { s = "0" + s };
    document.getElementById('currentTime').innerHTML = h + ":" + m + ":" + s + " " + b;
    setTimeout(() => { startTime() }, 1); 
}
startTime();


// 11. Delay
let hw = document.getElementById('helloWorld');
hw.addEventListener('click', () => {
    setTimeout(() => { hw.style.color = '#' + Math.random().toString(16).substr(-6); }, 3000);
});

// 12. Walk the DOM

function walkTheDOM(node) {
    console.log(node);
    node = node.firstChild;
    while(node) {
        walkTheDOM(node);
        node = node.nextSibling;
    }
}
