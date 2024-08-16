import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.InputMismatchException;
import java.util.Scanner;
public class BillboardClient {
    
    	 private static final String OUTPUT_FILE = "output.txt";

    	    public static void main(String[] args) throws IOException, FileNotFoundException  {
    	        Scanner input = new Scanner(System.in);

    	        String outputFile = OUTPUT_FILE;

    	        
    	            Scanner songsIn = new Scanner(new FileReader("BillboardHot100.csv"));
    	            Billboard100 billboard = new Billboard100(songsIn);
    	            
    	            PrintWriter writer = new PrintWriter(outputFile);
    	           
    	               
    	                while (true) {
    	                    
    	                    theChoices(input, billboard, writer);
    	                    break;
    	                }
    	    }
    	    
    	  
    	         private static boolean theChoices(Scanner input, Billboard100 billboard, PrintWriter writer) throws IOException {
    	        	    boolean next = true;

    	        	    while (next) {
    	        	    	 String menuData = "1. Print all BillBoard 100 Songs\n" +
    	    	        				"2. Print songs that have been in the chart for more than 12 weeks\n" +
    	    	        				"3. Print songs in a specific week\n" +
    	    	        				"4. Search for perfomer\n" +
    	    	        				"5. Search for song\n" +
    	    	        				"6. Print songs with Instance greater than 1\n" +
    	    	        				"7. Print songs with Peak Position 1\n" +
    	    	        				"8. Print songs by WeekID\n" +
    	    	        				"9. Print songs in alphabetical order by song name\n" +
    	    	        			    "10. Print songs in alphabetical order by performer name\n" +
    	    	        			    "11.Exit the Program";
    	    	        				
    	    	        				System.out.println(menuData);

    	        	        int choice;
    	        	        try {
    	        	            choice = input.nextInt();
    	        	        } catch (InputMismatchException e) {
    	        	            System.out.println("\nInvalid input! Must be an integer.");
    	        	            input.nextLine(); // Consume the invalid input
    	        	            continue;
    	        	        }
    	        	      
    	        	        switch (choice) {
    	        	            case 1:
    	        	            	writer.flush();
    	        	                billboard.naturalOrder(writer);
    	        	                break;
    	        	            case 2:
    	        	            	writer.flush();
    	        	                billboard.moreThan12Weeks(writer);
    	        	                break;
    	        	            case 3:
    	        	            	writer.flush();
    	        	                billboard.songsInSpecificWeek(writer, input);
    	        	               break;
    	        	            case 4:
    	        	            	writer.flush();
    	        	                billboard.searchForPerformer(writer, input);
    	        	                break;
    	        	            case 5:
    	        	            	writer.flush();
    	        	                billboard.searchForSongName(writer, input);
    	        	               break;
    	        	            case 6:
    	        	            	writer.flush();
    	        	                billboard.instanceGreaterThan1(writer);
    	        	                break;
    	        	            case 7:
    	        	            	writer.flush();
    	        	                billboard.peakPosition1(writer);
    	        	              break;
    	        	            case 8:
    	        	            	writer.flush();
    	        	                billboard.orderByWeekID(writer);
    	        	               break;
    	        	            case 9:
    	        	                billboard.orderBySongName(writer);
    	        	               break;
    	        	            case 10:
    	        	            	writer.flush();
    	        	                billboard.orderByPerformerName(writer);
    	        	              break;  
    	        	            case 11:
    	        	                System.out.println("End");
    	        	                next = false;
    	        	              break;
    	        	            default:
    	        	                System.out.println("Invalid choice. Please choose a number from the menu.");
    	        	        }
    	        	        
    	        	     
    	        	 
    	        	    }

    	        	  
    	        	  
						return next;
    	        	   
    	        	   

    }
    	         
}
	

