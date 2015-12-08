package com.lithia.game;

import com.lithia.game.entity.mob.Turkey;
import com.lithia.game.world.World;

public class Game
{
	
	private int time;
	private World world;
	public int scrollX, scrollY;
	
	public Game()
	{
		world = new World(1500, 160);
		world.getDrawGraphics().setClearColor(0xaaccee);
		
		world.addEntity(new Turkey(0, 0));
	}
	
	public void tick()
	{
		time++;
	}
	
	public World getWorld()
	{
		return world;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public void update()
	{
		tick();
		
		world.update();
	}
	
}
