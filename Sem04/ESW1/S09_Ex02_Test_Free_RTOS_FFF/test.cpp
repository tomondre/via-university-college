#include "gtest/gtest.h"

#include "../Fake Function Framework/fff.h"

DEFINE_FFF_GLOBALS

extern "C" {
	#include "TaskOne.c"
	#include "TaskTwo.c"
}

FAKE_VOID_FUNC(taskOne_run);
FAKE_VOID_FUNC(taskTwo_run);

class ProductionTest : public ::testing::Test {
protected:
	void SetUp() override {
		RESET_FAKE(taskOne_run);
		RESET_FAKE(taskTwo_run);
		FFF_RESET_HISTORY();
	}
	void TearDown() override {
	}
};

TEST_F(ProductionTest, CreateTest) {
	//Arrange

	//Act

	//Assert
}

TEST_F(ProductionTest, MeasureAndGetTemperature) {
	//Arrange

	//Act

	//Assert

}