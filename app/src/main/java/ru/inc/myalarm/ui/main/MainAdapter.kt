package ru.inc.myalarm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.inc.myalarm.databinding.ItemAlarmMainPageBinding
import ru.inc.myalarm.model.entity.ui.Alarm

class MainAdapter : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    var lmdClickListener: ((Alarm) -> Unit)? = null
    var list: List<Alarm> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            ItemAlarmMainPageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply { itemView.setOnClickListener { lmdClickListener?.invoke(list[adapterPosition]) } }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount() = list.size


    inner class MyViewHolder(val ui: ItemAlarmMainPageBinding) : RecyclerView.ViewHolder(ui.root) {

        fun bind(alarm: Alarm) {
            ui.txtName.text = alarm.name
            ui.txtDate.text = alarm.date
        }
    }
}