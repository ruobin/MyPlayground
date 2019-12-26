import java.io.*;
import java.util.*;

// Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

// Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

// image1 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 0, 0, 0, 1],
//   [1, 1, 1, 1, 1, 1, 1],
// ]

// Sample output variations (only one is necessary):

// findRectangle(image1) =>
//   x: 3, y: 2, width: 3, height: 2
//   2,3 3,5 -- row,column of the top-left and bottom-right corners

// Other test cases:

// image2 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 0],
// ]

// findRectangle(image2) =>
//   x: 6, y: 4, width: 1, height: 1
//   4,6 4,6

// image3 = [
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 0, 0],
//   [1, 1, 1, 1, 1, 0, 0],
// ]

// findRectangle(image3) =>
//   x: 5, y: 3, width: 2, height: 2
//   3,5 4,6

// image4 = [
//   [0, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
//   [1, 1, 1, 1, 1, 1, 1],
// ]

// findRectangle(image4) =>
//   x: 0, y: 0, width: 1, height: 1
//   0,0 0,0

// image5 = [
//   [0],
// ]

// findRectangle(image5) =>
//   x: 0, y: 0, width: 1, height: 1
//   0,0 0,0

// n: number of rows in the input image
// m: number of columns in the input image


public class FindImageSolution {
    public static void main(String[] argv) {

        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int[][] image2 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0}
        };

        int[][] image4 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image5 = {
                {0}
        };


        MyRectangle result = new FindImageSolution().findImage(image5);
        System.out.println("x: " + result.left + ", y: " + result.top + ", width: " + result.width + ", height: " + result.height);

    }

    class MyRectangle {
        public int top;
        public int left;
        public int width;
        public int height;
    }

    private MyRectangle findImage(int[][] image1) {

        int totalHeight = image1.length;
        int totalWidth = image1[0].length;

        int rectangleTop = 0;
        int rectangleLeft = 0;
        boolean gotTopLeft = false;
        int width = 0;
        int height = 0;

        for(int i=0; i<totalHeight; i++) {

            for(int j=0; j<totalWidth; j++) {
                if(!gotTopLeft && image1[i][j] == 0) {
                    rectangleTop = i;
                    rectangleLeft = j;
                    gotTopLeft = true;//stop update top and left values
                }
                if(image1[i][j] == 0) {
                    width++;
                }
                if(gotTopLeft && (image1[i][j] == 1 || j==totalWidth-1)) break;
            }
            if(gotTopLeft) break;
        }

        for(int i=rectangleTop; i<totalHeight; i++) {
            if(image1[i][rectangleLeft] == 0) {
                height++;
            } else {
                break;
            }
        }

        MyRectangle myRectangle = new MyRectangle();
        myRectangle.top = rectangleTop;
        myRectangle.left = rectangleLeft;
        myRectangle.width = width;
        myRectangle.height = height;
        return myRectangle;
    }
}
