package com.example.esunbank_vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.esunbank_vote.entity.VotingHistory;

import java.util.List;


public interface VotingHistoryDao extends JpaRepository<VotingHistory, Integer> {
    
    // 根據選民查詢投票記錄
    List<VotingHistory> findByVoter(String voter);
    
    // 根據投票項目號查詢投票記錄
    List<VotingHistory> findByVotingItemNo(int votingItemNo);
    
    // 調用 Stored Procedure 來獲取投票數
    @Query(value = "CALL esunbank.GetVotingCounts()", nativeQuery = true)
    List<Object[]> getVotingCounts();
}