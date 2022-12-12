package be.odisee.diceroller

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import be.odisee.diceroller.databinding.ActivityMainBinding

const val TAG = "MainActivity"
const val IMAGE_ID_TAG = "image_id"

class MainActivity : AppCompatActivity() {
    var imageId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        lifecycle.addObserver(LifecycleTracker("mainActivityObserver"))
        Log.d(TAG, "onCreate")
        imageId = savedInstanceState?.getInt(IMAGE_ID_TAG) ?: imageId

        setImage(binding)

        binding.rollButton.setOnClickListener {
            imageId = (1..6).random()
            setImage(binding)
        }

    }

    private fun setImage(binding: ActivityMainBinding) {
        val image = when (imageId) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.diceImage.setImageResource(image)
    }


    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(IMAGE_ID_TAG, imageId)
        Log.d(TAG, "OnSaveInstanceState")
        super.onSaveInstanceState(outState)
    }
}