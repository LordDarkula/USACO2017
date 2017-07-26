/*
ID: aubhros1
LANG: JAVA
TASK: square
*/

import java.io.*;
import java.util.*;

public class square {
    public static void main(String[] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("square.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int triangle1X1 = Integer.parseInt(st.nextToken());
        int triangle1Y1 = Integer.parseInt(st.nextToken());

        int triangle1X2 = Integer.parseInt(st.nextToken());
        int triangle1Y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());

        int triangle2X1 = Integer.parseInt(st.nextToken());
        int triangle2Y1 = Integer.parseInt(st.nextToken());

        int triangle2X2 = Integer.parseInt(st.nextToken());
        int triangle2Y2 = Integer.parseInt(st.nextToken());


        int leastX = Math.min(triangle1X1, Math.min(triangle1X2, Math.min(triangle2X1, triangle2X2)));
        int greatestX = Math.max(triangle1X1, Math.max(triangle1X2, Math.max(triangle2X1, triangle2X2)));

        int leastY = Math.min(triangle1Y1, Math.min(triangle1Y2, Math.min(triangle2Y1, triangle2Y2)));
        int greatestY = Math.max(triangle1Y1, Math.max(triangle1Y2, Math.max(triangle2Y1, triangle2Y2)));

        int area = (int)Math.pow(Math.max((greatestX - leastX), (greatestY - leastY)), 2);

        out.println(area);
        out.close();

    }
}
