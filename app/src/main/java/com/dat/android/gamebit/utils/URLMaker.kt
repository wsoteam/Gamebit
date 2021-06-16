package com.dat.android.gamebit.utils

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


    private const val DOMAIN_NAME = "https://longtails.biz/8zz9GF?"
    private const val DELIMETER = "-"


    //[web_id]-[id_account]-[appsflyer_id]-[advertising_id]-[sub_id_1]
    //[web_id]-[sub_id_1]
    //https://longtails.biz/8zz9GF?afid=$id&gadid=1057b684-c970-4d87-900f-a75269795258&webid=10500&sub_id_1=kek

    //afid (aps id) - uniq id of aps for user
    //gadid  - advert id (google)
    //gadid - advert id (google)

    fun createLink(naming : String, gadid : String, afid : String) : String {
        var webId = naming.split(DELIMETER)[0]
        var subId = naming.split(DELIMETER)[1]
        var url = "${DOMAIN_NAME}afid=$afid&gadid=$gadid&webid=$webId&sub_id_1=$subId"
        return url
    }

}