package net.devtech;

import org.openjdk.jmh.annotations.*;

import static net.devtech.days.four.Four.repeatingAndIncreasing;
import static net.devtech.days.four.Four.repeatingAndIncreasingAndNotOverrepeating;

public class FourBench {
	public static final int start = 359282;
	public static final int end = 820401;


	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public int partOne() {
		int counter = 0;
		for (int i = start; i <= end; i++)
			if (repeatingAndIncreasing(i)) counter++;
		return counter;
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public int partTwo() {
		int counter = 0;
		for (int i = start; i <= end; i++)
			if (repeatingAndIncreasingAndNotOverrepeating(i)) counter++;
		return counter;
	}
}
