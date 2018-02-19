let onchangeAddNums = new Event('onchange');
let num1 = document.getElementById('num1');
let num2 = document.getElementById('num2');
let sum = document.getElementById('sum');

// document.getElementById('num1').addEventListener("onChange", () => { addNums() });
// document.getElementById('num2').addEventListener("onChange", () => { addNums() });
document.getElementById('num1').onchange = function (onchangeAddNums) {addNums()};
document.getElementById('num2').onchange = function (onchangeAddNums) {addNums()};
num1.dispatchEvent(onchangeAddNums);
num2.dispatchEvent(onchangeAddNums);

function addNums() {
    if (isNaN(document.getElementById('num1').value) || isNaN(document.getElementById('num2').value)) {
        sum.innerHTML = 'Cannot add';
        return;
    }
    let number1 = parseInt(document.getElementById('num1').value, 10);
    let number2 = parseInt(document.getElementById('num2').value, 10);
    sum.innerHTML = number1 + number2;
}