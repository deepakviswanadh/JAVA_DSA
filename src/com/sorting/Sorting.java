package src.com.sorting;

import java.util.Arrays;

//bubble sort,insertion,selection->O(N^2)
//merge,heap sort->O(NlogN)
public class Sorting {
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            //here n-i because, for every ith loop, we are pushing 1 largest to the end
            //so next time we don't need to check the same again
            //hence reducing i times as we already pushed i elements
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int min = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                //from i+1 to n, we find the least no
                // assuming ith index is the least for now
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            //after found, we swap it with min.
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            //push all elements in arr from 0 to n-1
            //if they are greater than key to the right
            // by 1 position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr){
        int n= arr.length;
        //no need to split when size less than 2
        if(n<2){
            return;
        }
        int mid = n/2;
        int []leftArr= new int[mid];
        int []rightArr = new int[n-mid];
        for(int i=0;i<mid;i++){
            leftArr[i]= arr[i];
        }
        for(int i=mid;i<n;i++){
            rightArr[i-mid]= arr[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        mergeArr(arr,leftArr,rightArr);
    }

    public static void mergeArr(int []arr,int[]left, int[]right){
        int l=0;
        int r=0;
        int k=0;
        //sort and merge until both having same size of elements
        while(l<left.length && r<right.length){
            if(left[l]<right[r]){
                arr[k++]=left[l++];
            }
            else{
                arr[k++]=right[r++];
            }
        }
        //left remaining case
        while(l< left.length){
            arr[k++]=left[l++];
        }
        //right remaining case
        while(r< right.length){
            arr[k++]=right[r++];
        }
    }


    public void quickSort(int []arr, int start, int end){
        if(start>=end) {
            return;
        }
        int pivotIndex=findPivotIndex(arr,start, end);
        //divide and conquer around pivot and not including it
        quickSort(arr,start,pivotIndex-1);
        quickSort(arr,pivotIndex+1,end);
    }

    public int findPivotIndex(int []arr,int start,int end){
        int pElement= arr[start];
        //skip comparing pivot element
        int i=start+1;
        int j=end;
        while(i<j){
            do{
                i++;
            }while(arr[i]<=pElement);
            do{
                j--;
            }while(arr[j]>pElement);
            swap(arr,i,j);
        }
        if(i<j) {
            swap(arr, start, j);
        }
        return j;
    }

    public void swap(int[]arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
