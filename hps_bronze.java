/*
ID: aubhros1
LANG: JAVA
TASK: hps
*/

import java.io.*;
import java.util.StringTokenizer;

public class hps_bronze {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        int length = Integer.parseInt(f.readLine());
        StringTokenizer st;

        int [][]signs = new int[2][length];

        int cluster1 = 0;
        int cluster2 = 0;
        for (int i = 0; i < length; i++)
        {
            st = new StringTokenizer(f.readLine());
            int sign1 = Integer.parseInt(st.nextToken());
            int sign2 = Integer.parseInt(st.nextToken());
            if (sign1 == 1)
            {
                if (sign2 == 2)
                {
                    cluster1++;
                } else if (sign2 == 3)
                {
                    cluster2++;
                }
            } else if (sign1 == 2)
            {
                if (sign2 == 3)
                {
                    cluster1++;
                } else if (sign2 == 1)
                {
                    cluster2++;
                }
            } else if (sign1 == 3)
            {
                if (sign2 == 1)
                {
                    cluster1++;
                } else if (sign2 == 2)
                {
                    cluster2++;
                }
            }
        }

        out.println(Math.max(cluster1, cluster2));
        out.close();

    }
}
