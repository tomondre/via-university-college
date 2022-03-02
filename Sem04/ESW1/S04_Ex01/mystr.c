#include <stdio.h>
#include"mystr.h"

int my_strlen(const char* str)
{
	int count = 0;
	while(*str!= '\0')
	{
		count++;
		str++;
	}

	return count;
}

int my_strcmp(const char* str1, const char* str2)
{

	if(my_strlen(str1) != my_strlen(str2))
	{
		return 0;
	}

	while (*str1 != '\0')
	{
		if (*str1 < *str2)
		{
			return -1;
		} else
		{
			return 1;
		}

		str1++;
		str2++;
	}

	return 0;
}

char* my_strcpy(char* dest, const char* src)
{
	// int i = 0;
	// while (*(src + i) != '\0')
	// {
	// 	*(dest + i) = *(src + i);
	//
	// 	i++;
	// }
	// return dest;

	char* result = dest;
	while (*src != '\0')
	{
		*dest = *src;
		dest++;
		src++;
	}
	return result;
}

char* my_strdup(const char* str)
{
	 
}