package com.lithia.game.entity;

import com.lithia.game.gfx.Bitmap;

/**
 * Basic helper class to handle entities. Will probably have a lot more
 * functionality later.
 */
public class EntityHelper
{
	
	private static EntityHelper instance;
	
	private EntityHelper() {}
	
	public static EntityHelper getInstance()
	{
		if (instance == null) instance = new EntityHelper();
		return instance;
	}
	
	public void renderEntity(Entity e, int x, int y, Bitmap screen)
	{
		screen.draw(e.getDrawGraphics(), x, y);
	}
	
}
