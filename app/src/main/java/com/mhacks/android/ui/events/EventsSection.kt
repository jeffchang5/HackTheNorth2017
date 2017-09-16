package com.mhacks.android.ui.events

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.vipulasri.timelineview.LineType
import com.github.vipulasri.timelineview.TimelineView
import com.mhacks.android.data.model.Events
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection
import org.mhacks.android.R


/**
 * Created by jeffreychang on 8/31/17.
 */



 class EventsSection(val time: String,
                     val type: TimeLineType,
                     val events: ArrayList<Events>): StatelessSection(
        SectionParameters.Builder(R.layout.events_list_item)
        .headerResourceId(R.layout.events_header_item)
        .build()) {

     override fun getContentItemsTotal(): Int {
         return events.size
     }

    override fun getHeaderViewHolder(view: View): RecyclerView.ViewHolder {
        val holder = eventsectionHeaderViewHolder(view)

        when (type) {
            TimeLineType.START -> {
                holder.timelineView.initLine(LineType.BEGIN)
            }
            TimeLineType.NORMAL -> {
                holder.timelineView.initLine(LineType.ONLYONE)
            }
            TimeLineType.END -> {
                holder.timelineView.initLine(LineType.END)
            }
        }
        return holder

    }

    override fun onBindHeaderViewHolder(holder: RecyclerView.ViewHolder?) {
        val vh = holder as eventsectionHeaderViewHolder
        vh.eventsTimeTextView.text = time
    }

     override fun getItemViewHolder(view: View): RecyclerView.ViewHolder {
         val holder = eventsectionItemViewHolder(view)
         if (type == TimeLineType.END) holder.hide()
         return holder
     }

    override fun onBindItemViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as eventsectionItemViewHolder
        viewHolder.announcementItemTitle.text = events[position].title
        viewHolder.descriptionItemTitle.text = events[position].info
     }

    class eventsectionHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timelineView = view.findViewById<View>(R.id.events_info_time_marker) as TimelineView
        val eventsTimeTextView = view.findViewById<View>(R.id.events_time_text) as TextView

    }

    class eventsectionItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val announcementItemTitle = view.findViewById<View>(R.id.events_item_title) as TextView
        val descriptionItemTitle = view.findViewById<View>(R.id.events_item_description) as TextView

        fun hide() {
            view.visibility = View.GONE
        }
    }

    data class EventSectionModel(val time: String, val events: ArrayList<Events>)

    enum class TimeLineType {
        START, NORMAL, END
    }

}


