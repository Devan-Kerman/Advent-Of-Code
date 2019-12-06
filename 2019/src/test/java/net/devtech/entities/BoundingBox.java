package net.devtech.entities;

public class BoundingBox {
	private double width, height, depth;

	public BoundingBox(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getDepth() {
		return depth;
	}

	public BoundingBox expand(double scale) {
		return new BoundingBox(width*scale, height*scale, depth*scale);
	}

}
