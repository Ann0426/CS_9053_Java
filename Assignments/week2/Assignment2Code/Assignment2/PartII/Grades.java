import java.util.Scanner;  
public class Grades {

	public static char letterGrade(float score) {
		  char grade = 'F';
		  if (score >= 90)
	      {
	        grade = 'A';
	        return grade;
	      }
	      else if (score >= 80)
	      {
	    	 grade = 'B';
	    	 return grade;
	      }
	      else if (score >= 70)
	      {
	         grade = 'C';
	         return grade;
	      }
	      else if (score >= 60)
	      {
	         grade = 'D';
	         return grade;
	      }
	      else
	      {
	         grade = 'F';
	         return grade;
	      }
		  
		  
		
		
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * score using Scanner because you will have to convert
		 * a command line argument to a float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "score" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		
		 
		// Create a Scanner object to read input.
	    Scanner console = new Scanner(System.in);
	    // Get the test score.
	    System.out.print("Enter your numeric test score : ");
	    float score = console.nextFloat();
		
		// Calculate the grade.
	    char grade = letterGrade(score);
		if (score >= 0) {
		// if the grade is not null print this out:
		System.out.println("The grade for a score of " + score + " is " + grade);}
		else {// if the grade is null, print this out:
		System.out.println("invalid score");}
		
	}
}
