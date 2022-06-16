#include "FreeRTOS.h"

#include "TaskTwo.h"
#include <stdio.h>
#include "task.h"
#include "queue.h"
#include "semphr.h"
#include "SharedResource.h"
#include "message_buffer.h"

QueueHandle_t queue;
SemaphoreHandle_t mutex;
SemaphoreHandle_t semaphore;
MessageBufferHandle_t message;

void taskTwo_create(MessageBufferHandle_t _message, SemaphoreHandle_t _semaphore, SemaphoreHandle_t _mutex, QueueHandle_t _queue) {
	queue = _queue;
	mutex = _mutex;
	semaphore = _semaphore;
	message = _message;

	taskTwo_init();
	
	xTaskCreate(
		taskTwo_loop,       /* Function that implements the task. */
		"MySecondTask",          /* Text name for the task. */
		configMINIMAL_STACK_SIZE,      /* Stack size in words, not bytes. */
		(void*)2,    /* Parameter passed into the task. */
		10,/* Priority at which the task is created. */
		NULL);      /* Used to pass out the created task's handle. */

}

void taskTwo_init() {
	printf("Task Two> Init \n");
}

void taskTwo_run() {
	// queueTask();
	//taskTwo_mutexTask();
	//taskTwo_semaphoreTask();
	taskTwo_messageTask();
}

void taskTwo_messageTask() {
	char* string = "Halabala";
	xMessageBufferSend(message, &string, sizeof(string), portMAX_DELAY);
	printf("Task Two> Message %s send \n", string);
}

void taskTwo_semaphoreTask() {
	xSemaphoreTake(semaphore, portMAX_DELAY);
	printf("TaskTwo> Semaphore taken \n");

	sharedResource_setValue(20);
	printf("TaskTwo> Shared Resource Value set to 20 and current value is: %d \n", sharedResource_getValue());

	xSemaphoreGive(semaphore);
	printf("TaskTwo> Semaphore given \n");
}

void taskTwo_mutexTask() {
	xSemaphoreTake(mutex, portMAX_DELAY);
	printf("TaskTwo> Mutex taken \n");
	
	sharedResource_setValue(20);
	printf("TaskTwo> Shared Resource Value set to 20 and current value is: %d\n", sharedResource_getValue());
	
	xSemaphoreGive(mutex);
	printf("TaskTwo> Mutex given \n");
}

void taskTwo_queueTask() {
	int value = 9;
	vTaskDelay(pdMS_TO_TICKS(1000));
	xQueueSend(queue, &value, portMAX_DELAY);
	printf("Task Two> Value Sends \n");
	
}

void taskTwo_loop(void* pvParameters)
{
	// Remove compiler warnings.
	(void)pvParameters;

	int i = 0;

	for (;;)
	{
		vTaskDelay(pdMS_TO_TICKS(1000));
		taskTwo_run();
	}
}
