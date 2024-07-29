package projekt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
    public static void main(String[] args) {
        // The provided images are apple.jpg, flower.jpg, and kitten.jpg
        int[][] imageData = imgToTwoD("./kitten.jpg");
        // Or load your own image using a URL!
        //int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
        //viewImageData(imageData);
        //int[][] trimmed = trimBorders(imageData, 60);
        //twoDToImage(trimmed, "./trimmed_apple.jpg");
        int[][] negative=negativeColor(imageData);
        twoDToImage(negative, "./negative_kitten.jpg");
        int[][] strech=stretchHorizontally(imageData);
        twoDToImage(strech,"./stretch_kitten.jpg");
        int[][] shrink=shrinkVertically(imageData);
        twoDToImage(shrink,"./shrink_kitten.jpg");
        int[][] invert = invertImage(imageData);
        twoDToImage(invert,"./invert_kitten.jpg");
        int[][] filtr =colorFilter(imageData,-75,30,-30);
        twoDToImage(filtr,"./filtr_kitten.jpg");
        int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
        twoDToImage(allFilters,"./all_kitten.jpg");
        // Painting with pixels
        int[][] paint=new int[500][500];
        int[][] randomImg = paintRandomImage(paint);
        twoDToImage(randomImg,"./random_random");
        int[] rgba={255,255,0,255};
        int[][] rectangleIm =paintRectangle(imageData,200,200,100,100,getColorIntValFromRGBA(rgba));
        twoDToImage(rectangleIm,"./rectangle_rectangle.jpg");
        int[][] generatedRectangles = generateRectangles(randomImg, 1000);

        twoDToImage(generatedRectangles, "./generated_recta.jpg");

    }
    // Image Processing Methods
    public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
        // Example Method
        if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
            int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
            for (int i = 0; i < trimmedImg.length; i++) {
                for (int j = 0; j < trimmedImg[i].length; j++) {
                    trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
                }
            }
            return trimmedImg;
        } else {
            System.out.println("Cannot trim that many pixels from the given image.");
            return imageTwoD;
        }
    }
    public static int[][] negativeColor(int[][] imageTwoD) {
        // TODO: Fill in the code for this method
        int[][] negative =new int[imageTwoD.length][imageTwoD[0].length];
        for(int i=0;i<negative.length;i++){
            for(int j=0;j<negative[0].length;j++){
                int[] rgba=getRGBAFromPixel(imageTwoD[i][j]);
                rgba[0]=255-rgba[0];
                rgba[1]=255-rgba[1];
                rgba[2]=255-rgba[2];
                negative[i][j]=getColorIntValFromRGBA(rgba);
            }
        }
        return negative;
    }


    public static int[][] stretchHorizontally(int[][] imageTwoD) {
        int[][] stretch=new int[imageTwoD.length][imageTwoD[0].length*2];
        int it=0;
        for(int i=0;i<imageTwoD.length;i++){
            for(int j=0;j< imageTwoD[i].length;j++){
                it=j*2;
                stretch[i][it]=imageTwoD[i][j];
                stretch[i][it+1]=imageTwoD[i][j];
            }
        }
        // TODO: Fill in the code for this method
        return stretch;
    }
    public static int[][] shrinkVertically(int[][] imageTwoD) {
        // TODO: Fill in the code for this method
        int[][] shrink=new int[imageTwoD.length/2][imageTwoD[0].length];
        for(int i=0;i<imageTwoD[0].length;i++){
            for(int j=0;j<imageTwoD.length-1;j+=2){
                shrink[j/2][i]=imageTwoD[j][i];
            }
        }
        return shrink;
    }


    public static int[][] invertImage(int[][] imageTwoD) {
        // TODO: Fill in the code for this method
        int[][] invert=new int[imageTwoD.length][imageTwoD[0].length];
        for(int i=imageTwoD.length-1;i>=0;i--){
            for(int j=imageTwoD[0].length-1;j>=0;j--){
                invert[i][j]=imageTwoD[(imageTwoD.length-1)-i][(imageTwoD[i].length-1)-j];

            }
        }
        return invert;
    }
    public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
        // TODO: Fill in the code for this method
        int[][] filtr = new int[imageTwoD.length][imageTwoD[0].length];
        for(int i=0;i<imageTwoD.length;i++){
            for(int j=0;j<imageTwoD[0].length;j++){
                int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
                int newRed=rgba[0]+redChangeValue;
                int newGreen=rgba[1]+greenChangeValue;
                int newBlue=rgba[2]+blueChangeValue;

                if(newRed>255){
                    newRed=255;
                }else if(newRed<0){
                    newRed=0;
                }
                if(newGreen>255){
                    newGreen=255;
                }else if(newGreen<0){
                    newGreen=0;
                }
                if(newBlue>255){
                    newBlue=255;
                }else if(newBlue<0){
                    newBlue=0;
                }
                rgba[0]=newRed;
                rgba[1]=newGreen;
                rgba[2]=newBlue;
                filtr[i][j]=getColorIntValFromRGBA(rgba);
            }
        }


        return filtr;
    }
    // Painting Methods
    public static int[][] paintRandomImage(int[][] canvas) {
        // TODO: Fill in the code for this method
        Random rand=new Random();
        for(int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[i].length;j++){
                int[] rgba = { rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 255 };
                canvas[i][j] = getColorIntValFromRGBA(rgba);

            }
        }

        return canvas;
    }
    public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {

        // TODO: Fill in the code for this method
        for(int i=0;i<canvas.length;i++){
            for(int j=0;j<canvas[i].length;j++){
                if(i>=rowPosition && i<=rowPosition +width){
                    if(j>=colPosition && j<=colPosition +height){
                        canvas[i][j]=color;
                    }

                }

            }
        }

        return canvas;
    }
    public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
        Random rand = new Random();
        for (int i = 0; i < numRectangles; i++) {
            int randomWidth = rand.nextInt(canvas[0].length);
            int randomHeight = rand.nextInt(canvas.length);
            int randomRowPos = rand.nextInt(canvas.length - randomHeight);
            int randomColPos = rand.nextInt(canvas[0].length - randomWidth);
            int[] rgba = { rand.nextInt(256), rand.nextInt(256), rand.nextInt(256), 255 };
            int randomColor = getColorIntValFromRGBA(rgba);
            canvas = paintRectangle(canvas, randomWidth, randomHeight, randomRowPos, randomColPos, randomColor);
        }
        return canvas;
    }
    // TODO: Fill in the code for this method


    // Utility Methods
    public static int[][] imgToTwoD(String inputFileOrLink) {
        try {
            BufferedImage image = null;
            if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
                URL imageUrl = new URL(inputFileOrLink);
                image = ImageIO.read(imageUrl);
                if (image == null) {
                    System.out.println("Failed to get image from provided URL.");
                }
            } else {
                image = ImageIO.read(new File(inputFileOrLink));
            }
            int imgRows = image.getHeight();
            int imgCols = image.getWidth();
            int[][] pixelData = new int[imgRows][imgCols];
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    pixelData[i][j] = image.getRGB(j, i);
                }
            }
            return pixelData;
        } catch (Exception e) {
            System.out.println("Failed to load image: " + e.getLocalizedMessage());
            return null;
        }
    }
    public static void twoDToImage(int[][] imgData, String fileName) {
        try {
            int imgRows = imgData.length;
            int imgCols = imgData[0].length;
            BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < imgRows; i++) {
                for (int j = 0; j < imgCols; j++) {
                    result.setRGB(j, i, imgData[i][j]);
                }
            }
            File output = new File(fileName);
            ImageIO.write(result, "jpg", output);
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e.getLocalizedMessage());
        }
    }
    public static int[] getRGBAFromPixel(int pixelColorValue) {
        Color pixelColor = new Color(pixelColorValue);
        return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
    }
    public static int getColorIntValFromRGBA(int[] colorData) {
        if (colorData.length == 4) {
            Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
            return color.getRGB();
        } else {
            System.out.println("Incorrect number of elements in RGBA array.");
            return -1;
        }
    }
    public static void viewImageData(int[][] imageTwoD) {
        if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
            int[][] rawPixels = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rawPixels[i][j] = imageTwoD[i][j];
                }
            }
            System.out.println("Raw pixel data from the top left corner.");
            System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
            int[][][] rgbPixels = new int[3][3][4];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
                }
            }
            System.out.println();
            System.out.println("Extracted RGBA pixel data from top the left corner.");
            for (int[][] row : rgbPixels) {
                System.out.print(Arrays.deepToString(row) + System.lineSeparator());
            }
        } else {
            System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
        }
    }
}

