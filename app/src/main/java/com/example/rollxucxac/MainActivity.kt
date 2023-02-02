package com.example.rollxucxac

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        // Tạo đối tượng Dice mới với 6 cạnh và lăn xúc xắc
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val dice2 = Dice(6)
        val diceRoll2 = dice.roll()
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        //Tìm ImageView trong bố cục
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
//        Dòng mã này để kiểm tra xem bạn có thể cập nhật ImageView đúng cách khi nhấp vào nút
//        hay không. Kết quả tung xúc xắc không phải lúc nào cũng là "2" mà chỉ sử dụng hình ảnh
//        dice_2 cho mục đích thử nghiệm.
        //Mã này gọi phương thức setImageResource() trên ImageView, truyền mã nhận dạng tài nguyên
        // cho hình ảnh dice_2. Thao tác này sẽ cập nhật ImageView trên màn hình để cho thấy hình ảnh dice_2.
//        diceImage.setImageResource(R.drawable.dice_2)

        //Xác định ID tài nguyên có thể rút được để sử dụng dựa trên cuộn xúc xắc
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Cập nhật ID IMAGEVIEW với ID tài nguyên có thể vẽ chính xác
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        //Cập nhật mô tả nội dung
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll.toString()
    }
}
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}