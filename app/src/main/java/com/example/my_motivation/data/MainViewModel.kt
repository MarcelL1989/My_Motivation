import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_motivation.data.model.Detailcard
import com.example.my_motivation.data.remote.Repository

import kotlinx.coroutines.launch

class MainviewModel: ViewModel() {


    private var _detailCards = MutableLiveData<List<Detailcard>>()
    val detailCards: LiveData<List<Detailcard>>
        get() = _detailCards


    fun loadDetailCards() {
        viewModelScope.launch {
          _detailCards.value = Repository().loadDetailcard()
        }
    }

        }

