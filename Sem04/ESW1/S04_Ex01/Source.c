#include <stdio.h>

#include"mystr.h"


int main()
{
	const char string[] = "123456";
	int count = my_strlen(string);
	printf("Count: %d", count);

	const char s1[] = "12345678";
	const char s2[] = "12345678";
	int result = my_strcmp(s1, s2);
	printf("\nCompare: %d", result);
	

	return 0;
}