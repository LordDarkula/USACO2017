/*
ID: aubhros1
LANG: JAVA
TASK: hps
*/

import java.io.*;


public class hps {

    public static int numH;
    public static int numP;
    public static int numS;

    public static int numH2;
    public static int numP2;
    public static int numS2;

    public static int numOccurances(char[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 'H')
            {
                numH2++;
            }
            else if (arr[i] == 'P')
            {
                numP2++;
            }
            else if (arr[i] == 'S')
            {
                numS2++;
            }
        }


        return Math.max(numH, Math.max(numP, numS))
                + Math.max(numH2, Math.max(numP2, numS2));
    }

    public static int newMax(char[] arr, int i)
    {
        if (arr[i] == 'H')
        {
            numH++;
            numH2--;
        }
        else if (arr[i] == 'P')
        {
            numP++;
            numP2--;
        }
        else if (arr[i] == 'S')
        {
            numS++;
            numS2--;
        }
        return Math.max(numH, Math.max(numP, numS))
                + Math.max(numH2, Math.max(numP2, numS2));
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        int length = Integer.parseInt(f.readLine());

        char[] signs = new char[length];

        for (int i = 0; i < length; i++)
        {
            signs[i] = f.readLine().charAt(0);

        }

        int max = numOccurances(signs);

        for (int divider = 0; divider < length; divider++)
        {
            int potMax = newMax(signs, divider);

            if (potMax > max)
            {
                max = potMax;
            }
        }

        out.println(max);
        out.close();

    }
}
