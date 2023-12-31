package com.example.musiapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [First.newInstance] factory method to
 * create an instance of this fragment.
 */
class First : Fragment() {
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
        val first:MutableList<String> = mutableListOf()
        val second:MutableList<String> = mutableListOf()
        val Third:MutableList<String> = mutableListOf()
        val fourth:MutableList<String> = mutableListOf()
        val fifth:MutableList<String> = mutableListOf()
        fifth.clear()
        second.clear()
        Third.clear()
        fourth.clear()
        fifth.clear()
        val view= inflater.inflate(R.layout.fragment_first, container, false)
        first?.add("https://cdn.siasat.com/wp-content/uploads/2023/10/arijit-singh.jpg")
        first?.add("https://rapidkings.com/wp-content/uploads/2023/05/sonu-nigam-ready-to-belt-out-new-ghazal-titled-yaad-01.jpg")
        first?.add("https://www.theindianpanorama.news/wp-content/uploads/2022/10/Shreya-ghoshal.jpg")
        first?.add("https://assets.telegraphindia.com/telegraph/2021/Feb/1614361329_2061982-kumarsanupadamshri-1569064850.jpg")
        first?.add("https://rollingstoneindia.com/wp-content/uploads/2022/01/SHAAN3.jpg")
        second?.add("https://www.iwmbuzz.com/wp-content/uploads/2019/10/neha-kakkar-is-the-best-singer-1024x576.jpg") //neha
        second?.add("https://cdn.dnaindia.com/sites/default/files/styles/half/public/2018/05/22/685157-sunidhi-chauhan.jpg") // sunidhi
        second?.add("https://wallpapers.com/images/hd/singer-armaan-malik-e5svos11wqw8z468.jpg") // arman
        second?.add("https://a10.gaanacdn.com/gn_img/artists/BZgWoOW2d9/ZgWozZDv32/size_xl_1537797161.webp") // kanika
        second?.add("https://i.pinimg.com/736x/53/3f/49/533f49fda11641332c73494a63aafb68.jpg") // dharsan
        second?.add("https://static.abplive.com/wp-content/uploads/2019/01/16154916/neeti_mohan.jpg") // neeti
        Third.add("https://img.etimg.com/thumb/width-1200,height-900,imgsize-29224,resizemode-75,msid-94687182/magazines/panache/udit-narayan-hale-hearty-clarifies-singers-manager-after-death-rumours-flood-social-media.jpg")
        Third.add("https://static.toiimg.com/thumb/msid-63771694,width-400,resizemode-4/63771694.jpg")
        Third.add("https://images.hindi.news18.com/ibnkhabar/uploads/2022/06/kk-16540234073x2.jpg")
        Third.add("https://images.indulgexpress.com/uploads/user/imagelibrary/2022/7/7/original/JavedAli.jpg")
        Third.add("https://www.iwmbuzz.com/wp-content/uploads/2020/12/5-most-attractive-looks-of-palak-muchhal.jpg")
        Third.add("https://i0.wp.com/highonscore.com/wp-content/uploads/2021/08/Asees-Kaur-Image-2-scaled.jpeg")
        Third.add("https://i.pinimg.com/originals/f2/a7/ac/f2a7acfa983f4f0f1bcb63a73c55d220.jpg")
        fourth.add("https://e1.pxfuel.com/desktop-wallpaper/841/906/desktop-wallpaper-yo-yo-posted-by-john-tremblay-yo-yo-honey-singh-android-thumbnail.jpg")
        fourth.add("https://i.pinimg.com/736x/6b/4f/94/6b4f94d65cd0631e49d5683a107598a6.jpg")
        fourth.add("https://stat5.bollywoodhungama.in/wp-content/uploads/2020/12/Sony-Music-India-partners-with-Epic-Games-to-feature-rapper-Raftaar-in-new-%E2%80%98Bhangra-Boogie-Cup%E2%80%99-Fortnite-campaign--413x300.jpg")
        fourth.add("https://i.pinimg.com/originals/27/5a/1e/275a1e29184d94f6a6c48ef1568ffe65.jpg")
        fourth.add("https://ik.imagekit.io/j83rchiauw/A_List_Star/KingRapperBiography.jpg")
        fourth.add("https://rollingstoneindia.com/wp-content/uploads/2023/05/2-960x1200.png")
        fifth.add("https://images.news18.com/ibnkhabar/uploads/2022/01/Lata-Mangeshkar-5.jpg")
        fifth.add("https://img.etimg.com/thumb/msid-102415899,width-480,height-360,imgsize-29210,resizemode-75/an-evergreen-voice.jpg")
        fifth.add("https://s.saregama.tech/image/c/m/9/29/b4/816_1624534520.jpg")
        fifth.add("https://upload.wikimedia.org/wikipedia/commons/0/05/Mohammed_Rafi_2016_postcard_of_India_crop-flip.jpg")

        val recycler1 = view.findViewById<RecyclerView>(R.id.Recycle1)
        val recycler2 = view.findViewById<RecyclerView>(R.id.recycler2)
        val recycle3 = view.findViewById<RecyclerView>(R.id.recycler3)
        val recycler4 = view.findViewById<RecyclerView>(R.id.recycler4)
        val recycler5 = view.findViewById<RecyclerView>(R.id.recycler5)

