package strings;

public class StringIndexes {

	public static void main(String[] args) {
		
		String className = "Introduction to Java Programming";
		System.out.println("Index of the first occurence of 'n' is " +
							className.indexOf('n'));
		System.out.println("Index of the last occurence of 'n' is " +
				className.lastIndexOf('n'));
		System.out.println("Index of the first occurence of \"ro\" is " +
				className.indexOf("ro"));
		System.out.println("Index of the last occurence of \"ro\" is " +
			className.lastIndexOf("ro"));
	}
}
