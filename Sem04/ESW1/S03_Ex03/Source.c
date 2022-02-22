#include <stdio.h>

int power(int x, int y)
{
	int sum = x;
	for (int i = 0; i < y - 1; i++)
	{
		sum = sum * x;
	}

	return sum;
}

void multiSwap(int* x, int* y, int* z)
{
	int temp = *x;
	*x = *y;
	*y = *z;
	*z = temp;
}

int main()
{
	int result = power(2, 4);
	printf("Power: %d", result);

	int x = 1;
	int y = 2;
	int z = 3;

	printf("\nSequence before: %d, %d, %d", x, y, z);

	multiSwap(&x, &y, &z);

	printf("\nSequence after: %d, %d, %d", x, y, z);


	return 0;
}

