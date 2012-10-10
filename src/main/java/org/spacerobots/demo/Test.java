package org.spacerobots.demo;

/**
 * Created with IntelliJ IDEA.
 * User: shep
 * Date: 9/27/12
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {

        float radian;
        int radius = 1;

        for(int degree=0;degree<180;degree++) {
            System.out.println("Degree: " + degree);
            System.out.println(Math.sin(((float)degree)*2*Math.PI) + 1.5f);
        }
    }
}
