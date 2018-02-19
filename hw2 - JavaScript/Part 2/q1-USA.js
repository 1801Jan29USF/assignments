function getUSA() {
    //     let usArray = document.querySelectorAll('span');
    //     usArray.forEach(element => {
    //         if (element.getAttribute('data-customAttr') === 'USA') {
    //             return element.innerText;
    //         }
    //     });
    //     return console.log('USA not found');
    // feels like cheating
    return document.querySelectorAll('span')[1].innerText;
    }