import java.util.Arrays;


public class Grid {
    public static final int DEAD = 0;
    public static final int ALIVE = 1;
    public static final int FIRST_INDEX = 0;
    public static final int NUM_RESURRECTORS = 3;
    public static final int NUM_UNDERPOPULATION = 2;
    public static final int NUM_OVERPOPULATION = 3;
    int[][] rows;

    public Grid(int[]... rows) {
        this.rows = rows;
    }

    public Grid(Grid template) {
        this.rows = new int[ template.yLength() ][ template.xLength() ];

    }

    public Grid next() {
        Grid nextGrid = new Grid(this);

        for (int y = 0; y < nextGrid.yLength(); y++) {
            for (int x = 0; x < nextGrid.xLength(); x++) {
                nextGrid.set(x, y, cellNext(x, y));
            }
        }
        return nextGrid;
    }

    private int yLength() {
        return rows.length;
    }

    private int cellNext(int x, int y) {
        if (isAlive(x, y) && (aliveNeighbors(x, y) == NUM_UNDERPOPULATION || aliveNeighbors(x, y) == NUM_OVERPOPULATION)) {
            return ALIVE;
        } else if (isDead(x, y) && aliveNeighbors(x, y) == NUM_RESURRECTORS){
            return ALIVE;
        }else{
            return DEAD;
        }
    }

    private boolean isDead(int r, int c) {
        return get(r, c) == DEAD;
    }

    public int aliveNeighbors(int x, int y) {
        return get(x-1, y-1) + get(x, y - 1) + get(x+1, y-1) +
                get(x - 1, y) + get(x + 1, y) +
                get(x-1, y+1) + get(x, y + 1) + get(x+1, y+1);
    }

    private int get(int x, int y) {
        if (x < FIRST_INDEX || x >= xLength() || y < FIRST_INDEX || y >= yLength()) {
            return DEAD;
        } else {
            return rows[y][x];
        }
    }

    public int xLength() {
        return rows[FIRST_INDEX].length;
    }

    private void set(int x, int y, int value) {
        this.rows[y][x] = value;
    }

    public String toString() {
        return Arrays.deepToString(rows);
    }


    public boolean equals(Object o) {
        Grid obj = (Grid) o;
        return Arrays.deepEquals(obj.getRows(), this.rows);
    }


    private int[][] getRows() {
        return this.rows;
    }

    public boolean isAlive(int x, int y) {
        return get(x, y) == ALIVE;
    }
}
