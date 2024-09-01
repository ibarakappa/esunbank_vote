package com.example.esunbank_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.esunbank_vote.entity.VotingItem;
import com.example.esunbank_vote.entity.VotingItemVoteCountDTO;
import com.example.esunbank_vote.repository.VotingHistoryDao;
import com.example.esunbank_vote.repository.VotingItemDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotingItemServiceImpl implements VotingItemService {

	private final VotingItemDao votingItemDao;
	private final VotingHistoryDao votingHistoryDao;

	@Autowired
	public VotingItemServiceImpl(VotingItemDao votingItemDao, VotingHistoryDao votingHistoryDao) {
		this.votingItemDao = votingItemDao;
		this.votingHistoryDao = votingHistoryDao;
	}

	@Override
	public List<VotingItem> getAllVotingItems() {
		return votingItemDao.findAll();
	}

	@Override
	public VotingItem getVotingItemById(int id) {
		return votingItemDao.findById(id).orElse(null);
	}

	@Override
	public VotingItem findVotingItemNo(int votingItemNo) {
		return votingItemDao.findByVotingItemNo(votingItemNo);

	}

	@Override
	@Transactional
	public VotingItem createOrUpdateVotingItem(VotingItem votingItem) {
		return votingItemDao.save(votingItem);
	}

	@Override
	@Transactional
	public void deleteVotingItem(int votingItemNo) {
		votingItemDao.deleteByVotingItemNo(votingItemNo);
	}

	@Override
	public List<VotingItemVoteCountDTO> getVotingItemVoteCounts() {
		List<Object[]> results = votingHistoryDao.getVotingCounts();
		List<VotingItemVoteCountDTO> voteCounts = new ArrayList<>();

		for (Object[] row : results) {
			int votingItemNo = (Integer) row[0];
			String votingItemName = (String) row[1];
			long voteCount = ((Number) row[2]).longValue();
			voteCounts.add(new VotingItemVoteCountDTO(votingItemNo, votingItemName, voteCount));
		}

		return voteCounts;
	}
}
