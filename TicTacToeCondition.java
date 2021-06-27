package javaProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicTacToeCondition {

	public enum arrayValues{X,O,Empty}
	private arrayValues gameValue[][] = null;
	private arrayValues toggleValue;
	
	public TicTacToeCondition() {
		gameValue = new arrayValues[3][3];
		Arrays.fill(gameValue[0], arrayValues.Empty);
		Arrays.fill(gameValue[1], arrayValues.Empty);
		Arrays.fill(gameValue[2], arrayValues.Empty);
		toggleValue = arrayValues.X;
	}
	
	public void setToggleValue()
	{
		toggleValue = toggleValue == arrayValues.X ? 
							TicTacToeCondition.arrayValues.O : 
							TicTacToeCondition.arrayValues.X;
	}
	
	public arrayValues getToggleValues() {
		return toggleValue;
	}
	
	public void resetToggleValues() {
		toggleValue = arrayValues.X;
	}
	
	public void resetGameValue()
	{
		Arrays.fill(gameValue[0], arrayValues.Empty);
		Arrays.fill(gameValue[1], arrayValues.Empty);
		Arrays.fill(gameValue[2], arrayValues.Empty);
	}
	
	public void setGameValue(int row, int col, arrayValues value) {
		gameValue[row][col] = value;
	}
	
	public int checkCondition(arrayValues value)
	{
		
		int count_col1 = 0;
		int count_col2 = 0;
		int count_col3 = 0;
		
		int count_row1 = 0;
		int count_row2 = 0;
		int count_row3 = 0;
		
		int count_diagonal1 = 0;
		int count_diagonal2 = 0;
		
		for(int i=0;i<3;i++)
		{
			count_col1 += gameValue[i][0] == value ? 1 : 0;
			count_col2 += gameValue[i][1] == value ? 1 : 0;
			count_col3 += gameValue[i][2] == value ? 1 : 0;
			
			count_row1 += gameValue[0][i] == value ? 1 : 0;
			count_row2 += gameValue[1][i] == value ? 1 : 0;
			count_row3 += gameValue[2][i] == value ? 1 : 0;
			
			count_diagonal1 += gameValue[i][i] == value ? 1 : 0;
			count_diagonal2 += gameValue[i][2-i] == value ? 1 : 0;
		}
		
		if(count_col1 == 3 || count_col2 == 3 || count_col3 == 3 ||
		   count_row1 == 3 || count_row2 == 3 || count_row3 == 3 ||
		   count_diagonal1 == 3 || count_diagonal2 == 3)
		{
			if(value == arrayValues.X)
			{
				return 1;
			}
			else if(value == arrayValues.O)
			{
				return 2;
			}
		}
		else if(Arrays.asList(gameValue[0]).contains(arrayValues.Empty) || 
				   Arrays.asList(gameValue[1]).contains(arrayValues.Empty) ||
				   Arrays.asList(gameValue[2]).contains(arrayValues.Empty))
		{
			return 3;
		}
		
		return 0;
	}
}

