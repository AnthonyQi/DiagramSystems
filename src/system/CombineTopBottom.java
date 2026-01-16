package system;

public class CombineTopBottom implements Diagram {
	private int animationType;    // Animation type for the diagram
    private char[][] board;       // Combined board of characters

    public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
        this.animationType = animationType;
        if (top.getNumberCols() != bottom.getNumberCols()) {
            throw new IllegalArgumentException("Not Valid");
        }
        this.board = TwoDimArrayUtil.
        		appendTopBottom​(top.getBoard(), bottom.getBoard());
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
