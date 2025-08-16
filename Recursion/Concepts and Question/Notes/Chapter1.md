# Chapter 1: Introduction to Recursion

## 📘 What is Recursion?

**Recursion** is a programming technique where a function calls itself to solve smaller instances of the same problem. It breaks down a problem into simpler subproblems, solving each with the same logic until a base case is reached.

### 📌 Key Components of Recursion

- **Base Case:** The condition under which the recursion stops.
- **Recursive Case:** The part where the function calls itself with a simpler input.

---

## ✅ Why Use Recursion?

- Elegant solutions to complex problems.
- Reduces code length for problems naturally defined recursively (e.g., tree traversals, factorial, Fibonacci, etc.).
- Powerful in divide-and-conquer algorithms.

---

## 🧪 Examples

### 1. Factorial of a Number

```java
public class Fact {
    public static void main(String[] args) {
        System.out.println(factorial(10)); // Output: 3628800
    }

    public static int factorial(int num) {
        if (num <= 1) return 1;           // Base case
        return num * factorial(num - 1);  // Recursive case
    }
}
```

### 2. nth Fibonacci number

```java

public class Fib {
    public static void main(String[] args) {
        System.out.println(fibonacci(5)); // Output: 5
    }

    private static int fibonacci(int i) {
        if (i == 0) return 0;             // Base case 1
        if (i == 1) return 1;             // Base case 2
        return fibonacci(i - 1) + fibonacci(i - 2); // Recursive case
    }
}
```

### 3. Reverse a String Using Recursion

```java

class RevStr {
    public static void main(String[] args) {
        rec("Hello", 0); // Output: olleH
    }

    public static void rec(String str, int ind) {
        if (ind >= str.length()) return;       // Base case
        rec(str, ind + 1);                     // Recursive case
        System.out.print(str.charAt(ind));     // Print after recursion
    }
}
```