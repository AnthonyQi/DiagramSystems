package system;
public class TwoDimArrayUtil
extends Object {
	public TwoDimArrayUtil() {}
	public static char[][] appendLeftRight​(char[][] left, char[][] right) {
		if (left == null || right == null) {
	        throw new IllegalArgumentException("Not Valid");
	    }
	    int maxRows = Math.max(left.length, right.length);
	    char[][] result = new char[maxRows][];
	    for (int i = 0; i < maxRows; i++) {
	        int leftColumns = (i < left.length) ? left[i].length : 0;
	        int rightColumns = (i < right.length) ? right[i].length : 0;
	        result[i] = new char[leftColumns + rightColumns];
	        for (int j = 0; j < leftColumns; j++) {
	            result[i][j] = left[i][j];
	        }
	        for (int j = 0; j < rightColumns; j++) {
	            result[i][leftColumns + j] = right[i][j];
	        }
	    }
	    return result;
	}
	public static char[][] appendTopBottom​(char[][] top, char[][] bottom) {
		if (top == null || bottom == null) {
	        throw new IllegalArgumentException("Not Valid");
	    }
		int x = top.length;
		int y = bottom.length;
		char [][] appendArray = new char[x+y][];
		for (int i = 0; i < top.length; i++) {
			appendArray[i] = new char[top[i].length];
	        for (int j = 0; j < top[i].length; j++) {
	        	appendArray[i][j] = top[i][j];
	        }
	    }

	    for (int i = 0; i < bottom.length; i++) {
	    	appendArray[top.length + i] = new char[bottom[i].length];
	        for (int j = 0; j < bottom[i].length; j++) {
	        	appendArray[top.length + i][j] = bottom[i][j];
	        }
	    }
	    return appendArray;
	}
	public static boolean isRagged​(char[][] array) {
		boolean ragged = false;
		if(array == null) {return true;}
		for(char[] row: array) {
			if(row.length != array[0].length || row == null) {
				ragged = true;
			}
		}
		return ragged;
	}
	public static void rotateLeftOneColumn​(char[][] array) {
		if(array == null || isRagged​(array)) {
			throw new IllegalArgumentException("Not Valid");
		}
		if (array.length == 0 || array[0].length <= 1) {
	        return;
	    }
		for(int i = 0; i < array.length; i++) {
			char temp = array[i][0];
			for(int j = 0; j < array[i].length-1; j++) {
				array[i][j] = array[i][j+1];
			}
			array[i][array[i].length-1] = temp;
		}
	}
	public static void rotateTopOneRow​(char[][] array) {
		if(array == null || isRagged​(array)) {
			throw new IllegalArgumentException("Not Valid");
		}
		if (array.length <= 1) {
	        return;
	    }
		char[] temp = array[0];
		for(int i = 0; i < array.length-1; i++) {
			array[i] = array[i+1];
		}
		array[array.length - 1] = temp;
	}
}
