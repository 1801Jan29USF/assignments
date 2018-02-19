function walkTheDOM (node, func) {
    if (node.childNodes !== null) {
        for (let i = 0; i < node.childNodes.length; i++) {
            console.log(node.childNodes[i]);
            walkTheDOM(node.childNodes[i], walkTheDOM);
        }
    }
}

walkTheDOM(document.documentElement, walkTheDOM);
