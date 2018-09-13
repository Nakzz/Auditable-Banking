import java.util.Arrays;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Auditable Banking
// Files: AuditableBanking.java, AuditableBankingTests.java
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Mory Keita
// Partner Email: mkeita@wisc.edu
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class AuditableBankingTests {

     public static void main(String[] args) {
         
//         testCalculateNumberOfOverdrafts();
//         testProcessCommand();
         testCalculateCurrentBalance();
         
     }

     
     //TODO: make tests for quick withdraw and normal transaction. atleast 2 more. 
     //TODO: write method descriptions 
     
     /**
      * Goal of this test method is to determine if there is a problem within the ProcessCommand method 
      * by using a bunch of dummy input that represents what a possible user could use. This method is
      * able to determine if the method worKs by calling the actual method within the test method.
      * 
      * @return a boolean value indicating weather the code specifically for ProcessCommand works
      */
    public static boolean testProcessCommand() {
        
        int[][] transactions = new int[100][] ; //oversized array
        int[] transaction1 = {1, 10, -20, 30, -20, -20}; //perfect size array
        int[] transaction2 = {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}; //perfect size array
        
        transactions[0] = transaction1; //puts transaction1 in the zero index 
        transactions[1] = transaction2; //puts transaction1 in the first index 

        boolean foundProblem = false; //boolean value to determine if java found a problem
        
        String command = "0 0 1 1 0 1 1"; //represents an input that a user could use
        int count = 2;
        
        int resultCount = AuditableBanking.processCommand(command, transactions, count);
        //calls processCommand method in order to determine number of transactions
        
        if(resultCount == 3 && transactions[2][2]==1) { 
          //looks for specific values for when looking at # given by calling ProcessCommand 
            System.out.println("PASSED TESTS 1/1 of testProcessCommand!!!"); //lets me know if the test worked
            foundProblem = false; 
        } else {
            System.out.println(
                "FAILURE: processCommand returned: "+ resultCount+ ", and transactions contained: "
                    + Arrays.deepToString(transactions)); //Converts multidimensional arrays to strings
            foundProblem = true;
        }
        
        return !foundProblem;
    }

    
    /**
     * Goal of this test method is to determine if there is a problem within the CalculateCurrentBalance method 
     * by using a bunch of dummy input that represents what a possible user could use. This method is
     * able to determine if the method works by calling the actual method within the test method.
     * 
     * @return a boolean value indicating weather the code specifically for CalculateCurrentBalance works
     * and checks to see that the test method returns the correct value    
     */
    
    public static boolean testCalculateCurrentBalance() {
        boolean foundProblem = false;
        int[][] transactions = new int[100][] ;
         transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                         // balance: -20)
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
            {1, 115}, // +0 overdrafts (ending balance: +100)
            {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
        };

        // test with a single transaction of the Integer Amount encoding
        int transactionCount = 2;
        
        int balance =
            AuditableBanking.calculateCurrentBalance(transactions, transactionCount);
        //use calculate method in order to determine the final balance left in the account
        if (balance != -15) {
            System.out.println(
                "FAILURE: calculateCurrentBalance did not return -15 when transactionCount = 2, and transactions contained: "
                    + Arrays.deepToString(transactions) + "balance: " + balance); 
            //prints out a visual response for the coder to determine if the code was able to function of not 
            foundProblem = true;
        } else {
            System.out.println("PASSED TEST 1/2 of testCalculateCurrentBalance!!!");
        }
        
        // test with four transactions: including one of each encoding
        transactionCount = 4;
        balance = AuditableBanking.calculateCurrentBalance(transactions, transactionCount);
        if (balance != -100) {
            System.out.println(
                "FAILURE: calculateCurrentBalance did not return -100 when transactionCount = 4, and transactions contained: "
                    + Arrays.deepToString(transactions) + "balance: " + balance);
            foundProblem = true;
        } else {
            System.out.println("PASSED TESTS 2/2 of testCalculateCurrentBalance!!!");
        }
        return !foundProblem; //returns the opposite of the value of the boolean value stored in foundProblem
    }

    /**
     * Goal of this test method is to determine if there is a problem within the CalculateNumberOfOverdrafts method 
     * by using a bunch of dummy input that represents what a possible user could use. This method is
     * able to determine if the method works by calling the actual method within the test method.
     * 
     * @return a boolean value indicating weather the code specifically for CalculateNumberOfOverdrafts works
     * and checks to see that the test method returns the correct value for overdrafts  
     */
    
    public static boolean testCalculateNumberOfOverdrafts() {
        boolean foundProblem = false;
        int[][] transactions = new int[][] {{1, 10, -20, +30, -20, -20}, // +2 overdrafts (ending
                                                                         // balance: -20)
            {0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // +2 overdrafts (ending balance: -15)
            {1, 115}, // +0 overdrafts (ending balance: +100)
            {2, 3, 1, 0, 1}, // +1 overdrafts (ending balance: -100)
        };

        // test with a single transaction of the Integer Amount encoding
        int transactionCount = 1;
        int overdrafts =
            AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
        //calls calculateNumberOfOverdrafts method in order to get total value of overdrafts
        if (overdrafts != 2) { //checks to see if overdraft value is equal to two
            System.out.println(
                "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
                    + Arrays.deepToString(transactions) + "Overdraft: "+ overdrafts);
            foundProblem = true;
        } else
            System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

        // test with four transactions: including one of each encoding
        transactionCount = 4;
        overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
        if (overdrafts != 5) {//checks to see if overdraft value is equal to five
            System.out.println(
                "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
                    + Arrays.deepToString(transactions) + "Overdraft: "+ overdrafts);
            foundProblem = true;
        } else
            System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

        return !foundProblem;
    }
}
