inField 'reviews_id' doesn't have a default value# C code

## Before avoiding pipeline hazard
```
long A[9] = { -1, -2, -3, 1, 2, 3, 4, 5, 6};
long W[9] = { 1, 2, -1, -1, 0, 1, 0, -1, 1};
int main(void) {
	long sum = 0;
	int i, prod; 
	for(i=0; i<9; i++) { 
		prod = A[i] * W[i];
		if(prod<0) continue;

		sum += prod;
	}
	return 0;
}
```


## After avoiding pipeline hazard - loop unrolling
```
long A[9] = { -1, -2, -3, 1, 2, 3, 4, 5, 6};
long W[9] = { 1, 2, -1, -1, 0, 1, 0, -1, 1};

int main(void) {
	long sum = 0;
	int i, prod1, prod2, prod3; 

	for(i=0; i<9; i+=3) { 
		prod1 = A[i] * W[i];
		prod2 = A[i+1] * W[i+1];
		prod3 = A[i+2] * W[i+2];

		if(prod1 >= 0) sum += prod1;
		if(prod2 >= 0) sum += prod2;
		if(prod3 >= 0) sum += prod3;
	}
	return 0;
}
```

I have also found other methods that could be used for avoiding pipeline hazards like Loop blocking or Compiler hints, but I was not able to implement these techniques because the loop is simple. For example: I wanted to implement Loop tiling, but there was not a room for the division of our loop to smaller sub-loops.






# Simulation output
![[Pasted image 20230515101054.png]]
# Analysis
* From the simulation output, it is clear to see that the unloop unrolling has improved the performance of the execution because it minimises pipeline hazard
* The amount of clock cycles went from 1508 to 1484, including executions other than the loop body itself
* The factor of the loop unroll is 3 because the number of loop iterations in our loop is 9, which can be easily split into 3 executions
* Loop unrolling improves performance, but it also increases the size of the code, which can lead to more memory-heavy operations. There seems to be a trade-off between the number of clock cycles of the program and the memory required to run it