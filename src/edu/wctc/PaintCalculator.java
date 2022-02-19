package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class PaintCalculator {

    private List<Room> roomList = new ArrayList<>();


    public void addRoom(double length, double width, double height) {
        Room room = new Room(length, width, height);
        roomList.add(room);
    }

    public String toString() {
        String returnStatement = "";
        if (roomList.size() == 0) {
            returnStatement = "There are no rooms.";
        } else {
            for (int i = 0; i < roomList.size(); i++) {
                returnStatement += "Room area: " + roomList.get(i).getArea() + "\n";
            }
        }
        return returnStatement;
    }
}
