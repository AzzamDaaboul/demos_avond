package be.odisee.tenniscounter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import be.odisee.tenniscounter.data.Score
import be.odisee.tenniscounter.databinding.ScoreItemViewBinding
import java.util.*

class ScoreAdapter(val deleteAction: (Score) -> Unit) :
    ListAdapter<Score, ScoreAdapter.ScoreViewHolder>(ScoreDiffUtilItemCallback()) {

    class ScoreDiffUtilItemCallback : DiffUtil.ItemCallback<Score>() {
        override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
            return oldItem == newItem
        }

    }

    class ScoreViewHolder(val binding: ScoreItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): ScoreViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ScoreItemViewBinding.inflate(layoutInflater, parent, false)
                return ScoreViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        return ScoreViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = getItem(position)
        holder.binding.score = score
        holder.binding.deleteButton.setOnClickListener {
            deleteAction(score)
        }
    }
}

/**
class ScoreAdapter(val scores: List<Score>, val deleteAction: (Score) -> Unit) :
RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val scorePlayer1TextView = itemView.findViewById<TextView>(R.id.scorePlayer1)
val scorePlayer2TextView = itemView.findViewById<TextView>(R.id.scorePlayer2)
val scoreDateTextView = itemView.findViewById<TextView>(R.id.scoreDate)
val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteButton)
}

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
val layoutInflater = LayoutInflater.from(parent.context)
val view = layoutInflater.inflate(R.layout.score_item_view, parent, false)
return ScoreViewHolder(view)
}

override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
val score = scores[position]
holder.scorePlayer1TextView.text = score.scorePlayer1.toString()
holder.scorePlayer2TextView.text = score.scorePlayer2.toString()
holder.scoreDateTextView.text = DateFormat.format("dd-MM-yyyy HH:mm", Date(score.date))

holder.deleteButton.setOnClickListener {
deleteAction(score)
}
}

override fun getItemCount() = scores.size
}
 */