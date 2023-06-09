package Frogger.Entity;

import javafx.scene.image.Image;

/**
 * Class for WetTurtle entity
 * @author leeka
 *
 */
public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private int speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	
	@Override
	public void act(long now) {
		
		WetTurtleAnimation(now);
		
		move(speed , 0);
		
		ResetWetTurtle();
		
	}
	
	/**
	 * Create named instance of WetTurtle
	 * @param xposition
	 * @param yposition
	 * @param movement speed
	 * @param width
	 * @param height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:Resources/Turtle/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:Resources/Turtle/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:Resources/Turtle/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:Resources/Turtle/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * Set WetTurtle animation and when Wet turtle is sunk
	 * @param now
	 */
	//wet turtle animation and indication of sunk
	public void WetTurtleAnimation(long now) {
		if (now/900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
			
		}
		else if (now/900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now/900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (now/900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
	}
	
	/**
	 * Reset Wetturtle when out of bound
	 */
	//reset wetturtle if out of bound
	public void ResetWetTurtle() {
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
	
	
	/**
	 * to know whether WetTurtle is sunk
	 * @return status on whether Wetturtle is sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
}
