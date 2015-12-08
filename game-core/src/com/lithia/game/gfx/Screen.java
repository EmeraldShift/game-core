package com.lithia.game.gfx;

import com.lithia.game.Game;

public class Screen extends Bitmap
{
	
	public Screen(int w, int h)
	{
		super(w, h);
	}
	
	public void render(Game game)
	{
		clear();
		game.getWorld().render();
		
		draw(game.getWorld().getDrawGraphics(), game.scrollX, game.scrollY);
	}

}
