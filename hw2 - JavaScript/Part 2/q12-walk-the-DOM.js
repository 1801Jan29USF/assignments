function walkTheDOM (node, func) {
    return walkTheDOM(node.childNodes, walkTheDOM);
}

walkTheDOM(document.documentElement, walkTheDOM);