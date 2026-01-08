package day2;

public class NumberRange {

	public NumberRange(long startOfRange2, long endOfRange2) {
		
		this.startOfRange=startOfRange2;
		this.endOfRange=endOfRange2;
		
	}
	
@Override
	public String toString() {
		return "NumberRange [startOfRange=" + startOfRange + ", endOfRange=" + endOfRange + "]";
	}

/**
	 * @return the startOfRange
	 */
	public long getStartOfRange() {
		return startOfRange;
	}
	/**
	 * @return the endOfRange
	 */
	public long getEndOfRange() {
		return endOfRange;
	}

private long startOfRange;
		private long endOfRange;
		
}
