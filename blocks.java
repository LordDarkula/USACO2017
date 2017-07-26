/*
ID: aubhros1
LANG: JAVA
TASK: blocks
*/


import java.io.*;
import java.util.StringTokenizer;

public class blocks {
    public static void main(String[] args) throws IOException {

        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));

        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        int length = Integer.parseInt(f.readLine());

        String binary = new String(new char[length]).replace('\0', '1');;


        String[][] words = new String[length][2];
        int[] alphabet = new int[26];

        for (int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            words[i][0] = st.nextToken();
            words[i][1] = st.nextToken();

        }

        int[] temp1 = new int[26];
        int[] temp2 = new int[26];

        for (int i = 0; i < length; i++)
        {
            String word1 = words[i][0];
            String word2 = words[i][1];
            for (int ch = 0; ch < word1.length(); ch++)
            {
                temp1[word1.charAt(ch) - 'a'] ++;
            }

            for (int ch = 0; ch < word2.length(); ch++)
            {
                temp2[word2.charAt(ch) - 'a'] ++;
            }

            for (int ch = 0; ch < 26; ch++)
            {
                alphabet[ch] += Math.max(temp1[ch], temp2[ch]);
                temp1[ch] = 0;
                temp2[ch] = 0;
            }
        }

//        int numIterations = Integer.parseInt(binary, 2);
//
//        int[] temp = new int[26];
//
//        for (int i = 0; i <= numIterations; i++)
//        {
//            binary = String.format("%" + length + "s", Integer.toBinaryString(i)).replace(' ', '0');
//
//            for (int j = 0; j < length; j++)
//            {
//                String word = words[j][Integer.parseInt("" + binary.charAt(j))];
//
//                for (int chInd = 0; chInd < word.length(); chInd++)
//                {
//                    temp[word.charAt(chInd) - 'a'] ++;
//                }
//            }
//
//            for (int ch = 0; ch < 26; ch++)
//            {
//                alphabet[ch] = Math.max(alphabet[ch], temp[ch]);
//                temp[ch] = 0;
//            }
//
//        }

        for(int letter = 0; letter < 26; letter++) {
            out.println(alphabet[letter]);
        }

        out.close();

    }
}
