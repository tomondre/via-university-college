#pragma once

typedef struct linkedList* linkedList_t;

typedef enum ListReturnCode
{
	OK,
	EMPTY,
	NOT_FOUND,
	FULL,
	FOUND
} list_code_t;

linkedList_t linkedList_create();
list_code_t linkedList_destroy(linkedList_t self);
list_code_t linkedList_push(linkedList_t self, void* item);
void* linkedList_pull(linkedList_t self);
list_code_t linkedList_containsItem(linkedList_t self, void* item);
list_code_t linkedList_removeItem(linkedList_t self, void* item);
void* linkedList_peekItemByIndex(linkedList_t self, int index);
int linkedList_length(linkedList_t self);
void linkedList_clear(linkedList_t self);
//void linkedList_getIterator();
//void* linkedList_iteratorNext(LinkedListIterator iterator);
