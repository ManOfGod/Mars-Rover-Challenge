package marsrover;

public class Rover {
    private int x;
    private int y;
    private Direction currentDirection;

    public Rover() {
        x = 0;
        y = 0;
        currentDirection = Direction.N;
    }

    public Rover(int x, int y, Direction d) {
        this.x = x;
        this.y = y;
        this.currentDirection = d;
    }

    public void executeCommand(String command) {
        char[] commands = command.toCharArray();
        for (char c : commands) {
            processCommand(c);
        }
    }

    private void processCommand(char c) {
        switch (c) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                move();
                break;
            default:
                throw new IllegalArgumentException("Invalid Command");
        }
    }

    private void turnRight() {
        switch (currentDirection) {
            case N:
                currentDirection = Direction.E;
                break;
            case E:
                currentDirection = Direction.S;
                break;
            case S:
                currentDirection = Direction.W;
                break;
            case W:
                currentDirection = Direction.N;
                break;
            default:
                throw new IllegalArgumentException("Invalid Command");
        }
    }

    private void turnLeft() {
        switch (currentDirection) {
            case N:
                currentDirection = Direction.W;
                break;
            case E:
                currentDirection = Direction.N;
                break;
            case S:
                currentDirection = Direction.E;
                break;
            case W:
                currentDirection = Direction.S;
                break;
            default:
                throw new IllegalArgumentException("Invalid Command");
        }
    }

    private void move() {
        switch (currentDirection) {
            case N:
                y++;
                break;
            case E:
                x++;
                break;
            case S:
                y--;
                break;
            case W:
                x--;
                break;
            default:
                throw new IllegalArgumentException("Invalid Command");
        }
    }

    public int getXCoordinate() {
        return x;
    }

    public int getYCoordinate() {
        return y;
    }

    public Direction getDirection() {
        return currentDirection;
    }

    public String getCurrentLocation() {
        return x + ", " + y + ", " + currentDirection.name();
    }
}
