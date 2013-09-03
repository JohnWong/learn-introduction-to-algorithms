public class MaximumSubArray {  
    void maxSubArray(int a[]) {  
        int max_so_far = a[0];  
          int max_ending_here = a[0];
        int max_start_index = -1;  
        int max_end_index = 0;  
  
        for (int i = 1; i < a.length; i++) {  
            max_ending_here = max_ending_here + a[i];  
            if (max_ending_here < 0) {  
                max_ending_here = 0;  
                max_start_index = i;  
            } else if (max_so_far < max_ending_here) {  
                max_so_far = max_ending_here;  
                max_end_index = i;  
            }  
  
        }  
  
        if (max_so_far > 0)  
            System.out.println("The maximun sub array - size:" + max_so_far + ", from:" + max_start_index + " to:"  
                    + max_end_index);  
        else  
            System.out.println("All negative or zero, the maximum element is:" + max_so_far);  
    }  
  
    public static void main(String[] args) {  
//      int a[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };  
        // int a[] = { -1, -5, -4, -11, -21, -3 };  
//       int a[] = {0, 0, 0, 0, 0};  
        int a[] = {1, 2, -1, 3, 4};  
        MaximumSubArray ist = new MaximumSubArray();  
        ist.maxSubArray(a);  
    }  
}