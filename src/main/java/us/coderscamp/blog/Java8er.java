package us.coderscamp.blog;

/**
 * Created by nevda on 27/3/14.
 */
public class Java8er {
    public static void main(String[] args){
    	
    	// Anonymous Runnable
    	Runnable aR = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println();
			}
		};
		aR.run();
    	
    	// Lambda Runnable
        Runnable lR = () -> System.out.println("foo");
        lR.run();
    }
}
