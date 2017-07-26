package cowcode;/*
ID: aubhros1
LANG: JAVA
TASK: cowcode.cowcode
*/

import java.io.*;
import java.util.StringTokenizer;

public class cowcode {

    public static String word;
    public static void rotate()
    {
        word = word + word.substring(word.length() - 1)
                + word.substring(0, word.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("cowcode/cowcode.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.cowcode.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        word = st.nextToken();
        long length = Long.parseLong(st.nextToken());

        long ln2 = length / 2;
        long lenWord = word.length();

        while (lenWord < ln2)
        {
             rotate();
            lenWord *= 2;
        }

        if (length == lenWord+1)
        {
            out.println(word.charAt((int)lenWord - 1));
            out.close();
            return;
        }

        long diff = length - lenWord - 2;
        out.println(word.charAt((int)diff));
        out.close();



    }
}
