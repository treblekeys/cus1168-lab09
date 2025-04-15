package academy.javapro;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileLab {
    // Store our sample data as a static List
    private static final List<Map<String, String>> salesData;
    private static final Scanner scanner = new Scanner(System.in);

    // Initialize our sample data
    static {
        salesData = new ArrayList<>();

        // Add all the sales records
        addSalesRecord("1001", "2023-01-15", "John Smith", "P123", "5", "29.99", "149.95", "North");
        addSalesRecord("1002", "2023-01-17", "Sarah Johnson", "P145", "2", "49.99", "99.98", "South");
        addSalesRecord("1003", "2023-01-18", "Michael Brown", "P123", "3", "29.99", "89.97", "East");
        addSalesRecord("1004", "2023-01-20", "Emma Wilson", "P187", "1", "199.99", "199.99", "West");
        addSalesRecord("1005", "2023-01-22", "Robert Davis", "P145", "4", "49.99", "199.96", "North");
        addSalesRecord("1006", "2023-01-25", "Jennifer Lee", "P187", "2", "199.99", "399.98", "South");
        addSalesRecord("1007", "2023-01-26", "David Miller", "P123", "10", "29.99", "299.90", "East");
        addSalesRecord("1008", "2023-01-27", "Amanda Clark", "P254", "3", "19.99", "59.97", "West");
        addSalesRecord("1009", "2023-01-28", "Thomas Johnson", "P187", "1", "199.99", "199.99", "North");
        addSalesRecord("1010", "2023-01-30", "Lisa Taylor", "P254", "8", "19.99", "159.92", "South");
        addSalesRecord("1011", "2023-02-02", "James Wilson", "P123", "6", "29.99", "179.94", "East");
        addSalesRecord("1012", "2023-02-03", "Patricia Brown", "P145", "3", "49.99", "149.97", "West");
        addSalesRecord("1013", "2023-02-05", "Richard Moore", "P254", "5", "19.99", "99.95", "North");
        addSalesRecord("1014", "2023-02-07", "Elizabeth Davis", "P187", "1", "199.99", "199.99", "South");
        addSalesRecord("1015", "2023-02-10", "Charles Garcia", "P123", "4", "29.99", "119.96", "East");
    }

    /**
     * Helper method to add a sales record to our static data
     */
    private static void addSalesRecord(String orderId, String date, String customerName,
                                      String productId, String quantity, String unitPrice,
                                      String totalAmount, String region) {
        Map<String, String> record = new HashMap<>();
        record.put("OrderID", orderId);
        record.put("Date", date);
        record.put("CustomerName", customerName);
        record.put("ProductID", productId);
        record.put("Quantity", quantity);
        record.put("UnitPrice", unitPrice);
        record.put("TotalAmount", totalAmount);
        record.put("Region", region);

        salesData.add(record);
    }

    /**
     * Main method to run the filtering operations
     */
    public static void main(String[] args) {
        System.out.println("===== Simplified File Data Processor =====\n");

        // Display all data first
        System.out.println("Original Data:");
        displayData(salesData);

        // Using a while loop for menu-driven operation
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();

            // Using switch for operation selection
            switch (choice) {
                case 1 -> { // Filter by quantity
                    System.out.println("\n===== Filter: Quantity > 5 (Large Orders) =====");
                    List<Map<String, String>> largeOrders = filterQuantityGreaterThan(salesData, 5);
                    displayData(largeOrders);
                }
                case 2 -> { // Filter by unit price
                    System.out.println("\n===== Filter: UnitPrice > 100 (Expensive Products) =====");
                    List<Map<String, String>> expensiveProducts = filterUnitPriceGreaterThan(salesData, 100);
                    displayData(expensiveProducts);
                }
                case 3 -> { // Filter by region
                    System.out.println("\n===== Filter: Region = \"North\" =====");
                    List<Map<String, String>> northRegionOrders = filterByRegion(salesData, "North");
                    displayData(northRegionOrders);
                }
                case 4 -> { // Exit the program
                    running = false;
                    System.out.println("Thank you for using the File Data Processor!");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Display the menu options
     */
    private static void displayMenu() {
        System.out.println("\n==== Filter Operations ====");
        System.out.println("1. Find large orders (Quantity > 5)");
        System.out.println("2. Find expensive products (UnitPrice > 100)");
        System.out.println("3. Find orders from North region");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    /**
     * Get a valid menu choice (using do-while loop)
     */
    private static int getMenuChoice() {
        int choice = 0;
        boolean validInput = false;

        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                validInput = (choice >= 1 && choice <= 4);
                if (!validInput) {
                    System.out.print("Please enter a number between 1 and 4: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        } while (!validInput);

        return choice;
    }

    /**
     * Display the data in a formatted table
     * Using enhanced for loop
     */
    private static void displayData(List<Map<String, String>> data) {
        // Display header
        System.out.println(String.format("%-8s %-12s %-20s %-10s %-8s %-10s %-12s %-8s",
                           "OrderID", "Date", "CustomerName", "ProductID", "Quantity",
                           "UnitPrice", "TotalAmount", "Region"));
        System.out.println("-".repeat(90));

        // Display each record using enhanced for loop
        for(Map<String, String> record : data){
            System.out.println(String.format("%-8s %-12s %-20s %-10s %-8s %-10s %-12s %-8s",
            record.get("OrderID"), record.get("Date"), record.get("CustomerName"), record.get("ProductID"), record.get("Quantity"), record.get("UnitPrice"), record.get("TotalAmount"), record.get("Region")
            ));
        }

        // Display count
        System.out.println("-".repeat(90));
        System.out.println("Total records: " + data.size());
    }

    /**
     * Filter 1: Find orders with quantity greater than the specified value
     * Using enhanced for loop and continue statement for flow control
     */
    private static List<Map<String, String>> filterQuantityGreaterThan(
            List<Map<String, String>> data, int minQuantity) {

        List<Map<String, String>> filteredData = new ArrayList<>();
        for(Map<String , String> record : data) {
            try{
                int quantity = Integer.parseInt(record.get("Quantity"));
                // Using an if statement with continue for flow control
                if(quantity <= minQuantity) continue;

                // If we get here, the record passed the filter
                filteredData.add(record);
            }
            // Skip records with invalid quantity values
            catch (NumberFormatException e) {
                System.out.println("Invalid quantity format in record: " + record.get("OrderID"));
            }
        }
        return filteredData;
    }

    /**
     * Filter 2: Find orders with unit price greater than the specified value
     * Using traditional while loop instead of for loop
     */
    private static List<Map<String, String>> filterUnitPriceGreaterThan(
            List<Map<String, String>> data, double minPrice) {
        List<Map<String, String>> filteredData = new ArrayList<>();
        // Using while loop and iterator
        int i = 0;
        while(i < data.size()) {
            Map<String, String> record = data.get(i);

            try {
                double unitPrice = Double.parseDouble(record.get("UnitPrice"));
                if(unitPrice > minPrice) {
                    filteredData.add(record);
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid unit price format in record: " + record.get("OrderID"));
            }
            i++;
        }
        return filteredData;
    }

    /**
     * Filter 3: Find orders from a specific region
     * Using enhanced for loop with switch statement for region comparison
     */
    private static List<Map<String, String>> filterByRegion(
            List<Map<String, String>> data, String targetRegion) {
        List<Map<String, String>> filteredData = new ArrayList<>();
        for(Map<String, String> record : data) {
            String recordRegion = record.get("Region");
            if (recordRegion == null) continue;
            switch(recordRegion) {
                case "North":
                case "South":
                case "East":
                case "West":
                    if (recordRegion.equalsIgnoreCase(targetRegion)) {
                        filteredData.add(record);
                    }
                    break;
                default:
                    System.out.println("Unknown region: " + recordRegion);
            }
        }
        return filteredData;
    }
}
