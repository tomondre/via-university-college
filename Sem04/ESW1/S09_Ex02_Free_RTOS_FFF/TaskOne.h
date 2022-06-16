#pragma once

#include "queue.h"
#include "semphr.h"
#include "message_buffer.h"

void taskOne_create(MessageBufferHandle_t _message, SemaphoreHandle_t _semaphore, SemaphoreHandle_t _mutex, QueueHandle_t _queue);
void taskOne_init();
void taskOne_run();
void taskOne_mutexTask();
void taskOne_loop(void* pvParameters);
void taskOne_semaphoreTask();
void taskOne_messageTask();