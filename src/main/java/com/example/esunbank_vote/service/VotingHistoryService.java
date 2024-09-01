package com.example.esunbank_vote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.esunbank_vote.entity.VotingHistory;


@Service
public interface VotingHistoryService {

    // 查詢所有投票記錄
    List<VotingHistory> getAllVotingHistories();

    // 根據ID查詢投票記錄
    VotingHistory getVotingHistoryById(int id);

    // 新增投票記錄
    List<VotingHistory> createVotingHistory(List<VotingHistory> votingHistories);
}