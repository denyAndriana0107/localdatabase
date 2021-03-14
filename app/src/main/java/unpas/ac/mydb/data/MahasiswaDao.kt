package unpas.ac.id.mydb.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MahasiswaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMahasiswa(mahasiswa: Mahasiswa)

    @Query("SELECT * FROM mahasiswa_master")
    fun readAllData():LiveData<List<Mahasiswa>>
}