import java.util.Scanner;

public class MuayThai {
	public static char letterGrade(int weight) {
		  char grade = 'F';
		  if (weight >= 0 && weight < 112 )
	      {
	        grade = 'A';
	        return grade;
	      }
	      else if (weight >= 112 && weight < 115)
	      {
	    	 grade = 'B';
	    	 return grade;
	      }
	      else if (weight >= 115 && weight < 118)
	      {
	         grade = 'C';
	         return grade;
	      }
	      else if (weight >= 118 && weight < 122)
	      {
	         grade = 'D';
	         return grade;
	      }
	      else if (weight >= 122 && weight < 126)
	      {
	         grade = 'E';
	         return grade;
	      }
	      else if (weight >= 126 && weight < 130)
	      {
	         grade = 'F';
	         return grade;
	      }
	      else if (weight >= 130 && weight < 135)
	      {
	         grade = 'G';
	         return grade;
	      }
	      else if (weight >= 135 && weight < 140)
	      {
	         grade = 'H';
	         return grade;
	      }
	      else if (weight >= 140 && weight < 147)
	      {
	         grade = 'I';
	         return grade;
	      }
	      else if (weight >= 147 && weight < 154)
	      {
	         grade = 'J';
	         return grade;
	      }
	      else if (weight >= 154 && weight < 160)
	      {
	         grade = 'K';
	         return grade;
	      }
	      else if (weight >= 160 && weight < 167)
	      {
	         grade = 'L';
	         return grade;
	      }
	      else if (weight >= 167 && weight < 175)
	      {
	         grade = 'M';
	         return grade;
	      }
	      else if (weight >= 175 && weight < 183)
	      {
	         grade = 'N';
	         return grade;
	      }
	      else if (weight >= 183 && weight < 190)
	      {
	         grade = 'O';
	         return grade;
	      }
	      else if (weight >= 190 && weight < 220)
	      {
	         grade = 'P';
	         return grade;
	      }
	      else
	      {
	         grade = 'Q';
	         return grade;
	      }
		  
		
	}
	
	
	public static String getWeightClass(char grade) {
		
		String weightClass = null;
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		

		  switch (grade) {
		    case 'A':
		    	weightClass = "Flyweight";
		      break;
		    case 'B':
		    	weightClass = "Super flyweight";
		      break;
		    case 'C':
		    	weightClass = "Bantamweight";
		      break;
		    case 'D':
		    	weightClass = "Super bantamweight";
		      break;
		    case 'E':
		    	weightClass = "Featherweight";
		      break;
		    case 'F':
		    	weightClass = "Super featherweight";
		      break;
		    case 'G':
		    	weightClass = "Lightweight";
		      break;
		      
		    case 'H':
		    	weightClass = "Super lightweight";
		      break;
		      
		    case 'I':
		    	weightClass = "Welterweight";
		      break;
		      
		    case 'J':
		    	weightClass = "Super welterweight";
		      break;
		      
		    case 'K':
		    	weightClass = "Middleweight";
		      break;
		      
		    case 'L':
		    	weightClass = "Super middleweight";
		      break;
		      
		    case 'M':
		    	weightClass = "Light heavyweight";
		      break;
		      
		    case 'N':
		    	weightClass = "Super light heavyweight";
		      break;
		      
		    case 'O':
		    	weightClass = "Cruiserweight";
		      break;
		      
		    case 'P':
		    	weightClass = "Heavyweight";
		      break;
		      
		    case 'Q':
		    	weightClass = "Super heavyweight";
		      break;
		      
		      
		  }

		  // Only change code above this line
		  return weightClass;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();
		char grade = letterGrade(pounds);
		String weightClass = getWeightClass(grade);
		
		if(pounds > 0)
		System.out.println("Weight class for " + pounds + " is "+ weightClass);
		
		// if for some reason you put in a negative number of pounds:
		else
		System.out.println("Invalid weight value");
	}
}
