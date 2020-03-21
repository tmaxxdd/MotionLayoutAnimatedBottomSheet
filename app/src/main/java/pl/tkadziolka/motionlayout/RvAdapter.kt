package pl.tkadziolka.motionlayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_item.view.*

class RvAdapter(private val listener: (String) -> Unit) : RecyclerView.Adapter<SimpleItem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleItem =
        SimpleItem(LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false))

    override fun getItemCount(): Int = 20

    override fun onBindViewHolder(holder: SimpleItem, position: Int) =
        holder.bind("Item $position", listener)
}

class SimpleItem(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(name: String, listener: (String) -> Unit) {
        itemView.itemLabel.text = name
        itemView.setOnClickListener { listener.invoke(name) }
    }
}