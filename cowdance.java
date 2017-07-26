/*
ID: aubhros1
LANG: JAVA
TASK: cowdance
*/

import java.io.*;
import java.util.StringTokenizer;


public class cowdance {
    public static int n;
    public static int tMax;

    public static int[] collapse(int[] cows, int stageSize)
    {
        int[] collapsed = new int[stageSize];
        for (int i = 0; i < cows.length; i++)
        {
            collapsed[min(collapsed)] += cows[i];
            if (collapsed[min(collapsed)] > tMax)
            {
                return null;
            }
        }

        return collapsed;

    }

    public static boolean tooLong(int[] cows)
    {
        for (int i = 0; i < cows.length; i++)
        {
            if (cows[i] > tMax)
            {
                return true;
            }
        }

        return false;
    }

    public static int min(int[] arr)
    {
        int min = arr[0];
        int minInd = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
                minInd = i;
            }
        }
        return minInd;
    }

    public static void main(String [] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));

        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());

        n = Integer.parseInt(st.nextToken());
        tMax = Integer.parseInt(st.nextToken());

        int[] cowDanceLength = new int[n];

        for (int i = 0; i < n; i++)
        {
            cowDanceLength[i] = Integer.parseInt(f.readLine());
        }

        for (int i = 1; i <= n; i++)
        {
            int[ ]arr = collapse(cowDanceLength, i);
            if (arr != null && !tooLong(arr))
            {
                out.println(i);
                out.close();
                return;
            }
        }

        out.println(n);
        out.close();


    }
}
