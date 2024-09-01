package com.example.esunbank_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.esunbank_vote.entity.VotingHistory;
import com.example.esunbank_vote.service.VotingHistoryService;

import java.util.List;

@CrossOrigin
@RestController
public class VotingHistoryController {

	@Autowired
    private  VotingHistoryService votingHistoryService;

//    @Autowired
//    public VotingHistoryController(VotingHistoryService votingHistoryService) {
//        this.votingHistoryService = votingHistoryService;
//    }

    @GetMapping("/api/getAllVotingHistories")
    public List<VotingHistory> getAllVotingHistories() {
        return votingHistoryService.getAllVotingHistories();
    }

    @GetMapping("/api/getVotingHistoryById")
    public ResponseEntity<VotingHistory> getVotingHistoryById(@PathVariable int id) {
        VotingHistory votingHistory = votingHistoryService.getVotingHistoryById(id);
        if (votingHistory != null) {
            return ResponseEntity.ok(votingHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/createVotingHistory")
    public ResponseEntity<List<VotingHistory>> createVotingHistories(@RequestBody List<VotingHistory> votingHistories) {
    	System.out.println(votingHistories.get(0).getVoter() + votingHistories.get(0).getVotingItemNo());
        List<VotingHistory> createVotingHistory = votingHistoryService.createVotingHistory(votingHistories);
        return null;
    }

}
