function getCustomAttribute() {
    let ele = document.getElementsByTagName("*");
    for (let i = 0; i < ele.length; i++) {
        if (ele[i].hasAttribute('data-customAttr')) {
            console.log(ele[i].getAttribute('data-customAttr'));
            console.log(ele[i]);
        }
    }
}