# Chapter 2: Time & Space Complexity in Recursion

---

## 📈 Time Complexity (T.C.)

To analyze how much **time** a recursive function takes, we use a **recurrence relation** that expresses the time taken by the function in terms of smaller input sizes.

### 🧠 How to Derive Time Complexity

1. **Write the recurrence relation**
2. **Unroll the recurrence**
3. **Find a pattern**
4. **Generalize and simplify**

---

### ✏️ Example 1: Factorial

```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

### Recurrence Relation:

```
T(n) = T(n - 1) + c
     = (T(n - 2) + c) + c
     = T(n - 2) + 2c
     = ...
     = T(0) + nc
=> T(n) ∈ O(n)
```

### ✏️ Example 2: Fibonacci

```java
public static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

### Recurrence Relation:

```
T(n) = T(n - 1) + T(n - 2) + c
```

this forms an exponential tree:

```
                T(n)
              /      \
          T(n-1)     T(n-2)
         /     \     /     \
     T(n-2)  T(n-3) T(n-3) T(n-4)
```
Each node spawns 2 more calls → total nodes ≈ 2ⁿ.

✅ Time Complexity: O(2^n) (Exponential)

## 📦 Space Complexity (S.C.)

Space complexity in recursion is the **maximum depth of the call stack** during execution.

---

### ✏️ Example 1: Factorial

```java
factorial(n) --> factorial(n - 1) --> ... --> factorial(1)
```

Stack frames = n calls
#### ✅ Space Complexity: O(n)

### ✏️ Example 1: Factorial

```java
fibonacci(n) --> fibonacci(n - 1), fibonacci(n - 2)
```

The call tree is wide and deep, but since **stack grows only along one path at a time**, depth = n
#### ✅ Space Complexity: O(n)

## ✅ Tips
<ul>
<li>Time Complexity → total work done.</li>
<li>Space Complexity → depth of recursion (stack frames).</li>
<li>Always identify base case, recursive case, and trace how many calls are made and how deep.</li>
</ul>