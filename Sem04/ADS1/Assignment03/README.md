# Considerations
## What you need?
- After I went through the assignment, I have realized that I will need a method for printing out the whole grid for testing purposes. The method toString() method was overridden for it as one of the first steps.   
- I need some kind of differentiation on whenever there is a queen on a specific field or not
## What methods you need?
- A method for checking if the current recursion is the completing one
- A method for checking if already placed queen does not conflict with the given row col position
- A method for printing out the current state of the board (toString())
## How to abandon futile attempts?
- I have achieved this with restricting the queen conflict check to not surpass the checked col value - after this value, no conflicts will be made. 
