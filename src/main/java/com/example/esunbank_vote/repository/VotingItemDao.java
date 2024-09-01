package com.example.esunbank_vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.esunbank_vote.entity.VotingItem;

public interface VotingItemDao extends JpaRepository<VotingItem, Integer> {

    // 根據投票項目號查詢投票項目
    VotingItem findByVotingItemNo(int votingItemNo);
    
    void deleteByVotingItemNo(int votingItemNo);
}