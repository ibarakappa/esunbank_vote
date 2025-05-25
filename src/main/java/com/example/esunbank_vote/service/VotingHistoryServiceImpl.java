package com.example.esunbank_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.esunbank_vote.entity.VotingHistory;
import com.example.esunbank_vote.entity.VotingHistoryDTO;
import com.example.esunbank_vote.repository.VotingHistoryDao;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<VotingHistoryDTO> getAllVotingHistoriesWithNames() {
		 List<Object[]> rawList = votingHistoryDao.findAllWithItemName();

	        return rawList.stream()
	            .map(obj -> new VotingHistoryDTO(
	                obj[1].toString(),       // Voter
	                obj[2].toString()        // Voting_ItemName
	            ))
	            .collect(Collectors.toList());
	    }
	}
