package Shapes;

public class Rectangle {
    private double width;
    private double height;
    private String color;
    private static int noOfRectangles = 0;

    Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
        noOfRectangles++;
    }

    Rectangle(double width, double height) {
        this(width, height, "Blue");
    }

    Rectangle(){
        this(0,0);
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public String toString() {
        return "I am a Rectangle. My width is "+width+" and my height is "+height;
    }

    public static int getNoOfRectnagles(){
        return noOfRectangles;
    }
}
