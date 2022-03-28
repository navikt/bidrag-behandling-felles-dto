package no.nav.bidrag.behandling.felles.dto.stonad

interface MottakerIdHistorikkClient {
  fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): HentStonadDto
}


interface StonadClient {
  fun hentStonad(stonadId: Int): HentStonadDto

  fun endreMottakerIdOgOpprettHistorikk(request: EndreMottakerIdRequestDto): MottakerIdHistorikkDto
}