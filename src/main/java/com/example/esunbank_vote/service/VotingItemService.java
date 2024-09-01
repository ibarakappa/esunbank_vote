package com.example.esunbank_vote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.esunbank_vote.entity.VotingItem;
import com.example.esunbank_vote.entity.VotingItemVoteCountDTO;



@Service
public interface VotingItemService {

    // 查詢所有投票項目
    List<VotingItem> getAllVotingItems();

    // 根據ID查詢投票項目
    VotingItem getVotingItemById(int id);
    
    // 根據ID查詢投票項目
    VotingItem findVotingItemNo(int id);

    // 新增或更新投票項目
    VotingItem createOrUpdateVotingItem(VotingItem votingItem);

    // 刪除投票項目
    void deleteVotingItem(int votingItemNo);
    
    // 獲取投票項目及其累積票數
    List<VotingItemVoteCountDTO> getVotingItemVoteCounts();
}