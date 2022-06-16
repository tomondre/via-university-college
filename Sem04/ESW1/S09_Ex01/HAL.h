#pragma once

typedef struct HAL* HAL_t;

void HAL_create(int portNo);
int HAL_getVoltage(int channel);