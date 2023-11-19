# Overflow
* The number of bits in memory is not enough for the stored number

# Procedure Calling
* Used for calling a function
* The function makes code reusable and modular
* In C
	* The entry point for the C program is also a function
	* Function declaration needs to be created before it is called
	* The function declaration and implementation can be split (function prototype and definition can be split)
* There is a call hierarchy in nested function calls
* Function 1 has a caller - a function 2 has called function 1 - therefore caller is function 2, and function 1 is a callee
* A function can call multiple functions
* The result is tree-like structure of different calls between functions

## Steps
1. Copy parameters in registers x10 to x17
2. Transfer control to the procedure
3. Acquire storage for the procedure - stack
4. Perform procedure operations
5. Place the result in the register for the caller
6. Return to the place of call

## Global variable
How can a variable be defined globally?
Is it defined in the stack before the function call - lifetime is throughout the program - not throughout the function

# Stack
* Dynamic program that changes over time - shrinks
* Used to keep track of
	* Function parameters
	* Function returns
	* Global-scope variables
	* Local-scope variables

* Procedure call: jump and link
	* *jal x1, ProcedureLabel*
	* Address of following instruction put in x1
	* Jumps to target address labeled ProcedureLabel
* Procedure Return: jump and link register
	* *jalr x0, 0(x1)*
	* Like cal, but jumps to 0 + address in x1
	* Use x0 as rd (x0 cannot be changed)
	* Can also be used for computed jumps

## Leaf procedure Example
Procedure of a function call that does not call any other function
```
leaf_example:
	addi sp, sp, -24
	sd x5, 16 (sp)
	sd x6, 8 (sp)
	sd x20, 0(sp)
	add x5, x10, x11
	add x6, x12, x1
	sub x20, x5, x6
	addi x10, x20, 0
	ld x20, 0(sp)
	ld x6, 8(sp)
	ld x5, 16(sp)
	addi sp, sp, 24
	jalr x0, 0(x1)
```


## Non-Leaf Procedure Example
* Values are stored in the stack
	* Return address
	* Arguments and temporarioes needed for the call
* Restore from the stack after the call
* It is resposibility of caller to save the registers to stack so that they are not overwritten by callee
```
fact:
	addi sp, sp, -16
	sd x1, 8(sp)
	sd x10, 0(sp)
	addi x5, x10, -1
	bge x5, x10, L1
	addi x10, x0, L1
	addi sp, sp, 16
	jalr x0, 0(x1)
L1: 
	addi x10, x10, -1
	jal x1, fact
	addi x6, x10, 0
	ld x10, 0(sp)
	ld x1, 8(sp)
	addi sp, sp, 16
	mul x10, x10, x6
	jalr x0, 0(x1)
```

## Heap
* Dynamic data
* Malloc() in C, new in Java

## Branch addressing
* Branch instructions specify
	* Opcode, two registers, target address
* Most branch targets are near branch
	* Forward or backward
* SV format
* Instruction size is 32 bits
* Registers has 64
* Relative addressing
	* Translating the label in terms of relative address to baseline address
	* Check
	* Called PC-relative addressing - target address = PC + immediate * 2