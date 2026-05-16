import java.util.*;
public class kmpmatching{
    static int[] computelsp(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0]=0;
        int i=1;
        int len=0;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] =len;
                i++;
            }else{
                if(len !=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }return lps;
    }
    static void kmpsearch(String text,String pattern){
        int m = text.length();
        int n = pattern.length();
        int[] lps = computelsp(pattern);
        int i=0;
        int j=0;
        while(i<m){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }
            if(j == n){
                System.out.println("The pattern found at :"+(i-j));
                j= lps[j-1];
            }else if(i<m && pattern.charAt(j) != text.charAt(i)){
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the text of String");
            String text = sc.nextLine();
            System.out.println("Enter the pattern of String");
            String pattern = sc.nextLine();
            kmpsearch(text,pattern);
        }
    
}
