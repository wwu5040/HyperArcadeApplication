package willTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;

public class TetrisBoard extends AnimatedComponent {

	private Block[][] board;
	private Color emptyColor;
	private ArrayList<Block> Tetramino;
	private ArrayList<ArrayList<Block>> Tetraminos;

	public TetrisBoard() {
		super(0, 0, 250, 500);
		board = new Block[10][20];
		emptyColor = Color.blue;
	}

	public void dropdown() {
		// TODO Auto-generated method stub

	}

	public void lower() {
		boolean canLower = true;
		for (Block b : Tetramino) {
			if (board[b.getX()][b.getX() - 1] != null)
				canLower = false;
			else {
				Tetramino.remove(0);
				newPiece();
			}
		}

		if (canLower) {
			for (Block b : Tetramino) {
				b.setX(b.getX() - 1);
				b.setY(b.getY() - 1);
			}
		}
	}

	public void newPiece() {
		Tetramino = Tetraminos.get(0);
		for (Block b : Tetramino) {
			if (board[b.getX()][b.getY()] != null)
				gameOver();
			else
				board[b.getX()][b.getY()] = b;
		}
		
	}

	public void gameOver() {

	}

	public void drawImage(Graphics2D g) {

		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board.length; h++) {
				if (board[w][h] != null)
					g.setColor(board[w][h].getColor());
				else
					g.setColor(emptyColor);
				g.fillRect(w * 30, h * 30, 25, 25);
			}
		}

	}

	public Block[][] getBoard() {
		return board;
	}

}
