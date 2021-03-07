package br.com.newgen.auctionscraper.usecases

import br.com.newgen.auctionscraper.infrastructure.component.scraper.SumareLeiloesScraper
import br.com.newgen.auctionscraper.models.Auction
import com.gargoylesoftware.htmlunit.html.DomNode
import org.springframework.stereotype.Component

@Component
class ScrapeAuction(val sumareLeiloesScraper: SumareLeiloesScraper) {

    fun test(): List<String> {
        return listOf()
    }
}