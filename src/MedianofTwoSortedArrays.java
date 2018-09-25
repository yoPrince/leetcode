public class MedianofTwoSortedArrays {
    public static void main(String[] args){
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] L = {0, 0}, R = {n - 1, m - 1};

        double ans = 0.0;
        if((n + m) % 2 == 1) ans = getTopK(nums1, nums2, L, R, (m + n + 1) / 2);
        else {
            ans = getTopK(nums1, nums2, L, R, (m + n) / 2);
            L[0] = L[1] = 0;
            R[0] = n - 1;
            R[1] = m - 1;
            ans += getTopK(nums1, nums2, L, R, (m + n + 2) / 2);
            ans /= 2.0;
        }
        return ans;
    }

    double getTopK(int[] nums1, int[] nums2, int[] L, int[] R, int k){
        int[] M = new int[2];
        M[0] = (L[0] + R[0]) / 2;
        M[1] = (L[1] + R[1]) / 2;
        if(L[0] > R[0]) return nums2[L[1] + k - 1];
        if(L[1] > R[1]) return nums1[L[0] + k - 1];
        if(nums1[M[0]] >= nums2[M[1]]){
            swap(L);
            swap(M);
            swap(R);
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }
        int cnt = M[0] - L[0] + 1 + M[1] - L[1] + 1;
        if(cnt <= k) {
            k -= M[0] - L[0] + 1;
            L[0] = M[0] + 1;
        }
        else R[1] = M[1] - 1;
        return getTopK(nums1, nums2, L, R, k);
    }

    void swap(int[] a){
        int t = a[0];
        a[0] = a[1];
        a[1] = t;
    }
}