
class LifeThreadsGame {
    int generation;

    public Get_First_Gen first = new Get_First_Gen();
    private final char[][] grid = first.getGrid();
    private final char[][] next_Generation = new char[20][20];

   LifeThreadsGame(){
       generation = first.get_First_Gen();
   }
    public void runThreads()
    {
        //thread for each square of the grid 20x20 = 400 threads
        Thread threads[] = new Thread[400];

        int index = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                threads[index] = new Thread(new Threads(i, j, grid, next_Generation));
                threads[index].start();
                index++;
            }
        }
        try {
            for (int i = 0; i < 400; i++) {
                threads[i].join();
            }

        }
        catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++)
                grid[i][j] = next_Generation[i][j];
        }
    }
    public char[][] getGrid() {
        return grid;
    }
    public char[][] getNext_Generation() {
        return next_Generation;
    }

    public void print(char [][]grid){
       int size = grid.length;

       for ( int i = 0; i< size; i++){
           for(int j = 0; j < size ; j++)
           {
               System.out.print(grid[i][j]);
           }
           System.out.println();
       }
        System.out.println();
    }

}

