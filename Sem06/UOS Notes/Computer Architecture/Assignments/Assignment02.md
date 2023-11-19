# Assignment02
Name: Tomas Ondrejka
Student Number: 2023010032

# Results
## C File
![[Pasted image 20230417100538.png]]
## Docker-Compose file
![[Pasted image 20230417100755.png]]
## Terminal command history
![[Pasted image 20230417100852.png]]
## Running docker container
![[Pasted image 20230417100945.png]]


## Full Generated Assembly

```
00000000000101e0 <main>:
   101e0:                    fe010113           addi    x2,x2,-32
   101e4:                    00113c23           sd      x1,24(x2)
   101e8:                    00813823           sd      x8,16(x2)
   101ec:                    02010413           addi    x8,x2,32
   101f0:                    fe042623           sw      x0,-20(x8)
   101f4:          /-------- 0780006f           jal     x0,1026c <main+0x8c>
   101f8:       /--|-------> 000117b7           lui     x15,0x11
   101fc:       |  |         6d878713           addi    x14,x15,1752 # 116d8 <A>
   10200:       |  |         fec42783           lw      x15,-20(x8)
   10204:       |  |         00379793           slli    x15,x15,0x3
   10208:       |  |         00f707b3           add     x15,x14,x15
   1020c:       |  |         0007b683           ld      x13,0(x15)
   10210:       |  |         000117b7           lui     x15,0x11
   10214:       |  |         72078713           addi    x14,x15,1824 # 11720 <W>
   10218:       |  |         fec42783           lw      x15,-20(x8)
   1021c:       |  |         00379793           slli    x15,x15,0x3
   10220:       |  |         00f707b3           add     x15,x14,x15
   10224:       |  |         0007b783           ld      x15,0(x15)
   10228:       |  |         00078593           addi    x11,x15,0
   1022c:       |  |         00068513           addi    x10,x13,0
   10230:       |  |         064000ef           jal     x1,10294 <mult>
   10234:       |  |         00050793           addi    x15,x10,0
   10238:       |  |         fef42423           sw      x15,-24(x8)
   1023c:       |  |         fe842783           lw      x15,-24(x8)
   10240:       |  |         0007879b           addiw   x15,x15,0
   10244:       |  |  /----- 0007cc63           blt     x15,x0,1025c <main+0x7c>
   10248:       |  |  |      fe842703           lw      x14,-24(x8)
   1024c:       |  |  |      ff01b783           ld      x15,-16(x3) # 11ec8 <sum>
   10250:       |  |  |      00f70733           add     x14,x14,x15
   10254:       |  |  |      fee1b823           sd      x14,-16(x3) # 11ec8 <sum>
   10258:       |  |  |  /-- 0080006f           jal     x0,10260 <main+0x80>
   1025c:       |  |  \--|-> 00000013           addi    x0,x0,0
   10260:       |  |     \-> fec42783           lw      x15,-20(x8)
   10264:       |  |         0017879b           addiw   x15,x15,1
   10268:       |  |         fef42623           sw      x15,-20(x8)
   1026c:       |  \-------> fec42783           lw      x15,-20(x8)
   10270:       |            0007871b           addiw   x14,x15,0
   10274:       |            00800793           addi    x15,x0,8
   10278:       \----------- f8e7d0e3           bge     x15,x14,101f8 <main+0x18>
   1027c:                    00000793           addi    x15,x0,0
   10280:                    00078513           addi    x10,x15,0
   10284:                    01813083           ld      x1,24(x2)
   10288:                    01013403           ld      x8,16(x2)
   1028c:                    02010113           addi    x2,x2,32
   10290:                    00008067           jalr    x0,0(x1)
```

