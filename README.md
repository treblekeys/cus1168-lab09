# Lab: File Data Processor Lab

### Learning Objectives

* Apply different loop constructs in practical data processing scenarios
* Implement exception handling for robust data operations
* Practice filtering data using various control structures
* Format data output for tabular display
* Develop menu-driven console applications

#### Prerequisites

* Basic understanding of Java syntax
* Knowledge of Java collections (`List`, `Map`)
* Familiarity with loop constructs (`for`, enhanced `for`, `while`)
* Experience with exception handling (`try`-`catch`)
* Understanding of conditional statements (`if`, `switch`)

#### Task Description

In this lab, you will complete a sales data processing application that allows users to filter sales records based on
different criteria. The application uses a sample dataset of sales transactions containing information such as order
IDs, customer names, product information, quantities, prices, and regions. You will implement several methods to display
and filter this data according to specific requirements.

#### Detailed Requirements

1. Complete the `displayData()` method that:
    * Takes a list of Map objects representing sales records
    * Displays the data in a formatted table using String.format
    * Shows the total number of records at the bottom

2. Implement the `filterQuantityGreaterThan()` method that:
    * Takes a list of sales records and a minimum quantity value
    * Returns a new list containing only records with quantities greater than the specified value
    * Uses enhanced for loops and continue statements for flow control
    * Implements proper exception handling for invalid data

3. Implement the `filterUnitPriceGreaterThan()` method that:
    * Takes a list of sales records and a minimum price value
    * Returns a new list containing only records with unit prices greater than the specified value
    * Uses traditional while loops instead of for loops
    * Implements proper exception handling for invalid data

4. Implement the `filterByRegion()` method that:
    * Takes a list of sales records and a target region
    * Returns a new list containing only records from the specified region
    * Uses enhanced for loops with switch statements for region comparison
    * Handles null values and unknown regions appropriately

## Technical Requirements

* Your implementation must handle edge cases appropriately (null values, invalid data formats)
* Each filtering method must return a new list without modifying the original data
* The display method must format the data as specified with proper column alignment
* Exception handling must provide appropriate error messages without crashing the program
* Your code must use the specified loop constructs and control flow statements

#### Project Setup

1. Open the `FileLab.`java file in your IDE
2. Locate the TODO comments in the code that mark the sections you need to implement
3. Complete each of the required methods as per the specifications
4. Do not modify the existing code structure or change method signatures
5. Test your implementation using the provided menu options

#### Expected Output

When running your program, it should produce output similar to:

```
===== Simplified File Data Processor =====

Original Data:
OrderID  Date         CustomerName         ProductID  Quantity UnitPrice  TotalAmount  Region  
------------------------------------------------------------------------------------------
1001     2023-01-15   John Smith           P123       5        29.99      149.95       North   
1002     2023-01-17   Sarah Johnson        P145       2        49.99      99.98        South   
1003     2023-01-18   Michael Brown        P123       3        29.99      89.97        East    
1004     2023-01-20   Emma Wilson          P187       1        199.99     199.99       West    
1005     2023-01-22   Robert Davis         P145       4        49.99      199.96       North   
1006     2023-01-25   Jennifer Lee         P187       2        199.99     399.98       South   
1007     2023-01-26   David Miller         P123       10       29.99      299.90       East    
1008     2023-01-27   Amanda Clark         P254       3        19.99      59.97        West    
1009     2023-01-28   Thomas Johnson       P187       1        199.99     199.99       North   
1010     2023-01-30   Lisa Taylor          P254       8        19.99      159.92       South   
1011     2023-02-02   James Wilson         P123       6        29.99      179.94       East    
1012     2023-02-03   Patricia Brown       P145       3        49.99      149.97       West    
1013     2023-02-05   Richard Moore        P254       5        19.99      99.95        North   
1014     2023-02-07   Elizabeth Davis      P187       1        199.99     199.99       South   
1015     2023-02-10   Charles Garcia       P123       4        29.99      119.96       East    
------------------------------------------------------------------------------------------
Total records: 15

==== Filter Operations ====
1. Find large orders (Quantity > 5)
2. Find expensive products (UnitPrice > 100)
3. Find orders from North region
4. Exit
Enter your choice (1-4): 1

===== Filter: Quantity > 5 (Large Orders) =====
OrderID  Date         CustomerName         ProductID  Quantity UnitPrice  TotalAmount  Region  
------------------------------------------------------------------------------------------
1007     2023-01-26   David Miller         P123       10       29.99      299.90       East    
1010     2023-01-30   Lisa Taylor          P254       8        19.99      159.92       South   
1011     2023-02-02   James Wilson         P123       6        29.99      179.94       East    
------------------------------------------------------------------------------------------
Total records: 3

==== Filter Operations ====
1. Find large orders (Quantity > 5)
2. Find expensive products (UnitPrice > 100)
3. Find orders from North region
4. Exit
Enter your choice (1-4): 2

===== Filter: UnitPrice > 100 (Expensive Products) =====
OrderID  Date         CustomerName         ProductID  Quantity UnitPrice  TotalAmount  Region  
------------------------------------------------------------------------------------------
1004     2023-01-20   Emma Wilson          P187       1        199.99     199.99       West    
1006     2023-01-25   Jennifer Lee         P187       2        199.99     399.98       South   
1009     2023-01-28   Thomas Johnson       P187       1        199.99     199.99       North   
1014     2023-02-07   Elizabeth Davis      P187       1        199.99     199.99       South   
------------------------------------------------------------------------------------------
Total records: 4

==== Filter Operations ====
1. Find large orders (Quantity > 5)
2. Find expensive products (UnitPrice > 100)
3. Find orders from North region
4. Exit
Enter your choice (1-4): 3

===== Filter: Region = "North" =====
OrderID  Date         CustomerName         ProductID  Quantity UnitPrice  TotalAmount  Region  
------------------------------------------------------------------------------------------
1001     2023-01-15   John Smith           P123       5        29.99      149.95       North   
1005     2023-01-22   Robert Davis         P145       4        49.99      199.96       North   
1009     2023-01-28   Thomas Johnson       P187       1        199.99     199.99       North   
1013     2023-02-05   Richard Moore        P254       5        19.99      99.95        North   
------------------------------------------------------------------------------------------
Total records: 4

==== Filter Operations ====
1. Find large orders (Quantity > 5)
2. Find expensive products (UnitPrice > 100)
3. Find orders from North region
4. Exit
Enter your choice (1-4): 4
Thank you for using the File Data Processor!

Process finished with exit code 0
```