class MartianPlanet {

    private static final int MAX_COORDINATE = 50;

    private int xBound;
    private int yBound;
    private Cell[][] surface;

    MartianPlanet(int x, int y) {
        assert(x > 0 && x <= MAX_COORDINATE);
        assert(y > 0 && y <= MAX_COORDINATE);
        this.surface = new Cell[x][y];
        this.xBound = x;
        this.yBound = y;
    }

    boolean isOnSurface(int x, int y) {
        return x >= 0 && x < xBound &&
               y >= 0 && y < yBound;
    }

    boolean hasScent(int x, int y) {
        assert(isOnSurface(x, y));
        return surface[x][y] == Cell.SCENT;
    }

    void markScent(int x, int y) {
        assert(isOnSurface(x, y));
        surface[x][y] = Cell.SCENT;
    }

    private enum Cell {
        FREE,
        SCENT,
        OCCUPIED
    }

}