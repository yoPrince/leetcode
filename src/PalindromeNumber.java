public class PalindromeNumber {
    public static void main(String[] args){
        System.out.println(new Solution().isPalindrome(112211));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(0));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int palindrome = 0;
        while(x != 0){
            palindrome = palindrome * 10 + x % 10;
            x /= 10;
        }
        if(palindrome == num) return true;
        else return false;
    }
}