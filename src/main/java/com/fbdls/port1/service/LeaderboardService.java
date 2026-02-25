package com.fbdls.port1.service;

import com.fbdls.port1.entity.Leaderboard;
import com.fbdls.port1.repository.LeaderboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    public List<Leaderboard> getTop10() {
        return leaderboardRepository.findTop10ByOrderByScoreDesc();
    }

    public Leaderboard saveScore(Leaderboard leaderboard) {
        return leaderboardRepository.save(leaderboard);
    }
}
