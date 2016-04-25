// Chris Stockley, 701, Data Structures
// Assignment 1, Linked Lists

#include <cstdlib>
#include <iostream>
#include <conio.h>
#include <sstream>
#include "LinkedList.h"

using namespace std;

// Methods used in main.
void outputOptions();
bool checkAlpha(const string &str);

int main(int argc, char** argv) {
	
	// Min and max combination numbers.
	int maxCNum = 49;
	int minCNum = 1;
	// Min and max list numbers.
	int listStart = 1;
	int listLimit = 7;
	// Position used for selecting a node.
	int position = 0;
	// Default node value in the linked list.
	int defaultNodeValue = 0;
	// Input for options.
	char userInput;

	// Linked list used in the main.
	LinkedList newList;

	// While loop to fill a predetermined linked list size.
	while (listStart <= listLimit) {
		listStart++;
		newList.AddNode(0);
	}

	// Main loop for application.
	while (true) {
		// Prints the linked list.
		newList.PrintList(position);

		// Prints the output options.
		outputOptions();

		// Gets a character for the user input.
		userInput = _getch();

		// If statements for the char chosen from the user.
		// Exits the program.
		if (userInput == 'q') {
			cout << endl << "Press ENTER to exit the program without saving.";
			break;
		}
		// Exits the program and asks for a file name.
		else if (userInput == 'e') {
			cin.clear();
			cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
			cout << endl << "Select a file name for the lock combination to be saved to. ";
			string fileName;
			
			// Letter validation for file name.
			while (true) {
				getline(cin, fileName);
				if (checkAlpha(fileName))
					break;
				cout << endl << "Only letters allowed. No numbers or special characters.";
			}
			fileName = fileName + ".txt";
			newList.SaveToFile(fileName.c_str());
			cout << endl << fileName << " has been saved. Press ENTER to exit.";
			break;
		}
		// Selects a node based on the position.
		else if (userInput == 'g') {
			listStart = 1;
			cout << endl << "Select a node based on position and press ENTER. ";
			// Validation so that you cant select a position that doesn't exist.
			while (true) {
				if ((cin >> position) && position <= listLimit && position >= listStart)
					break;
				cout << "Must be between " << listStart << "-" << listLimit << "." << endl;
				cin.clear();
				cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
			}
		}
		// Deletes/Resets a nodes value to 0.
		else if (userInput == 'd') {
			cout << endl << "Press ENTER to delete/reset the selected node to 0. ";
			_getch();
			newList.ResetSelectedNode(position);
		}
		// Resets all node values to 0.
		else if (userInput == 'r') {
			cout << endl << "Press ENTER to reset combination. ";
			_getch();
			newList.ResetList();
		}
		// Substitutes a nodes value for a nother values based on the position.
		else if (userInput == 's') {
			cout << endl << "Input a number between 1-49 and press ENTER. ";
			int value = 0;
			while (true) {
				if ((cin >> value) && value <= maxCNum && value >= minCNum)
					break;
				cout << "Must be between 1-49" << endl;
				cin.clear();
				cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
			}
			newList.SubstituteSelectedNode(position, value);
		}

		system("cls");
	}

	_getch();
	return 0;
}

// Options to be selected.
void outputOptions() {
	cout << endl << "                ---" << "[OPTIONS]" << "---" << endl;
	cout << "[Q](QUIT) - Exit program without saving." << endl;
	cout << "[E](EXIT) - Exit program and save to a text file." << endl;
	cout << "[G](GOTO) - Select a node based on position." << endl;
	cout << "[S](SUBSTITUTE) - Substitute the selected node's value for a new value." << endl;
	cout << "[D](DELETE) - Delete the selected node, replacing the value with 0." << endl;
	cout << "[R](RESET) - Resets all nodes to 0." << endl << endl;
	cout << "Select an option." << endl;
}

// Validation for numbers.
int numValidation(int value, int min, int max) {
	while (true) {
		if ((cin >> value) && value <= max && value >= min)
			break;
		cout << "Must be between 1-49" << endl;
		cin.clear();
		cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
	}
	return value;
}

// Validation for letters.
bool checkAlpha(const string &str) {
	for (int i = 0; i < str.size(); i++)
		if (!isalpha(str[i]) || isspace(str[i]))
			return false;
	return true;
}