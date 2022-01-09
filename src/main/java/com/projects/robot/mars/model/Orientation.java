package com.projects.robot.mars.model;

public enum Orientation {
    NORTH("N"), EAST("E"), WEST("W"), SOUTH("S");

    private String name;

    Orientation(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Orientation getOrientationForName(final String name)
    {
        for (Orientation orientation : Orientation.values())
            if (orientation.name.equals(name))
                return orientation;

        return null;
    }
}