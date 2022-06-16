#include "SharedResource.h"

int value = 0;

int sharedResource_getValue() {
	return value;
}
void sharedResource_setValue(int _value) {
	value = _value;
}