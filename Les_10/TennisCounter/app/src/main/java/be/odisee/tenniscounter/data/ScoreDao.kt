package be.odisee.tenniscounter.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ScoreDao {

    @Query("SELECT * FROM scores WHERE id= :id")
    suspend fun getScore(id: Int): Score

    @Query("SELECT * FROM scores WHERE score_player_1 >= 6 OR score_player_2 >= 6 ")
    fun getAll(): LiveData<List<Score>>

    @Query("SELECT * FROM scores  WHERE score_player_1 >= 6 OR score_player_2 >= 6 ORDER BY date DESC LIMIT 1")
    fun getMostRecentFinishedGameScore(): LiveData<Score>

    @Query("SELECT * FROM scores ORDER BY date DESC LIMIT 1")
    suspend fun getMostRecentScore(): Score

    @Insert
    suspend fun insert(score: Score)

    @Update
    suspend fun update(score: Score)

    @Delete
    suspend fun delete(score: Score)

}