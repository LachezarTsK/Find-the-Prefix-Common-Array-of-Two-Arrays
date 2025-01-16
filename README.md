# Minimize-XOR
Challenge at LeetCode.com. Tags: Bitwise Operations, Greedy.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
- Java, C++, C#, Kotlin, Golang: solution with bitwise operations.
- JavaScript, TypeScript: solution with frequency array.

When applying bitwise operations with JavaScript/TypeScript, these programming languages treat their standard 64-bit floating point number as a 32-bit integer. Since the number of bitwise shifts, which are used to store an occurence of a value, can be up to 50 shifts, in some cases there is an integer overflow. One possibility to avoid this for JavaScript/TypeScript is to use their BigInt class. 

However, with JavaScript/TypeScript, for this particular problem, such a solution is approximately 10 times slower in comparison with using a frequency array: ~50 ms for BigInt as opposed to ~4 ms for frequency array with their standard 64-bit floating point number.

The solution with bitwise operations with Java, C++, C#, Kotlin and Golang requires the application of 64-bit integers and it is at least as fast, or even faster, than the solution with frequency array and 32-bit integer.
