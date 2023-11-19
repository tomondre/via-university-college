# Instruction offsets
* The instruction offsets are represented in 2byte long offsets - if we want to move 10 bytes, we need to offset * 2 => 20
* The offsets are due to the fact that the address is half-word based - 16 bits

# Immediate addressing
The immediate addressing - addi
Register addressing - add
Base adressing - load, store
PC-relative addressing - used for fetching the instruction from memory

## Immediate Adressing for big values
* For big loop bodies, we can use multiple step jump/branch
* This is important because of the limitation of immediate value in instruction
* Similar is done for base addressing - for example load. We create a new register that points to the memory adress that is closer to the value in memory and within the offset reach

# Multi-threading in RISC-V
* Each thread is assigned a separate set of registers and memory space, and the processor switches between threads using context switching
* The shared address space is located in separate address space that is accessible by all threads

# Data Race
* Two different threads access the same memory locations and at least oen is write access
* Two processors share an area of memory
* Important if the threads do not synchronize
* Solution - Atomic Operations
### Atomic Operations
* No other access to the locaion allowed between the read and write
* Atomic => unbreakable
* Load Reserved - lr.d rd, (rs1)
	* Load from address in rs1 to rd
	* Place reservation on memory address
* Store conditional: sc.d rd, (rs1), rs2
	* Store from rs2 to address in rs1
	* Succeeds if location not changed since the lr.d - returns 0 in rd
	* Returns non-zero value in rd
	* If the operation is not successfull, then the operation for save is redone
	![[Pasted image 20230418112510.png]]
### Implementation with mutex
```
########## Lock Start ##########
Lock:
	addi x12, x0, 1
again:
	lr.d x10, (x20)
	bne x10, x0, again
	sc.d x11, (x20, x12
	bne x11, x0, again
########## Lock End ##########
Unlock:
	sd x0, 0(x20)
```

Only the thread that has acquired the lock can unlock it with no problem - that's why the the code uses sd and not sc.d

# Computer Systems
## Why to choose RISC-V
* No license for ISA
* Modularity - RISC-V has a groups of instructions
* Default is the 2 byte long instruction
* Break
	* exists the loop
* It was executed inside the nested loops, it does not exit the entire loops, but only exits one loop
```
while(true) {

}
```
Continue
* Stops the current iteration immediately and jumps to the next iteration in the loop
```
for (i=0; i<N; i++)
	if (A[i]<0) continue;
	// do some task otherwise
```

# Processor
* Instructions are implemented in a processor
* The compiled machine code becomes the direct input to the processor
* Interface of hardware and software
* The ISA implementation can be different by vendor
* Program Counter - contains program counter of instruction to be fetched
* Instruction set cache and data cache
* Instruction Memory is a cache in processor that keeps copy from DRAM
	* Contains the full instruction - OP code
* Data Memory is a cache in a processor that keeps copy from DRAM
* The outputs of the instructions is saved to register
* PC Counter - Same hardware for all instructions - share the common part

### R-Type instruction
* 