import android.app.Application
import androidx.lifecycle.*
import com.example.my_motivation.data.local.getDatabase
import com.example.my_motivation.data.model.Categorycard
import com.example.my_motivation.data.model.Detailcard
import com.example.my_motivation.data.remote.Repository

import kotlinx.coroutines.launch

class MainviewModel(application: Application) : AndroidViewModel(application)  {
    var database= getDatabase(application)
    var repository= Repository(database)
    private var _detailCards = MutableLiveData<List<Detailcard>>()
    val detailCards: LiveData<List<Detailcard>>
        get() = _detailCards
    var favoritesList = repository.favorites
    fun insertFavorites(detailcard: Detailcard) {
        viewModelScope.launch {
            repository.insertFavorites(detailcard)
        }

    }

    fun deleteFavorites(detailcard: Detailcard) {
        viewModelScope.launch{
            repository.delete(detailcard)
        }
    }







    fun loadDetailCards() {
        viewModelScope.launch {
          _detailCards.value = repository.loadDetailcard()
        }
    }
    fun loadCategoryCards(): List<Categorycard> {
       return repository.loadcategorycard()
    }
}

