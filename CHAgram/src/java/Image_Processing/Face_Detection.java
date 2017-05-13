/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image_Processing;

import java.util.Vector;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author tuana
 */
public class Face_Detection {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");

//        CascadeClassifier faceDetector = new CascadeClassifier("E:\\MITM 2016\\Programming Methodology - Git\\CHAgram-backend\\CHAgram\\web\\data\\haarcascade_frontalface_alt.xml");
//        Mat image = Highgui
//                .imread("E:\\MITM 2016\\Programming Methodology - Git\\CHAgram-backend\\CHAgram\\web\\data\\data\\lena.jpg");
        CascadeClassifier faceDetector = new CascadeClassifier("C:\\Users\\tuana\\Desktop\\haarcascade_frontalface_alt.xml"); //haarcascade_frontalface_alt.xml
//        Mat image = Highgui
//                .imread("C:\\Users\\tuana\\Desktop\\lena.jpg");
        Mat image = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg");
        System.out.println(image.cols());
        System.out.println(image.rows());
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        Mat small_image = Highgui.imread("C:\\Users\\tuana\\Desktop\\smile.png");
//        Size sz = new Size(image.width(), image.height());
//        Imgproc.resize(small_image, small_image, sz);
        Mat trunctaed = small_image.submat(new Rect(0, 0, 70, 70));
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        int i = 0;
        Mat temp = new Mat();
        for (Rect rect : faceDetections.toArray()) {
//            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
//                    new Scalar(0, 255, 0));

            Size sz = new Size(rect.width, rect.height);

            Imgproc.resize(small_image, temp, sz);
            Highgui.imwrite("C:\\Users\\tuana\\Desktop\\temp.png", temp);
            System.out.println(temp.channels() + "," + temp.cols() + "," + temp.rows());
            System.out.println(temp.channels() == image.channels());
//            Mat mask = Highgui.imread("C:\\Users\\tuana\\Desktop\\temp.png");

////           hough circle
//            Mat gray = new Mat();
//            Imgproc.cvtColor(temp, gray, Imgproc.COLOR_BGR2GRAY);
//            Imgproc.blur(gray, gray, new Size(3, 3));
//
//            Mat edges = new Mat();
//            int lowThreshold = 40;
//            int ratio = 3;
//            Imgproc.Canny(gray, edges, lowThreshold, lowThreshold * ratio);
//
//            Mat circles = new Mat();
//            Vector<Mat> circlesList = new Vector<Mat>();
//            Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 60, 200, 20, 30, 0);
//            for (int x = 0; x < Integer.parseInt(circles.size().toString()); x++) {
////                Mat croped_image = new Mat(temp, );
//            }

//            Imgproc.HoughCircles(edges, circles, Imgproc.CV_HOUGH_GRADIENT, 1, 60, 200, 20, 30, 0);
            
            System.out.println(i++);
            System.out.println(rect.x + "," + rect.y);
            System.out.println(rect.width + "," + rect.height);

            temp.copyTo(image.submat(new Rect(rect.x, rect.y, rect.width, rect.height)));
//            small_image.copyTo(image.submat(new Rect(rect.x, rect.y, rect.width, rect.height)));
        }

        String filename = "C:\\Users\\tuana\\Desktop\\ouput2.png";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);
    }
}
