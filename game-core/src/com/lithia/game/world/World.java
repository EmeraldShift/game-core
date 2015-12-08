package com.lithia.game.world;

import java.util.Vector;

import com.lithia.game.entity.Entity;
import com.lithia.game.gfx.Bitmap;

/**
 *	Simple world class to hold a bunch of stuff, including entities.
 */
public class World
{
	
	@SuppressWarnings("unused")
	private int width, height;
	private Vector<Entity> entities;
	private Bitmap draw;
	private boolean redraw;
	
	public World(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.draw = new Bitmap(width, height);
		
		entities = new Vector<Entity>();
		redraw = true;
	}
	
	public void render()
	{
		if(redraw)
		{
			draw.clear();
			
			for(Entity e : entities)
			{
				draw.draw(e.getDrawGraphics(), e.getX(), e.getY());
			}
			
			redraw = false;
		}
	}
	
	public Bitmap getDrawGraphics()
	{
		return draw;
	}
	
	public void addEntity(Entity e)
	{
		entities.addElement(e);
		e.setParent(this);
	}
	
	public void removeEntity(Entity e)
	{
		entities.remove(e);
	}
	
	public Vector<Entity> getEntities()
	{
		return entities;
	}

	public void update()
	{
		for(Entity e : entities)
		{
			e.update();
		}
		
		redraw = true;
	}

	public void setRedraw(boolean redraw)
	{
		this.redraw = redraw;
	}
	
}
