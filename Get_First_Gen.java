import java.io.File;
import java.util.Scanner;
public class Get_First_Gen {

    private final char[][] grid =new char[20][20];
    public int get_First_Gen()
    {
        int index = 0, genValue = 1;
        try
        {
            File file = new File("first_gen.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNext())
            {
                String str = scan.next();
                //if the length of the string is 20
                //read into grid
                if (str.length() == 20)
                {
                    for (int j = 0; j < 20; j++)
                    {
                        grid[index][j] = str.charAt(j);

                    }
                    index++;
                }
                else
                {
                    genValue = Integer.parseInt(str);
                    break;
                }
            }
            scan.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        //return the generation value
        return genValue;
    }
    public char[][] getGrid(){return grid;}
}
