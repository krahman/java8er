package us.coderscamp.blog;

/**
 * Created by nevda on 27/3/14.
 */
public class Java8er {
    public static void main(String[] args){
        Runnable r = () -> System.out.println("foo");
        r.run();
    }
}
