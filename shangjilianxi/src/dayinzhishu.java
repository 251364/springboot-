import java.util.Scanner;

public class dayinzhishu {

	public static void main(String[] args) {
	
		Scanner input=new Scanner(System.in);
         int num=input.nextInt();
		System.out.println("打印"+num+"内的所有质数");
	    byte [] bl=new byte[num];
	    int k;
	    for(int i=0;i<num;i++) {
	    	
	    	bl[i]=1;
	    }
	  for (int i = 1; i <= num/2; i++) {
		
		  if (bl[i]==0) {
			continue;
		}
		  for(int j=i;j<num/(i+1);j++) {
			  k=(i+1)*(j+1)-1;
			  bl[k]=0;
		  }
	}
	    
	  System.out.print('2'+" ");
	  for(int i=2;i<num;i+=2){
          if(bl[i]==1) {
              System.out.print((i+1)+" ");
          }
      }
	}

}
