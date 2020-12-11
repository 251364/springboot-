import java.util.Scanner;
public class Main{
 public static int[] Test(int[] a){
       int [] b =new int [1001];
       for (int i =0;i<1001;i++){
       b[i] = 0;
       }
       int len = a.length;
       for (int i =0;i<len;i++) {

        b[a[i]] = 1;
       }
       return b;
       }
 

    	
    	
    public	 static void main(String[]args) {
    	Scanner sc = new Scanner(System.in);
    	while (sc.hasNext()){
    		int n = sc.nextInt();
    		int[] a =new int [n];
    		for (int i =0;i<n;i++){
          a[i] = sc.nextInt();}
    		
            int[] c = Test(a);
         int len = c.length;
         for (int i =0;i<len;i++){
         if(c[i] == 1){
         System.out.println(i);
 }}}}}