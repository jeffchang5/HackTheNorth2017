package com.mhacks.android.ui.map

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.Spinner
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.mhacks.android.data.model.Floor
import com.mhacks.android.ui.common.BaseFragment
import com.mhacks.android.util.ResourceUtil
import org.mhacks.android.R
import java.util.*


/**j6yyg
 * Created by anksh on 12/31/2014.
 * Updated by omkarmoghe on 10/6/16

 * Displays maps of the MHacksApplication 8 venues.
 */
class MapViewFragment : BaseFragment()
{

    override var setTransparent: Boolean = true
    override var AppBarTitle: Int = R.string.title_map
    override var LayoutResourceID: Int = R.layout.fragment_map

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        setCustomActionBarColor(R.color.semiColorPrimary)
    }

//    private var mMapFragment: SupportMapFragment? = null
//    private var mGoogleMap: GoogleMap? = null
//
//
//    private fun setUpMapIfNeeded() {
//        if (mMapFragment == null) {
//            mMapFragment = SupportMapFragment.newInstance()
//            fragmentManager.beginTransaction().replace(R.id.map, mMapFragment).commit()
//        }
//
//        if (mGoogleMap == null) mMapFragment!!.getMapAsync(this)
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mGoogleMap = googleMap
//        googleMap.isBuildingsEnabled = true
//        googleMap.setPadding(0, ResourceUtil.convertDpToPixel(context, 60), 0, 0)
//        val settings = mGoogleMap!!.uiSettings
//        settings.isCompassEnabled = true
//        settings.isTiltGesturesEnabled = true
//
//        val center = CameraUpdateFactory.newCameraPosition(
//                CameraPosition.Builder()
//                        .target(LatLng(42.292650, -83.714359))
//                        .zoom(15f)
//                        .bearing(0f)
//                        .tilt(0f)
//                        .build()
//        )
//
//        if (ContextCompat.checkSelfPermission(this.activity.applicationContext,
//                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
//        }
//
//        if (ContextCompat.checkSelfPermission(this.activity.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            mGoogleMap!!.isMyLocationEnabled = true
//            mGoogleMap!!.uiSettings.isMyLocationButtonEnabled = true
//        } else {
//            //Permission was denied.
//        }
//
//        googleMap.animateCamera(center)
//    }
//
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        if (requestCode == 1) {
//            if (permissions.size == 1 && permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
//                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                if (ContextCompat.checkSelfPermission(this.activity.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//                    mGoogleMap!!.isMyLocationEnabled = true
//                    mGoogleMap!!.uiSettings.isMyLocationButtonEnabled = true
//                }
//            } else {
//                // Permission was denied. Display an error message.
//            }
//        }
//    }
//
//    private fun addOverlay(floor: Floor) {
//        setUpMapIfNeeded()
//    }
//
//    fun checkGooglePlayServices(activity: Activity): Boolean {
//        val googleApiAvailability = GoogleApiAvailability.getInstance()
//        val status = googleApiAvailability.isGooglePlayServicesAvailable(activity)
//        if (status != ConnectionResult.SUCCESS) {
//            if (googleApiAvailability.isUserResolvableError(status)) {
//                val dialog = googleApiAvailability.getErrorDialog(activity, status, 1)
//                dialog.setTitle("Update Google Play Services")
//                dialog.show()
//            }
//            return false
//        }
//        return true
//    }
//
//    override fun onResume() {
//        super.onResume()
//        setUpMapIfNeeded()
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//    }

    companion object {

        val instance: MapViewFragment
            get() = MapViewFragment()
    }

}
