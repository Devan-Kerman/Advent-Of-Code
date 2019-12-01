package net.devtech.days;

import net.devtech.util.Util;
import java.io.IOException;

public class One {
	public static void main(String[] args) throws IOException {
		System.out.println(Util.getURL("https://adventofcode.com/2019/day/1/input").mapToInt(Integer::parseInt).map(i -> i / 3).map(i -> i - 2).sum());
	}

}
