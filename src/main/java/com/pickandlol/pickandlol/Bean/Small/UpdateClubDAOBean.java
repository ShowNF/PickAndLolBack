package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.MatchClubDAO;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateClubDAOBean {

    public void exec(ClubDAO clubDAO, List<MatchClubDAO> matchClubDAOS) {
        int totalWinCount = 0;
        int totalLoseCount = 0;
        int totalKillCount = 0;
        int totalDeathCount = 0;
        int totalAssistCount = 0;
        int totalGap;
        double totalKDA;
        double winRate;

        for (MatchClubDAO matchClubDAO : matchClubDAOS) {
            totalWinCount += matchClubDAO.getMatchResult() == MatchResult.WIN ? 1 : 0;
            totalLoseCount += matchClubDAO.getMatchResult() == MatchResult.LOSE ? 1 : 0;
            totalKillCount += matchClubDAO.getKillCount();
            totalDeathCount += matchClubDAO.getDeathCount();
            totalAssistCount += matchClubDAO.getAssistCount();
        }

        if (totalDeathCount > 0) {
            totalKDA = (double) (totalKillCount + totalAssistCount) / totalDeathCount;
        }
        else totalKDA = 0.0;

        // 득실차
        totalGap = totalKillCount - totalDeathCount;

        // 승률
        if (totalWinCount + totalLoseCount > 0 && totalWinCount - totalLoseCount >= 0) {
            winRate = (double) totalWinCount / (totalWinCount + totalLoseCount);
        }
        else winRate = 0.0;


        // Update the TeamsDAO object
        clubDAO.setWinCount(totalWinCount);
        clubDAO.setLoseCount(totalLoseCount);
        clubDAO.setKillCount(totalKillCount);
        clubDAO.setDeathCount(totalDeathCount);
        clubDAO.setAssistCount(totalAssistCount);
        clubDAO.setKda(totalKDA);
        clubDAO.setTotalGap(totalGap);
        clubDAO.setWinRate(winRate);
    }
}
