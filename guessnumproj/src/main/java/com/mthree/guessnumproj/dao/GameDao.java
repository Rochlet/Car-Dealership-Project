package com.mthree.guessnumproj.dao;

import com.mthree.guessnumproj.dto.Game;
import com.mthree.guessnumproj.dto.Round;
import java.util.List;

/**
 *
 * @author Eric
 */
public interface GameDao {

    List<Game> getAllGames() throws DataAccessException;

    Game getGameById(int gameId) throws DataAccessException;

    int addGame(Game game) throws DataAccessException;

    int updateGame(Round round) throws DataAccessException;
}
