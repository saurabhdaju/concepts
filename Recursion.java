package Concepts;

//RECURSION
// When recursion : Whenever we find Choice and Decision in the question

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
        int[] arr1 = {6, 5, 5, 7, 4, 8, 3, 9, 5, 2, 0, 1};
//        InsertionSort(arr1, 0, arr1.length - 1);

        int[] arr2 = {10, 12, 12, 6, 8, 2, 5, 0, 11};
//        BubbleSort(arr2, 0, arr2.length - 1);

//        SelectionSort(arr1, 0, arr1.length - 1, 0);

        InsertionSort2(arr1, 1, 0);
        System.out.println(Arrays.toString(arr1));

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

    static void BubbleSort(int[] arr2, int start, int end) {
        if(end == start && end != 0) BubbleSort(arr2, 0, end - 1);
        if(end == start) return;
        if(arr2[start] > arr2[start + 1]) {
            int temp = arr2[start];
            arr2[start] = arr2[start + 1];
            arr2[start + 1] = temp;
        }

        BubbleSort(arr2, start + 1, end);
    }

    static void SelectionSort(int[] arr, int pointer, int end, int maxIdx) {
        if(end == 0) return;
        if(pointer > end) {
            //swap
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[end];
            arr[end] = temp;
            SelectionSort(arr, 0, end - 1, 0);
            return;
        }
        else {
            if (arr[pointer] > arr[maxIdx]) maxIdx = pointer;
                SelectionSort(arr, pointer + 1, end, maxIdx);
        }
    }

    static void InsertionSort2(int[] arr, int pointer, int comp) {
        if(pointer > arr.length) return;
        else {
            if(comp - 1 >= 0 && arr[comp] <= arr[comp - 1]) {
                    //swap
                    int temp = arr[comp];
                    arr[comp] = arr[comp - 1];
                    arr[comp - 1] = temp;
                    InsertionSort2(arr, pointer, --comp);
            }

            else {
                InsertionSort2(arr, ++pointer, pointer - 1);
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

class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 10, 1, 2, 3, 4};
        int target = 5;

        int ans = search(arr, target, 0, arr.length - 1);

        System.out.println(ans);
    }

    static int search(int[] arr, int target, int start, int end) {
        if(start > end) return -1;

        int mid = start + (end - start) / 2;

        if(arr[mid] == target) return mid;

        if(arr[start] <= arr[mid]) {
            if(target >= arr[start] && target < arr[mid]) return search(arr, target, start, mid - 1);
            else return search(arr, target, mid + 1, end);
        }

        else {
            if(target >= arr[start]) {
                return search(arr, target, start, mid - 1);
            }
            else return search(arr, target, mid + 1, end);
        }
    }
}


class PatternPrinting {
    public static void main(String[] args) {

        int rows = 5;
//        ultaTriangle(rows, rows);

//        ultaTriangle2(0 ,0, rows);

        seedhaTriangle(0, 0, rows);
    }

    static void ultaTriangle(int rows, int cols) {
        if(rows == 0) return;
        if(cols > 0) {
            System.out.printf("* ");
            ultaTriangle(rows, cols - 1);
        }
        else{
            System.out.println();
            ultaTriangle(rows - 1, rows - 1);
        }
    }

    static void ultaTriangle2(int row, int col, int rows) {
        if(row == rows) return;

        if(col < rows - row) {
            System.out.print("* ");
            ultaTriangle2(row, col + 1, rows);
        }

        else {
            System.out.println();
            ultaTriangle2(row + 1, 0, rows);
        }
    }


    //seedha triangle has the same code of ulta triangle 2, we have just changed the position of recursive calls haha...
    static void seedhaTriangle(int row, int col, int rows) {
        if(row == rows) return;

        if(col < rows - row) {
            seedhaTriangle(row, col + 1, rows);
            System.out.print("* ");
        }

        else {
            seedhaTriangle(row + 1, 0, rows);
            System.out.println();
        }
    }
}
