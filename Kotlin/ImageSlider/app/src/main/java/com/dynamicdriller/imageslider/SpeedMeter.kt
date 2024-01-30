package com.dynamicdriller.imageslider


import android.graphics.Paint
import android.graphics.RectF
import android.text.StaticLayout
import android.text.TextPaint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin
import android.graphics.Path as graphicsPath

@Composable
fun SpeedometerProgressbar(
    widthSize: Dp,
    progress: Float,
    modifier: Modifier = Modifier,
    strokeWidth: Dp
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .height(IntrinsicSize.Max)
    ) {
        Box() {

            var gradientColors = listOf(
                Color(0xFF66E466), // Mint Green
                Color(0xFFFFFF00), // Yellow
                Color(0xFFFFA500), // Yellowish Orange
                Color(0xFF14B3B3), // Light Cyan
                Color(0xFF66E466), // Mint Green
                Color(0xFFFFFF00), // Yellow
                Color(0xFFFFA500), // Yellowish Orange
                Color(0xFFDB324C)  // Light Red
            )


            var gradient = Brush.sweepGradient(gradientColors)



            ColorArcWithText(
                startAngle = 179.5f,
                sweepAngle = 36.5f,
                pathText = "Underweight",
                pathTextNumber = "< 18.5",
                colorGradient = gradient,
                strokeWidth = strokeWidth,
                widthSize = widthSize
            )
            ColorArcWithText(
                startAngle = 215.5f,
                sweepAngle = 36.5f,
                pathText = "Normal",
                pathTextNumber = "18.5 - 24.9",
                colorGradient = gradient,
                strokeWidth = strokeWidth,
                widthSize = widthSize
            )
            ColorArcWithText(
                startAngle = 251.5f,
                sweepAngle = 36.5f,
                pathText = "Overweight",
                pathTextNumber = "25.0 - 29.9",
                colorGradient = gradient,
                strokeWidth = strokeWidth,
                widthSize = widthSize
            )
            ColorArcWithText(
                startAngle = 287.5f,
                sweepAngle = 36.5f,
                pathText = "Obese",
                pathTextNumber = "30.0 - 34.9",
                colorGradient = gradient,
                strokeWidth = strokeWidth,
                widthSize = widthSize
            )
            ColorArcWithText(
                startAngle = 323.5f,
                sweepAngle = 36.5f,
                pathText = "Extremely  Obese",
                pathTextNumber = "> 35.0",
                colorGradient = gradient,
                strokeWidth = strokeWidth,
                widthSize = widthSize
            )

            Canvas(modifier = Modifier.size(widthSize)) {
                val canvasSize = size.minDimension
                val center = Offset(canvasSize / 2, canvasSize / 2)
                val smallCircleRadius =
                    canvasSize / 8.dp.toPx() // Adjust the radius of the small circle

                // Draw the small circle in the center
                drawCircle(
                    color = Color.Black, // Customize the color of the small circle
                    radius = smallCircleRadius,
                    center = center
                )
            }


            Canvas(modifier = Modifier.size(widthSize)) {
                val canvasSize = size.minDimension
                val radius = canvasSize / 2 - strokeWidth.toPx() / 2
                val center = Offset(canvasSize / 2, canvasSize / 2)

                val sweep = (progress / 50) * 180f

                // Calculate the needle position based on the progress value
                val needleAngle = 180f + sweep
                val needleLength = radius - (canvasSize * 0.08 ).dp.toPx()



                // Calculate the needle base coordinates
                val needleBaseX =
                    center.x + (radius ) * cos(Math.toRadians(needleAngle.toDouble())).toFloat()
                val needleBaseY =
                    center.y + (radius ) * sin(Math.toRadians(needleAngle.toDouble())).toFloat()

                // Calculate the needle tip coordinates
                val needleTipX =
                    center.x + needleLength * cos(Math.toRadians(needleAngle.toDouble())).toFloat()
                val needleTipY =
                    center.y + needleLength * sin(Math.toRadians(needleAngle.toDouble())).toFloat()


                // Create the path for the arrowhead shape
                val arrowPath = Path().apply {
                    moveTo(needleBaseX, needleBaseY)
                    lineTo(needleTipX - 4.dp.toPx(), needleTipY)
                    lineTo(needleTipX + 4.dp.toPx(), needleTipY)
                    close()
                }

                // Draw the needle
                drawPath(
                    path = arrowPath,
                    color = Color.Black,
                    style = Fill
                )
            }
        }
    }
}


@Composable
fun ColorArcWithText(
    startAngle: Float,
    sweepAngle: Float,
    pathText: String,
    pathTextNumber: String,
    colorGradient: Brush,
    strokeWidth: Dp,
    widthSize: Dp
) {
    Box() {
        Canvas(modifier = Modifier.size(widthSize)) {
            val canvasSize = size.minDimension
            val center = Offset(canvasSize / 2, canvasSize / 2)
/*
            val smallCircleRadius =
                canvasSize / 8.dp.toPx() // Adjust the radius of the small circle
*/

            drawArc(
                brush = colorGradient,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx()),
            )

/*            // Draw the small circle in the center
            drawCircle(
                color = Color.Black, // Customize the color of the small circle
                radius = smallCircleRadius,
                center = center
            )*/


            drawIntoCanvas {
                val arcHeight = (widthSize * 1.25f).toPx()
                val arcWidth = (widthSize * 1.25f).toPx()
                val path = graphicsPath().apply {
                    addArc(
                        RectF(
                            center.x - arcWidth / 2,
                            center.y - arcHeight / 2,
                            center.x + arcWidth / 2,
                            center.y + arcHeight / 2
                        ),
                        startAngle,
                        sweepAngle
                    )
                }

                // Create a StaticLayout to wrap the path text
                val textPaint = TextPaint().apply {
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.CENTER
                }
                val textWidth =
                    (widthSize / 3f).toPx() // Adjust the desired width for soft wrapping
                val textLayout = StaticLayout.Builder.obtain(
                    pathTextNumber,
                    0,
                    pathTextNumber.length,
                    textPaint,
                    textWidth.toInt()
                ).build()

                // Draw the wrapped text on the path
                val offsetY = 0f // Adjust the vertical offset for the wrapped text
                val lineCount = textLayout.lineCount
                for (i in 0 until lineCount) {
                    val lineBaseline = textLayout.getLineBaseline(i)
                    val lineText = pathTextNumber.substring(
                        textLayout.getLineStart(i),
                        textLayout.getLineEnd(i)
                    )
                    it.nativeCanvas.drawTextOnPath(
                        lineText,
                        path,
                        0f,
                        offsetY + lineBaseline,
                        textPaint
                    )
                }
                /*                it.nativeCanvas.drawTextOnPath(
                                    pathTextNumber,
                                    path,
                                    0f,
                                    0f,
                                    Paint().apply {
                                        textSize = 10.sp.toPx()
                                        textAlign = Paint.Align.CENTER
                                    }
                                )*/
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SpeedOMeterProgressbarPreview() {
    SpeedometerProgressbar(widthSize = 148.0.dp, progress = 25f, strokeWidth = 148.0.dp / 4)
}
