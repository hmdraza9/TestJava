package javaConcepts2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestStreamApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println("Using Java 7:\n\n");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("List: "+strings);
		System.out.println("Count empty Strings:"+getCountEmptyStringUsingJava7(strings));
		
		System.out.println("Count of strings with length 3: "+getCountOf3StringUsingJava7(strings));
		
		List<String> filteredStrings = getEmptyStringFilteredUsingJava7(strings);
		System.out.println("Empty filtered list: "+filteredStrings);
		
		Random random = new Random();
		System.out.println("Random numbers starts");
		for(int i=0;i<10;i++) {
			System.out.print("random.nextInt: "+random.nextInt()+"\n");
			System.out.print("random.nextBoolean: "+random.nextBoolean()+"\n");
			System.out.print("random.nextDouble: "+random.nextDouble()+"\n");
			System.out.print("random.nextFloat: "+random.nextFloat()+"\n");
			System.out.println("random.nextGaussian: "+random.nextGaussian()+"\n");
			System.out.println("random.nextInt(100): "+random.nextInt(100)+"\n");
			System.out.println("random.nextLong: "+random.nextLong()+"\n");
		}
		System.out.println("Random numbers ends");
		


		System.out.println("Using Java 8:\n\n");
		
		long count = strings.stream().filter(string->string.isEmpty()).count();
		System.out.println("Empty strings: "+count);
		
		count = strings.stream().filter(string->string.length()==3).count();
		System.out.println("Strings with length 3: "+count);
		
		List<String> filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
		System.out.println("Filtered list: "+filtered);
		
		String mergedString = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("String after merging: "+mergedString);
		
		List<Integer> number = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squareList = number.stream().map(i->i*i).distinct().collect(Collectors.toList());
		System.out.println("Squalre list: "+squareList);
		
		List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		IntSummaryStatistics stats = integers.stream().mapToInt((x)->x).summaryStatistics();
		System.out.println("Max#: "+stats.getMax());
		System.out.println("Min#: "+stats.getMin());
		System.out.println("Sum: "+stats.getSum());
		System.out.println("Average: "+stats.getAverage());
		
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		System.out.println("Using parallelStream:");
		count = strings.parallelStream().filter(string->string.isEmpty()).count();
		System.out.println("Count of empty strings: "+count);
		
		
	}

	private static List<String> getEmptyStringFilteredUsingJava7(List<String> strings) {
		// TODO Auto-generated method stub
		List<String> filteredList = new ArrayList<>();
		for(String string:strings) {
			if(!string.isEmpty())
				filteredList.add(string);
		}
		return filteredList;
	}

	private static int getCountOf3StringUsingJava7(List<String> strings) {
		// TODO Auto-generated method stub
		int count = 0;
		
		for(String string:strings) {
			if(string.length()==3)
				count++;
		}
		return count;
	}

	private static int getCountEmptyStringUsingJava7(List<String> strings) {
		// TODO Auto-generated method stub
		
		int count = 0;
		for(String string:strings) {
			if(string.isEmpty())
				count++;
		}
		
		return count;
	}

}
