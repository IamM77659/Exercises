import java.util.Scanner;

public class UniqueAndDuplicateNumbers {

    // Method to print unique numbers and duplicates
    public static void processNumbers(int[] numbers, int n) {
        int[] uniqueNumbers = new int[n]; // To store unique numbers
        int[] duplicateNumbers = new int[n]; // To store duplicate numbers
        int uniqueCount = 0;
        int duplicateCount = 0;

        System.out.println("Unique numbers:");
        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;

            // Check if the number already exists in the unique list
            for (int j = 0; j < uniqueCount; j++) {
                if (numbers[i] == uniqueNumbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                // Add to duplicates if not already added
                boolean alreadyInDuplicates = false;
                for (int k = 0; k < duplicateCount; k++) {
                    if (numbers[i] == duplicateNumbers[k]) {
                        alreadyInDuplicates = true;
                        break;
                    }
                }
                if (!alreadyInDuplicates) {
                    duplicateNumbers[duplicateCount++] = numbers[i];
                }
            } else {
                // Add to unique numbers
                uniqueNumbers[uniqueCount++] = numbers[i];
                System.out.println("#" + uniqueCount + " - " + numbers[i]);
            }
        }

        System.out.println("Duplicate numbers:");
        for (int i = 0; i < duplicateCount; i++) {
            System.out.print(duplicateNumbers[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of input cases
        System.out.print("Enter number of inputs (N): ");
        int n = scanner.nextInt();

        // Input validation
        if (n <= 0 || n > 100) {
            System.out.println("N must be between 1 and 100.");
            return;
        }

        int[] numbers = new int[n];

        // Read N numbers between 1 and 100
        System.out.println("Enter " + n + " numbers (1 to 100):");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num < 1 || num > 100) {
                System.out.println("Invalid number. Must be between 1 and 100.");
                i--; // Re-ask for this number
            } else {
                numbers[i] = num;
            }
        }

        // Call the method to process and print the results
        processNumbers(numbers, n);

        
    }
}