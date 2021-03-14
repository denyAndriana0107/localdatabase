package unpas.ac.id.mydb.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa_master")
data class Mahasiswa (
        @PrimaryKey(autoGenerate = true)
        val id:Int,
        val nrp:String,
        val nama:String
    )

