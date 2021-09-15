package com.mthree.guessnumproj.dao;

import com.mthree.guessnumproj.dto.Round;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface RoundDao {
    
    List<Round> getAllRoundsByGameId(int gameId) throws DataAccessException;
    Round getRoundById(int roundId) throws DataAccessException;
    int addRound(Round round) throws DataAccessException;

}