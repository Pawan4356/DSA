# Chapter 3: Tail Recursion vs Non-Tail Recursion

## 📘 What is Tail Recursion?

A **tail recursive function** is a function where the **recursive call is the last operation** in the function. There is no pending work after the recursive call returns.

### ✅ Why is Tail Recursion Important?

- Some compilers/languages **optimize tail-recursive functions** to use constant space (Tail Call Optimization or TCO).
- Helps avoid stack overflow for large inputs.

---

## 📌 Structure of Tail Recursion

```java
void func(int n) {
    if (n == 0) return;   // Base case
    // do work (if any)
    func(n - 1);          // Recursive call is the LAST statement
}
```

## 🔁 Example: Tail Recursion (Printing)

```java
public class TailExample {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n) {
        if (n == 0) return;
        System.out.println(n);
        print(n - 1); // Last operation
    }
}
```

### 🧠 Note:
The recursive call `print(n - 1)` is the final step → **tail recursive**.

---

### 🔁 Example: Tail Recursive Factorial

To make factorial tail-recursive, we use an **accumulator** that carries the intermediate result.

```java
public class TailFact {
    public static void main(String[] args) {
        System.out.println(fact(5, 1)); // Output: 120
    }

    public static int fact(int n, int acc) {
        if (n == 0) return acc;
        return fact(n - 1, n * acc); // Recursive call is the last operation
    }
}
```

## 🌀 What is Non-Tail Recursion?

In **non-tail recursion**, the recursive call is **not the last operation**. There is **pending work** after the recursive call returns.

This means the current function call **cannot complete** until the recursive call finishes, which keeps adding frames to the call stack.

---

### 📌 Structure of Non-Tail Recursion

```java
void func(int n) {
    if (n == 0) return;
    func(n - 1);      // Recursive call
    // more work AFTER the call
}
```

### 🔁 Example: Non-Tail Recursion (Reverse String)

```java
public class NonTailExample {
    public static void main(String[] args) {
        reverse("Hello", 0);
    }

    public static void reverse(String str, int ind) {
        if (ind >= str.length()) return;
        reverse(str, ind + 1);
        System.out.print(str.charAt(ind)); // Work AFTER recursion → non-tail
    }
}
```
### ✅ Output
```java
olleH
```

📌 Reason: Recursion is followed by a print → non-tail.

## 🧠 Stack Behavior Difference

### ✅ Tail Recursion (Linear Stack)

```scss
call(3)
 └─> call(2)
      └─> call(1)
           └─> call(0) → return
```
Each call can be replaced as there's no work after.

## 🌀 Non-Tail Recursion (Nested Stack)

Consider the following recursive flow:

```
call(3)
 -> call(2)
   -> call(1)
     -> call(0) → return
   print(1)
 print(2)
print(3)
```


🧠 **Explanation:**

- Each recursive call goes deeper until the base case is reached (`call(0)`).
- Then, as the stack unwinds, each function resumes execution **after** the recursive call.
- Therefore, the **print statements execute in reverse order** of the calls.

📌 This behavior is typical of **non-tail recursion**, where:

- Recursive calls **must finish** before continuing.
- Each call frame is **kept in memory** until all inner calls complete.
- This leads to a **stack depth of O(n)**.
