package net.freshplatform.alrayada_web.sections.devices.componenets

import androidx.compose.runtime.Composable
import net.freshplatform.alrayada_web.components.LineStroke
import net.freshplatform.alrayada_web.components.NavigationIcon
import net.freshplatform.alrayada_web.components.core.CenterHorizontally
import net.freshplatform.alrayada_web.components.core.MyImage
import net.freshplatform.alrayada_web.core.data.StringRes
import net.freshplatform.alrayada_web.core.services.localization.stringResource
import net.freshplatform.alrayada_web.models.ThemeColors
import net.freshplatform.alrayada_web.sections.devices.models.Device
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun DeviceItem(
    modifier: Modifier = Modifier,
    device: Device,
    isLast: Boolean
) {
    Column(
        modifier = Modifier
            .minHeight(300.px)
            .maxWidth(600.px)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier
                .margin(bottom = 20.px)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    P(
                        attrs = Modifier
                            .margin(topBottom = 0.px)
                            .fontSize(24.px)
                            .fontWeight(FontWeight.Bold)
                            .color(ThemeColors.Primary.colorValue)
                            .toAttrs()
                    ) {
                        Text(device.companyName)
                    }
                    P(
                        attrs = Modifier
                            .margin(topBottom = 0.px)
                            .fontSize(16.px)
                            .margin(left = 8.px)
                            .color(ThemeColors.Secondary.colorValue)
                            .toAttrs()
                    ) {
                        Text(device.deviceName)
                    }
                }
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontSize(16.px)
                        .margin(left = 4.px)
                        .color(Color("#676767"))
                        .toAttrs()
                ) {
                    Text(device.desc)
                }

                Div(
                    attrs = Modifier
                        .maxHeight(30.px)
                        .height(100.px)
                        .toAttrs()
                )
                P(
                    attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontSize(20.px)
                        .margin(left = 4.px)
                        .color(ThemeColors.Primary.colorValue)
                        .toAttrs()
                ) {
                    Text(stringResource(StringRes.Features))
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(70.percent)
                    .border(
                        width = 2.px,
                        style = LineStyle.Solid,
                        color = ThemeColors.Primary.colorValue,
                    )
                    .padding(12.px)
                    .borderRadius(
                        topLeft = 16.px,
                        bottomLeft = 16.px,
                        bottomRight = 32.px,
                        topRight = 200.px,
                    )
            ) {
                MyImage(
                    src = device.imagePath,
                    contentDescription = "${device.deviceName} Image",
                    modifier = Modifier
                        .objectFit(ObjectFit.Cover)
                        .fillMaxSize()
                )
            }

        }
        Features(
            modifier = Modifier
                .margin(bottom = 24.px),
            device = device
        )
        if (!isLast) {
            CenterHorizontally {
                LineStroke(
                    modifier = Modifier
                        .margin(bottom = 24.px)
                )
            }
        }
    }
}

@Composable
private fun Features(modifier: Modifier = Modifier, device: Device) {
    Column(
        modifier = Modifier
            .then(modifier)
    ) {
        device.features.forEach {
            FeatureItem(
                modifier = Modifier
                    .margin(bottom = 6.px),
                feature = it
            )
        }
    }
}

@Composable
private fun FeatureItem(
    modifier: Modifier = Modifier,
    feature: StringRes
) {
    Row(
        modifier = Modifier
            .then(modifier)
    ) {
        NavigationIcon(
            modifier = Modifier
                .margin(right = 6.px),
            selected = false,
        )
        Text(stringResource(feature))
    }
}