# ScreenLock Pattern Algorithm

## Table of Contents
- [General Info](#general-info)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Screenshots](#screenshots)
- [Room for Improvement](#room-for-improvement)

## General Info
The **ScreenLock Pattern Algorithm** is an implementation that simulates the creation and validation of screen lock patterns, commonly used in mobile devices. This solution is modeled as a graph-based system, enabling flexible and dynamic management of valid connections while adhering to the constraints of real-world lock patterns.

The program uses **Depth-First Search (DFS)** to explore all possible patterns of a given length and applies custom logic to handle constraints like skipping intermediate nodes.

## Technologies Used
- **Java**: Core language for implementing the graph-based logic and recursion.
- **Data Structures**: Maps and Lists are used to represent the graph and manage dynamic updates efficiently.

## Features
### 1. **Graph-Based Representation**
The lock grid is modeled as a graph where:
- Nodes (`A` to `I`) represent screen points.
- Edges define valid connections, updated dynamically to reflect skipping rules.

### 2. **DFS Exploration**
- Explores all valid paths recursively.
- Tracks visited nodes to prevent revisits and maintain the integrity of patterns.

### 3. **Dynamic Edge Handling**
- Temporary connections are added or removed during traversal based on the current node and constraints.
- Efficiently manages edge states without precomputing all possibilities.

### 4. **Custom Rules Simulation**
Implements realistic rules like:
- Skipping unvisited intermediate nodes (e.g., skipping from `A` to `C` requires visiting `B` first).
- Adjusting edges dynamically for specific nodes (`B`, `E`, etc.).

## Screenshots
![Screenshot Operation result](screenshots/Operation%20result.png)

Example of code execution:
```java
ScreenLock sl = new ScreenLock();
int combinations = sl.calculateCombinations('G', 5);
System.out.println(combinations);
