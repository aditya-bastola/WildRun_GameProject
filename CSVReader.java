// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.io.*;

// reads csv file into into a 2d array 
public class CSVReader {
	
	// reads csv file put it into a 2d array
	// array will later be used to put each sprite in their positions
	public static int [] [] readCSV (String fileName)
	{
		BufferedReader fileReader = null;

		int i = 0;
		final String DELIMITER = ",";
		int [] [] csvArray;
		int rowCount = 0;
		int columnCount = 0;


		try {

			String line = "";

			fileReader =  new BufferedReader(new FileReader (fileName));

			while(( line = fileReader.readLine()) != null)
			{
				i += 1;
				String [] tokens =  line.split(DELIMITER);
				columnCount = tokens.length;
			}

		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		finally {

			try {
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}
		
		//read again to add to csvArrary

		rowCount = i;

		csvArray = new int [rowCount] [columnCount];

		i = 0;

		try {

			String line = "";

			fileReader =  new BufferedReader(new FileReader (fileName));

			while(( line = fileReader.readLine()) != null)
			{

				String [] tokens =  line.split(DELIMITER);
				for (int j = 0; j < tokens.length; j++)
				{
					csvArray [i] [j] = Integer.parseInt( tokens[j]); 
				}

				i += 1;
			}
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		finally {

			try {
				fileReader.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

		}

		
		return csvArray;

	}
}
