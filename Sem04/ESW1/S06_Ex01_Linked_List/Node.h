#pragma once

typedef struct node* node_t;

void node_destroy(node_t self);
node_t node_create(void* item);
void* node_getItem(node_t self);
void node_setNext(node_t self, node_t next);
node_t node_getNext(node_t self);