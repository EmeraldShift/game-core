package com.lithia.game.gfx;

public class Bitmap
{
	
	public int w, h;
	public int[] pixels;
	private int color = 0x000000;
	
	public Bitmap(int w, int h)
	{
		this.w = w;
		this.h = h;
		
		pixels = new int[w * h];
	}
	
	public void draw(Bitmap b, int xo, int yo)
	{
		for(int y = 0; y < b.h; y++)
		{
			int yy = y + yo;
			if(yy < 0 || yy >= h) continue;
			
			for(int x = 0; x < b.w; x++)
			{
				int xx = x + xo;
				if(xx < 0 || xx >= w) continue;
				
				int p = b.pixels[x + y * b.w];
				
				if(p != 0xffff00ff && p != 0xff00ff)
					pixels[xx + yy * w] = p;
			}
		}
	}
	
	public void setClearColor(int color)
	{
		this.color = color;
	}
	
	public void clear()
	{
		for(int i = 0; i < pixels.length; i++)
		{
			pixels[i] = color;
		}
	}
	
}
