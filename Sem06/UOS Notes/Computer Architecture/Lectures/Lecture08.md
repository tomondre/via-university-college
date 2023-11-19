# Pipeline Performance
* If all stages are balanced
* Time between instructions equals non-pipelined time between instructions divided by the number of stages
* If not balanced, the speedup is less
* Speedup due to increasing throughout
* Latency - time for each instruction - does not decrease

# Pipelining Design
* Key concept in RISC-V design
* Used in virtually all current processors

# Hazards
* Structure hazards
	* Required busy
	* Some commands cannot be divided into a smaller chunk
	* Therefore cannot be executed in parallel
	* Example - load/store operations
	* 
* Data hazards
	* Need to wait for previous instruction to complete its data read/write
	* Solution - two stages for accessing register files - stage 2 (register read) and stage 5 (register write) - this is better solution so that the read value is already updated within the same clock cycle
	* `addi x20, x20, 0`
	* `sub x20, x20, x10` - the result from previous command needs to be stored before reading the x20 register
* Control hazards
	* Deciding on control action depends on previous instructions
	* Example: Branch - if the condition is met, the next instruction should be different than the already loaded
	* Solution: We load the next intended instructions and in case the branch condition is met, we ignore the progress of the instruction

## Data Hazards
* An instruction depends on completion of data access by a previoud instruction
* `add x10, x0, x1`
* `sub x2, x19, x3`
* Forwarding
* Load-Use data hazard
### Forwarding
* Use result when it is computed
* Don't wait for it to be stored in register
* Required extra connections in the datapath - result (output) from ALU coming back to the input of it - needs an extra connection and flag for it
### Load-use data hazard
* Compiler is responsible for filling the gaps between instructions that have dependency
* Not always possible
	* When value not computed when needed
	* When cannot forward backward in time
	* Example:
		* `ld x1, 0(x2)`
		* `sub x4, x1, x5`
		![[Pasted image 20230509104459.png]]
		* The value read from ID step is garbage. Also not needed because the datapath between MEM and EX overrides the input from ID step
* Solution - compiler can decide to put instructions between the two instruction prone to data hazard => in case of `add x10, x0, x1` and `sub x2, x19, x3` we can add 2 independent instructions to avoid data hazard
	![[Pasted image 20230509105220.png]]

![[Pasted image 20230509110248.png]]
1. Case takes 13 cycles
2. Case takes 11 cycles because compiler has added other instructions between the dependent instructions to improve efficiency and avoid waiting time between instructions

## Control Hazards
* Branch determines the flow of control
	* Fetching next instruction depends on branch outcome
	* Pipeline can't always fetch correct instruction
* In RISC-V pipeline
	* Need to compare registers and compute target early
	* Add hardware to do it in ID stage
		* Using subtraction and comparing if result is 0
		* Implementation done via XOR gates
### Branch Prediction
* Predict the result of branch instruction, so that the pipeline is more efficient
* It is 50/50 chance that the result will be correct to the prediction
* Prediction correct
* Prediction not correct
	* We have to use null instruction - set all the control buts to 0
### Static Prediction
* On compile time
* The compiler sets the branch predictions
* Based on a typical behaviour
* Example
	* Loop and if-statement
	* Predict backward branches taken
	* Predict backward branches not taken
### Dynamic branch prediction
* Hardware measures actual branch behaviour - records the history of each branch
* When wrong, stall while re-fetching, and updating history

# Pipeline Summary
* Pipelining improves performance by increasing instruciton throughput
* Executes multiple instrucitons in parallel


# Load-Use hazard
* Need registers between stages - to hold information produced in previous cycle
## Pipelined Control
![[Pasted image 20230509115946.png]]
Control signals derived from instruction - as single cycle implementation
### Dependencies and forwarding
![[Pasted image 20230509120130.png]]

### Double data hazards
```
add x1, x1, x2
add x1, x1, x3
add x1, x1, x4
```
We have to use the most recent value for the forwarding

## Load-Use Pipelining architecture with hazard detection
![[Pasted image 20230509121107.png]]

# Branch Hazard
* If branch outcome is determined in MEM
![[Pasted image 20230509121337.png]]
We need to flush the instructions in case the prediction was not correct

## Dynamic Branch Prediction
* In deeper and superscalar pipelines, branch penalty is more significant
* Branch prediction buffer - branch history table
* Indexed by recent branch instruction addresses
* Stores outcome taken/not taken
* To execute  a branch - check table, expect the same outcome
* Start fetching from fall-through or target
* If wrong, flush pipeline and flip prediction
* The branch predicts taken/not taken based on the stored value
	* If last was taken, predict correct
	* If it was not taken, predict not correct

### 1-Bit Predictor
* Mispredict as taken on last interation if inner loop
* Mispredict as not taken on first iteration of inner loop next time around

### 2-Bit Predictor
* Only change prediction on two successive mispredictions
	![[Pasted image 20230509122526.png]]
	If the value is not already in the table, predict default (taken/not taken)
* 