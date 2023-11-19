# Cache
## Direct Mapped Cache
* Location determined by address
* Direct mapped - only one choice - block address % number of block in cache


## Write through
* Always update memory when updating cache
* May take writes longer
* Write buffer can be used to hold data waiting to be written to memory
* CPU continues immediately

## Write Back
* On data write, update block in cache
* Write a dirty block back to memory when it is replaced - we store a dirty bit in cache along the value/address and when bit is set to 1 and being replaced, we store the value of cache into lower memory

## Write allocation
* Happens after writing a value
* Two types
	* Write allocate - fetch the block for possible read
	* No Write allocate - don't fetch the block - programs often write blocks before reading it

# Cache Performance
* Memory Stall Cycles
	$Memory Access/Program * Miss Rate * Miss Penalty$ 
	$Instructions/Program * Misses/Instructions * Miss Penalty$
* AMAT - Average Memory Access Time
$AMAT=Hit Time + Miss Rate * Miss Penalty$

## Associative Caches
* Fully Associative
	* Allow a given block to go in any cache entry
	* Requires all entries to be searched at once
	* Comparator per entry - expensive
* n-way set associative
	* Each set contains n entries - elements
	* Location in the cache - $BlockNumber \% NumberOfSetsInCache$
	* Search all entries in a given set at once
	* N comparators - less expensive

## Replacement policy
* Associative
	* Prefer non-valid entry, if there is one
	* Otherwise, replace among entries in the set
* Least-Recently used
	* Replace the one unused for the longest time
	* Simple for 2 way, hard for 4+ ways
* Random
	* Same performance as LRU for high associativity

# Cache Misses
* Compulsory misses
	* Cold start misses
	* First access to the block
	* Lazy load
* Capacity misses
	* Due to limited size of cache
	* A replaced block is later accessed again, but needs to be loaded again
* Conflict misses
	* Collision misses
	* Non-fully associative cache
	* Due to competition for entries in a set
	* Would not occur if the fully associative cache is of the same size as memory/accessed data

## Multilevel caches
* The closer to the processor - the smaller and faster is the cache
* L1
	* Level 1
	* Primary cache attached to CPU
	* Small but fast
	* Minimal hit time
* L2
	* Level 2
	* Faster than main memory/L3
	* Larger, slower
* L3
	* Level 3
	* High end systems may include L3
	* Compared to L2 even larger and slower
