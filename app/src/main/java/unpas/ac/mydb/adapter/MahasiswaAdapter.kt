package unpas.ac.mydb.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import unpas.ac.id.mydb.data.Mahasiswa
import unpas.ac.mydb.databinding.MahasiswaItemsBinding

class MahasiswaAdapter:RecyclerView.Adapter<MahasiswaAdapter.MahasiswaHolder>() {
    private var data= emptyList<Mahasiswa>()
    class MahasiswaHolder(var binding:MahasiswaItemsBinding):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaHolder {
        val binding= MahasiswaItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MahasiswaHolder(binding)
    }

    override fun onBindViewHolder(holder: MahasiswaHolder, position: Int) {
        //fungsi memasukan data dari database ke view component
        var current = data.get(position)
        holder.binding.itemId.text=current.id.toString()
        holder.binding.itemNama.text= current.nama
        holder.binding.itemNrp.text= current.nrp
    }

    override fun getItemCount():Int{
        return data.size
    }

    fun setData(mahasiswa:List<Mahasiswa>){
        data=mahasiswa
        notifyDataSetChanged()
    }
}


