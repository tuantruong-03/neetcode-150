package com.neetcode.arraynhashing;


public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] res = new int[len];
        res[0] = 1;
        // Step 1: Compute left product for each index
        // res[i] will contain the product of all elements to the left of index i of nums.
        for (int i = 1; i < len; i ++) {
            res[i] = nums[i-1]*res[i-1];
        }
        int rightProduct = 1;
        // Step 2: Compute right product on-the-fly and multiply it to res[i]
        // rightProduct holds the product of all elements to the right of current index.
        for (int i = len - 2; i >= 0; i--) {
            rightProduct *= nums[i+1];
            res[i] *= rightProduct;
        }
        return res;
    }

}
