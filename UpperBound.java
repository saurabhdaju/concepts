package Concepts;

//For an upper bound of a target value, either we find the value or not we have to always return the next biggest number present in the array.

class UpperBound_using_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3 , 5 , 7 , 9 , 11};
        int target = 5;

        int start = 0;
        int end = arr.length;

        while(start < end) {
            int mid = end + (end - start) / 2;
            if(arr[mid] > target) end = mid;
            else if(arr[mid] <= target) start = mid + 1;
        }
//        return start;

        System.out.println("index of the upperbound of target" + start);
    }
}
