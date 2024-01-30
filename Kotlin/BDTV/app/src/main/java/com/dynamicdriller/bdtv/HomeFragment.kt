package com.dynamicdriller.bdtv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dynamicdriller.bdtv.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val shomoyNewsUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/somoyt000011226615544544.stream/playlist.m3u8"
    private val channeliUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/channeli-8-org.stream/playlist.m3u8"
    private val jamunaUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/jamuna-test-sample-ok.stream/playlist.m3u8"
    private val independentUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/independent-8-org.stream/playlist.m3u8"
    private val dbcUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/dbcnews.stream/playlist.m3u8"
    private val channel24Url = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/channel24-sg-e8e.stream/playlist.m3u8"
    private val atnNewsUrl = "https://cdn.appv.jagobd.com:444/cZMLmVyX3RpbEU9Mi8xNy8yMDE0GIDU6RgzQ6NTAgdEoaeFzbF92YWxIZTO0U0ezN1IzMyfvcGVMZEJCTEFWeVN3PTOmdFsaWRtaW51aiPhnPTI/atnws-sg.stream/playlist.m3u8"
//    private val sonyTen2TvUrl = "https://edge4.bioscopelive.com/hls/anonymous/QR-sxv_hKYathW4VL33iBg/1691558792/live-sony-sports-ten-2-hd.m3u8"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.somoyTvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(shomoyNewsUrl)
            findNavController().navigate(action)
        }
        binding.jamunaTvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(jamunaUrl)
            findNavController().navigate(action)
        }
        binding.independentTvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(independentUrl)
            findNavController().navigate(action)
        }
        binding.dbcTvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(dbcUrl)
            findNavController().navigate(action)
        }
        binding.channel24TvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(channel24Url)
            findNavController().navigate(action)
        }
        binding.atnNewsTvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(atnNewsUrl)
            findNavController().navigate(action)
        }
        /*binding.sonyTen2TvCV.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTvViewFragment(sonyTen2TvUrl)
            findNavController().navigate(action)
        }*/
    }
}