# How the Program Works: File Copy Using `FileInputStream` and `FileOutputStream`

This program demonstrates how to copy the contents of one file to another using Java's `FileInputStream` and `FileOutputStream`. It also uses `Scanner` to interact with the user.

---

## **How It Works**

### 1. **Imports & Dependencies**
- `import java.io.IOException;`  
  *Allows handling file input/output exceptions.*

- `import java.io.FileInputStream;`  
  *Reads raw bytes from a file (suitable for binary files).*

- `import java.io.FileOutputStream;`  
  *Writes raw bytes to a file (suitable for binary files).*

- `import java.util.Scanner;`  
  *Reads user input from the console.*

---

### 2. **Class Structure**

#### **Class: `bin`**
- Contains the `binary()` method that:
  1. **Prompts the user** for the input file name.
  2. **Opens** the input file using `FileInputStream`.
  3. **Prompts the user** for the output file name.
  4. **Opens** the output file using `FileOutputStream`.
  5. **Reads** bytes from the input file and **writes** them to the output file (byte-by-byte).
  6. **Handles exceptions** and prints any error messages.

#### **Class: `Main`**
- Contains the `main()` method that:
  - Creates an instance of `bin`.
  - Calls the `binary()` method **twice** (so you can copy two files consecutively).

---

## **Step-by-Step Explanation**

1. **User Input**:  
   - The program asks for the source file name (the file you want to copy).
   - Then, it asks for the destination file name (the new file to be created/copied to).

2. **File Copy**:  
   - It opens both files using streams.
   - Reads one byte at a time from the source.
   - Writes that byte to the destination.
   - Repeats until the end of the file.

3. **Exception Handling**:  
   - If any I/O error occurs (e.g., file not found), it prints the error message.

---

## **Mnemonic for Remembering the Classes:**
- **FIS** = **F**ile**I**nput**S**tream – For reading bytes from files.
- **FOS** = **F**ile**O**utput**S**tream – For writing bytes to files.
- **S**canner – For **S**tring input (user input).

---

## **When to Use This Approach**

- **Binary files:** Use this for copying images, audio, PDFs, executables, etc.
- **Text files:** Can be used, but for text consider `BufferedReader`/`BufferedWriter` for efficiency and encoding support.

---

## **Example Usage**

1. Run the program.
2. When prompted, type the name of the file you want to copy (e.g., `image.jpg`).
3. When prompted again, type the name of the new file (e.g., `copy.jpg`).
4. If successful, you’ll see:  
   `Successfully wrote to the file`

---

## **Code Walkthrough**

```java
Scanner sc = new Scanner(System.in);
System.out.println("Enter the file name");
String fileName = sc.nextLine();

try(FileInputStream fis = new FileInputStream(fileName);){
    Scanner out = new Scanner(System.in);
    System.out.println("Enter the name of output file");
    String outFileName = out.nextLine();
    FileOutputStream fos = new FileOutputStream(outFileName);

    int i;
    while((i=fis.read())!=-1){
        fos.write(i);
    }
    System.out.println("Successfully wrote to the file");
}
catch (IOException e){
    System.out.println(e.getMessage());
}
```

---

## **Key Points & Explanation**

- **FileInputStream/FileOutputStream:**  
  - These work at the byte level, so are perfect for binary files.
- **Why not Scanner for files?**  
  - `Scanner` is great for user input and parsing text, **not** for copying files byte-for-byte.
- **Why use try-with-resources?**  
  - Ensures streams are closed automatically, preventing resource leaks.
- **Why read/write byte-by-byte?**  
  - Simple for demonstration, but in practice, you would use a buffer for efficiency.

---

## **Tips for Improvement**

- For large files, use a byte array buffer:
    ```java
    byte[] buffer = new byte[4096];
    int bytesRead;
    while((bytesRead = fis.read(buffer)) != -1) {
        fos.write(buffer, 0, bytesRead);
    }
    ```
- Always check for exceptions and handle errors gracefully.
- Close your streams (using try-with-resources is best practice).

---

## **Summary Table**

| Class              | Role                          |
|--------------------|------------------------------|
| `Scanner`          | User input                    |
| `FileInputStream`  | Read file (bytes)             |
| `FileOutputStream` | Write file (bytes)            |

---

## **Mnemonic Recap**  
- **FIS**: FileInputStream – For Input (reading bytes)
- **FOS**: FileOutputStream – For Output (writing bytes)
- **S**canner: For String input

---

If you need to copy files in Java—especially binary files—this is a safe and reliable approach!
