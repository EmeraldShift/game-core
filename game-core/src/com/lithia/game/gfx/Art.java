package com.lithia.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Art
{
	
	public static final Bitmap TURKEY = loadBitmap("turkey.png");
	
	private static Bitmap loadBitmap(String fileName)
	{
		Bitmap ret = null;
		
		try
		{
			BufferedImage img = ImageIO.read(Art.class.getResource("/tex/" + fileName));
			ret = new Bitmap(img.getWidth(), img.getHeight());
			
			img.getRGB(0, 0, ret.w, ret.h, ret.pixels, 0, ret.w);
		}
		catch(IOException e)
		{
			System.out.println("Could not load file from " + fileName + ": " + e.getMessage());
		}
		
		return ret;
	}
	
}
