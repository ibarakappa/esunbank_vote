package vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VotingHistoryRequest {
	@JsonProperty("投票人")
	private String voter;
	@JsonProperty("投票項目編號")
	private int votingItemNo;
	

	public String getVoter() {
		return voter;
	}
	public void setVoter(String voter) {
		this.voter = voter;
	}
	public int getVotingItemNo() {
		return votingItemNo;
	}
	public void setVotingItemNo(int votingItemNo) {
		this.votingItemNo = votingItemNo;
	}

}
