package Concepts;
/*
In a given array
let sum = summation of all the elements of a subarray of the given array
we have to find the maximum sum in a subarray among all subarrays
 */

class LargestSum {
    public static void main(String[] args) {
        int [] arr = {-2, -5, -8, -10, -11, -5, -35, -1};

        System.out.println(maxSum(arr));
        System.out.println(KadaneAlgorithm(arr));
    }

    // Time Complexity : O(n*n)
    static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int crrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSum = Math.max(maxSum, arr[i]);
            crrSum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                crrSum += arr[j];
                maxSum = Math.max(crrSum, maxSum);
            }
        }

        return maxSum;
    }


// Time Complexity : O(n)
    static int KadaneAlgorithm(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int crrSum = 0;

        for (int i = 0; i < arr.length; i++) {
            crrSum += arr[i];

            maxSum = Math.max(maxSum, crrSum);

            if(crrSum < 0) crrSum = 0;
        }

        return maxSum;
    }
}