#ifndef HASH_H
#define HASH_H

#include "Hash.h"
#include <iostream>
#include <string>

using namespace std;

class Hash {
private:
	// Hast table size.
	static const int tableSize = 10;
	
	// Private word used in the Hash Table.
	struct word {
		string key;
		string value;
		word* next;
	};

	// Hash table array.
	word* HashTable[tableSize];

public:
	// Constructor.
	Hash();
	// Method to hash at string.
	int HashString(string key);
	// Adds a word to the hash table.
	void AddWord(string key, string value);
	// Prints the final hash table.
	void PrintHashTable();
	// Prints the items in each index.
	void PrintItemsInIndex(int index);
	// Seaches the hash table by value.
	bool FindValue(string key);
};

#endif
