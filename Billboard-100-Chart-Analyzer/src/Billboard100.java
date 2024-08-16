import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Billboard100 {

   private SortedArrayCollection<Song> song = new SortedArrayCollection<>();

    public Billboard100(Scanner input) {
  
        addingSongs(input);
    }

    private void addingSongs(Scanner input) {
      input.nextLine();
       
        while (input.hasNext()) {
            String[] string = input.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            String chartURL = string[0];
            String stringD = string[1];
            String[] arrayD = stringD.split("/");
            int month = Integer.valueOf(arrayD[0]);
            int day = Integer.valueOf(arrayD[1]);
            int year = Integer.valueOf(arrayD[2]);
            Date weekId = new Date(month, day, year);
            String songName = string[2];
            String performerName = string[3];
            String songId = string[4];
            Integer instance = Integer.valueOf(string[5]);
            Integer position = Integer.valueOf(string[6]);
            Integer weeksOnChart = Integer.valueOf(string[7]);
            Song aSong = new Song(chartURL, weekId, songName, performerName, songId, instance, position, weeksOnChart);
            song.add(aSong);
           
        }
    }
   
    public void naturalOrder(PrintWriter writer) throws IOException  {
		writer.write("----- NATURAL ORDER-----\n\n");
		Iterator<Song> iter = song.iterator();
		while (iter.hasNext()) {
			Song song = iter.next();
			writer.append(song.toString());
			writer.write("\n");
			writer.flush();
		
			
		}
     
    }

    public void moreThan12Weeks(PrintWriter writer) throws IOException {
        		
		writer.write("----- OVER 12 WEEKS -----\n\n");
		Iterator<Song> iter = song.iterator();
		while (iter.hasNext()) {
			Song song = (Song)iter.next();
			if (song.weeksOnChart > 12) {
					writer.append(song.toString());
					writer.write("\n");
					writer.flush();
				
				}
			
			}
    }

    public void songsInSpecificWeek(PrintWriter writer, Scanner input) throws IOException {
        Scanner question = new Scanner(System.in);
        System.out.println("Please enter the specific week format: mm/dd/yyyy ");
        String answer = question.nextLine();
        String[] date = answer.split("/");
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        
       
        writer.write("----- WHEN SEARCH SPECIFIC WEEK -----\n\n");
        Iterator<Song> iter = song.iterator();
        while(iter.hasNext()) {
        	Song song = (Song)iter.next();
        	if(song.weekID.equals(new Date(day,month,year))) {
        		writer.append(song.toString());
				writer.write("\n");
				writer.flush();
			
        	}
        }
        
    }

    public  void searchForPerformer(PrintWriter writer, Scanner input) throws IOException {
        Scanner performer = new Scanner(System.in);
        System.out.println("Enter a performer name");
        String name = performer.nextLine();
     
        writer.write("----- SEARCH FOR PERFORMER -----\n\n");
        Iterator<Song> iter = song.iterator();
        while(iter.hasNext()) {
        	Song song = (Song)iter.next();
        	if(song.performerName.equals(name)) {
        		writer.append(song.toString());
				writer.write("\n");
				writer.flush();
				
    }
   }
        
  }
    

    public void searchForSongName(PrintWriter writer, Scanner input) throws IOException {
    	  Scanner songs = new Scanner(System.in);
          System.out.println("Enter a song name");
          String nameOfSong = songs.nextLine();
         
          writer.write("----- SEARCH FOR SONG -----\n\n");
          Iterator<Song> iter = song.iterator();
          while(iter.hasNext()) {
          	Song song = (Song)iter.next();
          	if(song.songName.toLowerCase().equals(nameOfSong)) {
          		writer.append(song.toString());
  				writer.write("\n");
  				writer.flush();
  				
    }
   }
 }

    public void instanceGreaterThan1(PrintWriter writer) throws IOException {
    	writer.write("----- INSTANCE GREATER THAN 1 -----\n\n");
		Iterator<Song> iter = song.iterator();
		while (iter.hasNext()) {
			Song song = (Song)iter.next();
			if (song.instance > 1) {
					writer.append(song.toString());
					writer.write("\n");
					writer.flush();
    }
		}
    }

    public void peakPosition1(PrintWriter writer) throws IOException {
    	writer.write("----- PEAK POSITION IS 1-----\n\n");
		Iterator<Song> iter = song.iterator();
		while (iter.hasNext()) {
			Song song = (Song)iter.next();
			if (song.peakPosition == 1) {
					writer.append(song.toString());
					writer.write("\n");
					writer.flush();
    }
		}
    }

    public  void orderByWeekID(PrintWriter writer) throws IOException {
    	SortedArrayCollection<Song> list2 = new SortedArrayCollection<>(Song.weekIDComparator());
        Iterator<Song> iter = song.iterator();

        while (iter.hasNext()) {
            Song song = iter.next();
            list2.add(song);
        }

        Iterator<Song> iter2 = list2.iterator();
        writer.write("----- ORDER BY WEEK ID -----\n\n");

        while (iter2.hasNext()) {
            Song song = iter2.next();
            writer.append(song.toString());
            writer.write("\n");
            writer.flush();
        }
    }
         	
         	
    
   
    


    public void orderBySongName(PrintWriter writer) throws IOException {
      	SortedArrayCollection<Song> list2 = new SortedArrayCollection<>(Song.songNameComparator());
        Iterator<Song> iter = song.iterator();

        while (iter.hasNext()) {
            Song song = iter.next();
            list2.add(song);
        }

        Iterator<Song> iter2 = list2.iterator();
        writer.write("----- ORDER BY SONG NAME-----\n\n");

        while (iter2.hasNext()) {
            Song song = iter2.next();
            writer.append(song.toString());
            writer.write("\n");
            writer.flush();
        }
    }

    public void orderByPerformerName(PrintWriter writer) throws IOException {
       	SortedArrayCollection<Song> list2 = new SortedArrayCollection<>(Song.performerNameComparator());
        Iterator<Song> iter = song.iterator();

        while (iter.hasNext()) {
            Song song = iter.next();
            list2.add(song);
        }
      

        Iterator<Song> iter2 = list2.iterator();
        writer.write("----- ORDER BY PERFORMER NAME -----\n\n");

        while (iter2.hasNext()) {
            Song song = iter2.next();
            writer.append(song.toString());
            writer.write("\n");
            writer.flush();
           
        }
      
    }
  
}

