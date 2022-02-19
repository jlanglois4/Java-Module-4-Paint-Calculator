package edu.wctc;

import java.util.*;

public class Room {
    private List<Wall> wallList = new ArrayList<>();

    public Room(double length, double width, double height) {

        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public String toString() {

        return "" + getArea();

    }

    public double getArea() {
        double area = 0;
        for (Wall totalWallArea : wallList) {
            area += totalWallArea.getArea();
        }
        return area;
    }

}
