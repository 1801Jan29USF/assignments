function getAnchorChildren() {
    let anchors = document.querySelectorAll('a span');
    for (let i = 0; i < anchors.length; i++) {
        console.log(anchors[i].innerText);
    }
}