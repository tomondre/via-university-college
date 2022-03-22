#include "gtest/gtest.h"

extern "C" {
#include <production.h>
}

class ProductionTest : public ::testing::Test
{
protected:
	void SetUp() override
	{
	}

	void TearDown() override
	{
	}
};

TEST_F(ProductionTest, TestName)
{
	int sum = production_sum(1, 2);
	ASSERT_EQ(sum, 3);
}
