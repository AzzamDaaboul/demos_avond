package be.odisee.tenniscounter.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class Score(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "score_player_1") var scorePlayer1: Int,
    @ColumnInfo(name = "score_player_2") var scorePlayer2: Int,
    val date: Long
) {
    override fun toString(): String {
        return "$scorePlayer1 - $scorePlayer2"
    }
}
