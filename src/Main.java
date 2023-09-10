/*check if string CAN be a palindrome.
Main
A ->10 commits


if yes print the string.
Input: aaabb
Output: baaab

aaaaabb
abaaaba
Input:: aabbdc
Output: can’t be palindrome*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static boolean checkPal(String s, HashMap<Character, Integer> hm) {

        int n=s.length();
        for(int i=0;i<n;i++) {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        if(n%2 == 0) {
            for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
                if(entry.getValue() % 2!=0)
                    return false;
            }
            return true;
        }
        else {
            int c=0;
            for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
                if(entry.getValue() %2 !=0 ) {
                    c++;
                    if(c>1)
                        return false;
                }
            }
            return true;
        }
    }

    public static String findPal(String s, HashMap<Character, Integer> hm) {

        int n=s.length();
        StringBuilder sb = new StringBuilder();
        if(n%2 == 0) {
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                int val = entry.getValue();
                for(int i=1;i<=val/2;i++) {
                    sb.append(entry.getKey());
                }
            }
            StringBuilder sb1=new StringBuilder(sb);
            sb1.reverse();
            String res = sb.toString() + sb1.toString();
            return res;
        }
        else {
            char ch ='\0';
            int count = 0;
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                int val = entry.getValue();
                if(val%2 == 0) {
                    for (int i = 1; i <= val / 2; i++) {
                        sb.append(entry.getKey());
                    }
                }
                else {
                    ch  = entry.getKey();
                    count = entry.getValue();
                }
            }
            StringBuilder sb1=new StringBuilder(sb);
            sb1.reverse();
            StringBuilder oddCharStr = new StringBuilder();
            for(int i=0;i<count; i++) {
                oddCharStr.append(ch);
            }
            String res = sb.toString() + oddCharStr.toString() + sb1.toString();
            return res;
        }
    }

    public static void main(String []args) throws IOException {

        BufferedReader y = new BufferedReader(new InputStreamReader(System.in));
        String s = y.readLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        if(checkPal(s, hm)) {
            System.out.println(findPal(s,hm));
        }
        else {
            System.out.println("String cannot be a palindrome");
        }
    }
}
