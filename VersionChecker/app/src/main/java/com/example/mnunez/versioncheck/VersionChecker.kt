package com.example.mnunez.versioncheck

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build


class VersionChecker {

    companion object {

        fun getAppVersionById(meliApp: MeliApps, context: Context): AppVersion? {

            val packageInfo: PackageInfo? = try {
                context.packageManager.getPackageInfo(meliApp.versionId, 0)
            } catch (e: PackageManager.NameNotFoundException) {
                null
            }

            var versionName: String? = null
            var versionCode: String? = null

            packageInfo?.let {
                versionName = it.versionName
                versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    it.longVersionCode.toString()
                } else {
                    it.versionCode.toString()
                }
            }

            return if (versionCode == null || versionName == null) {
                null
            } else {
                AppVersion(versionName!!, versionCode!!)
            }

        }

    }


    enum class MeliApps(val versionId: String) {
        ML("com.mercadolibre"), MP("com.mercadopago.wallet")
    }

    data class AppVersion(
        var versionName: String,
        var versionCode: String
    )

}