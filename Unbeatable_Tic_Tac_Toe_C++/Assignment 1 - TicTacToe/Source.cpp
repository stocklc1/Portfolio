//Chris Stockley, w0271204
//C++ Programming
//Assignment 1 - Tic Tac Toe
//October 10, 2015

#include <iostream>
#include <conio.h>

using namespace std;

class Validations {
public:
	//Checks if the character is 1-9 and returns false if it isn't. True if is.
	bool validateDigit(char input) {
		if (input == '1' || input == '2' || input == '3' || input == '4' || input == '5' || input == '6' || input == '7' || input == '8' || input == '9')
			return true;
		else
			return false;
	}
};

class GameBoard {
private:
	//Variables used in the GameBoard class.
	char X = 'X';
	char O = 'O';

public:
	//Loops through the array and prints the array in a "Tic Tac Toe" style.
	void printBoard(char boardArray[3][3]) {
		for (int row = 0; row < 3; row++) {
			cout << endl;
			for (int col = 0; col < 3; col++) {
				if(col == 0) {
					cout << "  " << boardArray[row][col] << " | ";
				}
				else if (col < 2) {
					cout << boardArray[row][col] << " | ";
				}
				else {
					cout << boardArray[row][col];
				}
			}
			if (row < 2) {
				cout << endl << " ---+---+---";
			}
		}
	}
	//Takes in the user input and changes the array according to what the user inputed.
	void changeBoard(char userInput, char boardArray[3][3]) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (userInput == '1') {
					boardArray[0][0] = X;
				}
				else if (userInput == '2') {
					boardArray[0][1] = X;
				}
				else if (userInput == '3') {
					boardArray[0][2] = X;
				}
				else if (userInput == '4') {
					boardArray[1][0] = X;
				}
				else if (userInput == '5') {
					boardArray[1][1] = X;
				}
				else if (userInput == '6') {
					boardArray[1][2] = X;
				}
				else if (userInput == '7') {
					boardArray[2][0] = X;
				}
				else if (userInput == '8') {
					boardArray[2][1] = X;
				}
				else if (userInput == '9') {
					boardArray[2][2] = X;
				}
			}
		}
	}
	//Checks if the computer has a win on the board and returns true. If not the returns false.
	bool checkWinTie(char boardArray[3][3]) {
		if (boardArray[0][0] == O && boardArray[0][1] == O && boardArray[0][2] == O ||
			boardArray[1][0] == O && boardArray[1][1] == O && boardArray[1][2] == O ||
			boardArray[2][0] == O && boardArray[2][1] == O && boardArray[2][2] == O ||
			boardArray[0][0] == O && boardArray[1][0] == O && boardArray[2][0] == O ||
			boardArray[0][1] == O && boardArray[1][1] == O && boardArray[2][1] == O ||
			boardArray[0][2] == O && boardArray[1][2] == O && boardArray[2][2] == O ||
			boardArray[0][0] == O && boardArray[1][1] == O && boardArray[2][2] == O ||
			boardArray[0][2] == O && boardArray[1][1] == O && boardArray[2][0] == O)
			return true;
		else
			return false;
	}
	//Checks if the space on the board is takes or not. If not taken then returns true. Else it returns false.
	bool checkSpaceTaken(char boardArray[3][3], char userInput) {
		if (userInput == '1') {
			if (boardArray[0][0] == userInput)
				return true;
		}
		if (userInput == '2') {
			if (boardArray[0][1] == userInput)
				return true;
		}
		if (userInput == '3') {
			if (boardArray[0][2] == userInput)
				return true;
		}
		if (userInput == '4') {
			if (boardArray[1][0] == userInput)
				return true;
		}
		if (userInput == '5') {
			if (boardArray[1][1] == userInput)
				return true;
		}
		if (userInput == '6') {
			if (boardArray[1][2] == userInput)
				return true;
		}
		if (userInput == '7') {
			if (boardArray[2][0] == userInput)
				return true;
		}if (userInput == '8') {
			if (boardArray[2][1] == userInput)
				return true;
		}
		if (userInput == '9') {
			if (boardArray[2][2] == userInput)
				return true;
		}
		else
			return false;
	}
} newGb; 

