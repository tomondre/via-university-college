#include "Account.h"
#include <stdio.h>
#include <stdlib.h>


typedef struct account
{
	int accountNo;
	double creditLimit;
	double balance;
} account;

account_t account_create(int accountNo, double creditLimit)
{
	account_t _new_account = calloc(sizeof(account), 1);

	if (NULL == _new_account)
	{
		return NULL;
	}

	//_new_account->accountNo = accountNo;
	//_new_account->creditLimit = creditLimit;

	return _new_account;
}

account_status_t account_withdraw(account_t self, double amount)
{
	if (self == NULL)
	{
		return ACCOUNT_NOT_INSTANTIATED;
	}
	if ((self->balance - amount) > -self->creditLimit)
	{
		return OVER_MAX_CREDIT_LIMIT;
	}
	self->balance -= amount;
	return OK;
}


account_status_t account_deposit(account_t self, double amount)
{
	if (self == NULL)
	{
		return ACCOUNT_NOT_INSTANTIATED;
	}
	self->balance += amount;
	return OK;
}

double account_getBalance(account_t self)
{
	return self->balance;
}

double account_getCreditLimit(account_t self)
{
	return self->creditLimit;
}

int account_getAccountNo(account_t self)
{
	return self->accountNo;
}

void account_destroy(account_t self)
{
	if (NULL != self)
	{
		free(self);
	}
}
