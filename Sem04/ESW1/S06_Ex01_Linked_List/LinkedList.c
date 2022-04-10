#include "LinkedList.h"
#include "Node.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct linkedList
{
	node_t root;
} linkedList;


linkedList_t linkedList_create()
{
	linkedList_t list = calloc(sizeof(linkedList), 1);

	if (list == NULL)
	{
		return NULL;
	}
	list->root = NULL;
	return list;
}

list_code_t linkedList_destroy(linkedList_t* self)
{
	if (self != NULL)
	{
		free(self);
	}
	*self = NULL;
	return OK;
}

list_code_t linkedList_push(linkedList_t self, void* item)
{
	node_t node = node_create(item);
	node_setNext(node, self->root);
	self->root = node;
	return OK;
}

void* linkedList_pull(linkedList_t self)
{
	if (self->root == NULL)
	{
		return NULL;
	}

	node_t root = self->root;
	self->root = node_getNext(root);
	//root = NULL;
	void* itemResult = node_getItem(root);
	node_destroy(root);
	return itemResult;
}

list_code_t linkedList_containsItem(linkedList_t self, void* item)
{
	node_t current = self->root;
	while (current != NULL)
	{
		if (node_getItem(current) == item)
		{
			return FOUND;
		}
		current = node_getNext(current);
	}
	return NOT_FOUND;
}

list_code_t linkedList_removeItem(linkedList_t self, void* item)
{
	node_t current = self->root;
	if (current == NULL)
	{
		return NOT_FOUND;
	}
	if (node_getItem(current) == item)
	{
		self->root = node_getNext(current);
		return OK;
	}

	node_t next = node_getNext(current);
	while (next != NULL)
	{
		if (node_getItem(next) == item)
		{
			node_setNext(current, node_getNext(next));
			node_setNext(next, NULL);
			//SHOULD WE DESTROY?
			return OK;
		}
		current = next;
		next = node_getNext(current);
	}
	
	return NOT_FOUND;
}

void* linkedList_peekItemByIndex(linkedList_t self, int index)
{
	node_t current = self->root;

	while (current != NULL)
	{
		if (index == 0)
		{
			return node_getItem(current);
		}
		current = node_getNext(current);
		index--;
	}
	return NULL;
}

int linkedList_length(linkedList_t self)
{
	node_t current = self->root;

	if (NULL == self->root)
	{
		return 0;
	}

	int count = 0;
	while (current != NULL)
	{
		count++;
		current = node_getNext(current);
	}
	return count;
}


void linkedList_clear(linkedList_t self)
{
	self->root = NULL;
}