package com.example.musiapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //This is for one time rotation
        //img.animate().rotation(360f).setDuration(5000).start()
        // For non-stop rotation
//        val rotate = ObjectAnimator.ofFloat(img,"rotation",0f,360f)
//        rotate.duration = 5000
//        rotate.repeatCount = ObjectAnimator.INFINITE
//        rotate.interpolator = LinearInterpolator()
//        rotate.start()
        val retrofiBuilder = Retrofit.Builder()
            .baseUrl("https://collect_the_api_from_rapidAPi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiInterface::class.java)
        val retrofitData = retrofiBuilder.getData("arijit")
        retrofitData.enqueue(object : Callback<allData?> {
            override fun onResponse(call: Call<allData?>, response: Response<allData?>) {
                if(response.isSuccessful){
                val recyclerView = view.findViewById<RecyclerView>(R.id.recycle)
               val responseBody = response.body()
                val array = responseBody?.data!!
                if(array.isNotEmpty()) {
                    val adaptercreate = adptar(array, context as Activity)
                    recyclerView.adapter = adaptercreate
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    adaptercreate.setItemclickListener(object :adptar.onItemclicklitener{
                        override fun onItemclick(position: Int) {
                            val name:String = array[position].title.toString()
                            val pic_link:String = array[position].album.cover.toString()
                            val song:String = array[position].preview.toString()
                            val intent = Intent(context,music_screen::class.java)
                            intent.putExtra("Song_name",name)
                            intent.putExtra("Song_link",song)
                            intent.putExtra("Pic_link",pic_link)
                            startActivity(intent)
                        }

                    })
                }
                else{
                    Toast.makeText(context,"The array is empty",Toast.LENGTH_SHORT).show()
                }
                }
                else{
                    Toast.makeText(context,"Failed to load",Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<allData?>, t: Throwable) {
             Log.d("TAG: On failure","Failed"+t.message)
            }
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
