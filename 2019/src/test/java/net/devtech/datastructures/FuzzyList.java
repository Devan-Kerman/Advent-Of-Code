package net.devtech.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FuzzyList<T> {
	private static final int DEFAULT_SIZE = 128;
	private List<T>[] values;
	public FuzzyList(int initialCapacity) {
		values = new List[initialCapacity];
		Arrays.setAll(values, i -> new ArrayList<>());
	}

	public FuzzyList() {
		this(DEFAULT_SIZE);
	}

	public void add(int x, int y, int z, T item) {
		values[index(x, y, z)].add(item);
	}

	public List<T> get(int x, int y, int z) {
		return values[index(x, y, z)];
	}

	public static void main(String[] args) {
		FuzzyList<Integer> ints = new FuzzyList<>();
		Random random = new Random();
		final int amount = 1000;
		for (int i = 0; i < amount; i++)
			ints.add(random.nextInt(), random.nextInt(), random.nextInt(), random.nextInt());
		System.out.println(ints);
	}

	@Override
	public String toString() {
		return "FuzzyList{" + "values=" + Arrays.toString(values) + '}';
	}

	public int index(int x, int y, int z) {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + z;
		return (result < 0 ? -result : result) % values.length;
	}
}
