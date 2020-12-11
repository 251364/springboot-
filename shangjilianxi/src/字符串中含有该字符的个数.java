import java.util.*;
public class 字符串中含有该字符的个数{
    public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String s= in.nextLine();
   
   String  cc=in.nextLine();
    
      count(s,cc);
}
public static void count(String s,String c){

	char cc=c.toCharArray()[0];
  int co = 0;
  for(int i=0;i<s.length();i++){
    if(s.charAt(i)==cc){
      co++;
    }
    
  }
  System.out.println(co);
}
}