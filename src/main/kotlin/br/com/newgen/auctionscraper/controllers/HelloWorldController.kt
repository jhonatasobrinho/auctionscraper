package br.com.newgen.auctionscraper.controllers

import br.com.newgen.auctionscraper.infrastructure.component.scraper.SumareLeiloesScraper
import br.com.newgen.auctionscraper.models.Auction
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(val scraper: SumareLeiloesScraper) {

    @GetMapping("hello")
    fun test(): Auction {
        return Auction("Test", setOf())
    }
}