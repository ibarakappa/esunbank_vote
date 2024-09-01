package com.example.esunbank_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.esunbank_vote.entity.VotingHistory;
import com.example.esunbank_vote.repository.VotingHistoryDao;

import java.util.List;

@Service
public class VotingHistoryServiceImpl implements VotingHistoryService {

    private final VotingHistoryDao votingHistoryDao;

    @Autowired
    public VotingHistoryServiceImpl(VotingHistoryDao votingHistoryDao) {
        this.votingHistoryDao = votingHistoryDao;
    }

    @Override
    public List<VotingHistory> getAllVotingHistories() {
        return votingHistoryDao.findAll();
    }

    @Override
    public VotingHistory getVotingHistoryById(int id) {
        return votingHistoryDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<VotingHistory> createVotingHistory(List<VotingHistory> votingHistories) {
        return votingHistoryDao.saveAll(votingHistories);
    }
}