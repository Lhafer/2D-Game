package main;

import entity.Entity;

public class Vector2D {
	public int x;
	public int y;
	public int delta;
	public Vector2D(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		delta = speed;
		
	}
	public Vector2D() {
		this.x = 0;
		this.y = 0;
		delta = 0;
		
	}
	
	public void move(int speed, Entity entity) {
		
	}
}
