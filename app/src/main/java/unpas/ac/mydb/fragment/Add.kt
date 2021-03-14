package unpas.ac.mydb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import unpas.ac.id.mydb.data.Mahasiswa
import unpas.ac.id.mydb.viewModel.MahasiswaViewModel
import unpas.ac.mydb.R
import unpas.ac.mydb.databinding.FragmentAddBinding


class Add : Fragment() {
    lateinit var addBinding: FragmentAddBinding
    lateinit var mahasiswaViewModel: MahasiswaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add, container, false)
        addBinding = FragmentAddBinding.bind(view)

        mahasiswaViewModel = ViewModelProvider(this).get(MahasiswaViewModel::class.java)
        addBinding.btnAdd.setOnClickListener {
            insertData()
        }
        return view

    }
    //fungsi insert to database
    private fun insertData() {
        var nrp:String  = addBinding.nrpInput.text.toString()
        var nama:String = addBinding.namaInput.text.toString()
        if (checkInput(nrp,nama)){
            var mahasiswa = Mahasiswa(0,nrp, nama)
            mahasiswaViewModel.addMahasiswa(mahasiswa)
            Toast.makeText(requireContext(),"input Saved",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_add_to_list)
        }else{
            Toast.makeText(requireContext(),"input can't empty",Toast.LENGTH_SHORT).show()
        }
    }
    //fungsi check nput kosong
    private fun checkInput(nrp:String,nama:String): Boolean {
        return !nrp.isEmpty() && !nama.isEmpty()
    }

}