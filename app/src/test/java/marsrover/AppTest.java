/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void RoverTest() {
        // Arrange
        Rover rover = new Rover();

        // Act
        rover.executeCommand("LMLMLMLMLM");

        // Assert
        assertEquals("-1, 0, W", rover.getCurrentLocation());
        assertEquals(-1, rover.getXCoordinate());
        assertEquals(0, rover.getYCoordinate());
        assertEquals(Direction.W, rover.getDirection());
    }

    @Test
    void RoverTestWithDefinedInitialLocation() {
        // Arrange
        Rover rover = new Rover(3, 3, Direction.E);

        // Act
        rover.executeCommand("MMRMMRMRRM");

        // Assert
        assertEquals("5, 1, E", rover.getCurrentLocation());
        assertEquals(5, rover.getXCoordinate());
        assertEquals(1, rover.getYCoordinate());
        assertEquals(Direction.E, rover.getDirection());
    }

    @Test
    void RoverTestWithInvalidCommand() {
        // Arrange
        Rover rover = new Rover();

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rover.executeCommand("MLFRRE");
        });

        // Assert
        assertTrue(exception.getMessage().contains("Invalid Command"));
    }
}
