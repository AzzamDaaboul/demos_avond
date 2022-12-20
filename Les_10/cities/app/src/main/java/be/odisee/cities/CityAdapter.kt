package be.odisee.cities

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class CityAdapter(val data: List<String>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityTextView = itemView.findViewById<TextView>(R.id.cityTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.city_item_view, parent, false)
        view.setBackgroundColor(
            Color.rgb(
                Random.nextInt(255),
                Random.nextInt(255),
                Random.nextInt(255)
            )
        )
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = data[position]
        holder.cityTextView.text = city
    }

    override fun getItemCount(): Int = data.size

}