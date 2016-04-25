#include "Hash.h"
#include <stdlib.h>
#include <iostream>
#include <string>
#include <conio.h>
#include <fstream> 

int main() {
	// Createsa new Hash object.
	Hash newHash;

	// Text files for use.
	ifstream dicfile("dictionary.txt");
	ifstream misfile("mispelled.txt");
	string str;

	// Adds the dictionary words to the hash table.
	while (getline(dicfile, str))
	{
		newHash.AddWord(str, str);
	}

	// Prints the hash table.
	newHash.PrintHashTable();

	// Checks for mispelling in the mispelled text file.
	while (getline(misfile, str))
	{
		std::string delimiter = " ";
		size_t pos = 0;
		string token;
		cout << endl << "Misspelled Words" << endl << endl;
		while ((pos = str.find(delimiter)) != std::string::npos) {
			for (int i = 0; i < str.length(); i++) {
				// Changes all letters to an empty string.
				if (!isalpha(str[i]))
					str[i] = ' ';
				else
					// Changes all letters to lower case.
					str[i] = tolower(str[i]);
			}
			token = str.substr(0, pos);
			// Makes sure it only checks the words that are left.
			if (token.length() > 0) {
				if (!newHash.FindValue(token))
					// Outputs the mispelled words.
					cout << token << endl;
			}
			str.erase(0, pos + delimiter.length());
		}
	}

	_getch();

	return 0;
}