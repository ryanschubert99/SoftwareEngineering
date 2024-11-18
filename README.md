# SoftwareEngineering
Assignment 2: API Implemenation
In this assignment a 2d Matrix Computation engine was created.
System Diagram
https://github.com/ryanschubert99/SoftwareEngineering/blob/9fd6d6aa38de325b84c6a41d7b3c326be74c9f16/20240917_090522.jpg

Uses a max of 4 Threads.
Benchmark Tests:
We optimized the loop to improve cache efficiency by reusing values from matrix1[i][k] across multiple operations, 
reducing memory accesses and speeding up matrix multiplication.
![image](https://github.com/user-attachments/assets/ceae436e-dfc8-4443-933a-713284a60a0b)


