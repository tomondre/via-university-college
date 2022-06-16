#include "FreeRTOS.h"

#include <stdio.h>
#include "task.h"
#include "queue.h"
#include "semphr.h"
#include "TaskOne.h"
#include "SharedResource.h"
#include "message_buffer.h"

QueueHandle_t queue;
SemaphoreHandle_t mutex;
SemaphoreHandle_t semaphore;
MessageBufferHandle_t message;

void taskOne_create(MessageBufferHandle_t _message, SemaphoreHandle_t _semaphore, SemaphoreHandle_t _mutex, QueueHandle_t _queue) {
	queue = _queue;
	mutex = _mutex;
	semaphore = _semaphore;
	message = _message;

	taskOne_init();

	xTaskCreate(
		taskOne_loop,       /* Function that implements the task. */
		"MyFirstTask",          /* Text name for the task. */
		configMINIMAL_STACK_SIZE,      /* Stack size in words, not bytes. */
		(void*)2,    /* Parameter passed into the task. */
		2,/* Priority at which the task is created. */
		NULL);      /* Used to pass out the created task's handle. */

}

void taskOne_init() {
	printf("Task One Init");
}

void taskOne_run() {
	// queueTask();
	//taskOne_mutexTask();
	//taskOne_semaphoreTask();
	taskOne_messageTask();
}

void taskOne_messageTask() {
	char* string = "";

	xMessageBufferReceive(message, &string, 20, portMAX_DELAY);

	printf("TaskOne> Message received: %s \n", string);
}

void taskOne_semaphoreTask() {
	xSemaphoreTake(semaphore, portMAX_DELAY);
	printf("TaskOne> Semaphore taken \n");

	printf("TaskOne> Shared Resource Value set to 20 and current value is: %d\n", sharedResource_getValue());

	xSemaphoreGive(semaphore);
	printf("TaskOne> Semaphore given \n");
}

void taskOne_mutexTask() {
	//xSemaphoreTake(mutex, portMAX_DELAY);
	printf("TaskOne> Mutex taken \n");
	
	sharedResource_setValue(10);
	printf("TaskOne> Shared Resource Value set to 10 and current value is: %d\n", sharedResource_getValue());
	
	//xSemaphoreGive(mutex);
	printf("TaskOne> Mutex given \n");
}

void taskOne_queueTask() {
	int value;
	xQueueReceive(queue, &value, portMAX_DELAY);
	printf("Task One> Run Received: %d \n", value);
}

void taskOne_loop(void* pvParameters)
{
	// Remove compiler warnings.
	(void)pvParameters;

	for (;;)
	{
		taskOne_run();
	}
}
