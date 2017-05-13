/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image_Processing;

import java.awt.Color;
import java.io.File;
import static java.lang.Math.max;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Size;

import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author tuana
 */
public class Filter_Image {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Blur_Image();
//        GrayScale();
//        Contrast();
//        Brightness();
//        Sharpness();
        Rotate(90);
//        Zoom();

    }

    public static void Blur_Image() {

        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg");

        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, destination, new Size(7, 7), 0);
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\Gaussian7.jpg", destination);
    }

    public static void GrayScale() {

        Mat image = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg");
        Mat temp = new Mat();
        Imgproc.cvtColor(image, temp, Imgproc.COLOR_RGB2GRAY);

        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\GrayScale.jpg", temp);

    }

    public static void Contrast() {

        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg",
                Highgui.CV_LOAD_IMAGE_GRAYSCALE);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());

        Imgproc.equalizeHist(source, destination);
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\contrast.jpg", destination);
    }

    public static void Brightness() {
        double alpha = 2;
        double beta = 50;
        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());

        source.convertTo(destination, -1, alpha, beta);
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\brightness.jpg", destination);
    }

    public static void Sharpness() {

        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
        Imgproc.GaussianBlur(source, destination, new Size(0, 0), 10);
        Core.addWeighted(source, 2.5, destination, -1.5, 0, destination);
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\sharpness.jpg", destination);
    }

    public static void Rotate(double angle) { 

        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows(), source.cols(), source.type());
//        Core.flip(source, destination, 1); 
        int len = max(source.cols(), source.rows());
        Point pt = new Point(source.cols() / 2, source.rows() / 2);
        Mat M = Imgproc.getRotationMatrix2D(pt, angle, 1.0);
        Imgproc.warpAffine(source, destination, M, source.size());
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\rotate.jpg", destination);
    }

    public static void Zoom() { //not
        double zoomingFactor = 0.2;
        int zoomTemp = (int) (zoomingFactor * 2);
        Mat source = Highgui.imread("C:\\Users\\tuana\\Desktop\\lena.jpg", Highgui.CV_LOAD_IMAGE_COLOR);
        Mat destination = new Mat(source.rows() * zoomTemp, source.cols() * zoomTemp, source.type());
        Imgproc.resize(source, destination, destination.size(), zoomingFactor, zoomingFactor, Imgproc.INTER_NEAREST);
        Highgui.imwrite("C:\\Users\\tuana\\Desktop\\zoom.jpg", destination);
    }
}
