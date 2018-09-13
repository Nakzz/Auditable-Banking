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
        int[][] allTransactions = new int[100][]; //Initialized and declared sized of oversized array 
        int allTransactionsCount = 0;

        System.out.println("========== Welcome to the Auditable Banking App =========="); //1st messager that user will see

        while (!input.equalsIgnoreCase("Q")) { //checks to see if user enters Q, if user does then statement doesn't run
            System.out.println("COMMAND MENU:");
            System.out
                .println("  Submit a Transaction (enter sequence of integers separated by spaces)");
            System.out.println("  Show Current [B]alance");
            System.out.println("  Show Number of [O]verdrafts");
            System.out.println("  [Q]uit Program");
            System.out.println("ENTER COMMAND: ");

            input = scnr.nextLine().toUpperCase(); //takes whatever the user inputs and makes it uppercase

            allTransactionsCount = processCommand(input, allTransactions, allTransactionsCount); // calls processCommand method to get the # of transactions 
            System.out.println("");
        }

        System.out.println("============ Thank you for using this App!!!! ============"); //once allTransactionCount is recieved or Q is inputed then this message is outputed



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
        if (allTransactions.length == allTransactionsCount) { //Checks to see if the array is full
            return allTransactionsCount;
        }

        allTransactions[allTransactionsCount] = newTransactions; //inputs each new transaction into the array
        allTransactionsCount++; //increase count

        // DEBUG AJ
//        System.out.println("Final allTransactionCount: " + allTransactionsCount);

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

        String[] commandAsArray = new String[command.length()]; //Initialized and declared sized of perfectly-sized array 

        commandAsArray = command.split(" "); //puts the users input into an the commandAsArray


        int[] newTransaction = new int[commandAsArray.length]; //Initialized and declared sized of perfectly-sized array
        int balance, overdraftNum; //declares variables


        if (allTransactions.length == allTransactionsCount) { //Checks to see if the array is full
            return allTransactionsCount;
        } else if (commandAsArray[0].equalsIgnoreCase("0") //determines if its a binary transaction, 
            || commandAsArray[0].equalsIgnoreCase("1") || commandAsArray[0].equalsIgnoreCase("2")) { //determines if its a Integer or withdraw transaction

            for (int c = 0; c < commandAsArray.length; c++) {
                newTransaction[c] = Integer.parseInt(commandAsArray[c]); //converts all the string values into integer values
            }

            allTransactionsCount =
                submitTransactions(newTransaction, allTransactions, allTransactionsCount); //calls submitTransactions in order to get Tansaction count
        } else if (commandAsArray[0].equalsIgnoreCase("B")) { //determine that user input is looking for balance

            balance = calculateCurrentBalance(allTransactions, allTransactionsCount); //uses calculateCurrent.. Method to return balance

            System.out.println("Current Balance: " + balance);

        } else if (commandAsArray[0].equalsIgnoreCase("O")) { //determines that user input is looking for overdraft number

            overdraftNum = calculateNumberOfOverdrafts(allTransactions, allTransactionsCount); //uses calculateCurrent.. Method to return overDraft #

            System.out.println("Number of Overdrafts: " + overdraftNum);
        }



        return allTransactionsCount; //the entire goal of this method is to return the total number of transactions
    }

    /**
     * Takes into account the all of the types of transactions(Binary, Integer, and Quick Withdraw) and figures out its
     * its impact on the balance. Different types of starting indexes determine what type of transaction is being processed.
     * 
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the total balance of the account after all the transactions
     */

    public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {

        int balance = 0;
        int[] quickWithdraw = {20, 40, 80, 100};

        for (int i = 0; i < allTransactionsCount; i++) { //the loop will run for every transaction made

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
                    balance += eachTransaction[c]; //desposits based on user input
                }

            } else if (eachTransaction[0] == 2) { // Quick Withdraw Transactions

                for (int c = 1; c < eachTransaction.length; c++) {
                    
                    balance += -quickWithdraw[c-1] * eachTransaction[c] ; //figures out the number of transactions for each fixed withdraw
                }
            }

        }
        return balance; //returns the users balance
    }

    /**
     * Takes into account the all of the types of transactions(Binary, Integer, and Quick Withdraw) and figures out its
     * its impact on the balance. If the balance becomes negative or the withdraw amount causes the balance to become 
     * negative then the overdraftnum will increase. This method will do nothing other than return OverDraft Number.
     * 
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions
     *        (before newTransactions is added.
     * @return the value of the overdraft on the account
     */


    public static int calculateNumberOfOverdrafts(int[][] allTransactions,
        int allTransactionsCount) {
        int balance = 0; //Initialized int
        int overdraftNum = 0; //Initialized int
        int[] quickWithdraw = {20, 40, 80, 100}; //establishes a 1d array with a fixed size(perfect size array)

        for (int i = 0; i < allTransactionsCount; i++) { //this for loop will allow the method to go through every transaction

            int[] eachTransaction = allTransactions[i];


            if (eachTransaction[0] == 0) // Binary Amount Transactions

                for (int c = 1; c < eachTransaction.length; c++) { //for statement used to figure out the difference between a withdraw and deposit
                    if (eachTransaction[c] == 0) { // Withdraw dollar
                        balance += -1; //removes $1 from the total user balance

                        if (balance < 0) {
                            overdraftNum++; //increases the overdraft numbere
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

                    if (balance < 0 && eachTransaction[c] < 0) { //checks to see that balance is negative and value within eachTransaction array is negative  
                        overdraftNum++;
                        // //DEBUG AJ
                        //System.out.println("Incrementing overdraft. Balance: : " + balance);
                    }
                }


            } else if (eachTransaction[0] == 2) { // Quick Withdraw Transactions
                // //DEBUG AJ
                // System.out.println("Entered Quick Transaction Processing: "+ commandAsArray);
                //
                for (int c = 1; c < eachTransaction.length; c++) { //runs through every withdraw transaction within the array
                    balance += -quickWithdraw[(eachTransaction[c])]; //subtracts withdraw value within the array from the total balance
                }
                if (balance < 0) { //check to see if balance is a negative value
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
