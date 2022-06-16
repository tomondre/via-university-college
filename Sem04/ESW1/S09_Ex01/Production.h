#pragma once

typedef struct production* production_t;

void production_create();
void production_measureTemperature(int sensorNo);
int production_getTemperature(int sensorNo);
