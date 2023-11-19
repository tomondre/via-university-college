# History of Computer
* 1642 - Pascaline - Manual mechanical

# Classes of Computers
* Desktop Computers
	* Single User
	* Low Cost
* Servers
	* Multi users support through network
	* Much greater capacity in both computing and storage
	* Supercomputers, datacenter
* Embedded computers
	* The largest class of computers
	* Limited set of computation for fixed functionality
	* Computers in automobiles, cell phones, TVs

# Command to Computers
* Bits - binary digits
* Instructions - command that are written in bits and are based on CPU instruction set
* Assembly language - symbolic version of instructions
* High level language - increases productivity - allow programme think more natural language and increases portability across different computer architectures

# Computer
* Consist of 5 components - input, output, control, datapath and memory
* Input - keyboard, mouse, mic, HDD, SSD
* Output - LCD, Speaker, HDD, SSD
* Datapath and Control - CPU - performs arithmetic operations
* Memory - DRAM (Dynamic Random Access Memory) - slower, dense memory and SRAM (Static Random Access Memory) - Faster, less dense

# Definition of Performance
* Response Time (execution time)
	* Time between start and completion of a task
	* To maximize performance, we need to minimize the execution time
	* Decreasing execution almost always improves throughput
* Throughput
	* Total amount of work done in given time
* Wall clock time (elapsed time)
	* Total time to complete a task including everything
* CPU Time (CPU Execution Time)
	* Time the CPU spends only for this task excluding the I/O waiting time
	* Equals to: Number of Clock Cycles for a program multiplied by clock cycle time
	* Equals to: Number of CPU clock cycles for a program divided by clock rate
* CPI
	* Clock Cycles per Instruction
	* Average time per instruction
	* Number od clock cycles per instruction equals the number of instructions for program multiplied by average clock cycles per instruction
* CPU - The performance equation
	* CPU = instructions count multiplied by CPI multiplied by clock time
	* Execution time - instruction count multiplied by clock cycles per second divided by clock rate
* Average CPI - equals to sum of clock cycles per instruction mutliplied by percentage of instructions of class i executed

# MIPS as performance metric
* Millions of instructions per second
* MIPS = Instruction Count divided by execution time * 10 ^6
	* Clock rate divided by CPI multiplied by 10 ^6
* CPI Varies between program on a given CPU

# The power wall
* Power = Capacitive load * volate^2 * frequency
* Power is proportional to the frequency
* Power is proportional to the square of the voltage
* Lower voltage to reduce power


# Exercise01
* B = 6 SECONDS
* A = 2GHZ IN 10 SECONDS
* A = B
* We need to get the number of clock cycles of the program
* We can get it by multiplying number of seconds by clock rate e.g. 10 sec * 2 GHZ
* 10seconds * 2ghz = 1.2 * (x ghz * 6 seconds) 

# Exercise02
* Computer A - clock cycle of 250ps and CPI of 2.0
* Computer B - clock cycle time of 500 ps and affective CPI of 1.2 for the same program
* 500/600 - 1,2 speedup

# CISC
* Complex instruction set computer
* Has separate load and store instructions - an instructions in cisc includes load and store operations within it
* Varied complex instructions -> varied instructions length

# RISC
* Reduced instruction set computer
* Reduced number of instructions compared to CISC
* Instead of complex instructions, the functionalities are implemented with combinations of simple and regular instructions
* Separate instructions for memory operations - load and store

# ARM Instruction set
* Most popular ISA in the world
* A large share of the embedded core market

# RISC-V
* Used as the example throughout the book
* Has free and open standard ISA, Open implementation
* No license for ISA
* Two licenses for RISC-V microarchitectures
## Modular Instruction set architecture
* RISC-V has groups of instructions - ISA extension
* They can be enabled or disabled as needed
| ISA Extension | Ratified | Notes |
|---------------|----------|-------|
| I/E           | Yes      | Instructions for basic Integer operations. This is the only extension that is mandatory. I requires 32 registers, E requires only 16. |
| M             | Yes      | Instructions for multiplication and division |
| C             | Yes      | Compact instructions that have only 16bit encoding. This extension is very important for applications requiring low memory footprint. |
| F             | Yes      | Single-precision floating-point instructions |
| D             | Yes      | Double-precision floating-point instructions |
| A             | Yes      | Atomic memory instructions |
| B             | No       | Bit manipulation instructions. The extension contains instructions used for bit manipulations, such as rotations or bit set/clear instructions. |
| V             | No       | Vector instructions that can be used for HPC. |
| P             | No       | DSP and packed SIMD instructions needed for embedded DSP processors. |
## Customizable ISA
* RISC-V support for the custom extension of ISA
* No predefined instruction group - designers can add any instructions they need for their application that they want to accelerate
* Need to implement hardware for the custom instructions
* Need to extend compilers for the new instructions

