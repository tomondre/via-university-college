# Memory operands
* Byte addressed
	* Unit of address in the memory
* Word aligned
	* The address of a word must be on a multiple of 4 in MIPS and ARM
* Word equals to 4 bytes
## Memory Operand Example 2
* Store
	* Two inputs - register index and content to be stored
	* Memory is a destination, register is source
	* To store register value to memory
* Integer is a full-byte long 

# Registers vs Memory
* Registers are faster to access than memory
* Operating on memory data requires loads and stores
	* More instructions to be executed
* Compiler must use registers for variables as much as possible
	* Only spill to memory for less frequently used variables
	* Register optimization is important
* ==Register spill== is a responsibility of a compiler

# Immediate operands
* Constant data specified in an instructions
	* addi x22, x22, 4 # x22 = x22 + 4
* Design Principle 3 - most common case fast
	* Small constants are common
	* Immediate oeprand avoid a load instruction
* Cons of the solution
	* There is a requirement for the hardware to contain a MUX, in order to be able for ALU to accept two values - register value and value from the instruction
	* Bit instruction is limited - there is only specific size for instructions

# Sign Extension
* Representing a numbe rusing more bits
	* Preserve the numeric value
* Replicate the sign bit to the left - unsigned values - extend with 0s
* Examples - 8-but to 16-bit
* Register size is 8 byte long
* Load of the unsigned value should be done with a load unsigned command - this one does not care about the most left bit

# Representing Instructions
* Instructions are encoded in binary
	* Called machine instruction
	* Machine code - a sequence of machine instructions
* RISC-V Instructions
	* Encoded as 32-bit instructions words
	* Small number of formats - Regurality

# R-Format Example
![[Pasted image 20230404111931.png]]
* Register pointers has a value of 5 bits due to the number of registers in hardware - up to 32
* There is a dependency between number of registers and instruction size - the more the registers in hardware, the longer the instruction will be
* The bigger the instruciton, the less efficiency of the hardware - each instruction needs to be fetched from memory before being executed - the bigger instruction, the more time it takes to actually fetch the instruction

# Hexadecimal
* Base 16
* Compact representation of bit strings
* 4 bits per hex digit

# RISC-V I-Format Instructions
* Immediate arithmetic and load instructions
	* rs1: source or base address register number
	* immediate: constant operand or offset added or base address
	* One of the bits in immediate operation is reserved for the sign - due to the fact the the immediate number is signed
* Design principle: good design demands good compromises
	* Different formats complicate decoding but allow 32-bit instructions uniformly
	* Keep formats as similar as possible

# Stored Program Computers
* Instructions represented in binary, just like data
* Instructions and data stored in memory
* Programs can operate on programs
* Binary compatibility allows compiled programs to work on different computers - standarlized ISAs

# Instruction Encoding
![[Pasted image 20230404115011.png]]

# Logical operations
* Instructions for bitwise manipulation

| Operation | C  | Java | RISC-V |
|------------ | ------------|  ------------| ------------|
| Shift left | << | << | slli |
| Shift right | >> | >>> | srli |
| Bitwise AND | & |  & | and, andi |
| Bitwise OR | \| |  \| | or, ori |
| Bitwise XOR | ^ |  ^ | xor, xori |
| Bitwise NOT | ~ |  ~ | xor, xori |

## Shift Operations
![[Pasted image 20230404115505.png]]

* Immed - how many positions to shift
* Shift left logical
	* Shift left and fill with 0 bits
	* *slli* by i bits multiplies by 2^i (unsigned only)
* Shift right logical
	* Shift right and fill with 0 bits
	* *srli* by i bits divides by 2^i (unsigned only)

* *slli* can be used to shift numbers < 64. In case of numbers bigger than 64, we can use x mod_64
![[Pasted image 20230404120315.png]]

# AND Operation
* Useful to include bits in a word
* Select some bits, clear others to 0
* and x9, x19, x11

# XOR Operation
* Differencing operation
* Flip some bits, leave others unchanged
* xor x9, x10, x12      //NOT operation  ![[Pasted image 20230404120831.png]]

# Conditional Operations
* Branch to a labeled instruction if a condition is true
* Otherwise continue sequntially
* beq rs1, rs2, L1
	* if(rs1 == rs2) branch to instruction
* C Code:
```
if (i==j) f = g+h;
else f = g-h
```
* f, g, ... in x19, x20,...
* Compiled RISC-V code
```
bne x22, x23, Else //If not equal, do else
add x19, x20, x21  //If equal, do exit
beq x0, x0, Exit

Else: sub x19, x20, x21
```


# Loop Statements
C Code:
```
while (save[i] == k) i+=1;    //i in x22, k in x24, address of save in x25
```
Compiled RISC-V code Loop:
```
Loop:
slli x10, x29
add x10, x19, x25
ld x9, 0(x10)  // The offset is necessary, 
bne x9, x24, Exit
addi x22, x22, 1
beq x0, x0, Loop // Return to loop instruction

Exit: 
```


Signed Unsigned