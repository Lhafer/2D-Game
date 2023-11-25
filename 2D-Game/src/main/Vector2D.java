package main;

import entity.Entity;

public class Vector2D {
	public double x;
	public double y;

	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	public Vector2D() {
		this.x = 0;
		this.y = 0;
		
	}
	public void move(Entity entity, Vector2D direct) {
		direct.normalize();
		System.out.println(direct);
		entity.worldPos = entity.worldPos.add(direct.times(entity.speed));
		
	}
	public void normalize() {
        double length = FastInverseSqrt(x * x + y * y);

        if (length != 0.0) {
            this.x *= length;
            this.y *= length;
        }
    }
	
	private static double FastInverseSqrt(double x) {
        long longBits = Double.doubleToLongBits(x);
        double y = Double.longBitsToDouble(0x5FE6EB50C7B537AAL - (longBits >> 1));
        return y * (1.5 - 0.5 * x * y * y);
    }
	
	public String toString() {
        return "(" + x + ", " + y + ")";
    }
	
	public Vector2D sub(Vector2D vector) {
		x -= vector.x;
		y -= vector.y;
		return this;
	}
	
	public Vector2D add(Vector2D vector) {
		
		x += vector.x;
		y += vector.y;
		return this;
	}
	
	public Vector2D times(int scale) {
		x *= scale;
		y *= scale;
		return this;
	}
}
