package DataStructures;

import Exceptions.InternalErrorException;

/**
 * This class implements the MultiplicitiesVector object, which is used to
 * store a multiplicities vector. It extends an EnhancedVector object.
 *
 * @author Michail Makaronidis, 2010
 */
public class MultiplicitiesVector extends EnhancedVector {

    /**
     * Creates an empty MultiplicitiesVector object.
     */
    public MultiplicitiesVector() {
        super();
    }

    /**
     * Creates an MultiplicitiesVector with content equal to the given matrix.
     *
     * @param M The matrix containing the vector elements
     */
    public MultiplicitiesVector(Integer[] M){
        super(M);
    }

    /**
     * Creates a new MultiplicitiesVector of specific lenth, where
     * all elements are equal to a specific value.
     *
     * @param k The value of all elements
     * @param length The length of the MultiplicitiesVector
     */
    public MultiplicitiesVector(int k, int length) {
        super(k, length);
    }

    /**
     * This method fills the current MultiplicitiesVector with the values
     * contained in a QNModel object (quening network model).
     *
     * @param qnm The QNModel object that represents the queing network we are
     * working on
     */
    public void fillFromQNModel(QNModel qnm) {
        this.fillFromMyVector(qnm.multiplicities);
    }

    /**
     * This method returns a copy of the current MultiplicitiesVector object. Position
     * and delta stacks are disregarded.
     *
     * @return Copy of the initial MultiplicitiesVector object.
     */
    @Override
    public MultiplicitiesVector copy() {
        MultiplicitiesVector c = new MultiplicitiesVector();
        this.copyTo(c);
        return c;
    }

    @Override
    public MultiplicitiesVector addVec(EnhancedVector b) {
        return (MultiplicitiesVector) super.addVec(b);
    }
    
    public int whichSingleQueueAdded() throws InternalErrorException {
    	int queue_added = 0;
    	for(int i = 0; i < size(); i++) {
    		if(get(i)  != 0 ) {
    			if(queue_added > 0 || get(i) != 1) {
    				throw new InternalErrorException("Internal Error: Called whichSingleQueueAdded() on a vector with more than one non-zero element");
    			} else {
    				queue_added = i + 1;
    			}
    		}
        }        
    	return queue_added;
    }
}
