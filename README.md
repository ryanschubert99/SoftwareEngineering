# SoftwareEngineering

# **Matrix Multiplyer**  


## **Overview**  
A system to take in user input to generate and multipy matrices.



---

## **Table of Contents**  
1. [Features](#features)  
2. [Benchmark test](#benchmark-test)  
3. [Tech Stack](#tech-stack)  
4. [Installation](#installation)  
5. [Usage](#usage)   
6. [Contact](#contact)  

---

## **Features**  
 
✅ Feature 1: **Multithreading** – Generates 20 threads for each matrix input.
✅ Feature 2: **File or maual input** – User can inpuy data via csv file or manual input  

---

## **Benchmark Test**  
Assignment 2: API Implemenation
In this assignment a 2d Matrix Computation engine was created.
System Diagram
https://github.com/ryanschubert99/SoftwareEngineering/blob/9fd6d6aa38de325b84c6a41d7b3c326be74c9f16/20240917_090522.jpg


Uses a max of 4 Threads.
Benchmark Tests:

We optimized the loop to improve cache efficiency by reusing values from matrix1[i][k] across multiple operations, 
reducing memory accesses and speeding up matrix multiplication.
![image](https://github.com/user-attachments/assets/ceae436e-dfc8-4443-933a-713284a60a0b)

link to Benchmark test:
https://github.com/ryanschubert99/SoftwareEngineering/blob/main/test/tests/Benchmark.java 
---

## **Tech Stack**  
### **Frontend**   
- JavaScript  
- Html 

### **Backend**  
- Java  

### **Tools**  
- Gradle  
- gRPC  
- Protobuf  

---

## **Installation**  

Follow these steps to set up the project locally.  

1. **Clone the repository**  
   ```bash
   git clone https://github.com/username/repository-name.git
   cd repository-name
   ```

2. **Run **  
   ```bash
   npm install
   ```
   ```
   ./gradlew generateProto
   ```
   

4. **Start the server**  
   UserRequestServer.java


5. **Input data**  
   Open frontend.html in your browser or run UserRequestClient
    

---

## **Usage**  
Describe how to use the project.  

Example:  
1. Register an account.  
2. Log in using your credentials.  
3. Create and manage tasks using the dashboard.  

---

## **Contact**  
**Louris Alejilat** – [Github](https://github.com/dashboard)
**Ryan Schubert** - [Github](https://github.com/ryanschubert99)

