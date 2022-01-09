package com.projects.robot.mars;

import com.projects.robot.mars.model.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
    @MethodSource("orientationLeft")
    public void testOrientation_Left(Orientation startOrientation, Orientation endOrientation, String message){
        Position position = new Position(0, 0, startOrientation);
        position.turnLeft();
        Assertions.assertTrue(endOrientation == position.getOrientation(), message);
    }

    private static Stream<Arguments> orientationLeft() {
        return Stream.of(
                arguments(Orientation.NORTH, Orientation.WEST ,  "Turning Left from North is West"),
                arguments(Orientation.EAST, Orientation.NORTH,  "Turning Left from East is North"),
                arguments(Orientation.WEST, Orientation.SOUTH,  "Turning Left from West is South"),
                arguments(Orientation.SOUTH, Orientation.EAST,  "Turning Left from South is East")
        );
    }

    @ParameterizedTest
    @MethodSource("orientationRight")
    public void testOrientation_Right(Orientation startOrientation, Orientation endOrientation, String message){
        Position position = new Position(0, 0, startOrientation);
        position.turnRight();
        Assertions.assertTrue(endOrientation == position.getOrientation(), message);
    }

    private static Stream<Arguments> orientationRight() {
        return Stream.of(
                arguments(Orientation.NORTH, Orientation.EAST ,  "Turning Right from North is East"),
                arguments(Orientation.EAST, Orientation.SOUTH,  "Turning Right from East is South"),
                arguments(Orientation.WEST, Orientation.NORTH,  "Turning Right from West is North"),
                arguments(Orientation.SOUTH, Orientation.WEST,  "Turning Right from South is West")
        );
    }

    @ParameterizedTest
    @MethodSource("moveForward")
    public void testMove_Forward(int x, int y, Orientation currentOrientation, int[] endOrdinates, String message1, String message2){
        Position position = new Position(x, y, currentOrientation);
        position.moveForward();
        Assertions.assertEquals(endOrdinates[0],position.getX(), message1);
        Assertions.assertEquals(endOrdinates[1],position.getY(), message2);
    }

    private static Stream<Arguments> moveForward() {
        return Stream.of(
                arguments(1, 1, Orientation.NORTH, new int[]{1,2} ,  "Moving Forward North does not impact x coordinate", "Moving Forward North increases the y coordinate by 1"),
                arguments(1, 1, Orientation.EAST, new int[]{2,1} ,  "Moving Forward East increases the x coordinate by 1", "Moving Forward East does not impact y coordinate"),
                arguments(1, 1, Orientation.WEST, new int[]{0,1} ,  "Moving Forward West decreases the x coordinate by 1", "Moving Forward West does not impact y coordinate"),
                arguments(1, 1, Orientation.SOUTH, new int[]{1,0} ,  "Moving Forward South does not impact x coordinate", "Moving Forward South decreases the y coordinate by 1")
        );
    }

}
