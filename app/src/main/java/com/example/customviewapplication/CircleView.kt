package com.example.customviewapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()
    private var centerX = 0f
    private var centerY = 0f
    private var radius = 10f

    init {
        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0)

        paint.run {
            strokeWidth = attributes.getDimension(R.styleable.CircleView_circle_stroke_width, 2f)
            color = attributes.getColor(
                R.styleable.CircleView_circle_color,
                ContextCompat.getColor(context, android.R.color.holo_purple)
            )
            val styleAttr = attributes.getInt(R.styleable.CircleView_circle_style, 1)

            style = when (styleAttr) {
                0 -> Paint.Style.FILL
                1 -> Paint.Style.STROKE
                2 -> Paint.Style.FILL_AND_STROKE
                else -> Paint.Style.STROKE
            }

            radius = attributes.getDimension(R.styleable.CircleView_circle_radius, 100f)
        }

        attributes.recycle()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        centerX = ((left + right) / 2).toFloat()
        centerY = ((top + bottom) / 2).toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(centerX, centerY, radius, paint)
        super.onDraw(canvas)
    }
}