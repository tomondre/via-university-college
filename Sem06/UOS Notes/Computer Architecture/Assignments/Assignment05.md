# Assignment05
NOTE: I am having issues with running the multithreaded program on my computer (Apple M1). The headers used in the C code are OS specific – for Windows (<windows.h>), therefore I had to download VmWare with windows VM. I was able to run the sequential part of the assignment, but when I try to run the multi-threaded one, I am getting errors saying that the linker could not locate the pthread headers (even when I can see them in dependencies of the VS 2022 project and the IDE does not complain about missing headers). To me it seems like an issue with the pthread libraries that are being imported into the project. I have followed the guide on how to import these things, but still getting the same issue.
One of the warnings I am getting is that the library is of type x64 and my pc is arm64, so I believe this is the problem.

## Platform info
* CPU: Apple M1 Pro
* CPU Core Number: 8

## C Code
```
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <windows.h>
#define HAVE_STRUCT_TIMESPEC
#define _TIMESPEC_DEFINED
#include <pthread.h>

#define epsilon 0.005
#define N 10000000

double PCFreq = 0.0;
__int64 timerStart = 0;
double S[N], A[N], B[N];
double st = 0.0, et;

void* TaskCode(void* argument) {
	int tid;
	tid = *((int*)argument);
	
	for (int i = tid * (N / 4); i < (tid + 1) * (N / 4); i++) {
		S[i] = log(A[i]) + log(B[i]);
	}
	
	return NULL;
}

void StartTimer() {
	LARGE_INTEGER li;
	
	if (!QueryPerformanceCounter(&li)) {
		printf("QueryPerformanceCounter faild! \n");
	}

	PCFreq = (double)li.QuadPart / 1000.0;
	QueryPerformanceCounter(&li);
	timerStart = li.QuadPart;
}

double GetTimer() {
	LARGE_INTEGER li;
	QueryPerformanceCounter(&li);
	return (double)(li.QuadPart - timerStart) / PCFreq;
}

int main() {
	double execT = 0.0;
	pthread_t threads[4];
	int args[4];
	
	for (int i = 0; i < N; i++) {
		A[i] = (double)(i + 1);
		B[i] = (double)(i + 2);
		S[i] = 0.0;
	}
	
	StartTimer();
	
	for (int i = 0; i < N; i++) {
		S[i] = log(A[i]) + log(B[i]);
	}

	execT = GetTimer();

	printf("Execution Time of Single Threaded Program = %lf\n", execT);

	double* seq_S = S;

	StartTimer();

	for (int i = 0; i < 4; ++i) {
		args[i] = i;
		pthread_create(&threads[i], NULL, TaskCode, (void*)&args[i]);
	}

	for (int i = 0; i < 4; ++i) {
		pthread_join(threads[i], NULL);
	}

	execT = GetTimer();

	for (int i = 0; i < N; i++) {
		if (fabs(seq_S[i] - S[i]) / seq_S[i] > epsilon) {
			printf("Verification failed\n");
			return 1;
		}
	}
	printf("Verification succeeded. \n");
	printf("Parallel execution tie = %lf\n", execT);

	return 0;
}
```