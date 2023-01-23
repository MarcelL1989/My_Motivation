import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_motivation.data.remote.Repository
import kotlinx.coroutines.launch

class MainviewModel: ViewModel() {
    //Todo SearchApi ersetzen durch eigene Api
    var repository= Repository()
    var motivation = repository.loadcategorycard()

    //fun loadMemes() {
      //  viewModelScope.launch {
        //    repository.loadmemes()
       // }

  //  }
}