import java.util.Scanner;

public class 字符串最后一个长度 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		CodeLength(s);

	}

	public static void CodeLength(String s) {
		String[] str = s.split(" ");
		int length = str.length;
		System.out.println(str[length - 1].length());
	}
}

//import java.util.*;
//public class Main{
//    public static int lengthOfLast(String str) {
//        String[] s =str.split(" ");
//        return s[s.length-1].length();
//    }
//      
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            String str = scan.nextLine();
//            System.out.println(lengthOfLast(str));
//        }
//    }
//}