import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {
    @Test
    public void given1x1AliveGridReturnDeadGrid(){
        assertEquals(new Grid(row(0)), new Grid(row(1)).next());
    }

    @Test
    public void given2x1AliveGridReturnDeadGrid(){
        assertEquals(new Grid(row(0, 0)), new Grid(row(1, 1)).next());
    }

    @Test
    public void given3x1AliveGridReturnAliveGridWIithEndsDead(){
        Grid g = new Grid(row(1, 1, 1));

        assertEquals(2, g.aliveNeighbors(1, 0));
        assertEquals(true, g.isAlive(1, 0));
        assertEquals(new Grid(row(0, 1, 0)), g.next());
        assertEquals(new Grid(row(1, 1, 1)), g);

    }

    @Test
    public void given4x1AliveGridReturnAliveGridWIithEndsDead(){
        assertEquals(new Grid(row(0, 1, 1, 0)), new Grid(row(1, 1, 1, 1)).next());
    }

    @Test
    public void given1x2AliveGridReturnDeadGrid() {
        assertEquals(new Grid(row(0),
                              row(0)),
                new Grid(row(1),
                         row(1)).next());
    }

    @Test
    public void given1x3AliveGridReturnAliveGridWithEndsDead(){
        assertEquals(new Grid(row(0),
                              row(1),
                              row(0)),
                     new Grid(row(1),
                              row(1),
                              row(1)).next());
    }

    @Test
    public void given2x2AliveGridReturnAliveGrid(){
        assertEquals(new Grid(row(1, 1),
                              row(1, 1)),
                new Grid(row(1, 1),
                         row(1, 1)).next());
    }

    @Test
    public void given2x2AliveGridWithOneDeadReturnAliveGrid(){
        assertEquals(new Grid(row(1, 1),
                              row(1, 1)),
                new Grid(row(1, 1),
                         row(0, 1)).next());
    }

    @Test
    public void given3x2TopRowAliveBottomRowDeadReturnAllDeadExceptMiddleCells(){
        assertEquals(new Grid(row(0, 1, 0),
                              row(0, 1, 0)),
                new Grid(row(1, 1, 1),
                         row(0, 0, 0)).next());
    }

    @Test
    public void given3x3AliveGridReturnAllDeadExceptCorners(){
        assertEquals(new Grid(row(1, 0, 1),
                              row(0, 0, 0),
                              row(1, 0, 1)),
                new Grid(row(1, 1, 1),
                         row(1, 1, 1),
                         row(1, 1, 1)).next());
    }

    private int[] row(int ...is) {
        return is;
    }
}
