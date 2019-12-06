package net.devtech.days.one;

import net.devtech.util.Util;
import java.io.IOException;

public class One {
	public static void main(String[] args) throws IOException {
		System.out.println("Part 1");
		System.out.println(Util.getURL("https://adventofcode.com/2019/day/1/input").mapToInt(Integer::parseInt).map(i -> i / 3).map(i -> i - 2).sum());
		System.out.println("Part 2");
		int sum = Util.getURL("https://adventofcode.com/2019/day/1/input").mapToInt(Integer::parseInt).map(i -> {
			int temp = i / 3 - 2;
			int fuel = 0;
			while (temp > 0) {
				fuel += temp;
				temp = temp / 3 - 2;
			}
			return fuel;
		}).sum();
		System.out.println(sum);
	}

}
