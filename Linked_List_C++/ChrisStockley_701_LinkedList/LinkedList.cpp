#include "LinkedList.h"
#include <iostream>
#include <conio.h>
#include <fstream>
#include <sstream>

using namespace std;

// Constructor Method
LinkedList::LinkedList() {
	headNode = NULL;
	currentNode = NULL;
}

// Method to add a node at the end of the linked list.
void LinkedList::AddNode(int value) {
	// Created a new pointer, and points it at a new node.
	nodePtr newNode = new Node;
	// Makes the next value of the newly created node equal NULL.
	newNode->next = NULL;
	// Makes the newly created node's value, equal the value passed into the method.
	newNode->value = value;
	// Checks if there is a list already created.
	if (headNode != NULL) {
		// Makes the current node point to the first node.
		currentNode = headNode;
		// Changes the index of the current node to 2.
		newNode->index = 2;
		// Checks if the current node is at the end of the list.
		while (currentNode->next != NULL) {
			// Makes sure that the combination is 'L', than 'R'.
			if (currentNode->direction == 'L') {
				currentNode->next->direction = 'R';
			}
			else if (currentNode->direction == 'R') {
				currentNode->next->direction = 'L';
			}
			// Makes the current node equal the next node after that one.
			currentNode = currentNode->next;
			// Increases the newly created nodes's index by one.
			newNode->index += 1;
		}
		// Makes the newly created notde the last node in the list.
		currentNode->next = newNode;
	}
	// Else the list hasn't been created and the new node is put at the begginning of a new list.
	else {
		newNode->index = 1;
		headNode = newNode;
	}
}

// Method to print the linked list.
void LinkedList::PrintList(int position) {
	// Iterate through the linked list and prints it out. 
	// Selected node will be highlighted.
	currentNode = headNode;

	cout << "---Linked List Combination Code---" << endl << endl;
	while (currentNode != NULL) {
		if (currentNode->index == position) {
			cout << "   Position: " << currentNode->index << " - " << "Code Number: ["<< currentNode->direction << currentNode->value << "]<--Node Selected" << endl;
		}
		else {
			cout << "   Position: " << currentNode->index << " - " << "Code Number: " << currentNode->direction << currentNode->value << endl;
		}

		currentNode = currentNode->next;
	}
}

// Method for reseting the linked list.
void LinkedList::ResetList() {
	// Iterates through the list and substitutes all values for 0.
	currentNode = headNode;

	while (currentNode != NULL) {
		currentNode->value = 0;
		currentNode = currentNode->next;
	}
}

// Method for reseted a select node.
void LinkedList::ResetSelectedNode(int position) {
	// Iteratates through the list and substitutes the selected node's value to 0.
	currentNode = headNode;

	while (currentNode != NULL) {
		if (currentNode->index == position) {
			currentNode->value = 0;
			break;
		}

		currentNode = currentNode->next;
	}
}

// Method for substituting a select node.
void LinkedList::SubstituteSelectedNode(int position, int value) {
	// Iterates through the list and substitutes the selected node's value for the value passed into the method.
	currentNode = headNode;

	while (currentNode != NULL) {
		if (currentNode->index == position) {
			currentNode->value = value;
			break;
		}

		currentNode = currentNode->next;
	}
}

// Method for saving the linked list to a text file.
void LinkedList::SaveToFile(const char* fileName) {
	// Iterates through the list and adds it to the fstream.
	// Then saves it to a text file based on the file name passed to the method.
	ofstream f;
	f.open(fileName, ios::out);

	currentNode = headNode;

	f << "Saved Linked List." << endl << endl;

	while (currentNode != NULL) {
		 f << currentNode->direction << currentNode->value << endl;
		currentNode = currentNode->next;
	}

	f.close();
}

