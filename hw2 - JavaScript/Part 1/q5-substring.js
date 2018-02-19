function substring(someStr, length, offset) {
    if (typeof someStr !== 'string' && typeof length !== 'number' && typeof offset !== 'number') {
        alert(`${someStr} is not a string, ${length} is not a number, and ${offset} is not a number`)

    } else if (typeof someStr !== 'string' && typeof length !== 'number'){
        alert(`${someStr} is not a string, and ${length} is not a number`);

    } else if (typeof someStr !== 'string' && typeof offset !== 'number'){
        alert(`${someStr} is not a string, and ${offset} is not a number`);

    } else if (typeof length !== 'number' && typeof offset !== 'number'){
        alert(`${length} is not a number, and ${offset} is not a number`);

    } else if (typeof someStr !== 'string'){
        alert(`${someStr} is not a string`);

    } else if (typeof length !== 'number'){
        alert(`${someStr} is not a number`);

    } else if (typeof offset !== 'number'){
        alert(`${offset} is not a number`);
    } else if (someStr.length < offset+1 || offset < 0) {
        alert('Starting index of substring is outside the range of the string')
    } else {
        const len = someStr.length;
        let strArr = someStr.split('');
        let subStr = '';    
        let maxLength = someStr.length-1;
        if (offset+length < someStr.length-1) {
            maxLength = offset+length;
        }
        for (let index = offset; index <= maxLength; index++) {
            subStr = subStr + strArr[index];
        }
        return subStr;
    }
}