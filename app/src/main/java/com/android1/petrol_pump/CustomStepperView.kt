package com.android1.petrol_pump

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.DataBindingUtil
import com.android1.petrol_pump.databinding.CustomStepperViewBinding
import com.android1.petrol_pump.databinding.SingleStepViewBinding

open class CustomStepperView : LinearLayoutCompat {

    private val stepperArray = ArrayList<SingleStepViewBinding>()

    private lateinit var mViewBinding : CustomStepperViewBinding


    constructor(context: Context) : super(context){
        initView(null,0)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        initView(attrs,0)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle){
        initView(attrs,defStyle)
    }


    private fun initView(attrs: AttributeSet?, defStyle: Int){
        mViewBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_stepper_view, this, true);
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomStepperView, defStyle, 0)
        val selectedStep = attributes.getString(R.styleable.CustomStepperView_selected_step)
        initInitStepperType()
        selectStep(selectedStep?.toInt() ?: 1)
    }

    private fun initInitStepperType(){
        stepperArray.add(mViewBinding.stepView1)
        stepperArray.add(mViewBinding.stepView2)
        stepperArray.add(mViewBinding.stepView3)

            mViewBinding.stepView1.viewLeftLine.visibility = View.GONE
            mViewBinding.stepView4.viewRightLine.visibility = View.GONE
            initStepText(mViewBinding.stepView1,"1",context.getString(R.string.pd_info_step))
            initStepText(mViewBinding.stepView2,"2",context.getString(R.string.credit_info_step))
            initStepText(mViewBinding.stepView3,"3",context.getString(R.string.other_credit_info_step))
            initStepText(mViewBinding.stepView4,"4",context.getString(R.string.bank_paid_step))
            stepperArray.add(mViewBinding.stepView4)

    }

    fun selectStep(selectedStep : Int){
        for( i in stepperArray.indices){
            val iteratedStep = i + 1
            if(iteratedStep == selectedStep){
                stepperArray[i].ivStep.setImageResource(R.drawable.dotted_circle_orange)
                stepperArray[i].tvStepNumber.changeColor(R.color.orange)
                break
            }else if(iteratedStep < selectedStep){
                stepperArray[i].ivStep.setImageResource(R.drawable.completed_step)
                stepperArray[i].tvStepNumber.hide()
                stepperArray[i].viewLeftLine.changeBackgroundColor(R.color.green)

                if(iteratedStep != selectedStep - 1){
                    stepperArray[i].viewRightLine.changeBackgroundColor(R.color.green)
                }
            }
        }
    }

    private fun initStepText(stepperSingleStepViewBinding: SingleStepViewBinding,stepNumber : String,stepText : String){
        stepperSingleStepViewBinding.tvStepNumber.text = stepNumber
        stepperSingleStepViewBinding.tvStepText.text = stepText
    }

}