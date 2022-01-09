package com.projects.robot.mars;

import com.projects.robot.mars.model.Orientation;
import lombok.Getter;

@Getter
public class Position {
    private int x;
    private int y;
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void turnLeft() {
        if(this.orientation.equals(Orientation.NORTH))
            this.orientation = Orientation.WEST;
        else if(this.orientation.equals(Orientation.EAST))
            this.orientation =  Orientation.NORTH;
        else if(this.orientation.equals(Orientation.WEST))
            this.orientation =  Orientation.SOUTH;
        else if(this.orientation.equals(Orientation.SOUTH))
            this.orientation =  Orientation.EAST;
    }

    public void turnRight() {
        if(this.orientation.equals(Orientation.NORTH))
            this.orientation =  Orientation.EAST;
        else if(this.orientation.equals(Orientation.EAST))
            this.orientation =  Orientation.SOUTH;
        else if(this.orientation.equals(Orientation.WEST))
            this.orientation =  Orientation.NORTH;
        else if(this.orientation.equals(Orientation.SOUTH))
            this.orientation =  Orientation.WEST;
    }

    public void moveForward(){
        if(this.orientation.equals(Orientation.NORTH))
            this.y++;
        else if(this.orientation.equals(Orientation.EAST))
            this.x++;
        else if(this.orientation.equals(Orientation.WEST))
            this.x--;
        else if(this.orientation.equals(Orientation.SOUTH))
            this.y--;
    }
}