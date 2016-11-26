import java.io.PrintStream;

class MartianRobot {

    private int x;
    private int y;
    private Status status;
    private Orientation orientation;
    private String instructions;
    private MartianPlanet planet;

    MartianRobot(int x, int y, Orientation orientation,
                 String instr, MartianPlanet planet) {
        this.x = x;
        this.y = y;
        this.status = Status.ALIVE;
        this.orientation = orientation;
        this.instructions = instr;
        this.planet = planet;
    }

    void executeInstructions() {
        for (char instr : instructions.toCharArray()) {
            if (status == Status.LOST) break;
            switch (instr) {
                case 'F': moveForward(); break;
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                default : break;
            }
        }
    }

    private void moveForward() {
        int nextX = nextX();
        int nextY = nextY();
        if (planet.isOnSurface(nextX, nextY)) {
            x = nextX;
            y = nextY;
        } else {
            if (!planet.hasScent(x, y)) {
                planet.markScent(x, y);
                status = Status.LOST;
            }
        }
    }

    private void turnLeft() {
        orientation = orientation.left();
    }

    private void turnRight() {
        orientation = orientation.right();
    }

    private int nextX() {
        switch (orientation) {
            case E: return x+1;
            case W: return x-1;
            default: return x;
        }
    }

    private int nextY() {
        switch (orientation) {
            case N: return y+1;
            case S: return y-1;
            default: return y;
        }
    }

    void printInfo(PrintStream stream) {
        stream.format("%d %d %s %s%n",
                x,
                y,
                orientation,
                status);
    }


    private enum Status {
        ALIVE(""),
        LOST("LOST");

        private String status;

        Status(String s) {
            this.status = s;
        }

        public String toString() {
            return status;
        }
    }

}