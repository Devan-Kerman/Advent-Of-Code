package net.devtech.days.four;

public class Four {
	private static final int DIGITS = 6;

	public static void main(String[] args) {
		int start = 359282; // put ur start here
		int end = 820401; // put ur end here

		// part one
		int counter = 0;
		for (int i = start; i <= end; i++)
			if (repeatingAndIncreasing(i)) counter++;
		System.out.println(counter);

		// part 2
		int counter2 = 0;
		for (int i = start; i <= end; i++)
			if (repeatingAndIncreasingAndNotOverrepeating(i))
				counter2++;
		System.out.println(counter2);
	}


	public static boolean repeatingAndIncreasing(int number) {
		boolean repeats = false;
		for (int i = 0; i < DIGITS; i++) {
			int scale = (int) Math.pow(10, i);
			int val = (number / scale) % 10;
			int next = (number / (scale * 10)) % 10;
			if (val == next) repeats = true;
			if (next > val) return false;
		}
		return repeats;
	}

	public static boolean repeatingAndIncreasingAndNotOverrepeating(int number) {
		boolean repeats = false;
		for (int i = 0; i < DIGITS; i++) {
			int scale = (int) Math.pow(10, i);
			int val = (number / scale) % 10;
			int next = (number / (scale * 10)) % 10;
			if (next > val)
				return false;
			if (scale > 1 && (number / (scale / 10)) % 10 == val && val == next)
				continue;
			int next_next = (number / (scale * 100)) % 10;
			if (val == next && next != next_next)
				repeats = true;
		}
		return repeats;
	}
}
