package no.nav.bidrag.behandling.felles.dto.stonad

interface StonadClient {
  fun hentStonad(stonadId: Int): HentStonadDto

  fun endreMottakerIdOgOpprettHistorikk(request: EndreMottakerIdRequestDto): MottakerIdHistorikkDto

  fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): HentStonadDto

}