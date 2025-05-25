package com.example.esunbank_vote.entity;

public class VotingHistoryDTO {
    private String voter;
    private String votingItemName;

    public VotingHistoryDTO(String voter, String votingItemName) {
        this.voter = voter;
        this.votingItemName = votingItemName;
    }

    public String getVoter() {
        return voter;
    }

    public String getVotingItemName() {
        return votingItemName;
    }
}