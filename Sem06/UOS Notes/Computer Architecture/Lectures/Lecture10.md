# SMP - Shared Memory
* Hardware provides single physical address space for all processors
* Synchronize shared variables using locks
* Access Time
	* UMA - uniform - cpu with only one shared memory
	* NUMA - nonuniform - cpu with multiple memory blocks
## Message Passing
* Used for communication between different threads/processes
* Decouples them
* Each processor has a separate private physical address space
* Hardware sends/received messages between processors
* MPI
	* Message Passing Interface
	* Communication protocol to support parallel programming in distributed memory systems
	* Widely used in High Performance Computing

# Hardware Multithreading
* Performing multiple threads of execution in parallel (the software multithreading is implemented by switching contexts on the same cpu)
* Replicates registers, PC, ...
* Fast switching between threads
* Switch threads after each cycle
* Of one thread stalls, other are executed
* Course-grain multithreading

# SMT
* Multiple issue dynamically scheduled processor
* Schedule instructions from multiple threads
* Instructions from independent threads execute when function units are available
* Within threads, dependencies are handled by scheduling and register renaming

# Multithreading methods
![[Pasted image 20230614120248.png]]
* Coarse MT
	* Executes threads until major break happens, then a new thread is executed
* Fine MT
	* On every clock cycle, each thread supports each thread
	* Can efficiently switch threads due to separate register files
* SMT
	* Very fine grained
	* Each clock cycle can be occupied by another thread
	* Requires complex hardware implementation

# Vector processor
* Highly pipelines function units

# GPU
* Graphics Processing Unit
* Accelerator
* CPU and GPU has different definitions
## History
* Early video cards - frame buffer memory with address generation for video outputs
* 3D Graphics processing - originally high-end computers
* Graphics Processing Units - processors oriented to 3D graphics tasks
## Why to use GPU
* Much faster for data-parallel computation
* Has a different architecture optimised for exploiting the fine grained data-parallelism
* Massive number of cores
## Architecture
* Processing is highly data-parallel
	* GPUs are highly multithreaded
	* Use thread switching to hide memory latency
	* Graphics memory is wide and high bandwidth
* GPGPUs
	* Heterogenous CPU/GPU systems

## CPU vs GPU
* CPU
	* For sequential code
	* Each core is optimised for executing a single thread
	* Used for reducing latency
* GPU
	* For parallel code
	* Hundreds of cores
	* It has smaller caches
	* Cores optimised for aggregate throughput
* Multicore
	* Each core is independent processing unit
* Manycore
	* Many more cores

