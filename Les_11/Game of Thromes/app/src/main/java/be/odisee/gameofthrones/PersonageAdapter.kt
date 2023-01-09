package be.odisee.gameofthrones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PersonageAdapter(val itemClicked: (Int) -> Unit) :
    ListAdapter<Personage, PersonageAdapter.PersonageViewHolder>(PersonageDiffUtil()) {

    class PersonageViewHolder(val view: View) : ViewHolder(view) {
        val nameTextView: TextView = view.findViewById<TextView>(R.id.name)
    }

    class PersonageDiffUtil : DiffUtil.ItemCallback<Personage>() {
        override fun areItemsTheSame(oldItem: Personage, newItem: Personage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Personage, newItem: Personage): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return PersonageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonageViewHolder, position: Int) {
        holder.nameTextView.text = getItem(position).fullName
        val id = getItem(position).id


        holder.view.setOnClickListener {
            itemClicked(id)
        }

    }
}