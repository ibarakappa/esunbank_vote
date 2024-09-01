package com.example.esunbank_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.esunbank_vote.entity.VotingItem;
import com.example.esunbank_vote.entity.VotingItemVoteCountDTO;
import com.example.esunbank_vote.service.VotingItemService;

import java.util.List;

@CrossOrigin
@RestController
public class VotingItemController {

	private final VotingItemService votingItemService;

	@Autowired
	public VotingItemController(VotingItemService votingItemService) {
		this.votingItemService = votingItemService;
	}

	@GetMapping("/api/getAllVotingItems")
	public List<VotingItem> getAllVotingItems() {
		return votingItemService.getAllVotingItems();
	}

	@PostMapping("/api/createVotingItem")
    public VotingItem createVotingItem(@RequestBody VotingItem votingItem) {

           if (votingItemService.findVotingItemNo(votingItem.getVotingItemNo()) != null) {
        	   return null;
           } else {
        	   return votingItemService.createOrUpdateVotingItem(votingItem);
           }
    }

	@PostMapping("/api/updateVotingItem")
	public ResponseEntity<VotingItem> updateVotingItem(@RequestBody VotingItem votingItemDetails) {
		VotingItem votingItem = votingItemService.findVotingItemNo(votingItemDetails.getVotingItemNo());
		if (votingItem != null) {
			votingItem.setVotingItemNo(votingItemDetails.getVotingItemNo());
			votingItem.setVotingItemName(votingItemDetails.getVotingItemName());
			return ResponseEntity.ok(votingItemService.createOrUpdateVotingItem(votingItem));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/api/deleteVotingItem")
	public ResponseEntity<Void> deleteVotingItem(@RequestBody int votingItemNo) {
		votingItemService.deleteVotingItem(votingItemNo);
		return ResponseEntity.noContent().build();
	}

	// 新增端點來獲取投票項目及其累積票數
	@GetMapping("/api/getVotingItemVoteCounts")
	public ResponseEntity<List<VotingItemVoteCountDTO>> getVotingItemVoteCounts() {
		List<VotingItemVoteCountDTO> voteCounts = votingItemService.getVotingItemVoteCounts();
		return ResponseEntity.ok(voteCounts);
	}
}
