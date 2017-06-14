package com.java8.sample;

public class ReverseArray {
	/* Function to reverse arr[] from start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while(start < end){
            
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        //rvereseArray(arr, start+1, end-1);
     // move the left and right index pointers in toward the center
        start++;
        end--;
        }
    }
 
    /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, arr.length-1);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }
}
