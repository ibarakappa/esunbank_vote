package com.example.esunbank_vote.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "voting_items", schema = "esunbank")
public class VotingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Voting_ItemNo", nullable = false)
    private int votingItemNo;

    @Column(name = "Voting_ItemName", nullable = false)
    private String votingItemName;

    // Constructors, Getters and Setters

    public VotingItem() {
    }

    public VotingItem(int votingItemNo, String votingItemName) {
        this.votingItemNo = votingItemNo;
        this.votingItemName = votingItemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}