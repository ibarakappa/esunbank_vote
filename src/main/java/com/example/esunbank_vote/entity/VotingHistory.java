package com.example.esunbank_vote.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "voting_history", schema = "esunbank")
public class VotingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Voter", nullable = false)
    private String voter;

    @Column(name = "Voting_ItemNo", nullable = false)
    private int votingItemNo;

    // Constructors, Getters and Setters

    public VotingHistory() {
    }

    public VotingHistory(String voter, int votingItemNo) {
        this.voter = voter;
        this.votingItemNo = votingItemNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
