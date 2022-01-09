/**
 * 
 */
package com.projects.robot.mars;

import com.projects.robot.mars.model.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author kishore ramana
 *
 */
class RobotTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
    @MethodSource("instructions")
    public void test_Instructions(String startPosition, String instructions, String endPosition, String message){
        Robot robot = new Robot();
        String resultPosition = robot.execute(startPosition, instructions);
        Assertions.assertNotNull(resultPosition);
        Assertions.assertEquals(endPosition,resultPosition, message);
    }

    private static Stream<Arguments> instructions() {
        return Stream.of(
                arguments("1 1 N", "LL" , "1 1 S",  "Rover is inside the plateau"),
                arguments("1 1 E", "RFRFRFRF" , "1 1 E",  "Rover is inside the plateau"),
                arguments("0 3 W", "LLFFFLFLFL" , "2 4 S",  "Rover is inside the plateau"),
                arguments("3 2 N", "FRRFLLFFRRFLL" , "3 3 N",  "Rover is lost")
        );
    }

}
