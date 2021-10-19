package hr.dtakac.factorynews.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFCE93D8)
val Purple500 = Color(0xFF6E00EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Teal700 = Color(0xFF018786)
val White = Color(0xFFFFFFFF)
val Red300 = Color(0xFFE57373)
val Black = Color(0xFF000000)
val AlmostBlack = Color(0xFF121212)

val LightColors = Colors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Teal700,
    background = White,
    surface = White,
    error = Red300,
    onPrimary = White,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
    onError = White,
    isLight = true
)

val DarkColors = Colors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    secondaryVariant = Teal700,
    background = AlmostBlack,
    surface = AlmostBlack,
    error = Red300,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = White,
    onSurface = White,
    onError = White,
    isLight = false
)