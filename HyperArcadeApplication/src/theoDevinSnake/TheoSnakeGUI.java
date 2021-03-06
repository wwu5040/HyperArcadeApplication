package theoDevinSnake;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import devin.DevTicket;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hyperArcade.ArcadeGUI;

public class TheoSnakeGUI extends FullFunctionScreen implements DevTicket {
	
		private Button back;
		private int score;
		private TextArea time;
		private ArrayList<SnakePart> snakeBody;
		private int userscore;
		private SnakePoint point;
		private boolean first;
		private int count;
		private TextArea text;
		private int points;
	public TheoSnakeGUI(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	public SnakePoint getPoint() {
		return point;
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		points=0;
		text= new TextArea(100,100,100,100,"");
		text.setText("");
		first=true;
		snakeBody = new ArrayList<SnakePart>();
		snakeBody.add(new SnakePart(500,500,25,25,true,this,count));
		
		Button back = new Button (0,50,200,100,"GO Back",new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.homeScreen);
			}
		});
		viewObjects.add(back);
		
		point = new SnakePoint(getRandomX(),getRandomY(),25,25,this);
		viewObjects.add(point);
		for(int i=0;i<snakeBody.size();i++) {
			viewObjects.add(snakeBody.get(i));
		}
//		for(SnakePart s : snakeBody) {
//		snakeBody.get(0).setAction(new Action() {
//			
//			@Override
//				public void act() {
//					if(snakeBody.get(0).checkColision(s)) {
//						gameOver();
//					}
//					if(snakeBody.get(0).checkColision(point)) {
//						pointGet();
//					}
//				}
//			});
//		}
	}

	public ArrayList<SnakePart> getSnakeBody() {
		return snakeBody;
	}

	protected void pointGet() {
		System.out.println("feelsdabman");
		point.setX(getRandomX());
		point.setY(getRandomY());
		points+=100;
//		try {
//			Thread.sleep(200);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		addSnek();
//		snakeBody.get(snakeBody.size()-1).setAction(new Action() {
//			
//			@Override
//			public void act() {
//				
//			}
//		});
//		for(SnakePart s : snakeBody) {
//			snakeBody.get(0).setAction(new Action() {
//
//				@Override
//					public void act() {
//						if(snakeBody.get(0).checkColision(s)) {
//							gameOver();
//						}
//						if(snakeBody.get(0).checkColision(point)) {
//							pointGet();
//						}
//						if(snakeBody.get(snakeBody.size()-2).getX()>=snakeBody.get(snakeBody.size()-1).getX()){
//							snakeBody.get(snakeBody.size()-1).setDirection(snakeBody.get(snakeBody.size()-2).getDirection());
//						}
//					}
//				});
//			}
	}
	public void addSnek() {
//		if(snakeBody.get(snakeBody.size()-1).getDirection()==1) {
//		 int snekX=snakeBody.get(snakeBody.size()-1).getX();
//		 int snekY=snakeBody.get(snakeBody.size()-1).getY()+30;
		snakeBody.add(new SnakePart(1000,1000,25,25,false,this,count));
		count++;
//		}
//		if(snakeBody.get(snakeBody.size()-1).getDirection()==2) {
//			 int snekX=snakeBody.get(snakeBody.size()-1).getX()-30;
//			 int snekY=snakeBody.get(snakeBody.size()-1).getY();
//			snakeBody.add(new SnakePart(snekX,snekY,25,25,false,this,count));
//			count++;
//		}
//		if(snakeBody.get(snakeBody.size()-1).getDirection()==3) {
//			 int snekX=snakeBody.get(snakeBody.size()-1).getX();
//			 int snekY=snakeBody.get(snakeBody.size()-1).getY()-30;
//			snakeBody.add(new SnakePart(snekX,snekY,25,25,false,this,count));
//			count++;
//			}
//		if(snakeBody.get(snakeBody.size()-1).getDirection()==4) {
//			 int snekX=snakeBody.get(snakeBody.size()-1).getX()+30;
//			 int snekY=snakeBody.get(snakeBody.size()-1).getY();
//			snakeBody.add(new SnakePart(snekX,snekY,25,25,false,this,count));
//			count++;
//			}
		
		//snakeBody.get(snakeBody.size()-1).setVx(snakeBody.get(snakeBody.size()-2).getVx());
		//snakeBody.get(snakeBody.size()-1).setVy(snakeBody.get(snakeBody.size()-2).getVy());
		addObject(snakeBody.get(snakeBody.size()-1));
}
	public int getRandomX() {
		return (int)(Math.random()*1024);
	}
	public int getRandomY() {
		return (int)((Math.random()*764)+25);
	}

	public void gameOver() {
		score = snakeBody.size()*1000;
		text.setText("Game Over");
		toTicket();
		update();
		for(int i = 1; i < snakeBody.size(); i++) {
			remove(snakeBody.get(i));
			snakeBody.get(i).setRunning(false);
			snakeBody.remove(i);
		}
		
	}
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case  KeyEvent.VK_UP : 
			if(snakeBody.get(0).getVy() != 5) {
				if(first) {
					first=false;
					snakeBody.get(0).moveUp();
				}else {
					snakeBody.get(0).moveUp();
				}
			}
			break;
		case KeyEvent.VK_DOWN :
			if(snakeBody.get(0).getVy() != -5) {
				if(first) {
					first=false;
					snakeBody.get(0).moveDown();
				}else {
					snakeBody.get(0).moveDown();
				}
			}
			break;
		case KeyEvent.VK_LEFT :
			if(snakeBody.get(0).getVx() != 5) {
				if(first) {
					first=false;
					snakeBody.get(0).moveLeft();
				}else {
					snakeBody.get(0).moveLeft();
			}
		}
			break;
		case KeyEvent.VK_RIGHT :
			if(snakeBody.get(0).getVx() != -5) {
				if(first) {
					first=false;
					snakeBody.get(0).moveRight();
				}else {
					snakeBody.get(0).moveRight();
				}
			}
			break;
		}
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void toTicket() {
		ArcadeGUI.homeScreen.updateTickets((int)score/20);
	}
	@Override
	public void displayTickets() {
		// TODO Auto-generated method stub
		
	}

	
}
