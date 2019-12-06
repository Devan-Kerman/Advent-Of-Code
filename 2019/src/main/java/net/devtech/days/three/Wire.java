package net.devtech.days.three;

import net.devtech.util.Util;
import java.awt.Point;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Wire {
	private Set<Point> wires = new HashSet<>();
	private int lx, ly;



	public void move(char code, int mod) {
		switch (code) {
			case 'R':
				addHorizontal(mod);
				break;
			case 'L':
				addHorizontal(-mod);
				break;
			case 'D':
				addVertical(mod);
				break;
			case 'U':
				addVertical(-mod);
				break;
		}
	}

	public int solve(Wire wire) {
		HashSet<Point> set = new HashSet<>(wires);
		set.retainAll(wire.wires);
		int curr = Integer.MAX_VALUE;
		for (Point point : set)
			if (distance(point) < curr) curr = distance(point);
		return curr;
	}

	public int solve2(Wire wire) {
		HashSet<Point> set = new HashSet<>(wires);
		set.retainAll(wire.wires);
		int curr = Integer.MAX_VALUE;
		for (Point point : set)
			if (stepsTo(point) + wire.stepsTo(point) < curr)
				curr = stepsTo(point) + wire.stepsTo(point);
		return curr;
	}

	public int stepsTo(Point point) {
		int steps = 0;
		for (Point wire : wires) {
			if (wire.equals(point))
				return steps;
			steps++;
		}
		throw new IllegalStateException("Impossible!");
	}

	public int distance(Point point) {
		return Math.abs(point.x) + Math.abs(point.y);
	}

	public static void main(String[] args) throws IOException {
		List<String[]> inputs = Util.getURL("https://adventofcode.com/2019/day/3/input").map(s -> s.split(",")).collect(Collectors.toList());
		Wire wire1 = parse(inputs.get(0));
		Wire wire2 = parse(inputs.get(1));
		System.out.println(wire1.solve(wire2));
		System.out.println(wire2.solve2(wire1));
	}

	public static Wire parse(String[] input) {
		Wire wire = new Wire();
		for (String s : input)
			wire.move(s.charAt(0), Integer.parseInt(s.substring(1)));
		return wire;
	}

	public void addHorizontal(int mx) {
		if (mx > 0) for (int i = 0; i < mx; i++)
			wires.add(new Point(lx += 1, ly));
		else for (int i = 0; i < Math.abs(mx); i++)
			wires.add(new Point(lx -= 1, ly));
	}

	public void addVertical(int my) {
		if (my > 0) for (int i = 0; i < my; i++)
			wires.add(new Point(lx, ly += 1));
		else for (int i = 0; i < Math.abs(my); i++)
			wires.add(new Point(lx, ly -= 1));
	}
}
