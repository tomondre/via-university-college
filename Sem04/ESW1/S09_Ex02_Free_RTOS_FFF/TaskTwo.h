#pragma once

#include "queue.h"
#include "semphr.h"
#include "message_buffer.h"

void taskTwo_create(MessageBufferHandle_t _message, SemaphoreHandle_t _semaphore, SemaphoreHandle_t _mutex, QueueHandle_t _queue);
void taskTwo_init();
void taskTwo_run();
void taskTwo_loop(void* pvParameters);
void taskTwo_mutexTask();
void taskTwo_semaphoreTask();
void taskTwo_messageTask();