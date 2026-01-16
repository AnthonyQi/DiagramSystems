package tests;

import static org.junit.Assert.*;
import system.*;
import org.junit.Test;

import app.DrawingApp;
import gui.BoardCell;

public class StudentTests {

    @Test
    public void testAppendLeftRight() {
        char[][] left = {{'1', '2'}, {'3', '4'}};
        char[][] right = {{'5', '6'}, {'7', '8'}};
        char[][] expected = {{'1', '2', '5', '6'}, {'3', '4', '7', '8'}};
        char[][] result = TwoDimArrayUtil.appendLeftRight​(left, right);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }

    @Test
    public void testAppendLeftRightInvalid() {
    	char[][] testL = null;
    	char[][] testR = null;
        try {
            TwoDimArrayUtil.appendLeftRight​(testL, testR);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Not Valid");
        }
    }

    @Test
    public void testAppendTopBottom() {
        char[][] top = {{'1', '2'}, {'3', '4'}};
        char[][] bottom = {{'5', '6'}, {'7', '8'}};
        char[][] expected = {{'1', '2'}, {'3', '4'}, {'5', '6'}, {'7', '8'}};
        char[][] result = TwoDimArrayUtil.appendTopBottom​(top, bottom);

        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], result[i][j]);
            }
        }
    }

    @Test
    public void testAppendTopBottomInvalid() {
        try {
            TwoDimArrayUtil.appendTopBottom​(null, new char[][]{{'a'}});
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Not Valid");
        }
    }

    @Test
    public void testIsRagged() {
        char[][] nonRagged = {{'1', '1'}, {'1', '1'}};
        char[][] ragged = {{'1', '1'}, {'1'}};

        assertFalse(TwoDimArrayUtil.isRagged​(nonRagged));
        assertTrue(TwoDimArrayUtil.isRagged​(ragged));
    }

    @Test
    public void testRotateLeftOneColumn() {
        char[][] array = {{'A', 'B'}, {'C', 'D'}};
        char[][] expected = {{'B', 'A'}, {'D', 'C'}};

        TwoDimArrayUtil.rotateLeftOneColumn​(array);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], array[i][j]);
            }
        }
    }

    @Test
    public void testRotateLeftOneColumnInvalid() {
    	char[][] test = null;
        try {
            TwoDimArrayUtil.rotateLeftOneColumn​(test);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Not Valid");
        }
    }

    @Test
    public void testRotateTopOneRow() {
        char[][] array = {{'A', 'B'}, {'C', 'D'}, {'E', 'F'}};
        char[][] expected = {{'C', 'D'}, {'E', 'F'}, {'A', 'B'}};

        TwoDimArrayUtil.rotateTopOneRow​(array);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], array[i][j]);
            }
        }
    }

    @Test
    public void testRotateTopOneRowInvalid() {
    	char[][] test = null;
        try {
            TwoDimArrayUtil.rotateTopOneRow​(test);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Not Valid");
        }
    }

    @Test
    public void testVerticalBars() {
    	VerticalBars bars = new VerticalBars(6, 6, 2, 'R', 'G', 'B', 0);
        char[][] board = bars.getBoard();
        String ans = DrawingApp.getVerticalBars(6, 6, 2, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		assertEquals(answer[i][j], board[i][j]);
        	}
        }
    }

    @Test
    public void testVerticalBarsAnimation() {
    	VerticalBars bars = new VerticalBars(6, 6, 2, 'R', 'G', 'B', 1);
        char[][] result = bars.nextAnimationStep();
        String ans = DrawingApp.getVerticalBars(6, 6, 2, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        TwoDimArrayUtil.rotateLeftOneColumn​(answer);
        for(int i =  0; i < result.length; i++) {
        	for(int j = 0; j < result[i].length; j++) {
        		assertEquals(result[i][j], answer[i][j]);
        	}
        }
    }

    @Test
    public void testCombineLeftRight() {
    	HorizontalBars bars1 = new HorizontalBars(6, 6, 2, 'R', 'G', 'B', 0);
    	VerticalBars bars2 = new VerticalBars(6, 6, 2, 'R', 'G', 'B', 0);
    	CombineLeftRight combined = new CombineLeftRight(bars1, bars2, 1);
    	char[][] result = combined.getBoard();
    	String left = DrawingApp.getHorizontalBars(6, 6, 2, 'R', 'G', 'B');
    	String right = DrawingApp.getVerticalBars(6, 6, 2, 'R', 'G', 'B');
    	char[][] LEFT = BoardCell.getCharArray(left);
    	char[][] RIGHT = BoardCell.getCharArray(right);
    	char[][] answer = TwoDimArrayUtil.appendLeftRight​(LEFT, RIGHT);
    	for(int i = 0; i < answer.length; i++) {
    		for(int j = 0; j < answer[i].length; j++) {
    			assertEquals(answer[i][j], result[i][j]);
    		}
    	}
    }

    @Test
    public void testCombineTopBottom() {
    	HorizontalBars bars1 = new HorizontalBars(6, 6, 2, 'R', 'G', 'B', 0);
    	VerticalBars bars2 = new VerticalBars(6, 6, 2, 'R', 'G', 'B', 0);
    	CombineTopBottom combined = new CombineTopBottom(bars1, bars2, 1);
    	char[][] result = combined.getBoard();
    	String left = DrawingApp.getHorizontalBars(6, 6, 2, 'R', 'G', 'B');
    	String right = DrawingApp.getVerticalBars(6, 6, 2, 'R', 'G', 'B');
    	char[][] LEFT = BoardCell.getCharArray(left);
    	char[][] RIGHT = BoardCell.getCharArray(right);
    	char[][] answer = TwoDimArrayUtil.appendTopBottom​(LEFT, RIGHT);
    	for(int i = 0; i < answer.length; i++) {
    		for(int j = 0; j < answer[i].length; j++) {
    			assertEquals(answer[i][j], result[i][j]);
    		}
    	}
    }

    @Test
    public void testFlag() {
        Flag flag = new Flag(3, 'R', 'G', 'B', 0);
        char[][] board = flag.getBoard();
        String ans = DrawingApp.getFlag(3, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		assertEquals(answer[i][j], board[i][j]);
        	}
        }
    }

    @Test
    public void testFlagAnimation() {
    	Flag flag = new Flag(3, 'R', 'G', 'B', 1);
    	Flag flag2 = new Flag(6, 'R', 'G', 'B', 2);
    	char[][] result = flag.nextAnimationStep();
        char[][] result2 = flag2.nextAnimationStep();
        String ans = DrawingApp.getFlag(3, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        TwoDimArrayUtil.rotateLeftOneColumn​(answer);
        char[][] answer2 = BoardCell.getCharArray
        		(DrawingApp.getFlag(6, 'R', 'G', 'B'));
        TwoDimArrayUtil.rotateTopOneRow​(answer2); 
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                assertEquals(result[i][j], answer[i][j]);
            }
        }
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[i].length; j++) {
                assertEquals(result2[i][j], answer2[i][j]);
            }
        }
    }

    @Test
    public void testHorizontalBars() {
        HorizontalBars bars = new HorizontalBars(6, 6, 2, 'R', 'G', 'B', 0);
        char[][] board = bars.getBoard();
        String ans = DrawingApp.getHorizontalBars(6, 6, 2, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		assertEquals(answer[i][j], board[i][j]);
        	}
        }
    }

    @Test
    public void testHorizontalBarsAnimation() {
    	HorizontalBars bars = new HorizontalBars(6, 6, 2, 'R', 'G', 'B', 1);
        char[][] result = bars.nextAnimationStep();
        String ans = DrawingApp.getHorizontalBars(6, 6, 2, 'R', 'G', 'B');
        char[][] answer = BoardCell.getCharArray(ans);
        TwoDimArrayUtil.rotateTopOneRow​(answer);
        for(int i = 0; i < result.length; i++) {
        	for(int j = 0; j < result[i].length; j++) {
        		assertEquals(result[i][j], answer[i][j]);
        	}
        }
    }

}
