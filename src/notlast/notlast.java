package notlast;/*
ID: aubhros1
LANG: JAVA
TASK: notlast.notlast
*/

import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class notlast {
    public static void main(String[] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("notlast/notlast.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.notlast.out")));

        // StringTokenizer st = new StringTokenizer(f.readLine());

        int length = Integer.parseInt(f.readLine());
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>(length);

        for (int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String name = st.nextToken();
            if (hash.containsKey(name))
            {
                hash.put(name, Integer.parseInt(st.nextToken()) + hash.get(name));
            }
            else
            {
                hash.put(name, Integer.parseInt(st.nextToken()));
            }

        }

        int lowest = 1000000000;
        int secondLowest = 1000000000;
        int numSecondLowest = 1;
        int numLowest = 1;
        String secondLowestCow = null;
        String lowestCow = null;
        String[] names = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        for (String name:
             names) {
            if (!hash.containsKey(name))
            {
                if (lowest == 0)
                {
                    numLowest ++;
                } else {
                    secondLowest = lowest;
                    secondLowestCow = lowestCow;
                    numSecondLowest = numLowest;
                    numLowest = 1;
                    lowestCow = name;
                    lowest = 0;
                }

            } else if (hash.get(name) < lowest)
            {
                secondLowest = lowest;
                secondLowestCow = lowestCow;
                numSecondLowest = numLowest;

                lowest = hash.get(name);
                numLowest = 1;
                lowestCow = name;

            } else if (hash.get(name) == lowest)
            {
                numLowest ++;
            } else if (hash.get(name) == secondLowest)
            {
                numSecondLowest ++;
            } else if (hash.get(name) < secondLowest)
            {
                secondLowestCow = name;
                secondLowest = hash.get(name);
                numSecondLowest = 1;
            }

        }

        if (numSecondLowest == 1 && secondLowestCow != null)
        {
            out.println(secondLowestCow);
        } else {
            out.println("Tie");
        }

        out.close();
    }
}
