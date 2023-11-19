# Avoiding Data Hazard
* Loop unrolling - created by replicating the loop body to expose more parallelism so that more operations from the loop are executed in one loop body

* Out-of-order processor
* Pipeline stages
* Issue width

## Power Efficiency
* The complexity of dynamic scheduling and speculations requires power
* Multiple simpler cores may be better


# Multicores, Multiprocessors and clusters
* GPU
	* Contains thousands of cores - Titan V - 5120
* Power wall is a problem for all types of computers - mobile devices, PCs, Supercomputers
## Parallel programming
* Problem because the programmer is expected to write multi-threaded programs - so that all the cores are optimised for the cores
* Difficulties
	* Partitioning - mapping
	* Coordination - load-balancing, synchronization
	* Communication overhead - data movement

## Shared Memory
* SMP - Share Memory Multiprocessor
* Hardware provides single physical address space for all processors
* Synchronize shared variables using locks
* Connected via high throughput bus
* Hardware support is needed for atomic operations - needed for having the shared memory
* Memory access time
	* UMA
	* NUMA

## Message Passing
* Another structure of memory
* Each core has its own separate memory
* A problem when the cores want to access memory from other core

