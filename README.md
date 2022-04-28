# Android-UI-System-Testing

An Android application with two input fields (EditBox), one button, and one output field. 
Both inputs are strings, but the second one should only accept a natural number. 
The application calculates the suffix of the first input from the character index given by the second parameter and writes the result to the output.

Further specifications:

1. An independent class calculates the suffix from a string and a natural number (returns with a string). If the number is greater than the length of the first input, then it throws an exception. 
non-instrumented unit tests for this class have been written for that matter.
2. The UI checks the second parameter whether it is a number or not (but does not check it is greater than the length of the string or not), passes the arguments to the class that calculates the results, and at last writes out the output. 
unit, UI tests and System tests for :
- normal behavior (2nd parameter number between 0 and the length of the first parameter)
- non-number second parameter (app writes an error message to output)
- the second parameter greater than the length of the first parameter, so the calculator throws an exception - also an error to the output)
