package main;

import entity.Entity;

public class Vector2D {
	public double x;
	public double y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	public Vector2D() {
		this.x = 0;
		this.y = 0;
		
	}
	public void move(Entity entity, Vector2D direct) {
		direct.normalize();
		direct = direct.times(entity.speed);
		direct.x = Math.round(direct.x);
		direct.y = Math.round(direct.y);
		entity.worldPos = entity.worldPos.add(direct);
		
		
	}
	public void normalize() {
        double length = Math.sqrt(x * x + y * y);

        if (length != 0.0) {
            this.x /= length;
            this.y /= length;
        }
    }

	public double magnitude() {
		 final double length = Math.sqrt(x * x + y * y);
		return length;
	}
	
	
	
	public String toString() {
        return "(" + x + ", " + y + ")";
    }
	
	public Vector2D sub(Vector2D vector) {
	    return new Vector2D(this.x - vector.x, this.y - vector.y);
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
