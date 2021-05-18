package com.dat.android.gamebit.utils

import com.dat.android.gamebit.presentation.SplashActivity

object URLMaker {

    private const val WELCOME_PARTNERS_LANDING = "wpl"
    private const val WELCOME_PARTNERS_REG_FAST = "wprf"
    private const val WELCOME_PARTNERS_REG_BONUS_PAGE = "wprb"

    private const val VULKAN_LANDING = "vl"
    private const val VULKAN_REG_FAST = "vrf"

    private const val TRAFFIC_CAKE_LANDING = "tcl"
    private const val TRAFFIC_CAKE_REG_SIMPLE = "tcrs"
    private const val TRAFFIC_CAKE_REG_FAST = "tcrf"
    private const val TRAFFIC_CAKE_REG_BONUS_PAGE = "tcrbp"

    private const val MONKISS_LANDING = "ml"
    private const val MONKISS_REG_FAST = "mrf"
    private const val MONKISS_REG_SIMPLE_1 = "mrs1"
    private const val MONKISS_REG_SIMPLE_2 = "mrs2"


    //todayspinl_[landing id]_[webmaster id]_[program id]_[subid]
    // https://luckyland777.com/[landing id]/?ref=wp_w[webmaster id]p[program id]_[subid]&click_id={click_id}

    //wl_[landing id]_[webmaster id]_[program id]_[subid]

    ///[web_id]_[id_account]_[appsflyer_id]_[advertising_id]

    fun createLink(naming : String, adId : String, apsId : String) : String {
        var key = naming.split("_")[0]
        var mainUrl = when (key) {
            WELCOME_PARTNERS_LANDING -> createWPLanding(key)
            WELCOME_PARTNERS_REG_FAST -> createWPRegFast(key)
            WELCOME_PARTNERS_REG_BONUS_PAGE -> createWPRegBP(key)
            VULKAN_LANDING -> createVulLanding(key)
            VULKAN_REG_FAST -> createVulRegFast(key)
            TRAFFIC_CAKE_LANDING -> createTCLanding(key)
            TRAFFIC_CAKE_REG_SIMPLE -> createTCRegS(key)
            TRAFFIC_CAKE_REG_FAST -> createTCRegF(key)
            TRAFFIC_CAKE_REG_BONUS_PAGE -> createTCRegBP(key)
            MONKISS_LANDING -> createMonkissLanding(key)
            MONKISS_REG_FAST -> createMonkissRegF(key)
            MONKISS_REG_SIMPLE_1 -> createMonkissRegSimple1(key)
            MONKISS_REG_SIMPLE_2 -> createMonkissRegSimple2(key)
            else -> ""
        }
        // TODO add adId and apsId


        return ""
    }

    private fun createWPLanding(naming: String) : String {
        //https://luckyland777.com/[landing id]/?ref=wp_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url = "${domain}${landingId}/?ref=wp_w${wm}p${programmId}_${subId}"
        return ""

    }

    private fun createWPRegFast(naming: String) : String {
        //https://mobyslot7.com/?s=[site id]&ref=wp_w[webmaster id]p[program id]_[subid]&url=register
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        // var url = "${domain}?s=${siteId}&ref=wp_w${wm}p${programmId}_${subId}&url=register"
        return ""

    }

    private fun createWPRegBP(naming: String) : String {
        //https://mobyslot7.com/?s=[site id]&ref=wp_w[webmaster id]p[program id]_[subid]&encoded_url=Ym9udXNlcy9saXN0I3BvcHVwLXJlZw=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //    "${domain}?s=${siteId}&ref=wp_w${wm}p${programmId}_${subId}&encoded_url=Ym9udXNlcy9saXN0I3BvcHVwLXJlZw="
        return ""

    }

    private fun createVulLanding(naming: String) : String {
        //https://vulkantop.pro/landingpages/[landing id]/index.php?ref=va_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //   "${domain}landingpages/${landingId}/index.php?ref=va_w${wm}p${programmId}_${subId}"
        return ""

    }

    private fun createVulRegFast(naming: String) : String {
        //https://aff-redir.com/?s=[site id]&ref=va_w[webmaster id]p[program id]_[subid]&url=register
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        // var url = "${domain}?s=${siteId}&ref=va_w${wm}p${programmId}_${subId}&url=register"
        return ""

    }

    private fun createTCLanding(naming: String)  : String{
        //https://cakeglobaloffers.com/landingpages/[landing id]/index.php?ref=ca_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        // var url =
        //    "${domain}landingpages/${landingId}/index.php?ref=ca_w${wm}p${programmId}_${subId}"
        return ""

    }

    private fun createTCRegS(naming: String)  : String{
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg==
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //    "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg=="
        return ""

    }

    private fun createTCRegF(naming: String)  : String{
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=cmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //   "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=cmVnaXN0ZXI="
        return ""

    }

    private fun createTCRegBP(naming: String) : String {
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=Ym9udXNlcyMhL2F1dGgvcmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //    "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=Ym9udXNlcyMhL2F1dGgvcmVnaXN0ZXI="
        return ""

    }

    private fun createMonkissLanding(naming: String)  : String{
        //https://12monkiredirect.com/landingpages/[landing id]/index.php?ref=mk_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //    "${domain}landingpages/${landingId}/index.php?ref=mk_w${wm}p${programmId}_${subId}"
        return ""

    }

    private fun createMonkissRegF(naming: String) : String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=cmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //   "${domain}?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=cmVnaXN0ZXI="
        return ""

    }

    private fun createMonkissRegSimple1(naming: String) : String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg==
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        //var url =
        //   "${domain}?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg=="
        return ""

    }

    private fun createMonkissRegSimple2(naming: String) : String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWc=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        // var url =
        //     "${domain}/?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWc="
        return ""
    }
}