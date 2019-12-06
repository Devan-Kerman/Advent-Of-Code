package net.devtech.days.two;

import com.aparapi.Kernel;
import com.aparapi.Range;
import net.devtech.util.Util;
import scala.Int;
import java.util.Arrays;

public class Day2Kernel extends Kernel {
	private int[] val = {0, 0};
	private int[] intcodes;

	public Day2Kernel(int[] intcodes) {
		this.intcodes = intcodes;
	}

	@Override
	public void run() {
		test(getGlobalId(0), getGlobalId(1));
	}

	private void test(int x, int y) {
		intcodes[1] = x;
		intcodes[2] = y;
		for (int i = 0; i < intcodes.length; i += 4) {
			int current = intcodes[i];
			if (current == 1) { // add opcode
				int i1 = intcodes[i + 1];
				int i2 = intcodes[i + 2];
				int i3 = intcodes[i + 3];

				int val1 = intcodes[i1];
				int val2 = intcodes[i2];
				int val3 = val1+val2;
				intcodes[i3] = val3;
			} else if (current == 2) { // mul opcode
				int i1 = intcodes[i + 1];
				int i2 = intcodes[i + 2];
				int i3 = intcodes[i + 3];
				int val1 = intcodes[i1];
				int val2 = intcodes[i2];
				int val3 = val1*val2;
				intcodes[i3] = val3;
			} else if (current == 99) i = intcodes.length;
		}

		if (intcodes[0] == 19690720) {
			val[0] = x;
			val[1] = y;
			cancelMultiPass();
		}
	}

	public static void main(String[] args) {
		Day2Kernel kernel = new Day2Kernel(Util.getURL("https://adventofcode.com/2019/day/2/input").map(s -> s.split(",")).flatMap(Arrays::stream).mapToInt(Integer::parseInt).toArray());
		try {
			kernel.setExplicit(true);
			kernel.put(kernel.val);
			kernel.execute(Range.create2D(100, 100));
			kernel.get(kernel.val);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(kernel.val[0] * 100 + kernel.val[1]);
	}
}
