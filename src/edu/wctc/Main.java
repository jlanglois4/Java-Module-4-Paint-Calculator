package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);

    private static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {
        boolean bool = true;
        do {
            printMenu();
            switch (keyboard.nextInt()) {
                case 1: // create rooms
                    createRoom();
                    break;
                case 2: // view rooms from memory
                    System.out.println(paintCalculator.toString());
                    break;
                case 3: // write rooms from file
                    writeFile();
                    break;
                case 4: //read rooms from file
                    readFile();
                    break;
                case 5: // exit
                    bool = false;
                    break;
            }
        } while (bool);

    }

    private static void createRoom() {
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintCalculator.addRoom(length, width, height);
    }

    private static void printMenu() {
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Write rooms to file");
        System.out.println("4. Read rooms from file");
        System.out.println("5. Exit");
    }

    private static double promptForDimension(String dimensionName) {
        int number = 0;
        boolean bool = true;

        do {
            try {
                System.out.println("Enter the room's " + dimensionName + ":");
                number = Integer.parseInt(keyboard.next());
                bool = false;
            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a valid number.");
            }
        } while (bool);
        return number;
    }

    private static void readFile() {
        try {
            File file = new File("rooms.txt");
            Scanner inputFile = new Scanner(file);
            double length;
            if (inputFile.hasNext()) {
                while (inputFile.hasNext()) {
                    String line = inputFile.nextLine();
                    length = Double.parseDouble(line.substring(line.lastIndexOf(':') + 1));
                    length = (length / 2) - 1;
                    paintCalculator.addRoom(length, 1, 1);
                }
                System.out.println("File read successfully");
            } else {
                System.out.println("The file is empty.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    private static void writeFile() {
        try {
            PrintWriter outputFile = new PrintWriter("rooms.txt");
            if (!paintCalculator.toString().equals("There are no rooms.")) {
                String room = paintCalculator.toString();
                outputFile.println(room);
                outputFile.flush();
                outputFile.close();
                System.out.println("File written successfully");
            } else {
                System.out.println("There are no rooms to write.");
            }
        } catch (IOException e) {
            System.out.println("File could not be written");
        }
    }
}
