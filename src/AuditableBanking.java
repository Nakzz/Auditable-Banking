//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
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
      
        if(allTransactions.length > allTransactionsCount) {
            return allTransactionsCount;
        }
        
        int newTransactionsCount = allTransactionsCount +1;
        
        
        allTransactions[newTransactionsCount] = newTransactions; 
        
      return newTransactionsCount;
    }

}
