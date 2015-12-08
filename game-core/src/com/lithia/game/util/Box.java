package com.lithia.game.util;

public class Box
{
	
	private int x, y;
	private int w, h;
	
	public Box(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.w = width;
		this.h = height;
	}
	
	public static boolean collide(Box a, Box b)
	{
		return !(a.x > b.x + b.w ||
				 a.x + a.w < b.x ||
				 a.y > b.y + b.h ||
				 a.y + a.h < b.y);
	}
	
	public static boolean inside(Box a, Box b)
	{
		return 	a.x > b.x &&
				a.y > b.y &&
				a.x + a.w < b.x + b.w &&
				a.y + a.h < b.y + b.h;
	}
	
}
