package no.nav.bidrag.behandling.felles.dto.stonad

interface MottakerIdHistorikkClient {
  fun finnAlleEndringerMottakerIdForStonad(stonadId: Int): StonadDto
}


interface StonadClient {
  fun hentStonad(stonadId: Int): StonadDto

  fun endreMottakerIdOgOpprettHistorikk(request: EndreMottakerIdRequestDto): EndreMottakerIdDto
}