package edu.kit.ipd.pronat.prepipedatamodel.token;

import java.util.Objects;

/**
 * @author Sebastian Weigelt
 */
public abstract class AbstractHypothesisToken {

	private String word;
	private int position;
	private double confidence;
	private HypothesisTokenType type;
	private double startTime;
	private double endTime;
	private int hash;

	public AbstractHypothesisToken(String word, int position, double confidence, HypothesisTokenType type, double startTime,
			double endTime) {
		this.word = word;
		this.position = position;
		this.confidence = confidence;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		resetHash();
	}

	public AbstractHypothesisToken(String word, int position, double confidence, HypothesisTokenType type) {
		this(word, position, confidence, type, 0.0d, 0.0d);
	}

	public AbstractHypothesisToken(String word, int position) {
		this(word, position, 1.0d, HypothesisTokenType.MISC);
	}

	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @return the confidence
	 */
	public double getConfidence() {
		return confidence;
	}

	/**
	 * @return the type
	 */
	public HypothesisTokenType getType() {
		return type;
	}

	/**
	 * @return the startTime
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public double getEndTime() {
		return endTime;
	}

	/**
	 * @param word
	 *            the word to set
	 */
	void setWord(String word) {
		this.word = word;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @param confidence
	 *            the confidence to set
	 */
	void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	void setType(HypothesisTokenType type) {
		this.type = type;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		if (hash != 0) {
			return hash;
		} else {
			hash = getWord().hashCode();
			hash = 31 * hash + getPosition();
			hash = (int) (31 * hash + getConfidence());
			return hash;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractHypothesisToken) {
			final AbstractHypothesisToken other = (AbstractHypothesisToken) obj;
			return getPosition() == other.getPosition() && getConfidence() == other.getConfidence()
					&& Objects.equals(getWord(), other.getWord()) && getType().equals(other.getType())
					&& getStartTime() == other.getStartTime() && getEndTime() == other.getEndTime();
		}
		return false;
	}

	private void resetHash() {
		hash = 0;
	}

}
