package com.projects.robot.mars;

import com.projects.robot.mars.model.Orientation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Robot {

    public static void main(String... strings){
        List<String> inputList = new ArrayList<>();
        System.out.println("Please type 'exit' after completing the input");
        try (Scanner scanner = new Scanner(System.in)) {
            String input;
            do{
                input = scanner.nextLine();
                if(!input.equals("exit")) inputList.add(input);
            } while(!input.equals("exit"));
        }

        System.out.println("Upper right coordinates : "+ inputList.get(0));

        Robot robot = new Robot();
        int counter = 1;
        for(int i=1 ; i< inputList.size(); i+=2){
           String output = robot.execute(inputList.get(i), inputList.get(i+1));
           System.out.println("Rover "+counter++ + " output : " + output);
        }
    }

    public String execute(String startPosition, String instructions){
        String[] startPosArr = startPosition.split(" ");
        Orientation currentOrientation = Orientation.getOrientationForName(startPosArr[2]);
        Position position = new Position(Integer.valueOf(startPosArr[0]), Integer.valueOf(startPosArr[1]), currentOrientation);

        for(char instruction : instructions.toCharArray()){
            switch (instruction) {
                case 'L':
                    position.turnLeft();
                    break;
                case 'R':
                    position.turnRight();
                    break;
                case 'F':
                    position.moveForward();
                    break;
                default:
                    System.out.println("Not a valid instruction - " + instruction);
            }
        }
        return position.getX() + " " + position.getY() + " "+ position.getOrientation().getName();
    }

}