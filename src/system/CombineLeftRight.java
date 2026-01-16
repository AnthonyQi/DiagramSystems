package system;

public class CombineLeftRight implements Diagram {
	private int animationType;
    private char[][] board;
	
	public CombineLeftRight(Diagram left, Diagram right, int animationType) {
		this.animationType = animationType;
		if (left.getNumberRows() != right.getNumberRows()) {
	        throw new IllegalArgumentException("Not Valid");
	    }
		this.board = TwoDimArrayUtil.appendLeftRight​(
	            left.getBoard(), right.getBoard());
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
