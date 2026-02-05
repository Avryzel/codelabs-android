package com.example.mycity.data

import com.example.mycity.R

object LocalDataProvider {
    val categories: List<Category> = listOf(
        Category(
            nameRes = R.string.category_historic_sites,
            places = listOf(
                Place(
                    nameRes = R.string.historic_site_monas,
                    descRes = R.string.historic_site_monas_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.historic_site_kota_tua,
                    descRes = R.string.historic_site_kota_tua_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.historic_site_national_museum,
                    descRes = R.string.historic_site_national_museum_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.historic_site_istiqlal,
                    descRes = R.string.historic_site_istiqlal_desc,
                    imageRes = R.drawable.ic_launcher_background
                )
            )
        ),
        Category(
            nameRes = R.string.category_street_food,
            places = listOf(
                Place(
                    nameRes = R.string.street_food_sabang,
                    descRes = R.string.street_food_sabang_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.street_food_blok_m,
                    descRes = R.string.street_food_blok_m_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.street_food_gultik,
                    descRes = R.string.street_food_gultik_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.street_food_nasi_goreng_sirih,
                    descRes = R.string.street_food_nasi_goreng_sirih_desc,
                    imageRes = R.drawable.ic_launcher_background
                )
            )
        ),
        Category(
            nameRes = R.string.category_shopping_malls,
            places = listOf(
                Place(
                    nameRes = R.string.mall_grand_indonesia,
                    descRes = R.string.mall_grand_indonesia_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.mall_plaza_indonesia,
                    descRes = R.string.mall_plaza_indonesia_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.mall_senayan_city,
                    descRes = R.string.mall_senayan_city_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.mall_kotakasablanka,
                    descRes = R.string.mall_kotakasablanka_desc,
                    imageRes = R.drawable.ic_launcher_background
                )
            )
        ),
        Category(
            nameRes = R.string.category_train_stations,
            places = listOf(
                Place(
                    nameRes = R.string.station_gambir,
                    descRes = R.string.station_gambir_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.station_jakarta_kota,
                    descRes = R.string.station_jakarta_kota_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.station_manggarai,
                    descRes = R.string.station_manggarai_desc,
                    imageRes = R.drawable.ic_launcher_background
                ),
                Place(
                    nameRes = R.string.station_sudirman,
                    descRes = R.string.station_sudirman_desc,
                    imageRes = R.drawable.ic_launcher_background
                )
            )
        )
    )
}