#include <stdio.h>

void main() {
	int fahr, celsius;
	int lower, upper, step;
	lower = 0;
	upper = 300;
	step = 20;

	fahr = lower;

	printf("fahr celsius\n");
	while (fahr <= upper) {
		celsius = 5 * (fahr - 32) / 9;
		printf("%d\t%d\n", fahr, celsius);
		fahr = fahr + step;
	}
	printf("/n");

	
	lower = -17;
	upper = 148;
	step = 9;
	celsius = lower;

	printf("celsius fahr/n");
	while (celsius <= upper)
	{
		fahr = (celsius * 1.8) + 32;
		printf("%d\t%d\n", celsius, fahr);
		celsius = celsius + step;
	}
}