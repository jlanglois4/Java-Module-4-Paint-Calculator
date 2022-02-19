package edu.wctc;

public class Wall {

    private double width;
    private double height;

    public Wall(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }


}
