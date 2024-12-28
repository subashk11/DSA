package com.recursion.hard;

public class BinarySearch {

        // element - number to be searched
        public static void main(String[] args) {
            // Write your code here
            int[] numbers = {
                    26, 27, 31, 31, 31, 32, 37, 38, 44, 44, 47, 51, 52, 58, 69, 70, 71, 73,
                    83, 84, 91, 94, 95, 97, 103, 104, 106, 111, 118, 130, 132, 134, 140, 141,
                    144, 148, 162, 163, 166, 175, 179, 180, 181, 182, 183, 184, 184, 185, 186,
                    190, 192, 195, 197, 199, 204, 209, 211, 214, 216, 218, 222, 232, 239, 242,
                    244, 245, 248, 250, 258, 258, 268, 270, 274, 276, 277, 291, 295, 297, 301,
                    302, 312, 313, 316, 322, 328, 331, 333, 334, 335, 337, 347, 350, 350, 353,
                    353, 354, 357, 358, 363, 364, 369, 382, 390, 393, 396, 400, 401, 403, 414,
                    418, 419, 421, 424, 430, 432, 440, 444, 464, 464, 467, 479, 488, 490, 492,
                    492, 495, 500
            };

            int element = 202;

            int length = numbers.length;

            // Binary seach
            int low = 0;
            int high = length-1;

            int idx = findItems(numbers, element, low, high);

            // find the mid
            System.out.println("the item is found at : "+ idx);

            // check the element is equal, lesser or greater , then proceed to decision based on that.
        }

        public static int findItems(int[] nums, int target, int low, int high) {
            // Base condition
            if(low>=high){
                return -1;
            }
            int mid = low + (high-low)/2;

            // check if mid == target
            if(nums[mid] == target) return mid;

            if(nums[mid] > target){
                // move to the left side
                return findItems(nums, target, low, mid-1);
            } else {
                return findItems(nums, target, mid+1, high);
            }
        }

}
