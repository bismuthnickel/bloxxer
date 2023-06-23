package input;

public class Controller {
	
	public double x, y, z, rotation, xa, za, rotationa;
	
	public static boolean turnLeft = false;
	public static boolean turnRight = false;
	public static boolean walk = false;
	public static double distance = 0;
	
	public void tick(boolean foward, boolean back, boolean left, boolean right, boolean jump, boolean crouch, boolean sprint) {
		double rotationSpeed = 0.1;
		double walkSpeed = 1;
		double speed = walkSpeed;
		double jumpHeight = 0.5;
		double xMove = 0;
		double zMove = 0;
		
		if (foward) {
			zMove++;
			walk = true;
		}
		if (back) {
			zMove--;
			walk = true;
		}
		if (left) {
			xMove--;
			walk = true;
		}
		if (right) {
			xMove++;
			walk = true;
		}
		if (turnLeft) {
			rotationa -= rotationSpeed;
		}
		if (turnRight) {
			rotationa += rotationSpeed;
		}
		if (jump) {
			y += jumpHeight;
		}
		if (crouch) {
			y -= jumpHeight / 2;
			speed = walkSpeed / 3;
		} else if (sprint) {
			speed = walkSpeed * 1.6;
		} else {
			speed = walkSpeed;
		}
		if (!foward && !back && !left && !right) {
			walk = false;
		}
		if (walk) {
			distance++;
		}
		
		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * speed;
		za += (zMove * Math.cos(rotation) - xMove * Math.sin(rotation)) * speed;
		
		x+= xa;
		z+= za;
		y*= 0.7;
		xa *= 0.1;
		za *= 0.1;
		rotation += rotationa;
		rotationa *= 0.1;
		
		//important stuff (i think):
		//xmove, zmove, rotationa
		
	}
	
}
