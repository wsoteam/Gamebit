package com.dat.android.gamebit.utils

object URLMaker {

    //todayspinl_[landing id]_[webmaster id]_[program id]_[subid]
    //https://mobyslot7.com/?s=[site id]&ref=wp_w[webmaster id]p[program id]_[subid]&url=register
    fun createWPLanding(naming : String, domain : String) : String{
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId =  naming.split("_")[3]
        var subId =  naming.split("_")[4]

        var url = "${domain}landingpages/${landingId}/index.php?ref=mk_w${wm}p${programmId}_${subId}"
        return url
    }
}