        val adptar1 = first_recycle_adapter(first, context as Activity)
        val adapter2 = second_recycle_smal_adapter(second,context as Activity)
        val adpater3 = third_recycle_adapter(Third,context as Activity)
        val adapter4 = fourth_recycle_adapter(fourth, context as Activity)
        val adapter5 = fifth_recycle_adapter(fifth, context as Activity)

        recycler1?.adapter = adptar1
        recycler2?.adapter = adapter2
        recycle3.adapter = adpater3
        recycler4.adapter = adapter4
        recycler5.adapter = adapter5

        recycler1?.layoutManager = LinearLayoutManager(context as Activity,LinearLayoutManager.HORIZONTAL,false)
        recycler2.layoutManager = LinearLayoutManager(context as Activity,LinearLayoutManager.HORIZONTAL,false)
        recycle3.layoutManager = LinearLayoutManager(context  as Activity ,LinearLayoutManager.HORIZONTAL,false)
        recycler4.layoutManager = LinearLayoutManager(context as Activity,LinearLayoutManager.HORIZONTAL,false)
        recycler5.layoutManager = LinearLayoutManager(context as Activity,LinearLayoutManager.HORIZONTAL,false)

        adptar1.setItemclickListener(object :first_recycle_adapter.onItemclicklitener{
            override fun onItemclick(position: Int) {
                val intent1 = Intent(context as Activity,song_list::class.java)
                 if(position == 0){
                     intent1.putExtra("singer","Arijit")
                 }
                else if(position == 1){
                     intent1.putExtra("singer","sonu nigam")
                 }
                else if(position == 2){
                     intent1.putExtra("singer","shreya ghosal")
                 }else if(position == 3){
                     intent1.putExtra("singer","kumar sanu")
                 }
                else if(position == 4){
                     intent1.putExtra("singer","shaan")
                 }
                startActivity(intent1)
            }

        })
        adapter2.setItemclickListener(object :second_recycle_smal_adapter.onItemclicklitener{
            override fun onItemclick(position: Int) {
                val intent2 = Intent(context as Activity,song_list::class.java)
                if(position == 0){
                    intent2.putExtra("singer","Neha kakkar")
                }
                else if(position == 1){
                    intent2.putExtra("singer","sunidhi chauhan")
                }
                else if(position == 2){
                    intent2.putExtra("singer","armaan malik")
                }else if(position == 3){
                    intent2.putExtra("singer","kanika kappor")
                }
                else if(position == 4){
                    intent2.putExtra("singer","Darshan Raval")
                }
                else if(position == 5){
                    intent2.putExtra("singer","Neeti Mohan")
                }
                startActivity(intent2)
            }

        })
        adpater3.setItemclickListener(object :third_recycle_adapter.onItemclicklitener{
            override fun onItemclick(position: Int) {
                val intent3 = Intent(context as Activity,song_list::class.java)
               if(position == 0){
                    intent3.putExtra("singer","udit narayan")
               }
               else if(position == 1){
                   intent3.putExtra("singer","monali thakur")
               }
               else if(position == 2){
                   intent3.putExtra("singer","Krishnakumar Kunnath")
               }else if(position == 3){
                   intent3.putExtra("singer","javed ali")
               }
               else if(position == 4){
                   intent3.putExtra("singer","palak mucchal")
               }
               else if(position == 5){
                   intent3.putExtra("singer","asses kaur")
               }
               else if(position == 6){
                   intent3.putExtra("singer","AR rahaman")
               }
               startActivity(intent3)
            }

        })
        adapter4.setItemclickListener(object :fourth_recycle_adapter.onItemclicklitener{
            override fun onItemclick(position: Int) {
                val intent4 = Intent(context as Activity,song_list::class.java)
                if(position == 0){
                    intent4.putExtra("singer","Badsah")
                }
                else if(position == 1){
                    intent4.putExtra("singer","Honey sing")
                }
                else if(position == 2){
                    intent4.putExtra("singer","Rafter")
                }else if(position == 3){
                    intent4.putExtra("singer","Devine")
                }
                else if(position == 4){
                    intent4.putExtra("singer","king")
                }
                else if(position == 5){
                    intent4.putExtra("singer","ikka")
                }
                startActivity(intent4)
            }

        })
        adapter5.setItemclickListener(object :fifth_recycle_adapter.onItemclicklitener{
            override fun onItemclick(position: Int) {
                val intent5 = Intent(context as Activity,song_list::class.java)
                if(position == 0){
                    intent5.putExtra("singer","lata mangeshkar")
                }
                else if(position == 1){
                    intent5.putExtra("singer","kishore kumar")
                }
                else if(position == 2){
                    intent5.putExtra("singer","asha bhosle")
                }else if(position == 3){
                    intent5.putExtra("singer","mohammad rafi")
                }
                startActivity(intent5)
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
         * @return A new instance of fragment First.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            First().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}