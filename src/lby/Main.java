package lby;

import lby.lab01.Circle;
import lby.lab01.Shape;
import lby.lab01.Square;
import lby.lab02.Palindrome;
import lby.lab03.Inverse;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        // MARK: - 1
//        Shape[] shapes = {
//                new Square(0, 0, 1),
//                new Square(0, 0, 2),
//                new Circle(0, 0, 3),
//                new Circle(0, 0, 4),
//        };
//        for (Shape shape: shapes) {
//            shape.print();
//        }

//        // MARK: - 2
//        Palindrome palindrome = new Palindrome();
//        try {
//            palindrome.getStringNPalindrome();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // MARK: - 3
        Inverse inverse = new Inverse();
        try {
            inverse.inverse();
        } catch (IOException e) {
            System.err.println(e);
        }

    }


    // Helper Methods
    private static void separator() {
        System.out.println("****************************");
        System.out.println("****************************");
    }
}