# My interpretation
```
# Ignoring - as mentioned in the presentation
addi    x2,x2,-32

# Ignoring 
sd      x1,24(x2)
sd      x8,16(x2)

# Ignoring
addi    x8,x2,32

# Store word 0 - sum
sw      x0,-20(x8)

###################### For loop start ######################

# Jump and link to main with 0 as the return value
jal     x0,1026c <main+0x8c>

########### Loading value of A ###########

# Loads value to upper 20bit of 32bit register. 0x11 equals to value 17
lui     x15,0x11

# Adds number 1752 to value in register x15
addi    x14,x15,1752 # 116d8 <A>

# Load word with -20 offset (i) from memory to register x15; x15 = i
lw      x15,-20(x8)

# Shift left logical immediate
slli    x15,x15,0x3

# Add value from register x14 to x15. x15 points to address in memory
add     x15,x14,x15

# Load value from memory address that is stored in x15. This is the result from the A load
ld      x13,0(x15)

##########################################

########### Loading value of W ###########

lui     x15,0x11
addi    x14,x15,1824 # 11720 <W>
lw      x15,-20(x8)
slli    x15,x15,0x3
add     x15,x14,x15
ld      x15,0(x15)

##########################################

# Move x15 - A[i] - to x11
addi    x11,x15,0

# Move x13 - W[i] - to x10
addi    x10,x13,0

# Call mult operation
jal     x1,10294 <mult>

# Move x10 to x15 - Save the value of W[i] to x15 - function call result
addi    x15,x10,0

# Saves the result in memory
sw      x15,-24(x8)

# Loads the result from memory
lw      x15,-24(x8)

# No idea why is this one used here - takes x15 and saves to x15
addiw   x15,x15,0

############## if prod < 0 continue; ##############

# Checks if prod is smaller than 0, if so, jump to main again
blt     x15,x0,1025c <main+0x7c>

# Loads the x14 (sum) to the register
lw      x14,-24(x8)
ld      x15,-16(x3) # 11ec8 <sum>

# Sum = sum + prod
add     x14,x14,x15

# Stores the result to memory
sd      x14,-16(x3) # 11ec8 <sum>

# Skip the next command - this one is set only on first for loop iteration
jal     x0,10260 <main+0x80>

# Set set x0 to zero (I guess in case it has been altered)
addi    x0,x0,0

# Load word from memory. This value represents i
lw      x15,-20(x8)

# Add one to i
addiw   x15,x15,1

# Save i to memory
sw      x15,-20(x8)

# Load i from memory
lw      x15,-20(x8)

# Store i to x14
addiw   x14,x15,0

# Replace the x15 value to 8 (boundary of for loop)
addi    x15,x0,8

# Check the for loop condition - if i is smaller or equal to 8
bge     x15,x14,101f8 <main+0x18>

###################### For loop end ######################

# Set x15 and x10 to zero
addi    x15,x0,0
addi    x10,x15,0

# Load the saved values from the start of the script
ld      x1,24(x2)
ld      x8,16(x2)

# Ignoring
addi    x2,x2,32

# Return 0
jalr    x0,0(x1)
```

</br>

# Reflection
* It seems like compiler uses relative paths to the return addresses - I have used in assembly name of the return addres - for example MAIN.
* Sometimes the compiler stores a value and loads it redundantly back to register. I believe this is to have the same value in both register and memory
* It seems like the mult function is altered - not in the code. It should be located in address 10294, but that one is outside of the main instructions that were generated by the interpreter
* I still do not understand how are the array values retrieved in respect to the i iterator index value - there are some computations - for example addition of 10294, which I do not understand. There may be workarounds due to the fact that the array consist of long values instead of int, which mean that some bits of long are loaded into different register than rest of the bits. I did not take the long values into consideration in my assignment 1
* In the first iteration of the for loop, the condition of for loop is checked (without increasing the i value) and then the body of for loop is called. I have implemented the for loop check as first steps in for loop body and increased i - index at the end of the body
* Some of the offsets are still unclear to me - I know that they represent relative offset from the specific address - either positive or negative, but I am not always sure what they represent
* There are some workarounds that compiler created - for example setting x0 to zero via command `addi  x0,x0,0` which is not 100% clear to me why.
* Overall I believe that my way of thinking was very similar to what compiler actually created, but I can see that there are many workarounds that I did not think of - they are implemented mainly due to the performance

## Other Assignment Related
* The lines that I have analysed are not only numbers 5 to 29 (as requested in presentation), but a whole code, so that I can get the whole context of the code
* The word document may be not formatted correctly, becuase I am using markdown as primary tool for creating the assignment document
