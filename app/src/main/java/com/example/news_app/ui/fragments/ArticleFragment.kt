package com.example.news_app.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.news_app.R
import com.example.news_app.ui.NewsActivity
import com.example.news_app.ui.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment(R.layout.fragment_article) {
    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        val webView = view.findViewById<WebView>(R.id.webView)

        val urlToLoad = article.url ?: "https://www.google.com"

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(urlToLoad)
        }

        val fab = view.findViewById<View>(R.id.fab)
        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}