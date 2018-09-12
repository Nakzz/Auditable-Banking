e//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Auditable Banking
// Files:           AuditableBanking.java, AuditableBankingTests.java
// Course:          CS300, Fall 2018
//
// Author:          Ajmain Naqib
// Email:           naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Mory Keita
// Partner Email:   mkeita@wisc.edu
// Partner Lecturer's Name: 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X_ Write-up states that pair programming is allowed for this assignment.
//   _X_ We have both read and understand the course Pair Programming Policy.
//   _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class AuditableBanking {

//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//
//    }
    
    /**
     * Adds a transaction group to an array of transaction groups. If the allTransactions array is
     * already full then this method will do nothing other than return allTransactionCount.
     * 
     * @param newTransactions is the new transaction group being added (perfect size).
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions 
     *        (before newTransactions is added.
     * @return the number of transaction groups within allTransactions after newTransactions is added.
     */
    public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
        int allTransactionsCount) {
        if(allTransactions.length == allTransactionsCount) {
            return allTransactionsCount;
        }
        else {          
                allTransactions[allTransactionsCount + 1] = newTransactions;
                allTransactionsCount++;
                return allTransactionsCount;  
        }
           
      return -1;
    }



    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the 
     * provided set of transactions groups then this method will do nothing other than return allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions 
     *        (before newTransactions is added. 
     * @return the number of transaction groups within allTransactions after newTransactions is added.
     */
public static int processCommand(String command, int[][] allTransactions, int allTransactionsCount) {
    // TODO: Implement this method
        String[] commandAsArray = new String[command.length()];
        commandAsArray = command.split(" ");
        int[] commandAsArrayInt = new int[commandAsArray.length];
        for (int i=0; i < commandAsArray.length; i++) {
            commandAsArrayInt[i] = Integer.parseInt(commandAsArray[i]);
        }
        if(allTransactions.length == allTransactionsCount) {
            return allTransactionsCount;
        }
        
        else if(commandAsArrayInt[0] == 0) {
            allTransactions[0][i] = commandAsArrayInt;
        }
        else if(commandAsArrayInt[0] == 1) {
            allTransactions[1][i] = commandAsArrayInt;
            }
        }
        else if(commandAsArrayInt[0] == 2) {
            allTransactions[2][i] = commandAsArrayInt;
            }
            
        }
    return -1;
  }

    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the 
     * provided set of transactions groups then this method will do nothing other than return allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions 
     *        (before newTransactions is added. 
     * @return the number of transaction groups within allTransactions after newTransactions is added.
     */

public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
  // TODO: Implement this method
    int CurrentBalance = 0;
     for(int i= 0; i < allTransactions.length; i++) { // should I use allTransactions.length or 3??
         for(int j=0; j < allTransactions[i].length; j++) {
             if(i == 0) {
                 if(allTransactions[0][j] == 0) {
                     CurrentBalance++;
                 }
             
                 else if(allTransactions[0][j] == 1) {
                     CurrentBalance--;
                 }
         }
            if(i == 1) {
                if(allTransactions[1][j] > 0) {
                    CurrentBalance = CurrentBalance + allTransactions[1][j];
                }
                else if(allTransactions[1][j] < 0) {
                    CurrentBalance = CurrentBalance - allTransactions[1][j];
                }
            }
            if(i == 2 && j < 5) {
            
                if(allTransactions[2][1] > 0) {
                    CurrentBalance = CurrentBalance - (20 * allTransactions[2][2]);
                }
                if(allTransactions[2][2] > 0) {
                    CurrentBalance = CurrentBalance - (40 * allTransactions[2][2]);
                }
                if(allTransactions[2][3] > 0) {
                    CurrentBalance = CurrentBalance - (80 * allTransactions[2][3]);
                }
                if(allTransactions[2][4] > 0) {
                    CurrentBalance = CurrentBalance - (100 * allTransactions[2][4]);
                }
                
            }
     }
         
  }
  return -1;
}

    /**
     * takes such a string as command/input, and correctly adds a new transaction group to the 
     * provided set of transactions groups then this method will do nothing other than return allTransactionCount.
     * 
     * @param command is the command of input entered by the user, which is added to Transaction group.
     * @param allTransactions is the collection that newTransactions is being added to (oversize).
     * @param allTransactionsCount is the number of transaction groups within allTransactions 
     *        (before newTransactions is added. 
     * @return the number of transaction groups within allTransactions after newTransactions is added.
     */


public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
  // TODO: Implement this method
  return -1;
}