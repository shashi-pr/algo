package java8.stream;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;

public class TestStream {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Find all transactions in the year 2011 and sort them by value (small
		// to high).
		List<Transaction> tr2011Sorted = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(comparing(Transaction::getValue)).collect(toList());
		System.out.println(tr2011Sorted);

		// What are all the unique cities where the traders work?
		List<String> uniqueCities = transactions.stream().map(t -> t.getTrader().getCity()).distinct()
				.collect(toList());
		System.out.println(uniqueCities);

		// Find all traders from Cambridge and sort them by name.
		List<Trader> tradersFromCambridge = transactions.stream().map(t -> t.getTrader())
				.filter(t -> t.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName))
				.collect(toList());
		System.out.println(tradersFromCambridge);

		// Return a string of all traders’ names sorted alphabetically
		String tradersNames = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted()
				.collect(joining());
		System.out.println(tradersNames);

		// Are any traders based in Milan?
		boolean anyTraderFromMilan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(anyTraderFromMilan);

		// Print the values of all transactions from the traders living in
		// Cambridge.
		transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue)
				.forEach(System.out::println);
		
		//What’s the highest value of all the transactions?
		
		
	}

}
