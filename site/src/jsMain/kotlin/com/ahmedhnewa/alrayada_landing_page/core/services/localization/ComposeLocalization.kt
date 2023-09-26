package com.ahmedhnewa.alrayada_landing_page.core.services.localization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ahmedhnewa.alrayada_landing_page.core.data.StringRes
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.Local.Arabic
import com.ahmedhnewa.alrayada_landing_page.core.services.localization.Local.English
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.url.URLSearchParams

private val defaultLocal: Local by lazy {
    var language = window.navigator.language

    val urlParams = URLSearchParams(window.location.search)
    val urlLang = urlParams.get("lang")
    urlLang?.let {
        language = it
    }

    val local = when {
        language.startsWith("en") -> English
        language.startsWith("ar") -> Arabic
        else -> English
    }
    val htmlElement = document.documentElement as HTMLElement
//    htmlElement.dir = local.dir.dirStr
    htmlElement.lang = language

    local
}

@Composable
fun stringResource(stringRes: StringRes): String {
    LaunchedEffect(stringRes) {}
    return LocalizationService
        .getInstance()
        .getLocalizedString(stringRes, defaultLocal)
}

/**
 * For composable events or non composable functions
 */
fun getStringResource(stringRes: StringRes): String {
    return LocalizationService
        .getInstance()
        .getLocalizedString(stringRes, defaultLocal)
}