package com.example.customviewapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat

class CircleView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint()
    private val centerX = 500f
    private val centerY = 500f
    private var radius = 100f

    init {
        val attrsArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0)

        paint.run {
            strokeWidth = attrsArray.getDimension(R.styleable.CircleView_circle_stroke_width, 2f)
            color = attrsArray.getColor(
                R.styleable.CircleView_circle_color,
                ContextCompat.getColor(context, android.R.color.holo_purple)
            )
            val styleAttr = attrsArray.getInt(R.styleable.CircleView_circle_style, 1)

            style = when(styleAttr) {
                0 -> Paint.Style.FILL
                1 -> Paint.Style.STROKE
                2 -> Paint.Style.FILL_AND_STROKE
                else -> Paint.Style.STROKE
            }

            radius = attrsArray.getDimension(R.styleable.CircleView_circle_radius, 100f)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawCircle(centerX, centerY, radius, paint)
        super.onDraw(canvas)
    }
}