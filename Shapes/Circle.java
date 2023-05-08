package Shapes;

public class Circle extends Shape{
    // Data fields
    private double radius;

    Circle(double radius, String color){
        super(color);
        this.radius = radius;
        this.color = color;
    }
    Circle(double radius) {
        this(radius, "Blue");
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }
    
}
