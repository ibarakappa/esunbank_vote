package com.example.esunbank_vote.entity;

public class VotingItemVoteCountDTO {
	 private int votingItemNo;
	    private String votingItemName;
	    private long voteCount;

	    public VotingItemVoteCountDTO(int votingItemNo, String votingItemName, long voteCount) {
	        this.votingItemNo = votingItemNo;
	        this.votingItemName = votingItemName;
	        this.voteCount = voteCount;
	    }

	    // Getters and Setters

	    public int getVotingItemNo() {
	        return votingItemNo;
	    }

	    public void setVotingItemNo(int votingItemNo) {
	        this.votingItemNo = votingItemNo;
	    }

	    public String getVotingItemName() {
	        return votingItemName;
	    }

	    public void setVotingItemName(String votingItemName) {
	        this.votingItemName = votingItemName;
	    }

	    public long getVoteCount() {
	        return voteCount;
	    }

	    public void setVoteCount(long voteCount) {
	        this.voteCount = voteCount;
	    }
}
