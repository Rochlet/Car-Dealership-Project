package com.mthree.guessnumproj.dao;

import com.mthree.guessnumproj.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Eric
 */
@Repository
public class RoundDaoImpl implements RoundDao {

    private final JdbcTemplate jdbc;
    final String getRoundById = "SELECT * FROM round WHERE roundId = ?";
    final String addRound = "INSERT INTO round VALUES (?,?,?,?,?,?)";
    final String getAllRoundsByGameId = "SELECT * FROM round WHERE gameId = ?";

    @Autowired
    public RoundDaoImpl(JdbcTemplate jdbc) {
         System.out.println("okay");
        this.jdbc = jdbc;
    }

    @Override
    public List<Round> getAllRoundsByGameId(int gameId) throws DataAccessException {
        return jdbc.query(getRoundById, new RoundMapper());
    }

    @Override
    public Round getRoundById(int roundId) throws DataAccessException {
        return jdbc.queryForObject(getRoundById, new RoundMapper(), roundId);
    }

    @Override
    public int addRound(Round round) throws DataAccessException {
        int status = jdbc.update(addRound, round.getRoundId(), round.getGameId(), round.getGuessTime(), round.getExactMatchCount(), round.getPartialMatch(), round.getPlayerGuessCount());
        if (status == 0) {
            throw new DataAccessException("Error code : " + status + " add failed") {};
        }
        return status;
    }

    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setGameId(rs.getInt("gameId"));
            Timestamp timestamp = rs.getTimestamp("guessTime");
            round.setGuessTime(timestamp.toLocalDateTime());
            round.setExactMatchCount(rs.getInt("exactMatch"));
            round.setPartialMatch(rs.getInt("partialMatch"));
            round.setPlayerGuessCount(rs.getInt("playerGuessCount"));
            return round;
        }
    }

}
