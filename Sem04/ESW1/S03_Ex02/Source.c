#include <stdio.h>

int main()
{
	char text[] = "The quick brown fox jumps over lazy dog";
	char* endS = text + 39; /* Don't worry about this */

	printf("The string now says: \"%s\n", text);
	*endS = '\0';
	printf("The string now says: \"%s\n", text);

	//Repeat the following three lines in your own example, but experiment 
	//with different values than just subtracting 1 from endS

	endS = endS - 1;
	*endS = "\0";
	printf("The string now says: \"%s\n", text);
	return 0;
}
