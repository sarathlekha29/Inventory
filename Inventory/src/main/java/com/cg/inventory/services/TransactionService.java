package com.cg.inventory.services;

import java.util.List;

import com.cg.inventory.model.Transaction;

/**
 * This is an interface for TransactionService class, it has all the abstract methods
 * 
 * @author prasanna
 *
 */
public interface TransactionService {

	/**
	 * This method returns list of all transactions
	 * 
	 * @return list of transactions
	 */
	List<Transaction> viewAllTransactions();

	/**
	 * This method takes transaction details and creates a new transaction for
	 * customer
	 * 
	 * @param transaction
	 * @return transaction entity details
	 */
	Transaction createTransaction(Transaction transaction);

	/**
	 * This method takes transaction Id and deletes the transaction
	 * 
	 * @param transactionId
	 */
	void deleteTransaction(Long transactionId);

	/**
	 * This method returns transactions by searching with specific transaction Id
	 * 
	 * @param transactionId
	 * @return transaction details if found or else throw exception
	 */
	Transaction viewTransactionById(Long transactionId);

	/**
	 * This method updates transaction details by searching with transaction Id
	 * 
	 * @param transactionId
	 * @param transaction
	 * @return transaction details if found or else throw exception
	 */
	Transaction updateTransaction(Long transactionId, Transaction transaction);

}