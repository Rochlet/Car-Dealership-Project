
package com.mthree.guessnumproj.dao;

import com.mthree.guessnumproj.dto.Game;
import com.mthree.guessnumproj.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eric
 */
@Repository
public class GameDaoImpl implements GameDao {

    private final JdbcTemplate jdbc;
    final String getAllGames = "SELECT * FROM game";
    final String getGameById = "SELECT * FROM game WHERE gameId = ?";
    final String addGame = "INSERT INTO game(gameId,inProgress,answer,player) VALUES (?,?,?,?)";
    final String updateGame = "Insert into round(roundId, gameId,guessTime,exactMatch,partialMatch,playerGuessCount  VALUES (?,?,?,?,?,?))";
    
    @Autowired
    public GameDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public List<Game> getAllGames()throws DataAccessException{    
        return jdbc.query(getAllGames, new GameMapper());
    }
   
    @Override
    public Game getGameById(int gameId) throws DataAccessException { 
        return jdbc.queryForObject(getGameById, new GameMapper(), gameId);
    }
    
    // game id is not auto increment
    @Override
    public int addGame(Game game) throws DataAccessException {
       int status = jdbc.update(addGame, game.getId(), game.getInProgress(),game.getAnswer(), game.getPlayer());  
       if(status == 0){
            throw new DataAccessException("Error code : " + status+" add failed");
       } 
       return status;
    }
    
    @Override
    public int updateGame(Round round) throws DataAccessException {
       int status = jdbc.update(updateGame, round.getRoundId(), round.getGameId(),round.getGuessTime(),round.getExactMatchCount(),round.getPartialMatch(),round.getPlayerGuessCount());  
       if(status == 0){
            throw new DataAccessException("Error code : " + status+" update failed");
       } 
       return status;
    }
    
    private static final class GameMapper implements RowMapper<Game> {
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
//            game.setId(rs.getInt("gameId"));
            game.setInProgress(rs.getBoolean("inProgress"));
            game.setAnswer(rs.getString("answer"));
            game.setPlayer(rs.getString("player"));
            return game;
        }
    }
    
}