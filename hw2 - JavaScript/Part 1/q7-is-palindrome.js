function isPalindrome(someStr, revStrFunc) {
    if (typeof someStr !== 'string') {
        return `${someStr} is not a string`;
    }
    let revStr = revStrFunc(someStr);
		if (someStr === revStr)
			return true;
        return false; 
}

function isPalindrome(someStr) {
    if (typeof someStr !== 'string') {
        return `${someStr} is not a string`;
    }
    let revStr = reverseStr(someStr);
		if (someStr === revStr)
			return true;
        return false; 
}