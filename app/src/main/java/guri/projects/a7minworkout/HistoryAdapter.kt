package guri.projects.a7minworkout

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import guri.projects.a7minworkout.databinding.ActivityBmiactivityBinding.inflate
import guri.projects.a7minworkout.databinding.ActivityExerciseBinding.inflate
import guri.projects.a7minworkout.databinding.ItemHistoryRowBinding

class HistoryAdapter(private val items: ArrayList<String>) :RecyclerView.Adapter<HistoryAdapter.ViewHolder>()
{

    class ViewHolder(binding: ItemHistoryRowBinding): RecyclerView.ViewHolder(binding.root){

        val llHistoryItemMain = binding.llHistoryItemMain
        val tvItem = binding.tvItem
        val tvposition = binding.tvPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val date : String = items[position]

        holder.tvposition.text = (position+1).toString()

        holder.tvItem.text = date


    }

    override fun getItemCount(): Int {

        return items.size
    }
}