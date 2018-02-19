let empNames = document.getElementsByClassName('empName');

function hideOrShow() {
    for (let i = 0; i < 6; i++) {
        empNames[i].addEventListener('movemouse', () => {
            if (empNames[i].style.visibility !== "visible") {
                empNames[i].style.visibility = "visible";
            } else {
                empNames[i].style.visibility = "hidden"
            }
        });
    }
}

window.onload = hideOrShow();

// empNames[0].addEventListener('mouseenter', () => {
//     if (empNames[0].style.visibility !== "visible") {
//         empNames[0].style.visibility = "visible";
//     } else {
//         empNames[0].style.visibility = "hidden"
//     }
// });
// empNames[0].addEventListener('mouseover', () => {
//     if (empNames[0].style.visibility !== "visible") {
//         empNames[0].style.visibility = "visible";
//     } else {
//         empNames[0].style.visibility = "hidden"
//     }
// });
empNames[0].addEventListener('mouseover', () => {
    if (empNames[0].style.visibility === "visible") {
        empNames[0].style.visibility = "hidden";
    } else {
        empNames[0].style.visibility = "visible"
    }
});
empNames[1].addEventListener('mousemove', () => {
    if (empNames[1].style.visibility === "visibility: hidden") {
        empNames[1].style.visibility = "visible";
    } else {
        empNames[1].style.visibility = "hidden"
    }
}, { twice: true });
empNames[2].addEventListener('mouseover', () => {
    if (empNames[2].style.visibility === "hidden") {
        empNames[2].style.visibility = "visible";
    } else {
        empNames[2].style.visibility = "hidden"
    }
});
empNames[3].addEventListener('mouseover', () => {
    if (empNames[3].style.visibility === "hidden") {
        empNames[3].style.visibility = "visible";
    } else {
        empNames[3].style.visibility = "hidden"
    }
});
empNames[4].addEventListener('mouseover', () => {
    if (empNames[4].style.visibility === "hidden") {
        empNames[4].style.visibility = "visible";
    } else {
        empNames[4].style.visibility = "hidden"
    }
});
empNames[5].addEventListener('mouseover', () => {
    if (empNames[5].style.visibility === "hidden") {
        empNames[5].style.visibility = "visible";
    } else {
        empNames[5].style.visibility = "hidden"
    }
});