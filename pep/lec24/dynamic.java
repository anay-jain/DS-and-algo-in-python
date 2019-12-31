import java.util.Scanner;
public class dynamic{

    static int[][] mul(int[][] F , int [][] M){
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0]; 
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1]; 
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0]; 
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1]; 
        
        F[0][0] = x; 
        F[0][1] = y; 
        F[1][0] = z; 
        F[1][1] = w;
        return F;
    }
    static int[][] apower2(int[][] F , int b){
        int[][] idn={{1,1},{1,0}};
        if(b==1){
            return idn;
        }
        // int[][] idn={{1,1},{1,0}};
         apower2(F, b/2);
        // ans = mul(F, idn);
        return (b%2)==0?mul(F,F):mul(mul(F,F),idn);
    }
    public static int targetjumpstabu(int n){
        int[]  memo = new int[n+1];
        memo[0]=1;
        for(int i =1;i<memo.length;i++){
            for(int j=1;j<7;j++){
                if(i-j>=0){
                    memo[i]+=memo[i-j];
                }
            }
        }
        return memo[n]; 
       }
       public static int targetjumpsmemo(int[] memo , int n ){
            if(n==0){
                return memo[0];
            }   
            if(memo[n]!=0){
                return memo[n];
            }
            int count=0;
            for(int i =1;i<7;i++){
                if(n-i>=0){
                    count+= targetjumpsmemo(memo, n-i);
                //    System.out.println(count);
                }
            }
            memo[n]=count;
            return memo[n];
       }
       static int callsdp=0, callsrec=0,classaddhidp=0;
       public static int mp_memo(int sr , int sc , int er , int ec , int[][] memo){
           callsrec++;
           if(sr==er && sc==ec){
               return 1;
               
           }
           if(memo[sr][sc]!=0){
               System.out.println("dp lagi h bc ");
               return memo[sr][sc];
           }
           classaddhidp++;
           if(memo[sc][sr]!=0){ // only valid for square matrix
               System.out.println("ulta");
               return memo[sc][sr];
           }
           callsdp++;
           if(sr<er){
               memo[sr][sc]+=mp_memo(sr+1, sc, er, ec, memo);
           }
           if(sc<ec){
               memo[sr][sc]+=mp_memo(sr, sc+1, er, ec, memo);
           }
        return memo[sr][sc];
       }
       public static int multimp( int er , int ec , int[][] dp){
           dp[er-1][ec-1]=1;
          
               for(int i=er-1;i>=0;i--){
                for(int j=ec-1;j>=0;j--){
                    for(int jumps =1;jumps<er;jumps++){
                    if(j+jumps<=ec)
                    dp[i][j]+=dp[i][j+jumps];
                    if(i+jumps<=er)
                    dp[i][j]+=dp[i+jumps][j];
                    if(i+jumps<=er&& j+jumps<=ec)
                    dp[i][j]+=dp[i+jumps][j+jumps];
                }
               }
           }
           return dp[0][0];
       }
       public static void display(int[][] arr ){
           for(int i=0;i<arr.length;i++){
               for(int j=0;j<arr[0].length;j++){
                   System.out.print(arr[i][j]+" ");

               }
               System.out.println(" ");
           }
       }
       public static void main(String[] args){
        // int[][] idn={{1,1},{1,0}};
        // int[][] newans  = apower2(idn,5);
        // System.out.println(newans[0][1]);
        // System.out.println(targetjumpstabu(5));
        // int[] memo = new int[6];
        // memo[0]=1;
        // System.out.println(target,jumpstabu(5));
        // System.out.println(targetjumpsmemo(memo , 5));
        int er =3,ec=3;
        int[][] memo = new int[er+1][ec+1];
    //    System.out.println( mp_memo(0, 0, er, ec, memo));
        // System.out.println(callsdp+ " " + classaddhidp+" and" + callsrec);
        System.out.println(multimp( er, ec, memo));
        display(memo);
    }
    
}