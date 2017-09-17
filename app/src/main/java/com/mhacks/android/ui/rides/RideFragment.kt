package com.mhacks.android.ui.rides

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mhacks.android.models.Ride
import com.mhacks.android.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_map.*
import org.mhacks.android.R


/**j6yyg
 * Created by anksh on 12/31/2014.
 * Updated by omkarmoghe on 10/6/16

 * Displays maps of the MHacksApplication 8 venues.
 */
class RideFragment : BaseFragment() {

    override var setTransparent: Boolean = true
    override var AppBarTitle: Int = R.string.title_map
    override var LayoutResourceID: Int = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setCustomActionBarColor(R.color.semiColorPrimary)
        fragment_map_recycler_view.adapter = RideListAdapter(
                context,
        )
    }

    internal class RideListAdapter(val context: Context,
                                   val rideArrayList: ArrayList<Ride>) : RecyclerView.Adapter<RideListViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RideListViewHolder {
            val root: View = LayoutInflater.from(context).inflate(R.layout.ride_viewholder_item, parent, false)

            return RideListViewHolder(root)
        }

        override fun getItemCount(): Int {
            return rideArrayList.size
        }

        override fun onBindViewHolder(holder: RideListViewHolder?, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    internal class RideListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    fun getMockData(): ArrayList<Ride> {
        ArrayList<Ride>
    }

}

