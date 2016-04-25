#ifndef LINKEDLIST_H
#define LINKEDLIST_H

class LinkedList {
private:
	// Inner class for the linked list class.
	typedef struct Node {
		// Variables used for the Node class.
		int value;
		char direction = 'R';
		int index;
		Node* next;
	}* nodePtr;

	// Private variables used for the Linked List class.
	nodePtr headNode;
	nodePtr currentNode;

public:
	// Constructor.
	LinkedList();
	// Add node to linked list method.
	void AddNode(int value);
	// Reset selected node method.
	void ResetSelectedNode(int position);
	// Print linked list method.
	void PrintList(int positon);
	// Reset the entire linked list method.
	void ResetList();
	// Substitute selected node method.
	void SubstituteSelectedNode(int position, int value);
	// Save to file method.
	void SaveToFile(const char* fileName);
	
	// Unused functions for future. 
	//void DeleteSelectedNode(int position);
	//void InsertAfterValue(int value, int num);
	//void InsertAtPosition(int nodenum, int num);
	//int RetrieveValue(int value);
	//int RetrievePosition(int nodenum);*/
};

#endif
