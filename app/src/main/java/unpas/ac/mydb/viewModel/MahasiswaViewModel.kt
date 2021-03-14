package unpas.ac.id.mydb.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import unpas.ac.id.mydb.data.Mahasiswa
import unpas.ac.id.mydb.data.MahasiswaDatabase
import unpas.ac.id.mydb.data.MahasiswaRepository

class MahasiswaViewModel(application: Application): AndroidViewModel(application) {

     val readAllData:LiveData<List<Mahasiswa>>
    private val repository:MahasiswaRepository

    init {
        val mahasiswaDao = MahasiswaDatabase.getDatabase(application).mahasiswaDao()
        repository = MahasiswaRepository(mahasiswaDao)
        readAllData = repository.readAllData
    }

    fun addMahasiswa(mahasiswa: Mahasiswa){
        viewModelScope.launch(Dispatchers.IO){
            repository.addMahasiswa(mahasiswa)
        }
    }
}