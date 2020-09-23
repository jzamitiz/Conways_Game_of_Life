
class Threads implements Runnable
{

    int y, x;
    private char[][] grid;
    private char[][] next_Generation;
    // constructor
    public Threads(int x, int y, char[][] grid, char[][] next_Generation)
    {
        this.y = y;
        this.x = x;
        this.grid = grid;
        this.next_Generation = next_Generation;
    }

    @Override
    public void run()
    {
        boolean cell_Alive = is_Cell_going_2live();

        if (cell_Alive)
            next_Generation[x][y] = 'X';
        else
            next_Generation[x][y] = 'O';
    }

    //Implementation of G.oL. rules and checking whether cells will live
    public boolean is_Cell_going_2live()
    {
        //find the number of neighbors alive
        int neighbor = 0;
        for (int i = x - 1; i <= x + 1; i++)
        {
            for (int j = y - 1; j <= y + 1; j++)
            {
                if ((i != x || j != y) && i >= 0 && j >= 0 && i < 20 && j < 20 && grid[i][j] == 'X')
                {
                    neighbor++;
                }
            }
        }
        //Checking G.o.L. rules..
        if (grid[x][y] == 'O' && neighbor == 3) {
            return true;//dead w/3 neighbors ==> alive!
        }

        if (grid[x][y] == 'X' && (neighbor == 2 || neighbor == 3)) {
            return true;//Alive with 2 or 3 neighbors ==> alive!
        }

        return false;//cell is dead..
    }
}