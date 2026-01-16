package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars implements Diagram {
    private int animationType;
    private char[][] board;

    public HorizontalBars(int maxRows, int maxCols, int bars, char color1,
    		char color2, char color3, int animationType) {
        this.animationType = animationType;
        String diagram = DrawingApp.getHorizontalBars(maxRows, 
        		maxCols, bars, color1, color2, color3);
        this.board = BoardCell.getCharArray(diagram);
    }

    @Override
    public char[][] getBoard() {
        return this.board;
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

    @Override
    public char[][] nextAnimationStep() {
        if(animationType == 1) {
            TwoDimArrayUtil.rotateTopOneRow​(board);
        }
        return board;
    }
}
