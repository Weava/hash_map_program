//***********************************************************************
// CS4343 - Program 4
// Weaver, Aaron
//
// A Hashing program that stores each word in a dictionary, and then
// compares the added values with text contained in a second .txt file.
// **********************************************************************


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Aaron L. Weaver
 * @version 1.0
 * @since 2014-4-17
 */
public class Program4
{
    /**
     * The main function grabs all the values from two seperate files,
     * the first file's words are added to a Hash map, the second
     * file's words are compared with those to see if they are in
     * the ADT.
     * @param args filename to be parsed
     * @return void
     */
	public static void main(String[] args)
	{
        SetOfStrings set = new SetOfStrings(200159);
        //Absolute address of the dictionary
		String csxFile = "/usr/share/dict/words";
		String argFile = "";
		if(args.length > 0)
		{
			argFile = args[0];
		}
		else
		{
			System.out.println("There was no command line file presented");
			System.exit(1);
		}

        String line = "";

        try 
        {
            FileReader fr = new FileReader(csxFile);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("Loading...");

            while((line = br.readLine()) != null)
            {
                String[] lineArr = line.split(" ");
                String[] toAdd = lineParser(lineArr, true);
                for(int i = 0; i < toAdd.length; i++)
                {
                    set.add(toAdd[i]);
                }
            }

            System.out.println("Done");

            FileReader fr2 = new FileReader(argFile);
            BufferedReader br2 = new BufferedReader(fr2);

            //Max, min, etc.
            int max = 0;
            int min = Integer.MAX_VALUE;
            int avg = 0;
            int count = 0;
            int sum = 0;

            while((line = br2.readLine()) != null)
            {
                int comparisons = 0;
                count++;
                String[] lineArr = line.split(" ");
                String[] toSearch = lineParser(lineArr, false);
                
                for(int i = 0; i < toSearch.length; i++)
                {
                    comparisons = set.contains(toSearch[i]);
                    sum += comparisons;
                    if(comparisons > max)
                    {
                        max = comparisons;
                    }
                    if(comparisons < min && comparisons >= 0)
                    {
                        min = comparisons;
                    }
                    if(comparisons > 0)
                    {
                        System.out.println(toSearch[i] + " " + comparisons + "\n");
                    }
                    else
                    {
                        System.out.println(toSearch[i] + " " + (-comparisons) + " " + "***NOT FOUND***\n");
                    }
                }
            }

            avg = sum/count;
            System.out.print("Size of set: " + set.getCount() + "\n");
            System.out.print("Min comparisons: " + min + "\n");
            System.out.print("Max comparisons: " + max + "\n");
            System.out.print("Avg comparisons: " + avg + "\n");
        }
        catch(IOException e)
        {
            System.out.println("The file " + csxFile + "could not be opened");
        }
	}

    /**
     * parses lines from the files, then tokenizes them.
     * @param args line read in from file
     * @param isCSX determines whether to be tokenized or not
     * @return String tokenized string
     */
    private static String[] lineParser(String[] lineArr, boolean isCSX)
    {
        String[] newArr = new String[lineArr.length];
        String line = "";
        for(int i = 0; i < lineArr.length; i++)
        {
            line = lineArr[i];
            if(!isCSX)
            {
                line = lineArr[i];
                line = line.replaceFirst("^[^a-zA-Z]+", "");
                line = line.replaceAll("[^a-zA-Z]+$", "");
            }
            line = line.toLowerCase();
            newArr[i] = line;
       }
       return newArr;
    }
}
