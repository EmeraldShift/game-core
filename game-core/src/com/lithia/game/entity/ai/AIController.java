package com.lithia.game.entity.ai;

import java.util.Vector;

import com.lithia.game.entity.EntityLiving;

public class AIController
{
	
	private Vector<AICommand> commands;
	private EntityLiving entity;
	
	public AIController(EntityLiving e)
	{
		this.entity = e;
		commands = new Vector<AICommand>();
	}
	
	public void addCommand(AICommand command)
	{
		commands.addElement(command);
	}
	
	public void execute()
	{
		for(AICommand c : commands)
		{
			c.execute(entity);
		}
	}
	
	
}