class ComputerPlayer {
private:
	//Variables used in the ComputerPlayer class.
	char x = 'X';
	char o = 'O';

public:
	//Method for when the users first input is in any corner of the GameBoard. (1,3,7,9) of the Array.
	void cornerStart(char *p00, char *p01, char *p02, char *p10, char *p11, char *p12, char *p20, char *p21, char *p22, int turnCount) {
		//First move.
		if (turnCount == 1) {
			if (*p00 == x)
				*p11 = o;
		}
		// Second move.
		if (turnCount == 2) {
			if (*p00 == x && *p01 == x)
				*p02 = o;
			if (*p00 == x && *p02 == x)
				*p01 = o;
			if (*p00 == x && *p10 == x)
				*p20 = o;
			if (*p00 == x && *p12 == x)
				*p02 = o;
			if (*p00 == x && *p20 == x || *p00 == x && *p21 == x || *p00 == x && *p22 == x)
				*p10 = o;
		}
		// Third move.
		if (turnCount == 3) {
			// 6
			if (*p00 == x && *p12 == x && *p02 == o && *p11 == o) {
				if (*p20 == x)
					*p10 = o;
				else
					*p20 = o;
			}
			// 8
			if (*p00 == x && *p21 == x && *p10 == o && *p11 == o) {
				if (*p12 == x)
					*p02 = o;
				else
					*p12 = o;
			}
			// 7
			if (*p00 == x && *p20 == x && *p10 == o && *p11 == o) {
				if (*p12 == x)
					*p02 = o;
				else
					*p12 = o;
			}
			// 2
			if (*p00 == x && *p01 == x && *p02 == o && *p11 == o) {
				if (*p20 == x)
					*p10 = o;
				else
					*p20 = o;
			}
			// 3
			if (*p00 == x && *p02 == x && *p01 == o && *p11 == o) {
				if (*p21 == x)
					*p10 = o;
				else
					*p21 = o;
			}
			// 4
			if (*p00 == x && *p10 == x && *p11 == o && *p20 == o) {
				if (*p02 == x)
					*p01 = o;
				else
					*p02 = o;
			}
			// 9
			if (*p00 == x && *p22 == x && *p10 == o && *p11 == o) {
				if (*p12 == x)
					*p02 = o;
				else
					*p12 = o;
			}

		}
		// Fourth move.
		do {
			if (turnCount == 4) {
				if (*p00 == x && *p01 == x && *p20 == x && *p02 == o && *p10 == o && *p11 == o) {
					if (*p12 == x)
						*p22 = o;
					else
						*p12 = o;
					break;

				}
				if (*p00 == x && *p02 == x && *p21 == x && *p01 == o && *p10 == o && *p11 == o) {
					if (*p12 == x)
						*p22 = o;
					else
						*p12 = o;
					break;
				}
				if (*p00 == x && *p02 == x && *p10 == x && *p01 == o && *p20 == o && *p11 == o) {
					if (*p21 == x)
						*p12 = o;
					else
						*p21 = o;
					break;
				}
				if (*p00 == x && *p20 == x && *p12 == x && *p02 == o && *p10 == o && *p11 == o) {
					if (*p21 == x)
						*p22 = o;
					else if (*p22)
						*p21 = o;
					else
						*p21 = 0;
					break;
				}
				if (*p00 == x && *p12 == x && *p21 == x && *p02 == o && *p10 == o && *p11 == o) {
					if (*p01 == x || *p22 == x)
						*p20 = o;
					break;
				}
				if (*p00 == x && *p12 == x && *p22 == x && *p02 == o && *p10 == o && *p11 == o) {
					if (*p01 == x)
						*p20 = o;
					break;
				}
			}
		} while (turnCount == 4);
	}
	//Method for when the users first input is in any side of the GameBoard. (2,4,6,8) of the Array.
	void sideStart(char *p00, char *p01, char *p02, char *p10, char *p11, char *p12, char *p20, char *p21, char *p22, int turnCount) {
		//First move.
		if (turnCount == 1) {
			if (*p01 == x)
				*p11 = o;
		}

		// Second move.
		if (turnCount == 2) {
			if (*p00 == x && *p01 == x)
				*p02 = o;
			else if (*p01 == x && *p22 == x)
				*p02 = o;
			else if (*p01 == x && *p20 == x)
				*p10 = o;
			else
				*p00 = o;
		}

		// Third move.
		do {
			if (turnCount == 3) {
				// 1
				if (*p00 == x && *p01 == x && *p02 == o && *p11 == o) {
					if (*p20 == x)
						*p10 = o;
					else
						*p20 = o;
					break;
				}
				// 3
				if (*p01 == x && *p02 == x && *p00 == o && *p11 == o) {
					if (*p22 == x)
						*p12 = o;
					else
						*p22 = o;
					break;
				}
				// 4
				if (*p01 == x && *p10 == x && *p00 == o && *p11 == o) {
					if (*p22 == x)
						*p02 = o;
					else
						*p22 = o;
					break;
				}
				// 6
				if (*p01 == x && *p12 == x && *p00 == o && *p11 == o) {
					if (*p22 == x)
						*p02 = o;
					else
						*p22 = o;
					break;
				}
				// 7
				if (*p01 == x && *p20 == x && *p10 == o && *p11 == o) {
					if (*p12 == x)
						*p22 = o;
					else
						*p12 = o;
					break;
				}
				// 8
				if (*p01 == x && *p21 == x && *p00 == o && *p11 == o) {
					if (*p22 == x)
						*p20 = o;
					else
						*p22 = o;
					break;
				}
				// 9
				if (*p01 == x && *p22 == x && *p02 == o && *p11 == o) {
					if (*p20 == x)
						*p21 = o;
					else
						*p20 = o;
					break;
				}
			}
		} while (turnCount == 3);

		// Fourth move.
		do {
			if (turnCount == 4) {
				if (*p00 == x && *p01 == x && *p20 == x && *p02 == o && *p10 == o && *p11 == o) {
					if (*p12 == x)
						*p22 = o;
					else
						*p12 = o;
					break;

				}
				if (*p01 == x && *p02 == x && *p22 == x && *p00 == o && *p11 == o && *p12 == o) {
					if (*p10 == x)
						*p21 = o;
					else
						*p21 = o;
					break;
				}
				if (*p01 == x && *p10 == x && *p22 == x && *p00 == o && *p02 == o && *p11 == o) {
					if (*p20 == x)
						*p21 = o;
					else
						*p20 = o;
					break;
				}
				if (*p01 == x && *p12 == x && *p22 == x && *p00 == o && *p02 == o && *p11 == o) {
					if (*p20 == x)
						*p21 = o;
					else
						*p20 = o;
					break;
				}
				if (*p01 == x && *p12 == x && *p20 == x && *p10 == o && *p22 == o && *p11 == o) {
					if (*p00 == x)
						*p02 = o;
					else
						*p00 = o;
					break;
				}
				if (*p01 == x && *p21 == x && *p22 == x && *p00 == o && *p20 == o && *p11 == o) {
					if (*p10 == x)
						*p02 = o;
					else
						*p10 = o;
					break;
				}
				if (*p01 == x && *p20 == x && *p22 == x && *p02 == o && *p21 == o && *p11 == o) {
					if (*p00 == x)
						*p10 = o;
					else
						*p00 = o;
					break;
				}
			}
		} while (turnCount == 4);
	}
	//Method for when the users first input is in middle of the GameBoard. (5) of the Array.
	void middleStart(char *p00, char *p01, char *p02, char *p10, char *p11, char *p12, char *p20, char *p21, char *p22, int turnCount) {
		//First move.
		if (turnCount == 1) {
			if (*p11 == x)
				*p02 = o;
		}
		// Second move.

		if (turnCount == 2) {
			if (*p11 == x && *p00 == x)
				*p22 = o;
			else if (*p11 == x && *p01 == x)
				*p21 = o;
			else if (*p11 == x && *p10 == x)
				*p12 = o;
			else if (*p11 == x && *p12 == x)
				*p10 = o;
			else if (*p11 == x && *p20 == x)
				*p00 = o;
			else if (*p11 == x && *p21 == x)
				*p01 = o;
			else if (*p11 == x && *p22 == x)
				*p00 = o;
		}
		// Third move.

		do {
			if (turnCount == 3) {
				// 1
				if (*p11 == x && *p00 == x && *p02 == o && *p22 == o) {
					if (*p12 == x)
						*p10 = o;
					else
						*p12 = o;
					break;
				}
				// 2
				if (*p01 == x && *p11 == x && *p02 == o && *p21 == o) {
					if (*p00 == x)
						*p22 = o;
					else if (*p10 == x)
						*p12 = o;
					else if (*p12 == x)
						*p10 = o;
					else if (*p22 == x)
						*p00 = o;
					else if (*p20 == x)
						*p10 = o;
					break;
				}
				// 4
				if (*p10 == x && *p11 == x && *p02 == o && *p12 == o) {
					if (*p22 == x)
						*p00 = o;
					else
						*p22 = o;
					break;
				}
				// 6
				if (*p11 == x && *p12 == x && *p02 == o && *p10 == o) {
					if (*p00 == x || *p20 == x)
						*p22 = o;
					else if(*p22 == x)
						*p00 = o;
					else if (*p01 == x)
						*p21 = o;
					else if (*p21 == x)
						*p01 = o;
					
						
					break;
				}
				// 7
				if (*p11 == x && *p20 == x && *p00 == o && *p02 == o) {
					if (*p01 == x)
						*p21 = o;
					else
						*p01 = o;
					break;
				}
				// 8
				if (*p11 == x && *p21 == x && *p01 == o && *p02 == o) {
					if (*p00 == x)
						*p22 = o;
					else
						*p00 = o;
					break;
				}
				// 9
				if (*p11 == x && *p22 == x && *p00 == o && *p02 == o) {
					if (*p01 == x)
						*p21 = o;
					else
						*p01 = o;
					break;
				}
			}
		} while (turnCount == 3);

		// Fourth move.
		do {
			if (turnCount == 4) {
				if (*p00 == x && *p11 == x && *p12 == x && *p02 == o && *p10 == o && *p22 == o) {
					if (*p01 == x)
						*p21 = o;
					else if (*p21 == x)
						*p01 = o;
					else if (*p20 == x)
						*p01 = o;
					break;
				}
				if (*p00 == x && *p01 == x && *p11 == x && *p02 == o && *p21 == o && *p22 == o) {
					if (*p12 == x)
						*p20 = o;
					else 
						*p12 = o;
					break;
				}
				if (*p01 == x && *p10 == x && *p11 == x && *p02 == o && *p12 == o && *p21 == o) {
					if (*p22 == x)
						*p00 = o;
					else
						*p22 = o;
					break;
				}
				if (*p01 == x && *p11 == x && *p20 == x && *p02 == o && *p10 == o && *p21 == o) {
					if (*p00 == x)
						*p22 = o;
					else if (*p22 == x)
						*p00 = o;
					else
						*p22 = o;
					break;
				}
				if (*p01 == x && *p11 == x && *p12 == x && *p02 == o && *p10 == o && *p21 == o) {
					if (*p00 == x)
						*p22 = o;
					else if (*p22 == x)
						*p00 = o;
					else
						*p22 = o;
					break;
				}
				if (*p01 == x && *p11 == x && *p22 == x && *p00 == o && *p02 == o && *p21 == o) {
					if (*p10 == x)
						*p12 = o;
					else if (*p12 == x)
						*p10 = o;
					else
						*p10 = o;
					break;
				}
				if (*p10 == x && *p11 == x && *p22 == x && *p00 == o && *p02 == o && *p12 == o) {
					if (*p01 == x)
						*p21 = o;
					else
						*p01 = o;
					break;
				}
				if (*p00 == x && *p11 == x && *p12 == x && *p02 == o && *p10 == o && *p22 == o) {
					if (*p01 == x)
						*p21 = o;
					else
						*p01 = o;
					break;
				}
				if (*p12 == x && *p11 == x && *p20 == x && *p02 == o && *p10 == o && *p22 == o) {
					if (*p00 == x)
						*p01 = o;
					else
						*p00 = o;
					break;
				}
				if (*p12 == x && *p11 == x && *p21 == x && *p02 == o && *p01 == o && *p10 == o) {
					if (*p00 == x)
						*p22 = o;
					else
						*p00 = o;
					break;
				}
				if (*p12 == x && *p11 == x && *p22 == x && *p02 == o && *p00 == o && *p10 == o) {
					if (*p01 == x)
						*p20 = o;
					else
						*p01 = o;
					break;
				}
				if (*p01 == x && *p11 == x && *p20 == x && *p00 == o && *p02 == o && *p21 == o) {
					if (*p10 == x)
						*p12 = o;
					else if (*p12 == x)
						*p10 = o;
					else
						*p10 = o;
					break;
				}
				if (*p00 == x && *p11 == x && *p21 == x && *p02 == o && *p01 == o && *p22 == o) {
					if (*p12 == x)
						*p10 = o;
					else
						*p12 = o;
					break;
				}
			}
		} while (turnCount == 4);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void topLeftCorner(char array[3][3], int turnCount) {
		char *p00 = &array[0][0];
		char *p01 = &array[0][1];
		char *p02 = &array[0][2];
		char *p10 = &array[1][0];
		char *p11 = &array[1][1];
		char *p12 = &array[1][2];
		char *p20 = &array[2][0];
		char *p21 = &array[2][1];
		char *p22 = &array[2][2];
		
		cornerStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);	
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void topMiddle(char array[3][3], int turnCount) {
		char *p00 = &array[0][0];
		char *p01 = &array[0][1];
		char *p02 = &array[0][2];
		char *p10 = &array[1][0];
		char *p11 = &array[1][1];
		char *p12 = &array[1][2];
		char *p20 = &array[2][0];
		char *p21 = &array[2][1];
		char *p22 = &array[2][2];

		sideStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void bottomLeftCorner(char array[3][3], int turnCount) {
		char *p00 = &array[2][0];
		char *p01 = &array[1][0];
		char *p02 = &array[0][0];
		char *p10 = &array[2][1];
		char *p11 = &array[1][1];
		char *p12 = &array[0][1];
		char *p20 = &array[2][2];
		char *p21 = &array[1][2];
		char *p22 = &array[0][2];
		
		cornerStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void leftMiddle(char array[3][3], int turnCount) {
		char *p00 = &array[2][0];
		char *p01 = &array[1][0];
		char *p02 = &array[0][0];
		char *p10 = &array[2][1];
		char *p11 = &array[1][1];
		char *p12 = &array[0][1];
		char *p20 = &array[2][2];
		char *p21 = &array[1][2];
		char *p22 = &array[0][2];

		sideStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void topRightCorner(char array[3][3], int turnCount) {
		char *p00 = &array[0][2];
		char *p01 = &array[1][2];
		char *p02 = &array[2][2];
		char *p10 = &array[0][1];
		char *p11 = &array[1][1];
		char *p12 = &array[2][1];
		char *p20 = &array[0][0];
		char *p21 = &array[1][0];
		char *p22 = &array[2][0];
		
		cornerStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void rightMiddle(char array[3][3], int turnCount) {
		char *p00 = &array[0][2];
		char *p01 = &array[1][2];
		char *p02 = &array[2][2];
		char *p10 = &array[0][1];
		char *p11 = &array[1][1];
		char *p12 = &array[2][1];
		char *p20 = &array[0][0];
		char *p21 = &array[1][0];
		char *p22 = &array[2][0];

		sideStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void bottomRightCorner(char array[3][3], int turnCount) {
		char *p00 = &array[2][2];
		char *p01 = &array[2][1];
		char *p02 = &array[2][0];
		char *p10 = &array[1][2];
		char *p11 = &array[1][1];
		char *p12 = &array[1][0];
		char *p20 = &array[0][2];
		char *p21 = &array[0][1];
		char *p22 = &array[0][0];
		
		cornerStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void bottomMiddle(char array[3][3], int turnCount) {
		char *p00 = &array[2][2];
		char *p01 = &array[2][1];
		char *p02 = &array[2][0];
		char *p10 = &array[1][2];
		char *p11 = &array[1][1];
		char *p12 = &array[1][0];
		char *p20 = &array[0][2];
		char *p21 = &array[0][1];
		char *p22 = &array[0][0];

		sideStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
	void middleMiddle(char array[3][3], int turnCount) {
		char *p00 = &array[0][0];
		char *p01 = &array[0][1];
		char *p02 = &array[0][2];
		char *p10 = &array[1][0];
		char *p11 = &array[1][1];
		char *p12 = &array[1][2];
		char *p20 = &array[2][0];
		char *p21 = &array[2][1];
		char *p22 = &array[2][2];

		middleStart(p00, p01, p02, p10, p11, p12, p20, p21, p22, turnCount);
	}
	//Changes the pointers so that the GameBoard is in right position. (Flips the board around).
} comPlayer;

class HumanPlayer {
public:
	//Variables used in the HumanPlayer class.
	char humanPick;
	//Prints to the console to enter your move and then 
	//makes the humanPick variable equal the first charcter entered.
	void humanTurn() {
		cout << endl << endl << "  Your Turn: ";
		humanPick = _getch();
	}
} humPlayer;

int main() {
	//Variables used in the main class.
	int turnCount = 1;
	char startPoint;
	bool winner = false;
	GameBoard newGB;
	ComputerPlayer comPlayer;
	HumanPlayer humPlayer;
	Validations vals;
	char boardArray[][3] = { {'1','2','3'}, { '4','5','6' }, { '7','8','9' } };
	//Prints the boards.
	newGb.printBoard(boardArray);
	//Calls humanTurn method in the HumanPlayer class.
	humPlayer.humanTurn();
	//Checks that the number inputed is in fact a number 1-9.
	//Loops though until user inputs a valid number 1-9. 
	while (!vals.validateDigit(humPlayer.humanPick)) {
		system("cls");
		newGb.printBoard(boardArray);
		cout << endl << endl << "  Must be a digit 1-9";
		humPlayer.humanTurn();
	}
	//Makes startPoint equal the users input.
	startPoint = humPlayer.humanPick;
	//Loops through until turn count equals 5.
	do {
		//Takes the user input and changes the board depending on the user input.
		newGB.changeBoard(humPlayer.humanPick, boardArray);
		//Decides what function to call from the ComputerPlayer class dependant on the startPoint.
		if(startPoint == '1')
			comPlayer.topLeftCorner(boardArray, turnCount);
		else if (startPoint == '2')
			comPlayer.topMiddle(boardArray, turnCount);
		else if (startPoint == '3')
			comPlayer.topRightCorner(boardArray, turnCount);
		else if (startPoint == '4')
			comPlayer.leftMiddle(boardArray, turnCount);
		else if (startPoint == '5')
			comPlayer.middleMiddle(boardArray, turnCount);
		else if (startPoint == '6')
			comPlayer.rightMiddle(boardArray, turnCount);
		else if (startPoint == '7')
			comPlayer.bottomLeftCorner(boardArray, turnCount);
		else if (startPoint == '8')
			comPlayer.bottomMiddle(boardArray, turnCount);
		else if (startPoint == '9')
			comPlayer.bottomRightCorner(boardArray, turnCount);
		//Clears the console.
		system("cls");
		//Prints the board.
		newGb.printBoard(boardArray);
		//Checks if the computer won. If so breaks from the loop and ends the game.
		if (newGB.checkWinTie(boardArray)) {
			cout << endl << endl << "  You Lose!";
			break;
		}
		//Increments the turnCount by 1.
		turnCount += 1;
		//Calls for another user input.
		humPlayer.humanTurn();
		//
		while (!vals.validateDigit(humPlayer.humanPick)) {
			system("cls");
			newGb.printBoard(boardArray);
			cout << endl << endl << "  Must be a digit 1-9";
			humPlayer.humanTurn();
		}
		//Checks that the space on the board isn't taken.
		while (!newGB.checkSpaceTaken(boardArray, humPlayer.humanPick)){
			system("cls");
			newGb.printBoard(boardArray);
			cout << endl << endl << "Space Taken";
			humPlayer.humanTurn();
			//Checks that the number inputed is in fact a number 1-9.
			//Loops though until user inputs a valid number 1-9. 
			while (!vals.validateDigit(humPlayer.humanPick)) {
				system("cls");
				newGb.printBoard(boardArray);
				cout << endl << endl << "  Must be a digit 1-9";
				humPlayer.humanTurn();
			}
		}
	} while (turnCount < 5);
	//Prints tie if the last turn didn't involve the computer winning.
	if (!newGB.checkWinTie(boardArray)) {
		newGB.changeBoard(humPlayer.humanPick, boardArray);
		system("cls");
		newGb.printBoard(boardArray);
		cout << endl << endl << "     Tie!";
	}

	_getch();
	return 0;
}