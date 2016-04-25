#include "Hash.h"
#include <iostream>
#include <string>

using namespace std;
Hash::Hash() {
	for (int i = 0; i < tableSize; i++) {
		HashTable[i] = new word;
		HashTable[i]->key = "empty";
		HashTable[i]->value = "empty";
		HashTable[i]->next = NULL;
	}
}

int Hash::HashString(string key) {
	// Takes the key of the string and gets the remainder 
	// by dividing its length by the hash table size.
	int hash = 0;
	int index;

	index = key.length();

	for (int i = 0; i < key.length(); i++){
		hash = hash + (int)key[i];
	}

	index = hash % tableSize;

	return index;
}

void Hash::AddWord(string key, string value)
{
	int index = HashString(key);

	// If the top node is empty;
	if (HashTable[index]->key == "empty") {
		HashTable[index]->key = key;
		HashTable[index]->value = value;
	}
	// If the node already has something in it. Create/Add to linked list.
	else {
		word* p = HashTable[index];
		word* n = new word;
		n->key = key;
		n->value = value;
		n->next = NULL;
		// Loops down the index list and adds the new word to the end.
		while (p->next != NULL) {
			p = p->next;
		}
		p->next = n;
	}
}

void Hash::PrintHashTable() {
	// Iterates through the table and print all values.
	int number;
	for (int i = 0; i < tableSize; i++) {
		cout << "---------------------------" << endl;
		cout << "Index " << i << " Values." <<  endl;
		// Prints all items in selected index.
		PrintItemsInIndex(i);
		cout << "---------------------------" << endl;
	}
}

void Hash::PrintItemsInIndex(int index) {
	// Starts where the selected index is.
	word* p = HashTable[index];

	if (p->key == "empty") {
		cout << "index = " << index << " is empty";
	}
	else {
		// Iterates through the index and prints the value.
		while (p->next != NULL) {
			cout << p->value << endl;
			p = p->next;
		}
	}
}

bool Hash::FindValue(string key) {
	// Gets the index by reverse hashing the key.
	int index = HashString(key);

	string value;

	word* p = HashTable[index];
	// Iterates through that index until the value is found.
	while (p != NULL) {
		if (p->key == key) {
			return true;
		}
		p = p->next;
	}
	return false;
}