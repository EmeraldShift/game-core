package com.lithia.game;

public class Game
{
	
	int time;
	
	public void tick()
	{
		time++;
	}
	
	public void update()
	{
		tick();
		
		// game stuff
	}
	
}
