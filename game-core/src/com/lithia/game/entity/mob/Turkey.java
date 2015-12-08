package com.lithia.game.entity.mob;

import com.lithia.game.entity.Entity;
import com.lithia.game.gfx.Art;

public class Turkey extends Entity
{

	public Turkey(int x, int y)
	{
		super(x, y, Art.TURKEY);
	}

	public void update()
	{
		x++;
	}
	
}