# ISA Design principles
1. Simplicity favours regularity
	* Simplicity favours regularity
	* Regularity makes implementation simpler
	* Simplicity enables higher performance at lower cost
2. Smaller is faster
	* Smaller is faster
	* Main memory has millions of locations
3. Make the common case fast
	* Small constants are common
	* Immediate operand avoids a load instruction
4. Good Design demands good compromises
	* Different formats complicate decoding, but allow 32-but unctions uniformly
	* Keep formats as similar as possible

## Variables
* Variables are storage for the data used in the program
* They reside in memory, not in processor
* Has Location, Size, Interpretation

## Registers
* If variables reside in memory, what are the things that hold the operands for ALU in processor?
* Registers - storage for operands used for ALU inside the processor

## Registers vs Memory
* Registers are faster to access than memory
* Operating memory data requires loads and stores
* RISC ISA has separate instructions for loading value to register, for storing the register value to the variables

## Mapping of a variable to a register
* The mapping of a variable to a register is decided by compiler
* This is also called register allocation
* First loads the variable to a certain register
* Then computes ALU operations sing register operands
* The number of register is much smaller than memory locations - at some point it can run out of the available registers and cannot hold the variable values

## Register number
* Total of 32 registers
* x0 - constant value 0
* x1 - return address
* x2 - stack pointer
* x3 - global pointer
* x4 - thread pointer
* x5 - x7, x28 - x31 - temporaries
* x8 - frame pointer
* x9, x18 - x27 - saved registers
* x10 - x11 - function arguments/results
* x12 - x17 - function arguments

## Memory operands
* Main memory used for composite data - Arrays, structures, dynamic data
* To apply arithmetic operations - load values from memory to registers and store result from register to memory
* Memory is byte addressed - each address identifies an 8 bit byte
* Words are aligned in memory - address must be multiple of 4
* RISC-V does not require words to be aligned in memory - unlike some other ISAs
* Byte-addresses - unit of address in the memory
* Word-aligned - address of a word must be on a multiple of 4 in arm

## Load Instructions
* `ld x3 4(x1)` - load doubleword to register x3 from the start address which is calculated by adding osset 4 to the value in register x1. Loads 8 bytes (doubleword) from memory address 0x1004 (if x1 = 0x1000 + 4)
* `lw x2 16(x5)` - load word (4 bytes) from the address x5 + 16 to x2
* `lh x6 0(x2)` - load halfword (2 bytes) from the address to x6
* `lb x6 0(x2)` - load one byte from the address to x6

## Exercise
* g = h + A[8]
* g in x23, h in x21, base address of A in x22
* ld x5 64(x22)
* lw x5 32(x22)
* lh x5 16(x22)
* add x23, x5m x21

## Store Instructions
* `sd x3 4(x1)` - store doubleword from register x3 to the address which is calculated by adding the offset 4 to the value in register x1
* `sw x2 16(x5)` - store word from x2 to the address x5
* `sh x6 0(x2)` - store halfword from x2 to the address x6
* `sb x6 0(x2)` - store byte from x6 to the address

## Exercise
* A[12] = h + A[8]
* h in x21, base address of A in x22
* x5 is temporary register

* ld x5, 64(x22)
* add x5, x5, x21
* sd x5, 96(x22)

## Registers vs memory
* Registers are faster to access than memory
* Operating on memory data requires loads and stores - more instructions to be executed
* Compuler mus use register for variables as much as possible
* Only spill to memory for less frequently used variables
* Register optimization is important

## Immediate operands
* Constant data specified in an instruction
* `addi x22, x22, 4 # x22 = x22 + 4`

## Unsigned Binary Integers
* Example - 0000 0000 0000 0000 0000 0000 0000 1011

## Signed Binary Integers
* Half of the size of unsigned

# Representing instructions
* Called machine instruction
* Machine code - a sequence of machine instruction
* RISC-V instructions - encoded as 32-bit instruction words - small number of formats
* R instruction format
	* opcode - operation code
	* rd - destination register number
	* funct3 - 3 bit function code
	* rs1 - first source register number
	* rs2 - second source register number
	* funct7 - 7 but function code

