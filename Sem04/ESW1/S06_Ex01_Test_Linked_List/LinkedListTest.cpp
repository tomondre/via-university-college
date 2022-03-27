#include "gtest/gtest.h"

extern "C" {
#include <LinkedList.h>
}

linkedList_t linkedList;

class LinkedListTest : public ::testing::Test
{
protected:
	void SetUp() override
	{
		linkedList = linkedList_create();
	}

	void TearDown() override
	{
	}
};


//TODO Out of heap
// Push too many


//------------------CREATE------------------

TEST_F(LinkedListTest, CanBeCreated)
{
	linkedList_t list = NULL;
	list = linkedList_create();
	ASSERT_TRUE(list != NULL);
}


//------------------DESTROY------------------
TEST_F(LinkedListTest, DestroyReturnsCorrectCode)
{
	//Act
	list_code_t code = linkedList_destroy(linkedList);

	//Assert
	ASSERT_TRUE(OK == code);
}


//------------------PUSH------------------
TEST_F(LinkedListTest, ValueIsPushed)
{
	int value = 1;
	list_code_t code = linkedList_push(linkedList, &value);
	ASSERT_TRUE(code == OK);
}

TEST_F(LinkedListTest, PushMultipleValues)
{
	int value = 1;
	list_code_t c1 = linkedList_push(linkedList, &value);
	list_code_t c2 = linkedList_push(linkedList, &value);
	list_code_t c3 = linkedList_push(linkedList, &value);

	EXPECT_TRUE(c1 == OK);
	EXPECT_TRUE(c2 == OK);
	EXPECT_TRUE(c3 == OK);

	EXPECT_TRUE(linkedList_length(linkedList) == 3);
}


//------------------PULL------------------
//TODO How to cast void pointer to int?
TEST_F(LinkedListTest, PullSingleItem)
{
	//Arrange
	int v1 = 1;
	linkedList_push(linkedList, &v1);

	//Act
	int r1 = *(int*) linkedList_pull(linkedList);

	//Assert
	ASSERT_TRUE(r1 == 1);
}


//TODO
TEST_F(LinkedListTest, PullMultipleItems)
{
	//Arrange
	int v1 = 1;
	linkedList_push(linkedList, &v1);
	int v2 = 2;
	linkedList_push(linkedList, &v2);
	int v3 = 3;
	linkedList_push(linkedList, &v3);

	//Act
	int r1 = *(int*) linkedList_pull(linkedList);
	int r2 = *(int*) linkedList_pull(linkedList);
	int r3 = *(int*) linkedList_pull(linkedList);

	//Assert
	EXPECT_TRUE(r1 == 3);
	EXPECT_TRUE(r2 == 2);
	EXPECT_TRUE(r3 == 1);
}

TEST_F(LinkedListTest, PullEmptyList)
{
	//Act
	int r1 = (int)linkedList_pull(linkedList);

	//Assert
	ASSERT_TRUE(r1 == NULL);
}


//------------------CONTAINS ITEM------------------
TEST_F(LinkedListTest, ContainsPushedItem)
{
	//Arrange
	int v1 = 1;
	list_code_t pushCode = linkedList_push(linkedList, &v1);

	//Act
	list_code_t containsCode = linkedList_containsItem(linkedList, &v1);

	//Assert
	EXPECT_TRUE(pushCode == OK);
	EXPECT_TRUE(containsCode== FOUND);
}

TEST_F(LinkedListTest, ContainsPushedItems)
{
	//Arrange
	int v1 = 1;
	list_code_t p1_code = linkedList_push(linkedList, &v1);
	int v2 = 2;
	list_code_t p2_code = linkedList_push(linkedList, &v2);


	//Act
	list_code_t containsCode_1 = linkedList_containsItem(linkedList, &v1);
	list_code_t containsCode_2 = linkedList_containsItem(linkedList, &v2);


	//Assert
	EXPECT_TRUE(p1_code == OK);
	EXPECT_TRUE(containsCode_1 == FOUND);

	EXPECT_TRUE(p2_code == OK);
	EXPECT_TRUE(containsCode_2 == FOUND);
}

TEST_F(LinkedListTest, NotContainsPushedItem)
{
	//Arrange
	int v1 = 1;
	list_code_t pushCode = linkedList_push(linkedList, &v1);
	int v2 = 2;

	//Act
	list_code_t containsCode = linkedList_containsItem(linkedList, &v2);

	//Assert
	EXPECT_TRUE(pushCode == OK);
	EXPECT_TRUE(containsCode == NOT_FOUND);
}


