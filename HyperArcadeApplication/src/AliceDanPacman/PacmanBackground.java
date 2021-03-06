package AliceDanPacman;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import markGalaga.MarkPlayerMovement;

public class PacmanBackground extends AnimatedComponent{
	private BufferedImage img;
	public PacmanBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
		setX(x);
		setY(y);
		img = new Graphic(0,0,w,h,"resources/Pacman_bg.png").getImage();
		update();			
		Thread t = new Thread(this);
		t.start();
	}

	public void drawImage(Graphics2D g) {
		if(img != null) {
			g.drawImage(img,0,0,null);
		}
	}


}
