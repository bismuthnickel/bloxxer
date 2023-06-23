package grapchis;

import java.util.Random;

import bloxxer.Game;

public class Screen extends Render {

	private Render test;
	private Render3D render;
	
	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		render = new Render3D(width, height);
		test = new Render(256,256);
		for (int i = 0; i < 256 * 256; i++) {
			test.pixels[i] = random.nextInt();
		}
	}
	
	public void render(Game game) {
		for (int i = 0; i < width * height; i++) {
			pixels[i] = 0;
		}
		
		//for (int i = 0; i < 15; i++) {
		//	int anim = (int) (Math.sin(((game.time * 15) + i * 15) % 2000.0 / 2000 * Math.PI * 2) * 200);
		//	int anim2 = (int) (Math.cos(((game.time * 15) + i * 15) % 2000.0 / 2000 * Math.PI * 2) * 200);
			// System.out.println(anim);
			// draw(test,(width - 256) / 2 + anim,(height - 256) / 2 + anim2);
			// System.out.println("mom look how good i am at drawing");
		//}
		
		render.floor(game);
		render.renderDistanceLimiter();
		draw(render, 0, 0);
	}
}
