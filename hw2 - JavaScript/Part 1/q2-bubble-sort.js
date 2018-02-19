function bubbleSort(numArray) {
    let swapped = true;
    do {
        let temp;
        swapped = false;
        for (let index = 0; index < numArray.length; index++) {
            if (numArray[index-1] > numArray[index]) {
                temp = numArray[index];
                numArray[index] = numArray[index-1];
                numArray[index-1] = temp;
                swapped = true;
            }
        }
    } while (swapped === true);
    return numArray;
}