#include "gtest/gtest.h"

#include "../Fake Function Framework/fff.h"

DEFINE_FFF_GLOBALS

extern "C" {
#include "Production.h"
#include "HAL.h"
}

FAKE_VOID_FUNC(HAL_create, int);
FAKE_VALUE_FUNC(int, HAL_getVoltage, int);

class ProductionTest : public ::testing::Test {
protected:
	void SetUp() override {
		RESET_FAKE(HAL_create);
		RESET_FAKE(HAL_getVoltage);
		FFF_RESET_HISTORY();
	}
	void TearDown() override {
	}
};

TEST_F(ProductionTest, CreateTest) {
	//Arrange


	//Act
	production_create();

	//Assert
	ASSERT_EQ(HAL_create_fake.call_count, 1);
}

TEST_F(ProductionTest, MeasureAndGetTemperature) {
	//Arrange
	HAL_getVoltage_fake.return_val = 10;
	production_create();

	//Act
	production_measureTemperature(100);
	int temperature = production_getTemperature(100);

	//Assert
	ASSERT_EQ(temperature, 20);

}