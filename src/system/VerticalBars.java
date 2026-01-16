package system;

import app.DrawingApp;
import gui.BoardCell;

public class VerticalBars implements Diagram {
	private int animationType;
    private char[][] board;
	
	public VerticalBars(int maxRows, int maxCols, int bars, char color1,
			char color2, char color3, int animationType) {
        this.animationType = animationType;
        String diagram = DrawingApp.getVerticalBars(maxRows, maxCols,
        		bars, color1, color2, color3);
        this.board = BoardCell.getCharArray(diagram);
    }

	@Override
	public char[][] getBoard() {
		return board;
	}

	@Override
	public char[][] nextAnimationStep() {
		if(animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}
		return board;
	}

	@Override
	public int getNumberRows() {
		return board.length;
	}

	@Override
	public int getNumberCols() {
		if (board.length > 0) {
            return board[0].length;
        }
        return 0;
	}

}