//------------------REMOVE ITEM------------------
TEST_F(LinkedListTest, RemoveZero)
{
	//Arrange
	int itemNotExistingInList = 2;

	//Act
	list_code_t removeItemCode = linkedList_removeItem(linkedList, &itemNotExistingInList);

	//Assert
	ASSERT_TRUE(removeItemCode == NOT_FOUND);
}

//REMOVE FROM ONE
TEST_F(LinkedListTest, RemoveFromOne)
{
	//Arrange
	int item_1 = 1;

	linkedList_push(linkedList, &item_1);

	//Act
	list_code_t removeItemCode = linkedList_removeItem(linkedList, &item_1);
	list_code_t containsResult = linkedList_containsItem(linkedList, &item_1);

	//Assert
	EXPECT_TRUE(removeItemCode == OK);
	EXPECT_TRUE(containsResult == NOT_FOUND);
}

//ERROR crt detected that the application wrote to memory after end of heap buffer
TEST_F(LinkedListTest, RemoveFromMultiple)
{
	//Arrange
	int item_1 = 1;
	int item_2 = 2;
	int item_3 = 3;

	linkedList_push(linkedList, &item_1);
	linkedList_push(linkedList, &item_2);
	linkedList_push(linkedList, &item_3);

	//Act
	list_code_t removeItemCode = linkedList_removeItem(linkedList, &item_1);
	list_code_t containsResult = linkedList_containsItem(linkedList, &item_1);

	//Assert
	EXPECT_TRUE(removeItemCode == OK);
	EXPECT_TRUE(containsResult == NOT_FOUND);
}

//------------------PEEK ITEM BY INDEX------------------
TEST_F(LinkedListTest, PeekIndexZero)
{
	//Arrange
	int item_1 = 1;
	int item_2 = 2;
	int item_3 = 3;

	linkedList_push(linkedList, &item_1);
	linkedList_push(linkedList, &item_2);
	linkedList_push(linkedList, &item_3);

	int index = 0;

	//Act
	void* peek = linkedList_peekItemByIndex(linkedList, index);
	int value = * ((int*)peek);

	//Assert
	ASSERT_TRUE(value == 3);
}

TEST_F(LinkedListTest, PeekIndexOne)
{
	//Arrange
	int item_1 = 1;
	int item_2 = 2;
	int item_3 = 3;

	linkedList_push(linkedList, &item_1);
	linkedList_push(linkedList, &item_2);
	linkedList_push(linkedList, &item_3);

	int index = 1;

	//Act
	int peek = *(int*)linkedList_peekItemByIndex(linkedList, index);

	//Assert
	ASSERT_TRUE(peek == 2);
}




//------------------LENGTH------------------
TEST_F(LinkedListTest, LengthIsOneWhenSingleElementPushed)
{
	//Arrange
	int value = 1;

	//Act
	list_code_t code = linkedList_push(linkedList, &value);
	int legnth = linkedList_length(linkedList);

	//Assert
	EXPECT_TRUE(code == OK);
	EXPECT_TRUE(legnth == 1);
}

TEST_F(LinkedListTest, LengthCorrespondsToNumberOfElementPushed)
{
	//Arrange
	int value = 1;

	//Act
	linkedList_push(linkedList, &value);
	linkedList_push(linkedList, &value);
	linkedList_push(linkedList, &value);
	int legnth = linkedList_length(linkedList);

	//Assert
	EXPECT_TRUE(legnth == 3);
}


TEST_F(LinkedListTest, LengthZeroWhenCreated)
{
	//ACT
	int length = linkedList_length(linkedList);

	//ASSERT
	ASSERT_TRUE(length == 0);
}


//------------------CLEAR------------------

TEST_F(LinkedListTest, Clear)
{
	//ARANGE
	int item_1 = 1;
	int item_2 = 2;
	int item_3 = 3;

	linkedList_push(linkedList, &item_1);
	linkedList_push(linkedList, &item_2);
	linkedList_push(linkedList, &item_3);

	//ACT
	linkedList_clear(linkedList);


	//ASSERT
	ASSERT_TRUE(linkedList_length(linkedList) == 0);
}

TEST_F(LinkedListTest, ClearEempty)
{
	//ACT
	linkedList_clear(linkedList);

	//ASSERT
	ASSERT_TRUE(linkedList_length(linkedList) == 0);
}