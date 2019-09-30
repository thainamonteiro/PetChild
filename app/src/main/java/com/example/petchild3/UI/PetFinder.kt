package com.example.petchild3.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.lifecycle.ViewModelProviders
import com.example.petchild3.Model.PetViewModel
import com.example.petchild3.Model.SearchParams
import com.example.petchild3.R
import kotlinx.android.synthetic.main.activity_pet_finder.*

class PetFinder : AppCompatActivity() {

    private var model = PetViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_finder)

        model = ViewModelProviders.of(this).get(PetViewModel::class.java)

        area_SeekBar.min = 0
        area_SeekBar.max = 500
        time_SeekBar.min = 0
        time_SeekBar.max = 24

    }

    fun submit() {

        val searchParams = SearchParams()
        if(deficience_RadioGroup.checkedRadioButtonId == yes_RadioButton.id)
            searchParams.deficience = true

        val _home = findViewById<RadioButton>(home_RadioGroup.checkedRadioButtonId)
        searchParams.home = _home.text.toString()
        searchParams.area = area_SeekBar.progress
        searchParams.children = children_Switch.isChecked
        searchParams.allergic = allergic_Switch.isChecked
        searchParams.pets = pets_Switch.isChecked

        model.searchParams.value = searchParams

    }


}
