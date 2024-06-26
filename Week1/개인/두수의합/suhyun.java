package Week1.개인.두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class suhyun {

    static int n, target, ans = 0;
    static StringTokenizer st;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        target = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            if(binary_search(0, a.length - 1, target - a[i])){
                ans += 1;
            }
        }
        System.out.println(ans / 2);
    }

    static boolean binary_search(int L, int R, int x){
        while(L <= R){
            int mid = (L + R) / 2;
            if(a[mid] < x){
                L = mid + 1;
            } else if(a[mid] > x){
                R = mid - 1;
            } else{
                return true;
            }
        }
        return false;
    }
}
