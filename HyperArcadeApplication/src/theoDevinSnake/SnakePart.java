package theoDevinSnake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.components.MovingComponent;
import markGalaga.MarkPlayerMovement;
import willTetris.Collidable;

public class SnakePart extends MarkPlayerMovement implements Collidable{
	private int direction;
	private boolean head;
	private TheoSnakeGUI beep;
	private Action detectColision;
	private SnakePart leader;
	private ArrayList<Position> lastPositions;
	

	public SnakePart(int x, int y, int w, int h, boolean head,TheoSnakeGUI snake, int lead) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		this.beep=snake;
		Thread t = new Thread(this);
		this.addSequence("resources/SnakeBody.png",1000,0, 0,50,50, 1);
		this.head=head;
		if(!head) {
			System.out.print((beep.getSnakeBody().indexOf(this)-1));
			this.leader=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1);
		}
		lastPositions= new ArrayList<Position>();
		t.start();
		
		update();
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void moveUp() {
		direction=1;
		setVx(0);
		setVy(-5);
	}
	public void moveDown() {
		direction=3;
		setVx(0);
		setVy(5);
	}
	public void moveLeft() {
		direction=4;
		setVy(0);
		setVx(-5);
	}
	public void moveRight() {
		direction =2;
		setVy(0);
		setVx(5);
	}
	public void turn(int x,int y,int dir) {
		if(this.direction ==1) {
		while(this.getY()>=y) {
			direction=dir;
			this.setY(y);
			if(beep.getSnakeBody().indexOf(this)!= beep.getSnakeBody().size()-1) {
				beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)+1).turn(this.getX(),this.getY(),dir);
			}
			break;
		}
		}
		if(this.direction ==3) {
			while(this.getY()<=y) {
			
				direction=dir;
				this.setY(y);
				if(beep.getSnakeBody().indexOf(this)!= beep.getSnakeBody().size()-1) {
					beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)+1).turn(this.getX(),this.getY(),dir);
				}
				break;
			}
		}
		if(this.direction ==2) {
			while(this.getX()>=x) {
				direction=dir;
				this.setX(x);
				if(beep.getSnakeBody().indexOf(this)!= beep.getSnakeBody().size()-1) {
					beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)+1).turn(this.getX(),this.getY(),dir);
				}
				break;
			}
		}
		if(this.direction ==4) {
			while(this.getX()<=x) {
				direction=dir;
				this.setX(x);
				if(beep.getSnakeBody().indexOf(this)!= beep.getSnakeBody().size()-1) {
					beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)+1).turn(this.getX(),this.getY(),dir);
				}
				break;
			}
		}
	
} 
	@Override
	public void checkBehaviors() {
		
//		if(direction==1) {
//			moveUp();
//		}
//		if(direction==2) {
//			moveRight();
//		}
//		if(direction==3) {
//			moveDown();
//		}
//		if(direction==4) {
//			moveLeft();
//		}

		lastPositions.add(new Position(this.getX(),this.getY()));
		if(lastPositions.size()>10) {
			lastPositions.remove(10);
		}
		if(!head) {
			if(leader.getLastPositions().size()==10) {
				this.setX(leader.getLastPositions().get(10).getX());
				this.setY(leader.getLastPositions().get(10).getY());
			}
		}
		if(beep.getSnakeBody().get(0).checkColision(this)) {
			beep.gameOver();
		}
		if(beep.getSnakeBody().get(0).checkColision(beep.getPoint())) {
			beep.pointGet();
		}
		//if(!head) {
		//if((beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()>=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() ) || (beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()<=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() )){
		//	beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).setDirection(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getDirection());
		//}
		//if( (beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()>=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX()) ||(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getY()<=beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getY() && beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getX()==beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).getX())){
		//	beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)).setDirection(beep.getSnakeBody().get(beep.getSnakeBody().indexOf(this)-1).getDirection());
		//}
	//}
}
	//private void act() {
	//	detectColision.act();
	//	
	//}

	public ArrayList<Position> getLastPositions() {
		return lastPositions;
	}

	public boolean checkColision(SnakePart p) {
		return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
	public boolean checkColision(SnakePoint p) {
	 return p.getX() < getX() + getWidth() && p.getX() + p.getWidth() > getX() &&
				p.getY() < getY() + getHeight() && p.getHeight() + p.getY() > getY();
	}
	//public void setAction(Action a) {
		//this.detectColision= a;
	//}

	@Override
	public void moveStop() {
		// TODO Auto-generated method stub
		
	}
}
