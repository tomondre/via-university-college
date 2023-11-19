
```
long A[9] = { -1, -2, -3, 1, 2, 3, 4, 5, 6};
long W[9] = {-2, 1, 2, -3, 1, 1, 2, 1, 1};
long sum = 0;

long mult( long a, long b );

int main (void) {
   int i, prod;
   for (i=0; i<9; i++) {
      prod = mult(A[i], W[i]);
      if (prod<0) continue;
      sum += prod;
   }
   return 0;  
}

long mult(long a, long b) {
   long ret;
   ret = a * b;
   return ret;
}
```

# Code
```
add x19, x0, 0
add x18, x0, 0
li x27 9
LOOP:
	bge x19, x27  EXIT
	addi x19, x19, 1
	add x23, x21, x19
	add x24, x22, x19

	# Load values for arrays to parameter registers
	ld x10 0(x23)
	ld x11 0(x24)

	jal x1, MULT

	# Copy the return value to prod
	addi x20, x10, 0
	
	blt x20, x0, LOOP
	add x18, x18, c20
	
	beq x0, x0 LOOP

MULT:
	# Allocate memory for the procedure
	addi sp, sp, -8
	sd x20, 8(sp)

	mul x20, x10, x11
	addi x10, x20, 0

	# Rollback the memory state
	ld x20, 8(sp)
	addi sp, sp, 8
	jalr x0, 0(x1)

EXIT:
```

