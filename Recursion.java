package Concepts;

//RECURSION
// When recursion : Whenever we find Choice and Decision in the question

import java.util.ArrayList;
import java.util.Arrays;

class SubsetsOfString {
    public static void main(String[] args) {
        String str = "abcd";
        String output = "";
        subsets(str, output);
    }

    static void subsets(String input, String output) {
        //Base condition
        //If the input size is 1 then we have reached the 2nd last node of the recursion tree;
        if(input.length() == 1) {
            System.out.println(output);
            System.out.println(output + input.charAt(0));
        }

        else {
            subsets(input.substring(1), output);
            subsets(input.substring(1), output + input.charAt(0));
        }
    }
}

class PrintingNumbers {
    public static void main(String[] args) {
        int n = 5;

        printInAsc(n);

        System.out.println();

        printInDsc(n);
    }

    static void printInAsc(int n) {
        //Base Condition
        if(n==1) System.out.print(n + " ");
        else {
            //Hypothesis
            printInAsc(n - 1);

            //Induction Step
            System.out.print(n + " ");
        }
    }

    static void printInDsc(int n) {
        //Base Condition
        if(n == 1) System.out.println(n);
        else {
            //Induction
            System.out.print(n + " ");

            //Hypothesis
            printInDsc(n-1);
        }
    }
}


// Four approaches to solve recursive problems
// 1. Make Recursive Tree : use input-output method (do this when you know what decisions are to made)
// 2. Induction - Base Condition - Hypothesis [IBH] (do this when you know you have to make the input smaller)  {useful in TREE and LINKED LIST questions}
// 3. Choice Diagram (DP)
// 4. Abhi nhi bataya hai



// 1. IBH
// Step 1  Hypothesis designing {
//                              print(n) will give us 1,2,3,..,n
//                          =>> print(n-1) will give us 1,2,3,..,n-1
//         }

// Step 2  Induction {
//                    print(n) {
//                    print(n - 1);
//                    System.out.println(n);
//         }

// Step 3  Base Condition {
//                if (n == 1) System.out.println(1);
//           }


//Position of hypothesis and induction decides what the code will do. Change in their position leads to major changes in the output


class Factorial {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(factorial(n));

        int ans = 1;
        factorial(n, ans);
    }

    // using return statement
    static int factorial(int n) {
        if( n == 1) return 1;
        return n * factorial(n - 1);
    }

    //directly printing the output
    static void factorial(int n, int ans) {
        if(n == 1) System.out.println(ans);
        else factorial(n - 1, ans * n);                                                                                                              // {baap lvl visualization xD}
    }
}

class Sorting {
    public static void main(String[] args) {
        int[] arr = {6,5,7,4,8,3,9,2,0,1};
        InsertionSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static void InsertionSort(int[] arr, int start, int end) {
        //Base Condition
        if(start == end) return;
        else {
            int target = end;
            InsertionSort(arr, start, end - 1);

            for (int i = end - 1; i >= 0; i--) {
                if(arr[i] > arr[target]) {
                    //swap
                    int temp = arr[i];
                    arr[i] = arr[target];
                    arr[target] = temp;
                    target--;
                }
                else break;
            }
        }
    }
}

class CheckingIfSorted {
    public static void main(String[] args) {

        int[] arr = {1, 5, 17, 9, 10, 15};

        System.out.println(ifsorted(arr, 0));
    }

    static boolean ifsorted(int[] arr, int pointer) {
        if(pointer == arr.length - 1) return true;

        if(arr[pointer] > arr[pointer + 1]) return false;

        return ifsorted(arr, pointer + 1);
    }
}

class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 4, 5, 7, 8, 9, 23};
        int target = 2;

//        System.out.println(firstIndex(arr, target, 0));
//        System.out.println(lastIndex(arr, target, arr.length - 1));

        System.out.println(func(arr, target, 0));
    }

    static int findIndex(int[] arr, int target, int index) {

        if(index == arr.length) return -1;

        if(arr[index] == target) return index;
        return findIndex(arr, target, index + 1);
    }

    static boolean exist(int[] arr, int target, int index) {
        if(index == arr.length) return false;

        return arr[index] == target || exist(arr, target, index + 1);
    }

    static int firstIndex(int[] arr, int target, int index) {
        if(index == arr.length) return -1;
        if(arr[index] == target) return index;

        return firstIndex(arr, target, index + 1);
    }

    static int lastIndex(int[] arr, int target, int index) {
        if(index < 0) return -1;
        if(arr[index] == target) return index;

        return lastIndex(arr, target, index - 1);
    }


    // storing indexes using array list
    // * do not pass list in argum ent
    // * return type should be list. => creating list in each function call

    static ArrayList<Integer> func(int[] arr, int target, int pointer) {
        ArrayList<Integer> list = new ArrayList<>();
        if(pointer == arr.length) return list;

        if(arr[pointer] == target) list.add(pointer);
        list.addAll(func(arr, target, pointer + 1));
        return list;
    }
}

