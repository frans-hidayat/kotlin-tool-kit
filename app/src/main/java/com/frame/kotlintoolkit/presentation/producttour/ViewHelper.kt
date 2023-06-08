package com.frame.kotlintoolkit.presentation.producttour

import android.view.View

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class ViewHelper {
    companion object {
        fun getAlpha(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .alpha else Honeycomb.getAlpha(view)
        }

        fun setAlpha(view: View, alpha: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).alpha = alpha
            } else {
                Honeycomb.setAlpha(view, alpha)
            }
        }

        fun getPivotX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .pivotX else Honeycomb.getPivotX(view)
        }

        fun setPivotX(view: View, pivotX: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).pivotX = pivotX
            } else {
                Honeycomb.setPivotX(view, pivotX)
            }
        }

        fun getPivotY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .pivotY else Honeycomb.getPivotY(view)
        }

        fun setPivotY(view: View, pivotY: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).pivotY = pivotY
            } else {
                Honeycomb.setPivotY(view, pivotY)
            }
        }

        fun getRotation(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .rotation else Honeycomb.getRotation(view)
        }

        fun setRotation(view: View, rotation: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).rotation = rotation
            } else {
                Honeycomb.setRotation(view, rotation)
            }
        }

        fun getRotationX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .rotationX else Honeycomb.getRotationX(view)
        }

        fun setRotationX(view: View, rotationX: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).rotationX = rotationX
            } else {
                Honeycomb.setRotationX(view, rotationX)
            }
        }

        fun getRotationY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .rotationY else Honeycomb.getRotationY(view)
        }

        fun setRotationY(view: View, rotationY: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).rotationY = rotationY
            } else {
                Honeycomb.setRotationY(view, rotationY)
            }
        }

        fun getScaleX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .scaleX else Honeycomb.getScaleX(view)
        }

        fun setScaleX(view: View, scaleX: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).scaleX = scaleX
            } else {
                Honeycomb.setScaleX(view, scaleX)
            }
        }

        fun getScaleY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .scaleY else Honeycomb.getScaleY(view)
        }

        fun setScaleY(view: View, scaleY: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).scaleY = scaleY
            } else {
                Honeycomb.setScaleY(view, scaleY)
            }
        }

        fun getScrollX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .scrollX.toFloat() else Honeycomb.getScrollX(view)
        }

        fun setScrollX(view: View, scrollX: Int) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).scrollX = scrollX
            } else {
                Honeycomb.setScrollX(view, scrollX)
            }
        }

        fun getScrollY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .scrollY.toFloat() else Honeycomb.getScrollY(view)
        }

        fun setScrollY(view: View, scrollY: Int) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).scrollY = scrollY
            } else {
                Honeycomb.setScrollY(view, scrollY)
            }
        }

        fun getTranslationX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .translationX else Honeycomb.getTranslationX(view)
        }

        fun setTranslationX(view: View, translationX: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).translationX = translationX
            } else {
                Honeycomb.setTranslationX(view, translationX)
            }
        }

        fun getTranslationY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view)
                .translationY else Honeycomb.getTranslationY(view)
        }

        fun setTranslationY(view: View, translationY: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).translationY = translationY
            } else {
                Honeycomb.setTranslationY(view, translationY)
            }
        }

        fun getX(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view).x else Honeycomb.getX(
                view
            )
        }

        fun setX(view: View, x: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).x
            } else {
                Honeycomb.setX(view, x)
            }
        }

        fun getY(view: View): Float {
            return if (AnimatorProxy.NEEDS_PROXY) AnimatorProxy.wrap(view).y else Honeycomb.getY(
                view
            )
        }

        fun setY(view: View, y: Float) {
            if (AnimatorProxy.NEEDS_PROXY) {
                AnimatorProxy.wrap(view).y = y
            } else {
                Honeycomb.setY(view, y)
            }
        }

        private object Honeycomb {
            fun getAlpha(view: View): Float {
                return view.alpha
            }

            fun setAlpha(view: View, alpha: Float) {
                view.alpha = alpha
            }

            fun getPivotX(view: View): Float {
                return view.pivotX
            }

            fun setPivotX(view: View, pivotX: Float) {
                view.pivotX = pivotX
            }

            fun getPivotY(view: View): Float {
                return view.pivotY
            }

            fun setPivotY(view: View, pivotY: Float) {
                view.pivotY = pivotY
            }

            fun getRotation(view: View): Float {
                return view.rotation
            }

            fun setRotation(view: View, rotation: Float) {
                view.rotation = rotation
            }

            fun getRotationX(view: View): Float {
                return view.rotationX
            }

            fun setRotationX(view: View, rotationX: Float) {
                view.rotationX = rotationX
            }

            fun getRotationY(view: View): Float {
                return view.rotationY
            }

            fun setRotationY(view: View, rotationY: Float) {
                view.rotationY = rotationY
            }

            fun getScaleX(view: View): Float {
                return view.scaleX
            }

            fun setScaleX(view: View, scaleX: Float) {
                view.scaleX = scaleX
            }

            fun getScaleY(view: View): Float {
                return view.scaleY
            }

            fun setScaleY(view: View, scaleY: Float) {
                view.scaleY = scaleY
            }

            fun getScrollX(view: View): Float {
                return view.scrollX.toFloat()
            }

            fun setScrollX(view: View, scrollX: Int) {
                view.scrollX = scrollX
            }

            fun getScrollY(view: View): Float {
                return view.scrollY.toFloat()
            }

            fun setScrollY(view: View, scrollY: Int) {
                view.scrollY = scrollY
            }

            fun getTranslationX(view: View): Float {
                return view.translationX
            }

            fun setTranslationX(view: View, translationX: Float) {
                view.translationX = translationX
            }

            fun getTranslationY(view: View): Float {
                return view.translationY
            }

            fun setTranslationY(view: View, translationY: Float) {
                view.translationY = translationY
            }

            fun getX(view: View): Float {
                return view.x
            }

            fun setX(view: View, x: Float) {
                view.x = x
            }

            fun getY(view: View): Float {
                return view.y
            }

            fun setY(view: View, y: Float) {
                view.y = y
            }
        }
    }
}