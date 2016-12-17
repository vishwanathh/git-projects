/**
 * 
 */
package com.vishwa.entity;

/**
 * @author evishha
 *
 */
public class Alpha {
	private int alphaId;
	private String alphaName;
	
	public int getAlphaId() {
		return alphaId;
	}
	public void setAlphaId(int alphaId) {
		this.alphaId = alphaId;
	}
	public String getAlphaName() {
		return alphaName;
	}
	public void setAlphaName(String alphaName) {
		this.alphaName = alphaName;
	}
	@Override
	public String toString() {
		return "Alpha [alphaId=" + alphaId + ", alphaName=" + alphaName + "]";
	}	
}
