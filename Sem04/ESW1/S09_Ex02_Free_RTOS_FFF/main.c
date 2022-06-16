#include <stdio.h>
#include "FreeRTOS.h"
#include "task.h"
#include "queue.h"
#include "semphr.h"
#include "message_buffer.h"

#include "TaskOne.h"
#include "TaskTwo.h"


void main(void)
{	
	QueueHandle_t queue = xQueueCreate(10, sizeof(int));
	SemaphoreHandle_t mutex = xSemaphoreCreateMutex();
	SemaphoreHandle_t semaphore = xSemaphoreCreateBinary();
	MessageBufferHandle_t message = xMessageBufferCreate(10);

	xSemaphoreGive(semaphore);

	taskOne_create(message, semaphore, mutex, queue);
	taskTwo_create(message, semaphore, mutex, queue);
	vTaskStartScheduler();
}