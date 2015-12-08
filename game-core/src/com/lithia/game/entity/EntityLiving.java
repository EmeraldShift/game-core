package com.lithia.game.entity;

import com.lithia.game.entity.ai.AIController;
import com.lithia.game.gfx.Bitmap;

public class EntityLiving extends Entity
{
	
	private AIController controller;
	
	public EntityLiving(int x, int y, Bitmap draw)
	{
		super(x, y, draw);
		
		controller = new AIController(this);
	}
	
	public void update()
	{
		controller.execute();
	}
	
	public AIController getController()
	{
		return controller;
	}
	
}
