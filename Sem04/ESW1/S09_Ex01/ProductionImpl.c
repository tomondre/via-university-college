#include "Production.h"
#include "HAL.h"

#include "stdlib.h"

int lastVoltage = 0;

void production_create() {
	production_t create = calloc(1, sizeof(production_t));
	HAL_create(10);
	return create;
}

void production_measureTemperature(int sensorNo) {
	lastVoltage = HAL_getVoltage(sensorNo);
}

int production_getTemperature(int sensorNo) {
	return lastVoltage * 2;
}