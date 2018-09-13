import java.util.Scanner;

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

public class AuditableBanking {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String input = "";
        int[][] allTransactions = new int[100][];
        int allTransactionsCount = 0;

        System.out.println("========== Welcome to the Auditable Banking App ==========");

        while (!input.equalsIgnoreCase("Q")) {
            System.out.println("COMMAND MENU:");
            System.out
                .println("  Submit a Transaction (enter sequence of integers separated by spaces)");
            System.out.println("  Show Current [B]alance");
            System.out.println("  Show Number of [O]verdrafts");
            System.out.println("  [Q]uit Program");
            System.out.println("ENTER COMMAND: ");

            input = scnr.nextLine().toUpperCase();

            allTransactionsCount = processCommand(input, allTransactions, allTransactionsCount);
            System.out.println("");
        }

        System.out.println("============ Thank you for using this App!!!! ============");



    }

    /**
     * Adds a transaction group to an array of transaction groups. If the allTransactions array is
     * already full then this method will do nothing other than return allTransactionCount.
     * 
     * @param newTransactions is the new transaction group being added (perfect size).
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the number of transaction groups within allTransactions after newTransactions is
     *         added.
     */
    public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
        int allTransactionsCount) {
        if (allTransactions.length == allTransactionsCount) {
            return allTransactionsCount;
        }

        allTransactions[allTransactionsCount] = newTransactions;
        allTransactionsCount++;

        // DEBUG AJ
        System.out.println("Final allTransactionCount: " + allTransactionsCount);

        return allTransactionsCount;

    }



    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the
     * provided set of transactions groups then this method will do nothing other than return
     * allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction
     *        group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the number of transaction groups within allTransactions after newTransactions is
     *         added.
     */
    public static int processCommand(String command, int[][] allTransactions,
        int allTransactionsCount) {

        String[] commandAsArray = new String[command.length()];
        commandAsArray = command.split(" ");


        int[] newTransaction = new int[commandAsArray.length];
        int balance, overdraftNum;


        if (allTransactions.length == allTransactionsCount) {
            return allTransactionsCount;
        } else if (commandAsArray[0].equalsIgnoreCase("0")
            || commandAsArray[0].equalsIgnoreCase("1") || commandAsArray[0].equalsIgnoreCase("2")) {

            for (int c = 0; c < commandAsArray.length; c++) {
                newTransaction[c] = Integer.parseInt(commandAsArray[c]);
            }

            allTransactionsCount =
                submitTransactions(newTransaction, allTransactions, allTransactionsCount);
        } else if (commandAsArray[0].equalsIgnoreCase("B")) {

            balance = calculateCurrentBalance(allTransactions, allTransactionsCount);

            System.out.println("Current Balance: " + balance);

        } else if (commandAsArray[0].equalsIgnoreCase("O")) {

            overdraftNum = calculateNumberOfOverdrafts(allTransactions, allTransactionsCount);

            System.out.println("Number of Overdrafts: " + overdraftNum);
        }



        return allTransactionsCount;
    }

    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the
     * provided set of transactions groups then this method will do nothing other than return
     * allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction
     *        group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the number of transaction groups within allTransactions after newTransactions is
     *         added.
     */

    public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {

        int balance = 0;
        int[] quickWithdraw = {0, 20, 40, 80, 100};

        for (int i = 0; i < allTransactionsCount; i++) {

            int[] eachTransaction = allTransactions[i];

            if (eachTransaction[0] == 0) // Binary Amount Transactions
                for (int c = 1; c < eachTransaction.length; c++) {
                    if (eachTransaction[c] == 0) { // Withdraw dollar
                        balance += -1;
                    } else if (eachTransaction[c] == 1) { // Deposits dollar
                        balance += 1;
                    }
                }

            else if (eachTransaction[0] == 1) { // Integer Amount Transactions

                for (int c = 1; c < eachTransaction.length; c++) {
                    balance += eachTransaction[c];
                }

            } else if (eachTransaction[0] == 2) { // Quick Withdraw Transactions

                for (int c = 1; c < eachTransaction.length; c++) {
                    balance += -quickWithdraw[(eachTransaction[c])];
                }
            }

        }
        return balance;
    }

    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the
     * provided set of transactions groups then this method will do nothing other than return
     * allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction
     *        group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the number of transaction groups within allTransactions after newTransactions is
     *         added.
     */


    public static int calculateNumberOfOverdrafts(int[][] allTransactions,
        int allTransactionsCount) {
        int balance = 0;
        int overdraftNum = 0;
        int[] quickWithdraw = {20, 40, 80, 100};

        for (int i = 0; i < allTransactionsCount; i++) {

            int[] eachTransaction = allTransactions[i];


            if (eachTransaction[0] == 0) // Binary Amount Transactions

                for (int c = 1; c < eachTransaction.length; c++) {
                    if (eachTransaction[c] == 0) { // Withdraw dollar
                        balance += -1;

                        if (balance < 0) {
                            overdraftNum++;
                            // //DEBUG AJ
//                            System.out.println("Incrementing overdraft. Balance: : " + balance);
                        }

                    } else if (eachTransaction[c] == 1) { // Deposits dollar
                        balance += 1;
                    }

                }

            else if (eachTransaction[0] == 1) { // Integer Amount Transactions
                // //DEBUG AJ
                // System.out.println("Entered Integer Transaction Processing: "+ commandAsArray);
                //
                for (int c = 1; c < eachTransaction.length; c++) {
                    balance += eachTransaction[c];

                    if (balance < 0 && eachTransaction[c] < 0) {
                        overdraftNum++;
                        // //DEBUG AJ
                        //System.out.println("Incrementing overdraft. Balance: : " + balance);
                    }
                }


            } else if (eachTransaction[0] == 2) { // Quick Withdraw Transactions
                // //DEBUG AJ
                // System.out.println("Entered Quick Transaction Processing: "+ commandAsArray);
                //
                for (int c = 1; c < eachTransaction.length; c++) {
                    balance += -quickWithdraw[(eachTransaction[c])];
                }
                if (balance < 0) {
                    overdraftNum++;
                    // //DEBUG AJ
//                    System.out.println("Incrementing overdraft. Balance: : " + balance);
                }
            }


            // DEBUG AJ
//            System.out.println("End of a transaction group. Balance: : " + balance);
//            System.out.println();
//            System.out.println();

        }

        return overdraftNum;
    }

}
