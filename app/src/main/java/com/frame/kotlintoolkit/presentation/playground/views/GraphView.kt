package com.frame.kotlintoolkit.presentation.playground.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.frame.kotlintoolkit.R
import com.frame.kotlintoolkit.core.extentions.dp


class GraphView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val lineColors = listOf(
        resources.getColor(R.color.custom_data_color_line_pink),
        resources.getColor(R.color.custom_data_color_line_blue)
    )
    private val fillColors = listOf(
        listOf(
            resources.getColor(R.color.custom_data_color_pink),
            resources.getColor(R.color.custom_data_color_pink_fade)
        ),
        listOf(
            resources.getColor(R.color.custom_data_color_blue),
            resources.getColor(R.color.custom_data_color_blue_fade)
        )
    )

    // Called when the view should render its content.
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            val width = it.width.toFloat()
            val height = it.height.toFloat()
            val paddingTop = 20f.dp
            val value = (width * 0.4f).toDouble()
            val valueRight = width - value

            val tiltSize =
                Math.sqrt(Math.pow(value, 2.0) + Math.pow(height.toDouble() - paddingTop, 2.0))
            val curveSize = value - (tiltSize / 2) + 12.55760721560796

            val tiltSizeRight =
                Math.sqrt(Math.pow(valueRight, 2.0) + Math.pow(height.toDouble() - paddingTop, 2.0))
            val curveSizeRight = value + (tiltSizeRight / 2) - 12.55760721560796

            val linePaint = Paint().apply {
                isAntiAlias = true
                color = if (isBestSelected) lineColors[0] else lineColors[1]
                style = Paint.Style.STROKE
                strokeCap = Paint.Cap.ROUND
                strokeWidth = 1.5f.dp
            }

            val linePath = Path()
            linePath.moveTo(value.toFloat(), paddingTop)
            linePath.quadTo(curveSize.toFloat(), paddingTop, 0f, height)
            linePath.moveTo(value.toFloat(), paddingTop)
            linePath.quadTo(curveSizeRight.toFloat(), paddingTop, width, height)

            val selectedLinePath = Path()
            selectedLinePath.moveTo(value.toFloat(), height)
            selectedLinePath.lineTo(value.toFloat(), paddingTop)

            val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
            fillPaint.isAntiAlias = true
            fillPaint.shader = LinearGradient(
                0f,
                0f,
                0f,
                height.toFloat(),
                if (isBestSelected) fillColors[0][0] else fillColors[1][0],
                if (isBestSelected) fillColors[0][1] else fillColors[1][1],
                Shader.TileMode.MIRROR
            )

            val fillPath = Path()
            fillPath.moveTo(value.toFloat(), paddingTop)
            fillPath.quadTo(curveSize.toFloat(), paddingTop, 0f, height)
            fillPath.lineTo(value.toFloat(), height)
            fillPath.moveTo(value.toFloat(), paddingTop)
            fillPath.quadTo(curveSizeRight.toFloat(), paddingTop, width, height)
            fillPath.lineTo(value.toFloat(), height)


            val text = "Terbaik untukmu"
            val paint = Paint()
            val approxWidth = ((text.length * 12f) / 2) + 15
            if (value < approxWidth) {
                paint.textAlign = Paint.Align.LEFT
            } else if (value > width - approxWidth) {
                paint.textAlign = Paint.Align.RIGHT
            } else {
                paint.textAlign = Paint.Align.CENTER
            }
            paint.color = resources.getColor(R.color.custom_data_color_line_pink)
            paint.textSize = 10f.dp

            paint.typeface = ResourcesCompat.getFont(context, R.font.helvetica_neue_lt_pro_bd)

            it.drawPath(fillPath, fillPaint)
            it.drawPath(linePath, linePaint)
            it.drawPath(selectedLinePath, linePaint)

            it.drawText(
                text,
                value.toFloat(),
                paddingTop * 0.4f,
                paint
            )
        }
    }

    private var isBestSelected = false
    fun changeColor() {
        isBestSelected = !isBestSelected
        invalidate()
    }
}