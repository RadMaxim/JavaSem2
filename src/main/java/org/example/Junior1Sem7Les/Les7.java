package org.example.Junior1Sem7Les;

import java.util.Arrays;

public class Les7 {
    static int count1 = 0;
    static int count2 = 0;
        public static int binarySearch(int[] arr, int target) {
            count1++;
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;


                if (arr[mid] == target) {
                    return mid;
                }


                if (arr[mid] < target) {
                    left = mid;
                }

                else {
                    right = mid;
                }
            }


            return -1;
        }
        public static int searchIndex(int[] arr, int target){
            for (int i = 0; i <arr.length ; i++) {
                if (arr[i]==target) {
                    count2 = i+1;
                    return i;
                }

            }
            return -1;
        }

        public static void main(String[] args) {
            int[] array = {2, 4, 8, 12, 16, 23, 38, 56, 72, 91};
            int target = 4;

            int result = binarySearch(array, target);
            int resultFor = searchIndex(array,target);
            int result2 = searchElemArray(array,target);
            System.out.println("1 "+result);
            System.out.println("2 "+resultFor);
            System.out.println("3 "+result2);

            if (result == -1) {
                System.out.println("Элемент не найден");
            } else {
                System.out.println("Элемент найден на индексе: " + result);
            }
        }
        public static int searchElemArray(int []arr, int target){
            return Arrays.binarySearch(arr,target);
        }

    }


