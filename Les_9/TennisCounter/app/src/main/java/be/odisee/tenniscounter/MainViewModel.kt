package be.odisee.tenniscounter

import android.view.View
import androidx.lifecycle.*
import be.odisee.tenniscounter.data.Score
import be.odisee.tenniscounter.data.ScoreDao
import kotlinx.coroutines.launch
import java.util.*


@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val scoreDao: ScoreDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(scoreDao) as T
        }

        throw IllegalArgumentException("Unknwon ViewModel class")
    }
}

class MainViewModel(val scoreDao: ScoreDao) : ViewModel() {

    private val _setScorePlayer1 = MutableLiveData(0)
    val setScorePlayer1: LiveData<Int> = _setScorePlayer1

    private val _setScorePlayer2 = MutableLiveData(0)
    val setScorePlayer2: LiveData<Int> = _setScorePlayer2

    private val _gameScorePlayer1 = MutableLiveData(0)
    val gameScorePlayer1: LiveData<Int> = _gameScorePlayer1

    private val _gameScorePlayer2 = MutableLiveData(0)
    val gameScorePlayer2: LiveData<Int> = _gameScorePlayer2

    var currentScore: Score? = null
    var lastFinishedScore: LiveData<Score>


    val player1Won = Transformations.map(setScorePlayer1) {
        if (it >= 6) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    val player2Won = Transformations.map(setScorePlayer2) {
        if (it >= 6) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }

    val resetVisibility = MediatorLiveData<Int>()

    init {
        resetVisibility.value = View.INVISIBLE
        resetVisibility.addSource(setScorePlayer1) {
            if (it >= 6) {
                resetVisibility.value = View.VISIBLE
            }
        }
        resetVisibility.addSource(setScorePlayer2) {
            if (it >= 6) {
                resetVisibility.value = View.VISIBLE
            }
        }
        lastFinishedScore = scoreDao.getMostRecentFinishedGameScore()
        viewModelScope.launch {

            currentScore = scoreDao.getMostRecentScore()

            if (lastFinishedScore.value == currentScore) {
                createNewScore()
            }
            _setScorePlayer1.value = currentScore!!.scorePlayer1
            _setScorePlayer2.value = currentScore!!.scorePlayer2

        }
    }

    suspend fun createNewScore() {
        currentScore = Score(scorePlayer1 = 0, scorePlayer2 = 0, date = Date().time)
        currentScore?.let { scoreDao.insert(it) }
        currentScore = scoreDao.getMostRecentScore()
    }

    fun addScorePlayer1() {
        updateScore(_gameScorePlayer1, _gameScorePlayer2, _setScorePlayer1)
    }

    private fun updateScore(
        gameScore1: MutableLiveData<Int>,
        gameScore2: MutableLiveData<Int>,
        setScore1: MutableLiveData<Int>
    ) {
        gameScore1.value = when (gameScore1.value) {
            0 -> 15
            15 -> 30
            30 -> 40
            40 -> 0
            else -> throw Exception()
        }

        if (gameScore1.value == 0) {
            setScore1.value = setScore1.value!! + 1
            gameScore2.value = 0
        }

        saveScore()
    }

    fun addScorePlayer2() {
        updateScore(_gameScorePlayer2, _gameScorePlayer1, _setScorePlayer2)
    }


    fun saveScore() {

        currentScore?.scorePlayer1 = setScorePlayer1.value!!
        currentScore?.scorePlayer2 = setScorePlayer2.value!!
        viewModelScope.launch {
            currentScore?.let { scoreDao.update(it) }
        }
    }

    fun resetScores() {
        _setScorePlayer1.value = 0
        _setScorePlayer2.value = 0
        _gameScorePlayer1.value = 0
        _gameScorePlayer2.value = 0

        resetVisibility.value = View.INVISIBLE


        viewModelScope.launch {
            createNewScore()
        }
    }
}