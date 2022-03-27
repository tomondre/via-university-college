#include "Node.h"
#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
	void* item;
	node_t next;
} node;


node_t node_create(void* item)
{
	node_t node = calloc(sizeof(node), 1);

	if (NULL == node)
	{
		return NULL;
	}

	node->item = item;

	return node;
}


node_t node_getNext(node_t self)
{
	return self->next;
}

void node_setNext(node_t self, node_t next)
{
	self->next = next;
}

void* node_getItem(node_t self)
{
	return self->item;
}


void node_destroy(node_t self)
{
	if (self != NULL)
	{
		free(self);
	}
}