## Exercise
* if (i\=\=j) f = g+h;
* else f = g-h;

* lw x19 - load i
* lw x20 - load j
* lw x21 - load f
* lw x22 - load g
* lw x23 - load h
```
beq x19, x20, IF
bne x19, x20, ELSE

IF:
	add x21, x22, x23
ELSE:
	sub x21, x22, x23
```

while (save[i] == k) i += 1;
i in x22, k in x24, address of save in x25
```
LOOP:
	# Multiply i value by 8 - this is later used for dynamic pointer of array based on i
	slli x10, x22, 3
	add x23, x10, x25
	ld x25, 0(x23)
	bne x25, x24, EXIT
	addi x22, 1
	beq x0, x0, LOOP
EXIT:
```


# Commands
* `slli` - Logical left shift immediate
Load byte/halfword/word - sign extend to 64 bits in rd
* `lb rd, offset(rs1)`
* `lh rd, offset(rs1)`
* `lw rd, offset(rs1)`
Load byte/halfword/word unsigned- zero extend to 64 bits in rd
* `lbu rd, offset(rs1)`
* `lhu rd, offset(rs1)`
* `lwu rd, offset(rs1)`
Store byte/halfword/word - store rightmost 8/16/32
* `sb rd, offset(rs1)`
* `sh rd, offset(rs1)`
* `sw rd, offset(rs1)`

# Data Race and Synchronization
* Two different threads access the same memory locations and at least one is write access
* Two processors sharing an area of memory
* Hardware support required
	* Atomic read/write memory operation
	* No other access to the locaiton allowed between the read and write
* Could be single instruction - atomic swap of register <-> memory, or an atomic swap of instructions

## Atomic swap
* Load Reserved - lr.d rd,(rs1) - load from address in rs1 to rd
	* Place reservation on memory address
* Store conditional - sc.d rd,(rs1), rs(2), rs2
	* Store from rs2 to address in rs1
	* Succeeds if location not changed since the lr.d, return 0
	* Fails if location is changed - returns non-zero value in rd
```
again: 
	lr.d x10,(x20)
	sc.d x11,(x20), x23
	bne x11 x0, again
	addi x23,x10, 0
```
## Example - Data Race
![[Pasted image 20230424135643.png]]

get lock
if lock is 1, call again
store 0 to the lock
if store is unsuccessfull, call again
do stuff
store the lock with value 0


whileloop:
	loop condition if exit
	loop body
	beq to whileloop

forloop
	loop condition
	loop body
	increment



```
# x20 - lock address
# x21 - lock value
# x15 - value 1 to set
# x11 - return value from sc.d
# x12 - cnt
# x13 - address of cnt in memory
lock:
	ldi x15, x0, 1
	sc.d x11,(x20),x15
	bne x11, x0, again
	beq x0, x0, lock

body:
	ld x12, 0(x13)
	addi x12, x12, 1
	
unlock:
	sd x11, x0


again:
	lr.d x21, 0(x20)
	bne x21, x0, again
	addi x15, x0, 1
	sc.d x11, 0(x20), x15
	bne x11, x0, again
	
	beq x0, x0, body

body:
	ld x12, 0(x13)
	addi x12, x12, 1
	sd 12, 0(x13)
	beq x0, x0, unlock

unlock:
	sd x0, 0(x20)
```

## Procedure call instruction
* Steps
	1. Place parameters in registers x10 to x17
	2. Transfer control to procedure
	3. Acquire storage for procedure
	4. Perform procedure's operations
	5. Place result in register for caller
	6. Return to place of call (address in x1)
### Memory layout
![[Pasted image 20230424142735.png]]
* Text - program code
* Static data - global variables
* Dynamic data - heap
* Stack - automatic storage

### Procdure Call instruction
* `jal x1, ProcedureLabel`
	* jump and link
	* Save the address of the following instruction to x1
	* Jumps to target address labeled ProcedureLabel
* `jalr x0, 0(x1)`
	* like jal, but jumps to 0 + address in x1
	* use c0 as rd
	* can also be used for computed jumps

## Non-leaf procedures
* Procedures that call other procedures
* For nested call, caller needs to save on the stack
	* Its return address
	* Any arguments and temporarioes needed after the call
	* Restore from the stack after call

