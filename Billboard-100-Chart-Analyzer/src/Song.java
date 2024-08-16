import java.util.Comparator;

public class Song implements Comparable<Song> {
    public String chartURL;
    public Date weekID;
    public String songName;
    public String performerName;
    public String songID;
    public int instance;
    public int peakPosition;
    public int weeksOnChart;
	

    // constructor
    public Song(String chartURL, Date weekID, String songName, String performerName, String songID,
                int instance, int peakPosition, int weeksOnChart) {
        this.chartURL = chartURL;
        this.weekID = weekID;
        this.songName = songName;
        this.performerName = performerName;
        this.songID = songID;
        this.instance = instance;
        this.peakPosition = peakPosition;
        this.weeksOnChart = weeksOnChart;
    }

    // compareTo
    @Override
    public int compareTo(Song o) {
        return songID.compareTo(o.songID);
    }
    
    // comparators
	public static Comparator<Song> weekIDComparator() {
		 return new Comparator<Song>() {
		        public int compare(Song element1, Song element2) {
		            return element1.weekID.compareTo(element2.weekID);
		        }
		 };
	}

    public static Comparator<Song> songNameComparator() {
        return new Comparator<Song>() {
            public int compare(Song element1, Song element2) {
                return element1.songName.compareTo(element2.songName);
            }
        };
    }

    public static Comparator<Song> performerNameComparator() {
        return new Comparator<Song>() {
            public int compare(Song element1, Song element2) {
                return element1.performerName.compareTo(element2.performerName);
            }
        };
    }

    public static Comparator<Song> instance() {
        return new Comparator<Song>() {
            public int compare(Song element1, Song element2) {
                if (element1.instance == element2.instance)
                    return element1.performerName.compareTo(element2.performerName);
                else {
                    return Integer.compare(element2.instance, element1.instance);
                }
            }
        };
    }

    public boolean performedBy(String performerName) {
        return this.performerName.equalsIgnoreCase(performerName);
    }
	
    public String getName() {
        return songName;
    }

    public String toString() {
        return chartURL + ", " + weekID + ", " + songName + ", " + performerName + ", " +
                songID + ", " + instance + ", " + peakPosition + ", " + weeksOnChart;
    }
}