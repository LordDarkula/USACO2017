package gift1;/*
ID: aubhros1
LANG: JAVA
TASK: gift1.gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
    public static void main(String [] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1/gift1.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.gift1.out")));

        // Use StringTokenizer vs. readLine/split -- lots faster
        // StringTokenizer st = new StringTokenizer(f.readLine());

        int length = Integer.parseInt(f.readLine());

        String[] names = new String[length];
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>(length);

        for (int i = 0; i < length; i++)
        {
            String name = f.readLine();
            names[i] = name;
            hash.put(name, 0);
        }

        String line;
        while ((line = f.readLine()) != null)
        {
            String name = line;
            line = f.readLine();

            StringTokenizer st = new StringTokenizer(line);

            int amount = Integer.parseInt(st.nextToken());
            int gifts = Integer.parseInt(st.nextToken());
            int leftover;
            if (gifts == 0)
            {
                leftover = 0;
            }
            else
            {
                leftover = amount % gifts;
            }

            hash.put(name, hash.get(name) - amount + leftover);

            for (int i = 0; i < gifts; i++)
            {
                String receiver = f.readLine();
                hash.put(receiver, hash.get(receiver) + amount / gifts);
            }

        }

        for (int i = 0; i < length; i++)
        {
            System.out.println(names[i]);
            out.println(names[i] + " " + hash.get(names[i]));
        }

        out.close();

    }
}
