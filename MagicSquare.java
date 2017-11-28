import java.util.Scanner;

public class MagicSquare {
	public static void main(String[] args) {
		int i;
		int j;
		int sum_row2 = 0, sum_row3 = 0, sum_cols, sum_diag = 0;
		int sum = 0;
		boolean isMagic = true;
		Scanner input = new Scanner(System.in);
		int[][] square = new int[3][3];
		// get numbers for square
		System.out.println("What numbers are in the matrix");

		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				square[a][b] = input.nextInt();

			}

		}
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++)
				System.out.print(square[i][j] + " ");
			System.out.println();
		}

		for (j = 0; j < 3; j++) {
			sum += square[0][j];

		}
		System.out.println("" + sum);
		for (j = 0; j < 3; j++) {
			sum_row2 += square[1][j];
			System.out.println("" + sum_row2);

		}
		for (j = 0; j < 3; j++) {
			sum_row3 += square[2][j];

		}
		if (isMagic == true) {
			for (i = 0; i < 3; i++) {
				sum_cols = 0;
				for (j = 0; j < 3; j++) {
					sum_cols += square[i][j];
					if (sum_cols != sum) {
						isMagic = false;
						break; // fuck u ken
					}
				}
			}
		}
		if (isMagic == true) {
			sum_diag = 0;
			for (i = 0; i < 3; i++)
				for (j = 0; j < 3; j++)
					if ((i + j) == 2)
						sum_diag += square[i][j];
			if (sum_diag != sum) {
				isMagic = false;
			}
		}
		if(isMagic == false){
			System.out.println("Is not");
		}
		else{
			System.out.println("Is");
		}

	}

}
