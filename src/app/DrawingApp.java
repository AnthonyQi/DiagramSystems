package app;

import java.util.Random;

public class DrawingApp {

 	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		if(maxRows < 1 || maxCols < 1) {
			return null;
		}
		String rectangle = "";

		//might have to change i = 0 to i = 1.
		for(int i = 0; i < maxRows; i++) {
			for(int j = 0; j < maxCols; j++) {
				rectangle += symbol;
			}
			if(i < maxRows-1) {
				rectangle += "\n";
			}
		}
		return rectangle;
	}
 	
 	public static String getFlag(int size, char color1, char color2, char color3) {
 	    if (size < 3) {
 	        return null;
 	    }
 	    int cols = size * 5;
 	    String flag = "";
 	    //have to split the top and bottom due to the
 	    //previous attempts not working
 	    //top half
 	    for (int i = 0; i < size; i++) {
 	        for (int j = 0; j <= i; j++) {
 	            flag += color1;
 	        }
 	        if (i == 0) {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color2;
 	            }
 	        } else if (i == size - 1) {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color2;
 	            }
 	        } else {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color3;
 	            }
 	        }
 	        flag += "\n";
 	    }
 	    //bottom half
 	    for (int i = size - 1; i >= 0; i--) {
 	        for (int j = 0; j <= i; j++) {
 	            flag += color1;
 	        }
 	        if (i == 0) {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color2;
 	            }
 	        } else if (i == size - 1) {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color2;
 	            }
 	        } else {
 	            for (int j = i + 1; j < cols; j++) {
 	                flag += color3;
 	            }
 	        }
 	        if (i > 0) {
 	            flag += "\n";
 	        }
 	    }
 	    return flag;
 	}

	public static String getHorizontalBars(int maxRows, int maxCols, 
			int bars, char color1, char color2, char color3) {
		int rowsPer = maxRows/bars;
		int rowsRemain = maxRows%bars;
		//the int is truncating, so the mod 
		//is to find the remaining number of rows and get rid of them
		if(rowsPer < 1 || !isValidColor(color1) 
				|| !isValidColor(color2) || !isValidColor(color3)
					|| maxRows < 1 || maxCols < 1 || bars < 1) {
			return null;
		}
		String rect = new String();
		int rows = maxRows - rowsRemain;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < maxCols; j++) {
				if((i/rowsPer) % 3 == 0) {
					rect += color1;
				}
				else if((i/rowsPer) % 3 == 1) {
					rect += color2;				
				}
				else if((i/rowsPer) % 3 == 2) {
					rect += color3;
				}
			}
			if(i < rows-1) {
				rect += "\n";
			}
		}
		return rect;
	}

	public static String getVerticalBars(int maxRows, int maxCols,
			int bars, char color1, char color2, char color3) {
		int colsPer = maxCols/bars;
		int colsRemain = maxCols%bars;
		if(colsPer < 1 || !isValidColor(color1) 
				|| !isValidColor(color2) || !isValidColor(color3)
					|| maxRows < 1 || maxCols < 1 || bars < 1) {
			return null;
		}
		String rect = new String();
		for(int i = 0; i < maxRows; i++) {
			for(int j = 0; j < maxCols - colsRemain; j++) {
				if((j/colsPer) % 3 == 0) {
					rect += color1;
				}
				else if((j/colsPer) % 3 == 1) {
					rect += color2;
				}
				else if((j/colsPer) % 3 == 2) {
					rect += color3;
				}
			}
			if(i < maxRows-1) {
				rect += "\n";
			}
		}
		return rect;
	}

	public static char getRandomColor(Random random) {
		String color = "RGBY*.";
		int rand = random.nextInt(color.length());
		return color.charAt(rand);

	}

	private static boolean isValidColor(char color) {
		return color == 'R' || color == 'G' || color == 'B' 
				|| color == 'Y' || color == '*' || color == '.';
	}
}