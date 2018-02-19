let onclickColors = new Event('clicked');

let colors = document.getElementsByName('favoriteColor');
let oldFav = getColor();

colors[0].addEventListener('click', () => { alertColor() });
colors[1].addEventListener('click', () => { alertColor() });
colors[2].addEventListener('click', () => { alertColor() });
colors[3].addEventListener('click', () => { alertColor() });
function getColor() {
    for (let i = 0; i < colors.length; i++) {
        if (colors[i].checked === true) {
            colors.setA
            return colors[i].value;
        }
        
    }
}

function alertColor() {
    alert(`So you like ${getColor()} more than ${oldFav} now?`);
    for (let i = 0; i < colors.length; i++) {
        colors[i].style.backgroundColor = `"${getColor()}"`;
    }
    // colors[0].setAttribute("style", `background-color: ${getColor()};`);
    oldFav = getColor();
}