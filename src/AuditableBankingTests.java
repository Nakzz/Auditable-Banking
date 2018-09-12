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
         
         testCalculateNumberOfOverdrafts();
    
     }

    public static boolean testProcessCommand() {
        // TODO: Implement this method
        return false;
    }

    public static boolean testCalculateCurrentBalance() {
        // TODO: Implement this method
        return false;
    }

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
        if (overdrafts != 2) {
            System.out.println(
                "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
                    + Arrays.deepToString(transactions));
            foundProblem = true;
        } else
            System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

        // test with four transactions: including one of each encoding
        transactionCount = 4;
        overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
        if (overdrafts != 5) {
            System.out.println(
                "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
                    + Arrays.deepToString(transactions));
            foundProblem = true;
        } else
            System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

        return !foundProblem;
    }
}
