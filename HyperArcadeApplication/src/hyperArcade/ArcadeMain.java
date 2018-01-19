package hyperArcade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import AliceDanPacman.PacmanScreen;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import markGalaga.MarkGalaga;
import theoDevinSnake.TheoSnakeGUI;
import willTetris.TetrisMain;

public class ArcadeMain extends FullFunctionScreen {

	public ArcadeMain(int width, int height) {
		super(width, height);

	}

	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(), getHeight(), "resources/homescreen.png"));

		CustomImageButton tetris = new CustomImageButton(110, 400, 120, 75, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {

			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.tetrisScreen);
			}
		});
		tetris.setBackground(Color.black);
		tetris.setForeground(Color.black);
		viewObjects.add(tetris);

		CustomImageButton snake = new CustomImageButton(320, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {

			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.snakeScreen);
			}
		});
		snake.setBackground(Color.black);
		snake.setForeground(Color.black);
		viewObjects.add(snake);

		CustomImageButton galaga = new CustomImageButton(545, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.galagaScreen);
			}
		});
		galaga.setBackground(Color.black);
		galaga.setForeground(Color.black);
		viewObjects.add(galaga);

		CustomImageButton pacman = new CustomImageButton(760, 400, 100, 70, new DrawInstructions() {
			public void draw(Graphics2D g, boolean highlight) {
				if (!highlight) {
					g.setColor(Color.black);
					g.fillRect(0, 0, 100, 65);
				} else {

				}
			}
		}, new Action() {
			public void act() {
				ArcadeGUI.hyperArcade.setScreen(ArcadeGUI.pacmanScreen);
			}
		});
		pacman.setBackground(Color.black);
		pacman.setForeground(Color.black);
		viewObjects.add(pacman);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}