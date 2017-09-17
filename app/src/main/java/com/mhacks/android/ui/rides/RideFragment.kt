package com.mhacks.android.ui.rides

import android.os.Bundle
import android.support.v7.widget.RecyclerView
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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setCustomActionBarColor(R.color.semiColorPrimary)
        fragment_map_recycler_view.adapter = RideListAdapter()
    }

    internal class RideListAdapter : RecyclerView.Adapter<RideListViewHolder> {

        constructor(rideArrayList: ArrayList<Ride>) : super()

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RideListViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: RideListViewHolder?, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    internal class RideListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}

