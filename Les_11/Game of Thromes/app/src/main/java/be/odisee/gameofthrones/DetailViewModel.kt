package be.odisee.gameofthrones

import androidx.lifecycle.*
import be.odisee.gameofthrones.APIService.GameOfThronesService
import kotlinx.coroutines.launch

class DetailViewModelFactory(val service: GameOfThronesService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(service) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class DetailViewModel(val service: GameOfThronesService) : ViewModel() {
    private val _personage = MutableLiveData<Personage>()
    val personage: LiveData<Personage> = _personage

    fun loadPersonage(id: Int) {
        viewModelScope.launch {
            _personage.value = service.getPersonage(id)
        }
    }
}