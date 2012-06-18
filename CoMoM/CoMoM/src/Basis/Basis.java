package Basis;

import java.util.HashSet;
import java.util.Set;
import DataStructures.BigRational;
import DataStructures.QNModel;
import Exceptions.InternalErrorException;

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
	 * Not really sure what this is for yet, but MoM uses it...
	 */
	protected Set<Integer> uncomputables;
	
	/**
	 * Variable to store the size of the basis, due to frequent use
	 */
	protected int size;
	
	
	/**
	 * Constructor
	 * @param qnm The Queuing Network Model under study
	 */
	public Basis(QNModel qnm) {
		this.qnm = qnm;
		R = qnm.R;
		M = qnm.M;
		setSize();		
		basis = new BigRational[size];
		
		uncomputables = new HashSet<Integer>();
	}
	
	/**
	 * Initialises the basis for population (0,...0)
	 * @throws InternalErrorException 
	 */	
	public abstract void initialiseBasis() throws InternalErrorException;
	
	/**
	 * Calculates the size of the basis to be store in variable size
	 */
	protected abstract void setSize();
	
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
	
	/**
	 * Sets the basis vector 
	 */
	//TODO think about this, copies references, garbage collection....
	public void setBasis(BigRational[] v) {
		basis = v;
	}
	
	public void reset_uncomputables() {
		for(int i = 0; i < size; i++) {
			uncomputables.add(i);
		}
	}
	
	public void computatble(int i) {
		uncomputables.remove(i);
	}
	
	public Set<Integer> getUncomputables() {
		return uncomputables;
	}
}
