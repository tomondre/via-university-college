#pragma once

typedef struct account* account_t;

typedef enum STATUS
{
	OK,
	FORBIDDEN
}status_t;

account_t account_create();
double account_getBalance(account_t self);
status_t account_withdraw(account_t self, double amount);
status_t account_deposit(account_t self, double amount);

