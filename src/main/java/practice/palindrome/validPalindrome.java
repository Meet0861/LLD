package practice.palindrome;

import java.util.Scanner;

public class validPalindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkIfValidPD(s));
    }

    private static boolean checkIfValidPD(String s) {
        int l = 0, h =s.length()-1;
        while(l<=h){
            if(s.charAt(l) == s.charAt(h)){
                l++;
                h--;
            }
            else return false;
        }
        return true;
    }


}
