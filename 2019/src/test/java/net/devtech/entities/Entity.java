package net.devtech.entities;

public class Entity {
	private Location location;
	private BoundingBox bounds;

	public Entity(Location location, BoundingBox box) {
		this.location = location;
		this.bounds = box;
	}

	public Entity(Location location, double width, double height, double depth) {
		this(location, new BoundingBox(width, height, depth));
	}

	public Entity(double x, double y, double z, BoundingBox box) {
		this(new Location(x, y, z), box);
	}

	public Entity(double x, double y, double z, double width, double height, double depth) {
		this(x, y, z, new BoundingBox(width, height, depth));
	}

	public double getX() {
		return location.getX();
	}

	public double getY() {
		return location.getY();
	}

	public double getZ() {
		return location.getZ();
	}

	public double getHeight() {
		return bounds.getHeight();
	}

	public double getWidth() {
		return bounds.getWidth();
	}

	public double getDepth() {
		return bounds.getDepth();
	}

	public BoundingBox getBounds() {
		return bounds;
	}
}
