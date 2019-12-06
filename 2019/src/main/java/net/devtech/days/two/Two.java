package net.devtech.days.two;

import net.devtech.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Two {
	public static void main(String[] args) throws IOException {
		List<Integer> ints = Arrays.stream(Util.getURL("https://adventofcode.com/2019/day/2/input").collect(Collectors.joining()).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		final int range = 100;
		for (int i = 0; i < range; i++) {
			for (int i1 = 0; i1 < range; i1++) {
				List<Integer> copy = new ArrayList<>(ints);
				copy.set(1, i);
				copy.set(2, i1);
				if(interpret(copy) == 19690720)
					System.out.println(i * 100 + i1);
			}
		}

	}

	public static int interpret(List<Integer> ints) {
		for (int i = 0; i < ints.size(); i += 4) {
			int current = ints.get(i);
			if (current == 1) { // add opcode
				ints.set(ints.get(i + 3), ints.get(ints.get(i + 1)) + ints.get(ints.get(i + 2)));
			} else if (current == 2) { // mul opcode
				ints.set(ints.get(i + 3), ints.get(ints.get(i + 1)) * ints.get(ints.get(i + 2)));
			} else if (current == 99) break;
		}
		return ints.get(0);
	}
}
