# Exercise01

* Computer B
	* Execution time - 6 seconds
* Computer A
	* Execution Time - 10 seconds
	* CPU frequency - 2GHz
* Computer B require 1,2 times as many clock cycles as computer A
* What should be the clock rate of computer B?

Exa = k / 2 * 10^9
Exb = 1,2 * k


# Exercise02

CPI
A = 1
B = 2
C = 3

Prog1 = 2A +  1B + 2C =  10 (average CPI)
Prog2 = 4A + 1B + 1C  =  9  (average CPI)
*Needs to be multiplied by clock rate*

## Exercise03


|OP | Freq| CPI | Freq x CPI|
|------------ | ------------|  ------------|  ------------| 
| ALU | 50% |  1|  0.5| 
| Load | 20% |  5|  1| 
| Store | 10% |  3|  0.3|
| Branch | 20% |  2|  2.2|
| | |  Sum|  2.2| 

* How much faster would the machine be if a better data cache reduced the average load time to 2 cycles?

|OP | Freq| CPI | Freq x CPI|
|------------ | ------------|  ------------|  ------------| 
| ALU | 50% |  1|  0.5| 
| Load | 20% |  2|  0.4| 
| Store | 10% |  3|  0.3|
| Branch | 20% |  2|  2.2|
| | |  Sum|  1.6| 
| | |  Improvement|  1.375| 


* How does this compare with using branch prediction to save a cycle of the branch time?
|OP | Freq| CPI | Freq x CPI|
|------------ | ------------|  ------------|  ------------| 
| ALU | 50% |  1|  0.5| 
| Load | 20% |  5|  1| 
| Store | 10% |  3|  0.3|
| Branch | 20% |  2|  2.2|
| | |  Sum|  2| 
| | |  Improvement|  1.1| 

* What if two ALU instructions could be executed at once?
|OP | Freq| CPI | Freq x CPI|
|------------ | ------------|  ------------|  ------------| 
| ALU | 50% |  1|  0.5| 
| Load | 20% |  2|  0.4| 
| Store | 10% |  3|  0.3|
| Branch | 20% |  2|  2.2|
| | |  Sum|  1.95| 
| | |  Improvement|  1.12| 


## Exercise04
* Computer A and Computer B - same ISA - instruction set architecture
* Computer A
	* Clock cycle of 250 ps - 4 GHz
	* CPI = 2.
* Computer B
	* Clock cycle time of 500 ps
	* CPI = 1.2
* Which Computer is faster and how much?

*CPU Time = CPI * Clock Rate*

A =  2 * 250 = 500 
B = 1.2 * 500 = 600

600/500 = A is faster by 1.2


# Exercise04
* If we reduce a voltage by 25%, how much do we reduce the dynamic power consumption?
* 
