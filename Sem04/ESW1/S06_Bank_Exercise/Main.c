#include "Account.h"
#include <stdio.h>

int main()
{
	account_t a1, a2;
	a1 = account_create(1, 2);
	a2 = account_create(2, 10);

	printf("Account 1 details: accountNo - %d, creditLimit - %d, balance %d", account_getAccountNo(a1), account_getCreditLimit(a1), account_getBalance(a1));
	printf("\nAccount 2 details: accountNo - %d, creditLimit - %d, balance %d", account_getAccountNo(a2), account_getCreditLimit(a2), account_getBalance(a2));

}
