package Week1HW.q1;

/**
 * Functionality: Implements the bubble sort for integer arrays.
 */
public class BubbleSort {
    int[] bubbleSort(int[] array){
        int counter = array.length-1; //keeps track of the index of the last unsorted entry
        boolean swapped; //if this is true, then we have more indexes to check
        do{
            swapped = false;
            for(int i=1; i<=counter; i++){ //iterate over the array
                if(array[i-1] > array[i]){ //if the left entry is larger than the right
                    array = swap(array, i-1, i); //swap the two
                    swapped = true; //because we have swapped entries, we will have to iterate again
                }
            }
        }while(swapped);
        return array;
    }

    private int[] swap(int[] arr, int index1, int index2) { //standard three-variable swap
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }
}
