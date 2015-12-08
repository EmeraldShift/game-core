package com.lithia.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lithia.game.gfx.Screen;

public class Component extends Canvas implements Runnable
{
	
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "Game";
	private static final double FRAME_RATE = 60.0;
	public static final int WIDTH = 240;
	public static final int HEIGHT = 160;
	public static final int SCALE = 3;
	
	private Game game;
	private Screen screen;
	private BufferedImage img;
	private int[] pixels;
	private boolean running;
	
	private void init()
	{
		game = new Game();
		screen = new Screen(WIDTH, HEIGHT);
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
	}
	
	public void start()
	{
		running = true;
		new Thread(this).start();
	}
	
	public void stop()
	{
		running = false;
	}
	
	public void run()
	{
		long time = System.nanoTime();
		double unproc = 0;
		double timeRes = 1000000000.0 / FRAME_RATE;
		
		init();
		
		while (running)
		{
			long now = System.nanoTime();
			unproc += (now - time) / timeRes;
			time = now;
			
			while (unproc >= 1)
			{
				update();
				
				unproc--;
			}
			
			render();
		}
		
		exit(0);
	}
	
	private void update()
	{
		game.update();
	}
	
	private void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		screen.render(game);
		for(int i = 0; i < screen.pixels.length; i++)
		{
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		g.dispose();
		bs.show();
	}
	
	private void exit(int code)
	{
		if(code != 0)
		{
			System.out.println("Received error code " + code + ", exiting..");
			System.exit(code);
		}
		
		System.out.println("Game terminated execution, exiting cleanly..");
		System.out.println("Have a great day!");
		System.exit(0);
	}
	
	public static void main(String[] args)
	{
		Component game = new Component();
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.add(game, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
}
