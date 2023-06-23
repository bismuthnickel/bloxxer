package grapchis;

import bloxxer.Game;
import input.Controller;

public class Render3D extends Render {
	
	public double[] zBuffer;
	private double renderDistance = 12500;
	
	public Render3D(int width, int height) {
		super(width, height);
		zBuffer = new double[width*height];
	}
	
	public void floor(Game game) {
		
		double floorp = 8;
		double ceilingp = 8;
		double forward = game.controls.z;
		double right = game.controls.x;
		double up = game.controls.y;
		double walking = Math.sin(Controller.distance/6.0) * 0.5;
		double anim = walking * 1.3;
		
		double rotation = game.controls.rotation;
		double cosine = Math.cos(rotation);
		double sine = Math.sin(rotation);
		
		for (int y = 0; y < height; y++) {
			if (game.controls.y < 0) {
				anim = walking / 2;
			} else {
				anim = walking * 1.3;
			}
			double ceiling = (y - height / 2.0) / height;
			
			double z = (floorp + up) / ceiling;
			if (Controller.walk == true) {
				z = (floorp + up + anim) / ceiling;
			}
			
			if (ceiling < 0) {
				z = (ceilingp - up) / -ceiling;
				if (Controller.walk == true) {
					z = (ceilingp - up - anim) / -ceiling;
				}
			}
			
			for (int x = 0; x < width; x++) {
				double depth = (x - width / 2.0) / height;
				depth *= z;
				double xx = depth * cosine + z * sine;
				double yy = z * cosine - depth * sine;
				int xPix = (int) (xx + right);
				int yPix = (int) (yy + forward);
				zBuffer[x + y * width] = z;
				// System.out.println(x + ", " + y);
				pixels[x + y * width] = ((xPix & 15) * 150 | (yPix & 15) * 150) << 8;
				//pixels[x + y * width] = Texture.floor.pixels[(xPix & 7) + (yPix & 7) * 8];
				
				if (z > 500) {
					pixels[x + y * width] = 0;
				}
			}
		}
	}
	
	public void renderDistanceLimiter() {
		for (int i = 0; i < width * height; i++) {
			int colour = pixels[i];
			int brightness = (int) ((renderDistance) / (zBuffer[i]));
			
			if (brightness < 0) {
				brightness = 0;
			}
			
			if (brightness > 255) {
				brightness = 255;
			}
			
			int r,g,b;
			r = (colour >> 16) & 0xff;
			g = (colour >> 8) & 0xff;
			b = (colour) & 0xff;
			
			r = r*brightness / 255;
			g = g*brightness / 255;
			b = b*brightness / 255;
			
			pixels[i] = r << 16 | g << 8 | b;
		}
	}
	
}
