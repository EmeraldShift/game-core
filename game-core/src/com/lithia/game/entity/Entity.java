package com.lithia.game.entity;

import com.lithia.game.gfx.Bitmap;
import com.lithia.game.util.Box;
import com.lithia.game.world.World;

/**
 * This engine is 100% entity-based, meaning every game object, including
 * terrain and static structures, is stored as an entity, and shares the same
 * properties as all other entities. [TODO modularize static structures, etc.]
 */
public abstract class Entity
{

	private float x, y;
	private Bitmap draw;
	private Box box;
	private World parent;

	public Entity(int x, int y, Bitmap draw)
	{
		this.x = x;
		this.y = y;
		this.draw = draw;

		box = new Box(x, y, draw.w, draw.h);
	}

	protected void init()
	{
	}

	public void update()
	{
		if (parent != null)
			parent.setRedraw(true);
	}

	public int getX()
	{
		return (int) x;
	}

	public int getY()
	{
		return (int) y;
	}

	public Bitmap getDrawGraphics()
	{
		return draw;
	}

	public boolean collides(Entity e)
	{
		return Box.collide(box, e.getBoundingBox());
	}

	public Box getBoundingBox()
	{
		return box;
	}

	public void setParent(World parent)
	{
		this.parent = parent;
	}
	
}
