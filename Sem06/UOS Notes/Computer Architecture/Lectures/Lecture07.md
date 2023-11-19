* Questions:
	* Why is in the figure instruction memory split from data memory? RISC-V architecture has one place for memory and data

![[Pasted image 20230502102819.png]]

* ALU Control - used to represent the operation as 4 bits. Used to instruct ALU
	* MemtoReg - used to direct the result from ALU back to register to store
* There are only two parts of the processor that change the state of it
	* Data Memory
	* Register File
* The Instruction and Data memory is split in the figure because processors use a cache to store the values in memory. Instruction and Data have their own respective cache


# Load and Store instructions
* Read register operands
* Calculate the address using a 12-bit offset
* Load - read memory and update register
* Store - write register value to memory

## Load
* The data memory has two inputs - MemRead, and MemWrite - we need two bits in order to instruct it to read/write/null. NULL means that the current instruction that is being executed does not have nor data memory write/read
* Imm Gen - responsible for calculation of immediate values from the instructions
* Branch uses ALUsrc to set MUX to 1 in order to set the immediate offset of the value
* MemtoReg - used to specify if the current instruction is suppossed to store the result from data memory to register or not. In the case of load, the bit is set to 1 - we want to take the value from memory to register
* RegWrite is used to instruct Registers to either read or store

## Store
* Leverages immediate values to set the offset for the address stored in register
* The data memory for this instruction need MemWrite one, in order to store the write data to the address given as input
* The RegWrite needs to be set 0 in order to get the value to store into memory
* The MemtoReg value is ignored (we do not care, x) due to the fact that the register does not expect any write and therefore it does not matter if Register File get's any value or not

## Branch
![[Pasted image 20230502114955.png]]
* `beq`
* Leverages ALU to substract the two values and gets a result. If the two values are the same, the result is 0. If 0 is a result in ALU, the Zero flag is set to one. Then the result is inputed to AND operation with Branch flag from Control, and if both of the values are 1, the PC is set to the PC + immediate value
* The immediate value is used for adding value to PC, not directly to ALU! - it is used for substraction of two values give from read data 1 and 2 from registers. Therefore the memory mux needs to be set to 0, in order to fetch the read data 2 value instead of immediate value


|        | ALUSrc | ALUOp     | MemRead | MemWrite | RegWrite | MemtoReg   |
|--------|-------:|----------|--------|----------|----------|------------|
| load   |   1    | addition |   1    |    0     |    1     |    1       |
| store  |   1    | addition |   0    |    1     |    0     | dont care  |
| branch |   0    | substraction | 0    |    0     |    0     | dont care  |
* The branch instruction is shortest for branch
* The load instruction takes the most time
* The clock time needs to be bigger than the time that it takes for the logest instruction to execute, otherwise we do not care about the exection speed of the instructions


# Pipelining
* Parrallelism improves performance
* Means overlapping execution
## Analogy
* The process of cleaning clothes consists of 4 step
	* Adding to basket
	* Washing
	* Drying
	* Putting to wardrobe
* Each batch has clothes that fill each of the steps
* We can go through all the steps for each batch separately - not efficient
* It is more efficient to do parallel batches so that, for example, when the washing machine is free, we do not wait for the batch to complete, but we use the freed-up time to wash the next batch, even though the previous batch is not complete
## Five Stages
* Instruction fetch from memory

## Performance
* Assume that the read and write operations take half of the execution time, we first store and then read the register in pipelining

## Pipeline speed up
* If all stages are balanced - it takes the same time
	* Time between instructions equals to time between instructions (nonpipelined) divided by the number of stage
* If not balanced, the speedup is less
* Speedup due to increased throughput - latency does not decrease
* The full parallelism occurs only after a number of stages minus one. This is due to a fact that the first steps need to fill the stages in order, because each instruction has a step by step stages

## Hazards
* The situation that prevents starting the next instruction in the next cycle
* Structure hazards - a required resource is busy
* Data Hazard - need to wait for previous instruction to complete its data read/write
* Control Hazard - deciding on control action depends on previous instruction

* In the control hazard, we can assume that the control action does not depend on previous instruction and just execute the instruction. In case the dependence is true, we can rollback the instruction and ignore the instruction progress
* Load and store instruction occurs approximately 30% in assembly code each