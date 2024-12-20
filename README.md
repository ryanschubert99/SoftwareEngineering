# SoftwareEngineering

# **Matrix Multiplyer**  


## **Overview**  
A system to take in user input to generate and multipy matrices.



---

## **Table of Contents**  
1. [Features](#features)  
2. [Benchmark test](#benchmark-test)
3. [System Diagram](#system-diagram) 
4. [Tech Stack](#tech-stack)  
5. [Installation](#installation)   
6. [Contact](#contact)  

---

## **Features**  
 
✅ Feature 1: **Multithreading** – Generates 20 threads for each matrix input.
✅ Feature 2: **File or maual input** – User can inpuy data via csv file or manual input  

---

## **Benchmark Test**  

Benchmark Tests:

We optimized the loop to improve cache efficiency by reusing values from matrix1[i][k] across multiple operations, 
reducing memory accesses and speeding up matrix multiplication.





![image](https://github.com/user-attachments/assets/ceae436e-dfc8-4443-933a-713284a60a0b)

link to Benchmark test:
https://github.com/ryanschubert99/SoftwareEngineering/blob/main/test/tests/Benchmark.java 
---
**System Diagram**


![image](https://github.com/user-attachments/assets/014f0322-a7d7-4c22-9c0b-9096d3b7d14d)





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

## **Contact**  
**Louris Alejilat** – [Github](https://github.com/dashboard)
**Ryan Schubert** - [Github](https://github.com/ryanschubert99)

