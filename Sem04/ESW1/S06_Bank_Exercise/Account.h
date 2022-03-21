#pragma once

typedef struct account* account_t;

typedef enum AccountStatus
{
	OK,
	OVER_MAX_CREDIT_LIMIT,
	ACCOUNT_NOT_INSTANTIATED
} account_status_t;

account_t account_create(int accountNo, double creditLimit);
account_status_t account_withdraw(account_t self, double amount);
account_status_t account_deposit(account_t self, double amount);
double account_getBalance(account_t self);
double account_getCreditLimit(account_t self);
int account_getAccountNo(account_t self);