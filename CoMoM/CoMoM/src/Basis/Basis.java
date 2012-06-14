package Basis;

import java.util.Set;
import DataStructures.BigRational;
import DataStructures.QNModel;

public abstract class Basis {

	/**
	 * The Queuing Network Model under study
	 */
	protected QNModel qnm;
	
	/**
	 * Variables to store qnm fields for easy access	
	 **/	
	protected int R;
	protected int M;
	
	/**
	 * The basis vector of normalising constants
	 */
	protected BigRational[] basis;
	
	/**
	 * Variable to store the size of the basis, due to frequent use
	 */
	protected int size;
	
	/**
	 * Not really sure what this is for yet, but MoM uses it...
	 */
	protected Set<Integer> uncomputables;
	
	/**
	 * Constructor
	 * @param qnm The Queuing Network Model under study
	 */
	public Basis(QNModel qnm) {
		this.qnm = qnm;
		setSize();
		R = qnm.R;
		M = qnm.M;
		basis = new BigRational[size];
		//TODO uncomputables??
	}
	
	/**
	 * Initialises the basis for the begin of the recursion on next class
	 * @param next_class the next class to be recursed on
	 */	
	abstract void initialiseForClass(int next_class);
	
	/**
	 * Calculates the size of the basis to be store in variable size
	 */
	abstract void setSize();
	
	/**
	 * @return The size of the basis
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the basis vector for mutation
	 */
	public BigRational[] getBasis() {
		return basis;
	}
}