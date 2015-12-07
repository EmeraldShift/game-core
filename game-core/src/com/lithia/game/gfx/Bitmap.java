package com.lithia.game.gfx;

public class Bitmap
{
	
	public int w, h;
	public int[] pixels;
	
	public Bitmap(int w, int h)
	{
		this.w = w;
		this.h = h;
		
		pixels = new int[w * h];
	}
	
	public void draw()
	{
		
	}
	
}
