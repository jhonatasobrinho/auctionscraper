package br.com.newgen.auctionscraper.infrastructure.component.scraper

import br.com.newgen.auctionscraper.models.Lot
import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.HtmlDivision
import com.gargoylesoftware.htmlunit.html.HtmlPage
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
class SumareLeiloesScraper(val webClient: WebClient) {

    @Cacheable(cacheNames = ["Lot"], key = "#seedUrl")
    fun scrape(seedUrl: String): List<Lot> {
        println("Started scraping $seedUrl")

        webClient.use {
            val page = it.getPage<HtmlPage>(seedUrl)

            val lotsSection = page.querySelector<HtmlDivision>("div.lots")
            return lotsSection.childNodes
                .filterIsInstance(HtmlDivision::class.java)
                .map { lot -> lot.attributes.getNamedItem("id").nodeValue }
                .map { id -> Lot(id, scrapeLot(id).firstChild.asText()) }
        }
    }

    fun scrapeLot(id: String): HtmlPage {
        val seedUrl = "https://www.sumareleiloes.com.br/getLotCard/$id"
        println("Scraping $seedUrl")
        return webClient.getPage(seedUrl)
    }
}