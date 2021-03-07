package br.com.newgen.auctionscraper.infrastructure.component.scraper

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SumareLeiloesScraperTest {

    @Autowired
    lateinit var sumareLeiloesScraper: SumareLeiloesScraper

    @Test
    internal fun test() {
        val seedUrl = "http://www.sumareleiloes.com.br/leiloes/3159"
        sumareLeiloesScraper.scrape(seedUrl)
            .forEach {
                println(it.id)
                println("${it.rawValue}\n")
            }
    }
}