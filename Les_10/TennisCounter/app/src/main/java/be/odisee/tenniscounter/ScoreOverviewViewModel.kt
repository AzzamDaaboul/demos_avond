package be.odisee.tenniscounter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import be.odisee.tenniscounter.data.Score
import be.odisee.tenniscounter.data.ScoreDao
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class ScoreOverviewViewModelFactory(private val scoreDao: ScoreDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreOverviewViewModel::class.java)) {
            return ScoreOverviewViewModel(scoreDao) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class ScoreOverviewViewModel(val scoreDao: ScoreDao) : ViewModel() {
    val scores = scoreDao.getAll()

    fun delete(score: Score) {
        viewModelScope.launch {
            scoreDao.delete(score)
        }
    }
}