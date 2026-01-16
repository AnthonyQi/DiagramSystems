package system;

import app.DrawingApp;
import gui.BoardCell;

public class Flag implements Diagram {
	private int animationType;
	private char[][] board;
	
	public Flag(int size, char color1,
			char color2, char color3, int animationType) {
		this.animationType = animationType;
		String flag = DrawingApp.getFlag(size, color1, color2, color3);
		board = BoardCell.getCharArray(flag);
	}
	@Override
	public char[][] getBoard() {
		return this.board;
	}

	@Override
	public char[][] nextAnimationStep() {
		if(animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}
		else if(animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow​(board);
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
