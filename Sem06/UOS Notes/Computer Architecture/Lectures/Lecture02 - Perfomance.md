# Definitions

## Units
* > 1
	* Kilo - 2^10 - 
	* Mega - 2^20 - 
	* Giga - 2^30 - 
	* Tera - 2^40 - 
	* Peta - 2^50 - 
	* Exa - 2^60 - Exascale Computing
* < 1
	* Milli
	* Micro
	* Nano
	* Piko

## Response Time
* The time between the start and completion of the task

## Throughput
* The total bandwidth of work done in a given time - bits per second
* Measurement
	* OPS - Operations per Second
	* FLOPS - Floating Point Operations per Second
		* Also often used in ML
			* 8 bits is enough for keeping the model accuracy

## Wall clock time
* Total time to complete a task including everything
* Clock frequency - Hz - Hertz
* Cycle time - 

## CPU time
* Time the CPU spends only on task excluding I/O waiting time
* CPU is the only scope for the measurement

## Execution Time
* To maximize the performance, we need to minimize execution time
* CPU Execution time = number of clock cycles for program * clock cycle time (e.g. ms)
* CPU execution time = CPU clock cycles for program / program rate (e.g. Hz)

## CPI
* Clock cycles per instruction
* Average time per instructions
* CPU clock cycles for program = number of instructions for a program * average clock cycles (CPI)
* CPU Time = instruction_count * CPI * Clock Rate
* CPU Time = number of instructions for program * average clock cycles / CPU Clock cycles

## Effective (Average) CPI
// TODO

# Performance Summary
* The higher the the abstraction of computer, the more impact it can have on performance

// TODO
| | | CPI | Freq x CPI|
|------------ | ------------|  ------------|  ------------| 
| Algorithm | 50% |  1|  0.5| 
| Programming Language | 20% |  2|  0.4| 
| Compiler | 10% |  3|  0.3|
| ISA | 20% |  2|  2.2|

# Workload and Benchmarks
* Benchmarks
	* A set of programs that form a workload, specifically chosen to measure performance
* SPEC - System Performance Evaluation Cooperativ
	* Standard sets of benchmarks starting with SPEC89
	* SPEC CPU 2017 - latest
		* 43 benchmarks (SPECspeed, SPEXrate)
		* Integer benchmarks
		* Floating-point benchmarks
* Other benchmarks
	* Power Workloads - SPECpower_ssj2008
	* Java workloads - 
	* Multimedia workloads - 
	* GPU benchmark - 

## Pitfall: MIPS as Performance Metric
* Doesn't account for
	* Differences in ISAs between computers
	* Differences in complexity between instructions
* Not all computers has the same instruction set architecture - different ones can have different number of CPIs
* CPI varies between programs on a given CPU
* Complexity differences between instructions

## Power Trends
* The size of the transistors affects the power consumption - silicon
* Dynamic Power
* Power is proportional to the frequency
* Power is proportional to the to the square of volate
* Lower the voltage to reduce power

### Problem - Vdd scaling is hard
* Difficulty to lower the voltage further for the same frequency
* Vdd is now only slightly higher than Vth
* Small margins for High and Low
* High variability or large leakage power
* Vdd scaling is no longer scalabale

* Frequency after some time was not increased due to the power consumption issues.
* The performance has been increased by scaling out number of cores - with overall  the same frequency
* AMD has up to 96 cores for one CPU

## Multiprocessors
* More than one processor per chip
// TODO
* Power consumption of 1-core processor vs 2-core processor
* About 40% decrease in power consumption while maintaining the same performance
* Power = Capacitive Load x Volatage^2 x Frequency
* Power consumption of 1 core processor vs 4 core processor
	* 2x increased performance while maintaining similar power consumption as before
	* f/2 * 4 = double the frequency with 4 cores, with the same power consumption
## How could we lower the voltage
* In the same processor, there is a room for lowering the voltage
* Dynamic voltage frequency scaling - DVFS
	* To reduce power consumption, a processor can change its voltage and frequency dynamically depending on the workload
	* Can reduce the voltage from 1.2 to 0.85 - 55% difference that can be set dynamically

## Multicore processor
* Requires explicit parallel programming
	* Implicit parallel execution - instruction-level parallelism
		* Hardware executes multiple instructions at once
		* Hidden from the programmer
	* Not easy to do due to
		* Programming performance
		* Load balancing
		* Optimising communication and synchronisation
* The assumption in "N cores with 1/N frequency processor having the same performance"
	* All N cores are not idle, and can execute the same amount of instruction as other corses --> Load Balancing
* Load Balancing - if a processor is slower than another, then then the whole system is bounded to the slowest processor
* Amdlahl's law
	* Execution time after improvement = Execution time affected by improvement / Amount of improvement
