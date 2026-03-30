import java.util.*;
public class Stablematching{
    public static boolean prefersmen(int []pref,int m,int m1){
        for(int x:pref){
            if(x==m)return true;
            if(x==m1)return false;
        }return false;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the no of pairs :");
        int n = sc.nextInt();
        sc.nextLine();
        int [][]menpref = new int[n][n];
        int [][]womenpref = new int[n][n];
        Map<Character,Integer>menMap = new HashMap<>();
        Map<Character,Integer>womenMap = new HashMap<>();
        char[] menR = new char[n];
        char[] womenR = new char[n];
        System.out.println("Enter the men's preference list :");
        for (int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                char ch = Character.toUpperCase(sc.next().charAt(0));
                womenMap.putIfAbsent(ch,womenMap.size());
                womenR[womenMap.get(ch)]=ch;
                menpref[i][j] = womenMap.get(ch);
            }
        }
        System.out.println("Enter the women's prefrence :");
        for(int i =0 ;i<n;i++){
            for(int j=0;j<n;j++){
                char ch =Character.toUpperCase(sc.next().charAt(0));
                menMap.putIfAbsent(ch,menMap.size());
                menR[menMap.get(ch)]=ch;
                womenpref[i][j]=menMap.get(ch);
            }
        }
        int []womenpartner = new int[n];
        int []menfree = new int[n];
        int []nextproposal = new int[n];
        Arrays.fill(womenpartner,-1);
        int freecount = n;
        while(freecount >0){
            int male;
            for(male = 0;male<n;male++){
                if(menfree[male] == 0)break;
            }
            int w = menpref[male][nextproposal[male]];
            nextproposal[male]++;
            if(womenpartner[w] == -1){
                womenpartner[w]=male;
                menfree[male] = 1;
                freecount--;
            }else{
                int m1 = womenpartner[w];
                if(prefersmen(womenpref[w],male,m1)){
                    womenpartner[w]=male;
                    menfree[male]=1;
                    menfree[m1]=0;
                }
            }
        }
        System.out.println("the matchings are :");
        for(int i=0;i<n;i++){
            System.out.println("Women "+womenR[i]+" arraged with men "+menR[womenpartner[i]]);
        }
    }
}
