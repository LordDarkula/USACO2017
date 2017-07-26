/*
ID: aubhros1
LANG: JAVA
TASK: cowtip
*/
import java.io.*;

public class cowtip {
    public static int n;

    public static void tip(int[][] grid, int y, int x)
    {
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (grid[i][j] == 0)
                {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

        // StringTokenizer st = new StringTokenizer(f.readLine());

        n = Integer.parseInt(f.readLine());
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++)
        {
            String line = f.readLine();
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }
        int numTips = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1)
                {
                    tip(grid, i, j);
                    numTips++;
                }
            }
        }

        out.println(numTips);
        out.close();

    }
}