```
FACT:
	addi sp, sp, -16 # Push stack
	sd x1, 8(sp) # Push return address
	sd x10, 0(sp) # Push register to free space for return value - n
	addi x5, x10, -1 # n - 1
	bge x5, x0, SECOND # Check if value equals zero, if so, go to L1
	addi x10, x0, 1 # Set 1 to return register value x10
	addi sp, sp, 16 # Free up the pointer space
	jalr x0, 0(x1) # jump back to the return value
SECOND:
	addi x10, x10, -1 # M
	jal x1, FACT # Jump to fact and save the return address to x1
	addi x6, x10, 0 # Copy x10 to x6
	ld, x10, 0(sp) # Rollback the existing value in stack to x10
	ld x1, 8(sp) # Rollback the existing value in stack to x1 - return value
	addi sp, sp, 16 # Rollback the stack pointer
	mul x10, x10, x6 # Multiply the return value with 
	jalr x0, 0(x1) # Jump back to the return value
```


# Commands
 * `jal x1, ProcedureLabel` - Jump and link
  * `jalr x0, 0(x1)` - Jump and link return to the given address
  * `lw` - load word
  * `ld` - load double word
  * `sw` - store word
  * `sd` - store double word
  * `beq` - branch equals
  * `bne` - branch not equals
  * `bge` - branch greater equal to
  * `blt` - branch less than
  * `add` - add
  * `addi` - add immediate
  * `mul` - multiply
  * `slli` - shift left logical immediate
  * `srli` - shift right logical immediate
  * `lr.d` - used for atomic load - can be used for obtaining lock
  * `sc.d` - used for atomic store. Returns 0 if the store has been succesfull - can be used for storing lock
 
# Register Usage
* `x0` - constant 0
* `x1` - contains return address register
* `x2` - contains stack pointer
* `x3` - contains global pointer
* `x4` - contains thread pointer
* `x5 - x7, x28 - x31` - temporaries - used for saving computation values in function
* `x8` - frame pointer
* `x9, x18 - x27` - saved registers - used for saving the state of caller function
* `x10 - x11` - function arguments/results
* `x12 - x17` - function arguments

# Design principles
1. Simplicity favours regularity
2. Smaller is faster
3. Make common sense fast - immediate operands avoids a load instruction
4. Good design demands good compromises

## Questions
* What is the difference between RISC and CISC
	* RISC stands for Reduced Instruction Set Computer
		* Is granular in commands - store and load commands exists in it
		* Is modular - ther are multiple classes of commands
		* Is open and ISA is free
		* License can be bought for microarchitecture
		* Fixed instruction length
	* CISC Stands for Complex Instruction Set Computer
		* Has complex instructions that include multiple clock cycles
		* Does not have load and store instructions because they are included in the command - they are higher level
* How is the performance of cpu calculated
	* Number of instructions mutliplied by CPI divided by frequency
* What are the steps needed for procedure calling?
	* The caller sets the argument registers
	* The callee create space in stack for saving the return address and registers used in the procedure body
	* The callee pushes the return address to stack
	* The callee pushes the values that are used in the procedure to stack
	* The procedure is executed
	* The return value are set
	* The pushed register values are poped to rollback the state
	* The pushed return register value is poped to rollback the return register
	* The procedure jumps back to the return address
	* The caller can use the return value
* What does ARM stands for?
	* Advanced RISC machine
* What does FLOP stands for?
	* Floating point operation - measure of performance
* How can we ensure that memory is not corrupted when two threads wants to access the same variable in memory?
	* We use atomic operations that allows us to see if the value in address has been altered or not
* What does the power wall stands for?
	* Is related to the issue related to scaling performance and its dependce on power consumption. There is a limit how much power can be supplied and taken by processor before it starts to overheat and becomes unstable. Our solution is that we can split the computer architecture to cores that run with the same frequency at this lowers the power consumption. This solution comes with its set of challenges due to the fact that it is now also the coder responsibility to create code that supports multi-core application
* What is moore's law?
		* Says that the number of transistors multiplies each second year by two
* What is modularity in RISC-V?
	* There are sets of instruction for different use cases that can be included in the ISA - for example support for vector calculations
* What is the difference between memory and registers?
	* Memory is a way bigger and less efficient - that's where registers step in. There are only about 32 registers and they are used for fast access
* How many registers there are in CPU?
	* 32
* What is the size of instructions?
	* 32
* What is the size of registers?
	* 32
* What does CPI stands for?
	* Average Clock cycles Per instructions

