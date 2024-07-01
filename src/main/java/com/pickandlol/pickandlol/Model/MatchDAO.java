package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchSeason;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDAO {
    @Id
    Long matchId;
    MatchSeason matchSeason;
    String matchNum;
    Long homeClubId;
    Long awayClubId;
    String stadium;
    Integer year;
    Integer month;
    Integer day;
    String dayOfTheWeek;
    String time;
    String round;
    Integer homeScore;
    Integer awayScore;
    MatchStatus matchStatus;
    Long winnerClubId;
    Long loserClubId;
    String clubLogId; // list
}
