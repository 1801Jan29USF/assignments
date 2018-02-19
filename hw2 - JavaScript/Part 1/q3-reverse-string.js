function reverseStr(someStr) {
    const len = someStr.length;
		let strArr = someStr.split('');
		let revStr = '';
		for(let i = len-1; i >= 0; i--) {
			revStr = revStr+strArr[i];
		}
		return revStr;
}