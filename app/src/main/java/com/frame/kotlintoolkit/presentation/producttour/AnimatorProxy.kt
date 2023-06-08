package com.frame.kotlintoolkit.presentation.producttour

import android.graphics.Camera
import android.graphics.Matrix
import android.graphics.RectF
import android.os.Build.VERSION
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import java.lang.ref.WeakReference
import java.util.*

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
class AnimatorProxy private constructor(view: View) : Animation() {
    private var mView: WeakReference<View?>
    private val mCamera = Camera()
    private var mHasPivot = false
    private var mAlpha = 1.0f
    private var mPivotX = 0f
    private var mPivotY = 0f
    private var mRotationX = 0f
    private var mRotationY = 0f
    private var mRotationZ = 0f
    private var mScaleX = 1.0f
    private var mScaleY = 1.0f
    private var mTranslationX = 0f
    private var mTranslationY = 0f
    private val mBefore = RectF()
    private val mAfter = RectF()
    private val mTempMatrix = Matrix()
    var alpha: Float
        get() = mAlpha
        set(alpha) {
            if (mAlpha != alpha) {
                mAlpha = alpha
                mView.get()?.invalidate()
            }
        }
    var pivotX: Float
        get() = mPivotX
        set(pivotX) {
            if (!mHasPivot || mPivotX != pivotX) {
                prepareForUpdate()
                mHasPivot = true
                mPivotX = pivotX
                invalidateAfterUpdate()
            }
        }
    var pivotY: Float
        get() = mPivotY
        set(pivotY) {
            if (!mHasPivot || mPivotY != pivotY) {
                prepareForUpdate()
                mHasPivot = true
                mPivotY = pivotY
                invalidateAfterUpdate()
            }
        }
    var rotation: Float
        get() = mRotationZ
        set(rotation) {
            if (mRotationZ != rotation) {
                prepareForUpdate()
                mRotationZ = rotation
                invalidateAfterUpdate()
            }
        }
    var rotationX: Float
        get() = mRotationX
        set(rotationX) {
            if (mRotationX != rotationX) {
                prepareForUpdate()
                mRotationX = rotationX
                invalidateAfterUpdate()
            }
        }
    var rotationY: Float
        get() = mRotationY
        set(rotationY) {
            if (mRotationY != rotationY) {
                prepareForUpdate()
                mRotationY = rotationY
                invalidateAfterUpdate()
            }
        }
    var scaleX: Float
        get() = mScaleX
        set(scaleX) {
            if (mScaleX != scaleX) {
                prepareForUpdate()
                mScaleX = scaleX
                invalidateAfterUpdate()
            }
        }
    var scaleY: Float
        get() = mScaleY
        set(scaleY) {
            if (mScaleY != scaleY) {
                prepareForUpdate()
                mScaleY = scaleY
                invalidateAfterUpdate()
            }
        }
    var scrollX: Int
        get() {
            return mView.get()?.scrollX ?: 0
        }
        set(value) {
            val view = mView.get()
            view?.scrollTo(value, view.scrollY)
        }
    var scrollY: Int
        get() {
            return mView.get()?.scrollY ?: 0
        }
        set(value) {
            val view = mView.get()
            view?.scrollTo(view.scrollX, value)
        }
    var translationX: Float
        get() = mTranslationX
        set(translationX) {
            if (mTranslationX != translationX) {
                prepareForUpdate()
                mTranslationX = translationX
                invalidateAfterUpdate()
            }
        }
    var translationY: Float
        get() = mTranslationY
        set(translationY) {
            if (mTranslationY != translationY) {
                prepareForUpdate()
                mTranslationY = translationY
                invalidateAfterUpdate()
            }
        }
    var x: Float
        get() {
            val view = mView.get()
            return if (view == null) 0.0f else view.left.toFloat() + mTranslationX
        }
        set(x) {
            val view = mView.get()
            if (view != null) {
                translationX = x - view.left.toFloat()
            }
        }
    var y: Float
        get() {
            val view = mView.get()
            return if (view == null) 0.0f else view.top.toFloat() + mTranslationY
        }
        set(y) {
            val view = mView.get()
            if (view != null) {
                translationY = y - view.top.toFloat()
            }
        }

    private fun prepareForUpdate() {
        val view = mView.get()
        if (view != null) {
            computeRect(mBefore, view)
        }
    }

    private fun invalidateAfterUpdate() {
        val view = mView.get()
        if (view != null && view.parent != null) {
            val after = mAfter
            computeRect(after, view)
            after.union(mBefore)
            (view.parent as View).invalidate(
                Math.floor(after.left.toDouble()).toInt(),
                Math.floor(after.top.toDouble()).toInt(),
                Math.ceil(after.right.toDouble()).toInt(),
                Math.ceil(after.bottom.toDouble()).toInt()
            )
        }
    }

    private fun computeRect(r: RectF, view: View) {
        val w = view.width.toFloat()
        val h = view.height.toFloat()
        r[0.0f, 0.0f, w] = h
        val m = mTempMatrix
        m.reset()
        transformMatrix(m, view)
        mTempMatrix.mapRect(r)
        r.offset(view.left.toFloat(), view.top.toFloat())
        var f: Float
        if (r.right < r.left) {
            f = r.right
            r.right = r.left
            r.left = f
        }
        if (r.bottom < r.top) {
            f = r.top
            r.top = r.bottom
            r.bottom = f
        }
    }

    private fun transformMatrix(m: Matrix, view: View) {
        val w = view.width.toFloat()
        val h = view.height.toFloat()
        val hasPivot = mHasPivot
        val pX = if (hasPivot) mPivotX else w / 2.0f
        val pY = if (hasPivot) mPivotY else h / 2.0f
        val rX = mRotationX
        val rY = mRotationY
        val rZ = mRotationZ
        if (rX != 0.0f || rY != 0.0f || rZ != 0.0f) {
            val camera = mCamera
            camera.save()
            camera.rotateX(rX)
            camera.rotateY(rY)
            camera.rotateZ(-rZ)
            camera.getMatrix(m)
            camera.restore()
            m.preTranslate(-pX, -pY)
            m.postTranslate(pX, pY)
        }
        val sX = mScaleX
        val sY = mScaleY
        if (sX != 1.0f || sY != 1.0f) {
            m.postScale(sX, sY)
            val sPX = -(pX / w) * (sX * w - w)
            val sPY = -(pY / h) * (sY * h - h)
            m.postTranslate(sPX, sPY)
        }
        m.postTranslate(mTranslationX, mTranslationY)
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        val view = mView.get()
        if (view != null) {
            t.alpha = mAlpha
            transformMatrix(t.matrix, view)
        }
    }

    init {
        this.duration = 0L
        this.fillAfter = true
        view.animation = this
        mView = WeakReference(view)
    }

    companion object {
        var NEEDS_PROXY = false
        private var PROXIES: WeakHashMap<View?, AnimatorProxy?>? = null
        fun wrap(view: View): AnimatorProxy {
            var proxy = PROXIES!![view]
            if (proxy == null || proxy != view.animation) {
                proxy = AnimatorProxy(view)
                PROXIES!![view] = proxy
            }
            return proxy
        }

        init {
            NEEDS_PROXY = Integer.valueOf(VERSION.SDK) < 11
            PROXIES = WeakHashMap()
        }
    }
}