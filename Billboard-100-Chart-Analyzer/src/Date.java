
public class Date implements Comparable<Date> {
	public int month;
	public int day;
	public int year;


	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
			
		
	}

	public int compareTo(Date other) {
		if (this.year != other.year) {
	        return Integer.compare(this.year, other.year);
	    } else if (this.month != other.month) {
	        return Integer.compare(this.month, other.month);
	    } else {
	        return Integer.compare(this.day, other.day);
	    }
	}
	
	public boolean equals(Date other) {
		 if (this.month == other.month && this.day == other.day && 
				 this.year == other.year) {
	            return true;
	        }
	        return false;
		}
	public String toString() {
        return  + month + "/" + day + "/" + year;
    }
	}


