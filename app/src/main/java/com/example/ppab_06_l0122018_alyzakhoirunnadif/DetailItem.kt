package com.example.ppab_06_l0122018_alyzakhoirunnadif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ppab_06_l0122018.Items

class DetailItem : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_item, container, false)

        arguments?.getParcelable<Items>("CHARACTER")?.let { character ->
            view.findViewById<TextView>(R.id.CharacterName).text = character.name
            view.findViewById<ImageView>(R.id.CharacterImg).setImageResource(character.img)
            view.findViewById<TextView>(R.id.CharacterDescription).text = character.desc
        }


        return view
    }
}
