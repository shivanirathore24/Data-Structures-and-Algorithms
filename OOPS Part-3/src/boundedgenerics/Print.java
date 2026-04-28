package boundedgenerics;

public class Print {
    // bounded generics → only types implementing PrintInterface allowed
    public static <T extends PrintInterface> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
            // System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Vehicle v[] = new Vehicle[5];
        // array index starts from 0 → use (i+1) to start values from 10
        for (int i = 0; i < v.length; i++) {
            v[i] = new Vehicle(10 * (i + 1), "Shiv");
        }
        printArray(v);
        // 10 Shiv
        // 20 Shiv
        // 30 Shiv
        // 40 Shiv
        // 50 Shiv

        Student students[] = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(10 * (i + 1) + 1);
        }
        printArray(students);
        // 11
        // 21
        // 31
        // 41
        // 51
    }
}

/*
PrintInterface → defines rule: must have print()
Vehicle / Student → follow this rule (implement print())
Print<T extends PrintInterface> → accepts only types that follow this rule
So Print class does not implement print(), it just uses the guarantee that T has print()

Without bound (<T>) → type unknown → cannot call custom methods (like print)
With bound (<T extends Interface>) → method guaranteed → safe to call print()
Use bound when you need specific behavior, not just generic storage
*/