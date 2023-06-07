package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 1, invocationCount = 10)
    public void ahmet(){
        System.out.println("I am test1");
    }

    @Test(priority = 2)
    public void mehmet(){
        System.out.println("I am test2");
    }

    @Test(priority = 3)
    public void ayse(){
        System.out.println("I am test3");
    }
}
