#include "pch.h"

#include "gtest/gtest.h"

extern "C" {
#include <Account.h>
}

account_t acc;

class AccountTest : public ::testing::Test
{
protected:
	void SetUp() override
	{
		acc = account_create();
	}

	void TearDown() override
	{
	}
};

TEST_F(AccountTest, accountCanBeCreated)
{
	account_t acc = account_create();
	EXPECT_TRUE(acc != NULL);
}

TEST_F(AccountTest, balanceCanBeRetrieved)
{
	double balance = account_getBalance(acc);
	EXPECT_TRUE(balance == 0);
}

TEST_F(AccountTest, accountHasZeroBalanceWhenCreated)
{
	double balance = account_getBalance(acc);
	EXPECT_TRUE(balance == 0);
}

TEST_F(AccountTest, balanceCanBeRetrievedFromTheAccount)
{
	account_deposit(acc, 9);
	double balance = account_getBalance(acc);
	EXPECT_TRUE(balance == 10);
}

TEST_F(AccountTest, accountCanBeDeposited)
{
	account_deposit(acc, 10);
	account_getBalance(acc);
}
