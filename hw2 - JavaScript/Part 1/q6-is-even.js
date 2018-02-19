function isEven(someNum) {
    if (typeof someNum !== 'number') {
        return `${someNum} is not a number`;
    } else if((someNum & 1) == 0) {
        return true;
    }
    return false;
}