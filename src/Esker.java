import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Esker
{
	public static void main(String[] args)
	{
		int[] counts = new int[20];
		int totspaces = 0, totwords = 0, totchars = 0, totlines = 0, totfigs = 0, totspec = 0;
		try(Scanner stdin = new Scanner(new File("input.txt")))
		{
			while(stdin.hasNextLine())
			{
				++totlines;
				String line = stdin.nextLine();
				String[] words = line.split(" ");
				totspaces += (words.length - 1);
				totwords += words.length;
				for(String w : words)
				{
					totchars += w.length();
					if(w.length() <= 19 && w.length() > 0)
					{
						counts[w.length()-1] = ++counts[w.length()-1];
					}
					for(int i = 0; i < w.length(); ++i)
					{
						if(!Character.isLetter(w.charAt(i)))
						{
							++totspec;
						}
					}
				}
			}
			System.out.println("Number of lines: " + totlines);
			System.out.println("Number of spaces: " + totspaces);
			System.out.println("Number of characters: " + totchars);
			System.out.println("Number of words: " + totwords);
			System.out.println("Number of special characters: " + totspec);
			for(int i = 0; i < counts.length; ++i)
			{
				System.out.println("Number of " + (i+1) +" letter words: " + counts[i]);
				
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File named input.txt could not be found");
		}
	}
}
