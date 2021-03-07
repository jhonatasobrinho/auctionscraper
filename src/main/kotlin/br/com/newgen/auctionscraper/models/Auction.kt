package br.com.newgen.auctionscraper.models

class Auction(
    val description: String,
    val lots: Set<Lot>
)