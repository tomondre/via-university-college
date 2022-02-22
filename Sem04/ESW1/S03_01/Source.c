#include <stdio.h>
#include "Source.h"

int main() {
	int a, b;
	a = 7;
	b = 3;

	float divResult = (float) a / b;
	float modResult = a % b;
	
	printf("Division: %f", divResult);
	printf("\nModulo: %f", modResult);
	printf("\nDivision: %f, Modulo: %f", divResult, modResult);

	return 0;
}