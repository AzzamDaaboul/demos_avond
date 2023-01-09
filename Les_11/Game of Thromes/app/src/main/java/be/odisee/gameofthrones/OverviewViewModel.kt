package be.odisee.gameofthrones

import androidx.lifecycle.*
import be.odisee.gameofthrones.APIService.GameOfThronesService
import kotlinx.coroutines.launch

class OverviewViewModelFactory(val service: GameOfThronesService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(service) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class OverviewViewModel(val service: GameOfThronesService) : ViewModel() {
    private val _personages = MutableLiveData<List<Personage>>()
    val personages: LiveData<List<Personage>> = _personages

    fun loadPersonages() {
        viewModelScope.launch {
            _personages.value = service.getAllPersonages()
        }
    }
}