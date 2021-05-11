package com.dat.android.gamebit.utils

object URLMaker {

    //todayspinl_[landing id]_[webmaster id]_[program id]_[subid]
    // https://luckyland777.com/[landing id]/?ref=wp_w[webmaster id]p[program id]_[subid]&click_id={click_id}

    //wl_[landing id]_[webmaster id]_[program id]_[subid]

    fun createWPLanding(naming: String, domain: String): String {
        //https://luckyland777.com/[landing id]/?ref=wp_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}${landingId}/?ref=wp_w${wm}p${programmId}_${subId}"

        return url
    }

    fun createWPRegFast(naming: String, domain: String): String {
        //https://mobyslot7.com/?s=[site id]&ref=wp_w[webmaster id]p[program id]_[subid]&url=register
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=wp_w${wm}p${programmId}_${subId}&url=register"

        return url
    }
    fun createWPRegBP(naming: String, domain: String): String {
        //https://mobyslot7.com/?s=[site id]&ref=wp_w[webmaster id]p[program id]_[subid]&encoded_url=Ym9udXNlcy9saXN0I3BvcHVwLXJlZw=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=wp_w${wm}p${programmId}_${subId}&encoded_url=Ym9udXNlcy9saXN0I3BvcHVwLXJlZw="

        return url
    }
    fun createVulLanding(naming: String, domain: String): String {
        //https://vulkantop.pro/landingpages/[landing id]/index.php?ref=va_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}landingpages/${landingId}/index.php?ref=va_w${wm}p${programmId}_${subId}"

        return url
    }
    fun createVulRegFast(naming: String, domain: String): String {
        //https://aff-redir.com/?s=[site id]&ref=va_w[webmaster id]p[program id]_[subid]&url=register
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=va_w${wm}p${programmId}_${subId}&url=register"

        return url
    }
    fun createTCLanding(naming: String, domain: String): String {
        //https://cakeglobaloffers.com/landingpages/[landing id]/index.php?ref=ca_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}landingpages/${landingId}/index.php?ref=ca_w${wm}p${programmId}_${subId}"

        return url
    }
    fun createTCRegS(naming: String, domain: String): String {
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg==
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg=="

        return  url
    }
    fun createTCRegF(naming: String, domain: String): String {
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=cmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=cmVnaXN0ZXI="

        return url
    }
    fun createTCRegBP(naming: String, domain: String): String {
        //https://sweet-slots.com/?s=[site id]&ref=ca_w[webmaster id]p[program id]_[subid]&encoded_url=Ym9udXNlcyMhL2F1dGgvcmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=ca_w${wm}p${programmId}_${subId}&encoded_url=Ym9udXNlcyMhL2F1dGgvcmVnaXN0ZXI="

        return url
    }
    fun createMonkissLanding(naming: String, domain: String): String {
        //https://12monkiredirect.com/landingpages/[landing id]/index.php?ref=mk_w[webmaster id]p[program id]_[subid]
        var landingId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}landingpages/${landingId}/index.php?ref=mk_w${wm}p${programmId}_${subId}"

        return url
    }
    fun createMonkissRegF(naming: String, domain: String): String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=cmVnaXN0ZXI=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=cmVnaXN0ZXI="

        return url
    }
    fun createMonkissRegSimple1(naming: String, domain: String): String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg==
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWdpc3Rlcg=="

        return url
    }
    fun createMonkissRegSimple2(naming: String, domain: String): String {
        //https://777todayspin-redirect.com/?s=[site id]&ref=mk_w[webmaster id]p[program id]_[subid]&encoded_url=IyEvYXV0aC9yZWc=
        var siteId = naming.split("_")[1]
        var wm = naming.split("_")[2]
        var programmId = naming.split("_")[3]
        var subId = naming.split("_")[4]

        var url = "${domain}/?s=${siteId}&ref=mk_w${wm}p${programmId}_${subId}&encoded_url=IyEvYXV0aC9yZWc="

        return url
    }
}