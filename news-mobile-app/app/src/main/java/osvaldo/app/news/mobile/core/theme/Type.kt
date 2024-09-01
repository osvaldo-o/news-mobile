package osvaldo.app.news.mobile.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import osvaldo.app.news.mobile.R

val newsCycleFamiliy =  FontFamily(
    Font(R.font.news_cycle_regular, FontWeight.Normal),
    Font(R.font.news_cycle_bold, FontWeight.Bold)
)

val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = newsCycleFamiliy),
    displayMedium = baseline.displayMedium.copy(fontFamily = newsCycleFamiliy),
    displaySmall = baseline.displaySmall.copy(fontFamily = newsCycleFamiliy),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = newsCycleFamiliy),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = newsCycleFamiliy),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = newsCycleFamiliy),
    titleLarge = baseline.titleLarge.copy(fontFamily = newsCycleFamiliy),
    titleMedium = baseline.titleMedium.copy(fontFamily = newsCycleFamiliy),
    titleSmall = baseline.titleSmall.copy(fontFamily = newsCycleFamiliy),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = newsCycleFamiliy),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = newsCycleFamiliy),
    bodySmall = baseline.bodySmall.copy(fontFamily = newsCycleFamiliy),
    labelLarge = baseline.labelLarge.copy(fontFamily = newsCycleFamiliy),
    labelMedium = baseline.labelMedium.copy(fontFamily = newsCycleFamiliy),
    labelSmall = baseline.labelSmall.copy(fontFamily = newsCycleFamiliy),
)