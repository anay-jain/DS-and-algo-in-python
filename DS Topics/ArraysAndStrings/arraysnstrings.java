public class arraysnstrings{
    // leetcode 925 long pressed name
    public boolean isLongPressedName(String name, String typed) {
        int i =0, j =0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(j>=1 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }
            else{
                return false;
            }
        }
       return name.charAt(name.length()-1)==typed.charAt(typed.length()-1);
    }
    public static void reverse(int[] arr , int i , int j ){
        int l=j;
        for(int t = i;t<=(j+i)/2;t++,l--){
            int temp = arr[t];
            arr[t]=arr[l];
            arr[l]=temp;
        }
    }
    public void rotate(int[] nums, int k) {
     // make it in range
     int n = nums.length;
     k = k%n;
        if(n==1 || k==0 ) return;
     k=k<0?k+n:k;
        n=n-1;
        System.out.print(k);
     reverse(nums, 0,n-k );
     reverse(nums,n-k+1,n);
     reverse(nums, 0, n);

    
    }

    // next greater element
    public int nextGreaterElement(int n) {
        int idx=0;
        if(n<=10) return -1;
         if(n<0 || n>Integer.MAX_VALUE) return -1;
       int justgreater=0;
        boolean flag=false;
       String s = Integer.toString(n);
       StringBuilder sb = new StringBuilder(s);
       int i = s.length()-2;
       for(i=s.length()-2;i>=0;i--){
           int a = (int)s.charAt(i)-'0';
           int b =  (int) s.charAt(i+1)-'0';
           if(a<b){
               int t=i+1;
               justgreater=b;
               idx=t;
               while(t<s.length()){
                 
                   int ele = (int)s.charAt(t)-'0';
                   if(ele>a && ele<=justgreater){
                   justgreater=ele;
                   idx=t;
                   }
                     t++;
                   
                   
               }
               System.out.println(justgreater+" "+idx);
               flag=true;
          
               // swap them
               sb.setCharAt(i, s.charAt(idx));
               sb.setCharAt(idx, s.charAt(i));
               System.out.print(sb.toString());
               
               break;
           }
       }
       int end= s.length()-1;
       for(int st=i+1;st<=(s.length()+i)/2;st++,end--){
           char temp1 = sb.charAt(end);
           char temp2 = sb.charAt(st);
           sb.setCharAt(st, temp1);
           sb.setCharAt(end, temp2);
       }
       
       s=sb.toString();
        // int num=0;
        // for( i=0;i<s.length();i++){
        //     int a = (int)s.charAt(i)-'0';
        //     num= num*10+a;
        // }
        if(s.length()>=10) return -1;
       int num=  Integer.parseInt(s);
        if(num<0 || num>Integer.MAX_VALUE) return -1;
       return flag?num:-1;
   }
   // LEETCODE  53
   // kadane's algorithm 
   public int maxSubArray(int[] nums) {
       if(nums.length==0) return 0;
            int csum = nums[0];
            int osum = nums[0];
            for(int i=1;i<nums.length;i++){
                if(csum>=0){
                    // this means x(-ve) Y(csum) Z(-ve)
                    csum+=arr[i];

                }
                else{
                    cmax=arr[i];
                }
                osum = Math.max(osum, csum);
            }
            return osum;
}
// leetcode  11
public int maxArea(int[] height) {
        int i =  0;
        int j = height.length;
        int max = 0 ;
        while(i<j){
            if(height[i]>height[j]){
                max = Math.max(max , (j-i)*height[i]);
                j++;
                
            }
            else{
                max =  Math.max(max , (j-i)*height[j]);
                i++;
            }
        }
        return max;
}

// leetcode 26
class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length == 0 ) return 0;
        int j =0;
         for(int i =1;i<nums.length;i++){
             if(nums[i]!=nums[j]){    
                     j++;
                     nums[j] =nums[i];
             }
         }
     return j+1;
 }
 }

  
}