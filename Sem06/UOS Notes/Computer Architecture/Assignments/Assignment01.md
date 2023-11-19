How to initialise a variable to 0
*add c0 c0*
*addi x5 x0 7*

* Please assume that 
	* x18 for _sum_
	* x19 for _i_
	* x20 for _prod_
	* x21 for _A_
	* X22 for _W_

```
long sum = 0;
int i, prod; 
for (i=0; i<9; i++) { 
	prod = A[i] * W[i]; //use 'mul' for *
	if (prod<0) continue;
	sum += prod;
}
```

// Initializes sum and set value to 0
add x19, x0, 0
// Initializes i and set value to 0
add x18, x0, 0
// Sets the upper limit value for for loop (9)
li x27 9
LOOP:
	// Sets pointer of A to index i
	add x23, x21, x19
	// Sets pointer of W to index i
	add x24, x22, x19
	// Loads the values that are currently pointer by x23 and x22
	ld x25 0(x23)
	ld x26 0(x24)
	mul x20, x25, x26
	// if statement
	blt x20, r0, LOOP
	// Adds the prod to sum
	add x18, x18, c20
	// Increment i
	addi x19, x19, 1
	// Check loop condition
	blt x18, x27  EXIT
	// Check loop condition
	beq x0, x0 LOOP
EXIT:



```
add x19, x0, 0
add x18, x0, 0
li x27 9
LOOP:
	bge x19, x27  EXIT
	addi x19, x19, 1
	add x23, x21, x19
	add x24, x22, x19
	ld x25 0(x23)
	ld x26 0(x24)
	mul x20, x25, x26
	blt x20, x0, LOOP
	add x18, x18, c20
	
	beq x0, x0 LOOP
EXIT:
```