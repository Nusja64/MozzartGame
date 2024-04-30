package com.example.mozzart_test.ui.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.mozzart_test.databinding.FragmentDrawLiveBinding
import com.example.mozzart_test.utils.Constants
import timber.log.Timber

class DrawLiveFragment : Fragment() {

    private lateinit var binding: FragmentDrawLiveBinding
    private lateinit var webView: WebView
    private val url = Constants.DRAW_ANIMATION_URL

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDrawLiveBinding.inflate(layoutInflater)
        webView = binding.webView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {

        webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webView.settings.javaScriptEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl(url)
        Timber.d("URL IS : $url")
    }
}
