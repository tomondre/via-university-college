* Popular processors
	* ARM
	* RISC-V
	* MIPS

# Instruction set
* The most fine-grained commands to a computer
	* Programs should be transformed into the instructions
* Example: ADD r3 r1 r2;    => r3 = r1 + r2
* Different computers have different instructions sets
	* But with many aspects in common

## Command to Computers
* High-level language program - in C ====> Assembly language program (for ARM) ====> Machine learning instructions (for ARM)

## CISC
* Initial ISA (Instruction Set Architecture) design
* Any ISA that is not RISC (Reduced Instructions Set computer)
* No separate load and store instructions
* Instructions in CISC include load and store operations within it
* IBM's System/360 to z/Architecture

## RISC
* Features
	* Reduced number of instructions compared to CISC
	* Instead of complex instructions for memory operations: Load, Store ===> in CISC, load and store were part of an instructions
* Pipelining - can overlap the execution of instructions because they are regular => can achieve high throughput

## ARM instruction set
* Most popular Instruction Set Architecture in the world
* Family company that provides blueprints
	* Specification of implementation
* Large share of the embedded core market - applications include not only mobile phones and consumer electronics (Cortex-A), but also network/storage equipments, cameras, printers
### History
* Advanced RISC Machines Ltd. -Arcon Computers + Apple computers + VLSI Technology
* ARM Ltd. 1998
* ARM processors
	* ARM7, ARM9, ARM11
	* Cortex-X, -A, -M, -R
* Usage
	* Application Processor in Smarthphones - Exynos 2100: 1 Cortex-X1 core + 3 Cortex A78 cores + 4 Cortex-A55
	* MCU - Microcontroller Unit in many IoTs - Cortex-M3 for smrt home devices
	* Real-time  processor - Cortex-R4 for automobile devices and cameras
* ARM "ISA" has been licensed by many chip manufactures
	* DEC (Compaq, HP)- StrongARM in 1990
	* Intel (Marvell) - Xscale
	* Qualcomm - Snapdragon chip
	* Apple - M1, M2
	* Samsung - Mongoose M1, M2, M3
	* NVIDIA

## Why RISC-V
* Free and open standard ISA, Open implementation
* No license for ISA
* Two licenses for RISC-V microarchitectures - implementation
	* Open Source IP license
	* Commercial IP license
* Modular ISA
	* RISC-V ISA has groups of instructions
	* They can be enabled or disabled as needed
	* This allows implementing precisely the instruction groups

## Arithmetic Operations
* Add and subtract three operands - two sources and one ==destination==
* ADD ==a==, b, c;
* MIPS and RISC-V assembly language
* add a, b, c - get B + c

## Variables
* Storage for the data used in the program
* Declaration of variable
	* Creates a variable that points to a specific address with a size of the type of variable
	* 3 information:
		* Location - address of memory
		* Size - the number of bytes in representing the data type
		* Interpolation - the same bit string can be interpreted in different ways depending on the data type
* Single precission
* Double precission

## Registrers
* ALU - Arithemtic Logic Unit
* Storage operands used for ALU inside the processor
| | (Off-chip) memory | Registers |
|------------ | ------------|  ------------|
| Made of | DRAM | SRAM |
| Speed | Slow | Fast |
| Size | Large - a few GB |  Small - only dozens of registers|
| ISA | 20% |  2|
* Registers are faster to access thatn off-chip memory - due to the travel that the data needs to make in order to get to the CPU
* Operating on memory data requires loads and stores - more instructions to be executed
* RISC ISA - has a separate instructions
	* For loading variable value to a register
	* For storing register value to the variable
* Who decides the mapping of a variable to a register?
	* The compiler does
	* It's called register allocation
	* It first loads the variable to a certain register
	* It then computees the ALU operations using register operands
	* It finally stores the computed value to the variable
* The register numbers are mych smaller than memory locations
	* At some point it can run out of the available registers and cannot hold the variable balues
* Registers
	* x0 - the constant value 0
	* x1 - return address
	* x2 - stack pointer
	* x3 - global pointer
	* x4 - thread pointer
	* x5 - x7, x28 - x31: temporaries
	* x8 - frame pointer
	* x9, x18 - x27 - saved registers
	* x10 - x11 function arguments/results
	* x12 - x17 - function arguments

## Memory operands
* Main memory used for composite data - arrays, structures, dyanmic data
* To apply arithemtic operations
	* Load values from memory into registers
	* Store results from register to memory
* Memory is byte addressed
	* Each address identifies an 8-bit byte
* Wordsa re aligned in memory
	* Address must be a multiple of 4
* RISC-V does not require words to be aligned in memory
### Byte addresses, word aligned
* Byte-addressed - the unit in the memory
* Word-aligned - the address of a word must be on a multuple of 4 in MIPS abd ARM

## Load instructions
* *Id x3 4(x1)* - Load doubleword (=8 Bytes) to register x3 from the start, which is calculate by adding offest 4 bytes to the value in register
* *lw x2 16(x5)* - Load word(=4 Bytes) from the address to x2
### Example
* C code:
* g = h + A\[8\]
	* g in x23, h in x21, base address of A in x22
	* x5 in temporary register
* Compiled RISC-V code
	* Index 8 requires offset of 64
	* 8 bytes per word

ld x5 64(x22)      # reg x5 gets A[8]
add x23, x21, x5

8 bytes per word