package cowsignal;/*
ID: aubhros1
LANG: JAVA
TASK: cowsignal.cowsignal
*/

import java.io.*;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowsignal/cowsignal.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.cowsignal.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] signal = new char[m][n];
        char[][] amplified = new char[m*k][n*k];

        for (int i = 0; i < m; i++)
        {
            String line = f.readLine();

            for (int j = 0; j < n; j++)
            {
                signal[i][j] = line.charAt(j);
                for (int rep = 0; rep < k; rep++)
                {
                    amplified[k*i][j*k + rep] = line.charAt(j);
                }
            }

            for (int clone = 0; clone < k; clone++)
            {
                amplified[k*i + clone] = amplified[k*i];
            }
        }

        for (int i = 0; i < amplified.length; i++) {

            for (int j = 0; j < amplified[i].length; j++) {

                System.out.print(amplified[i][j]);
                out.print(amplified[i][j]);
            }
            out.println();
            System.out.println();
        }

        out.close();

    }
}
