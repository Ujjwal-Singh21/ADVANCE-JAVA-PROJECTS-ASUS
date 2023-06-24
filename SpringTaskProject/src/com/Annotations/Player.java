package com.Annotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("playerBean")
public class Player {

	@Value("45")
	private int jerseyNumber;
	
	@Value("Rohit Sharma")
	private String playerName;
	
	@Value("8500")
	private long playerRuns;

	@Override
	public String toString() {
		return "Player [jerseyNumber=" + jerseyNumber + ", playerName=" + playerName + ", playerRuns=" + playerRuns
				+ "]";
	}
}
